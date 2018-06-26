
import com.google.gson.Gson;
import sslRel.helpers.PdfReport;
import sslRel.helpers.Permission;
import sslRel.helpers.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigServlet extends HttpServlet{

    public ConfigServlet(){
        super();
    }

    public String listPaths(HttpServletRequest request) throws IOException {
        String url = request.getParameter("_urlaction");
        JobManager jobManager = new JobManager();
        ArrayList<File> dirs = jobManager.listAllDirectories();
        String dirsJson = jobManager.convertDiretoriesListToJson(dirs);
        String[] keys = jobManager.listJobsURLs();
        String selected="";
        if(keys!=null){
            for (String key :keys) {
                if(key.equals(url)){
                    selected = ",\"selected\":\""+jobManager.getJobByURL(url).folder+"\"";
                }
            }
        }



        return "{\"jobs\":"+dirsJson+selected+"}";
    }

    public String getJobParams(HttpServletRequest request) throws Exception {
        Resource res = new Resource();

        String jobFolder = request.getParameter("job");

        res.findResource(new File(System.getProperty("reportsTemplates")+"/"+jobFolder),"rssql.json",false);

        JobManager jobManager = new JobManager();
        Map<String,JobManager.JobFormat> jobs = jobManager.getJobs();
        String jsonOut;

        JobManager.JobFormat job = new JobManager.JobFormat();


        if(jobs!=null){
            Set<String> keys = jobs.keySet();
            for(String key:keys){
                JobManager.JobFormat listedJob = jobs.get(key);
                if(listedJob.folder.equals(jobFolder)&&key.equals(request.getParameter("_urlaction"))){
                    job = listedJob;
                    break;
                }
            }
        }


        if((res.files!=null)&&(!res.files.isEmpty())) {
            String rssqlFile = res.files.get(0).getCanonicalPath();
            RSSQL rssql = new RSSQL(rssqlFile);
            ArrayList<String> inputKeys = rssql.inputs;
            if (job.params == null) job.params = new HashMap<>();

            for (String key : inputKeys) {
                if (job.params.get(key) == null) {
                    job.params.put(key, "");
                }
            }
            jsonOut= new Gson().toJson(job.params);
        }else if(job.params==null){
            jsonOut="{\"msg\":\"Não Há parâmetros\"}";
        }else{
            jsonOut= new Gson().toJson(job.params);
        }
        return jsonOut;
    }

    public String saveJob(HttpServletRequest request) throws IOException {

        JobManager jobManager = new JobManager();
        String url = request.getParameter("_urlaction");
        String params = request.getParameter("params");
        String jobFolder = request.getParameter("job");
        jobManager.saveJob(url,jobFolder,params);
        return "{\"msg\":\"Sucesso ao salvar Job\"}";
    }

    public String clearJob(HttpServletRequest request) throws IOException {
        JobManager jobManager = new JobManager();
        String url = request.getParameter("_urlaction");

        if(jobManager.clearJob(url))return "{\"msg\":\"Sucesso ao deletar Job\"}";
        else return  "{\"msg\":\"Essa página não tinha job\"}";

    }

    public String deleteJob(HttpServletRequest request) throws IOException {
        JobManager jobManager = new JobManager();
        String url = request.getParameter("_urlaction");

        if(jobManager.clearJob(url))return "{\"msg\":\"Sucesso ao deletar Job\"}";
        else return  "{\"msg\":\"Essa página não tinha job\"}";

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(Permission.isSuperAdmin(request)){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            PrintWriter writer = response.getWriter();
            String out;
            switch (action){
                case "getJobs":out = this.listPaths(request);break;
                case "saveJob":out = this.saveJob(request);break;
                case "clearJob":out = this.clearJob(request);break;
                case "getJob":
                    try {
                        out = this.getJobParams(request);
                    } catch (Exception e) {
                        StringBuilder msg = new StringBuilder();
                        for(StackTraceElement m:e.getStackTrace()){
                            msg.append(m);
                        }
                        out = "{\"msg\":\""+msg+"\"}";
                    }
                    break;
                case "openConfig":out = "{\"openUI\":true}";break;
                default:out = "{\"error\":\"Não foi possível encontrar função\"}";break;
            }
            writer.write(out);
        }else{
            throw new ServletException("Você não tem permissão para executar esta ação");
        }
    }
}
