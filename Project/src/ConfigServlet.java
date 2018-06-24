
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigServlet extends HttpServlet{

    public ConfigServlet(){
        super();
    }

    public void listPaths(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String url = request.getParameter("_urlaction");
        JobManager jobManager = new JobManager();
        ArrayList<File> dirs = jobManager.listAllDirectories();
        String dirsJson = jobManager.convertDiretoriesListToJson(dirs);
        String[] keys = jobManager.listJobsURLs();
        String selected="";
        if(keys!=null){
            for (String key :keys) {
                if(key.equals(url)){
                    selected = ",\"selected\":\""+ jobManager.getJobByURL(url).folder+"\"";
                }
            }
        }

        response.getWriter().write("{\"jobs\":"+dirsJson+selected+"}");
    }

    public void getJobParams(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
                if(listedJob.folder.equals(jobFolder)){
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
        response.getWriter().write(jsonOut);
    }

    public void saveJob(HttpServletRequest request,HttpServletResponse response) throws IOException {

        JobManager jobManager = new JobManager();
        String url = request.getParameter("_urlaction");
        String params = request.getParameter("params");
        String jobFolder = request.getParameter("job");
        jobManager.saveJob(url,jobFolder,params);
        response.getWriter().write("{\"msg\":\"Sucesso ao criar Job\"}");
    }

    public void deleteJob(HttpServletRequest request,HttpServletResponse response) throws IOException {
        JobManager jobManager = new JobManager();
        String url = request.getParameter("_urlaction");
        String params = request.getParameter("params");
        String jobFolder = request.getParameter("job");

        //jobManager.deleteJob(url,jobFolder,params);
        response.getWriter().write("{\"msg\":\"Sucesso ao deletar Job\"}");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(Permission.isSuperAdmin(request)){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");

            switch (action){
                case "getJobs":this.listPaths(request,response);break;
                case "saveJob":this.saveJob(request,response);break;
                case "deleteJob":this.deleteJob(request,response);
                case "getJob":
                    try {
                        this.getJobParams(request,response);
                    } catch (Exception e) {
                        StringBuilder msg = new StringBuilder();
                        for(StackTraceElement m:e.getStackTrace()){
                            msg.append(m);
                        }
                        response.getWriter().write("{\"msg\":\""+msg+"\"}");
                    }
                    break;
                case "openConfig":response.getWriter().write("{\"openUI\":true}");break;
                default:response.getWriter().write("{\"error\":\"Não foi possível encontrar função\"}");break;
            }
        }else{
            throw new ServletException("Você não tem permissão para executar esta ação");
        }
    }
}
