
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


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        StringBuilder content= new StringBuilder();
        String folder = "DiarioDeClasses";
        File path = new File(System.getProperty("reportsTemplates")+"/"+folder);
        Resource f = new Resource();
        f.findResource(path,".html",false);
        ArrayList<File> files = f.files;
        File file = files.get(0);
        PdfReport.generate(response,folder,Resource.getFileContent(file));
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
                    selected = ",\"selected\":"+ jobManager.getJobByURL(url).folder;
                }
            }
        }

        response.getWriter().write("{\"jobs\":"+dirsJson+selected+"}");
    }

    public void getJobParams(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String jobFolder = request.getParameter("job");

        JobManager jobManager = new JobManager();
        Map<String,JobManager.JobFormat> jobs = jobManager.getJobs();
        String jsonOut="{\"msg\":\"Erro: Não foi encontrado o Job pesquisado\"}";

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


        //TODO chamar Replacement specifier e casar ele com params pra mandar pro front-end;



        jsonOut= new Gson().toJson(job.params);
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(Permission.isAny(request)){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");

            switch (action){
                case "getJobs":this.listPaths(request,response);break;
                case "saveJob":this.saveJob(request,response);break;
                case "getJob":this.getJobParams(request,response);break;
                case "openConfig":response.getWriter().write("{\"openUI\":true}");break;
                default:response.getWriter().write("{\"error\":\"Não foi possível encontrar função\"}");break;
            }
        }else{
            throw new ServletException("Você não tem permissão para executar esta ação");
        }
    }
}
