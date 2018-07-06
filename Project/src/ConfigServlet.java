
import com.google.gson.Gson;
import sslRel.helpers.Permission;
import sslRel.helpers.Resource;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@MultipartConfig
public class ConfigServlet extends HttpServlet  {

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
        String fs =System.getProperty("file.separator");
        Resource res = new Resource();

        String jobFolder = request.getParameter("job");

        res.findResource(new File(System.getProperty("reportsTemplates")+fs+jobFolder),"rssql.json",false);

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
            jsonOut="{\"msg\":\"Não Há parâmetros\",\"type\":\"warning\"}";
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
        return "{\"msg\":\"Sucesso ao salvar Job\",\"type\":\"success\"}";
    }

    public String clearJob(HttpServletRequest request) throws IOException {
        JobManager jobManager = new JobManager();
        String url = request.getParameter("_urlaction");

        if(jobManager.clearJob(url))return "{\"msg\":\"Sucesso ao desvincular Job\",\"type\":\"success\"}";
        else return  "{\"msg\":\"Essa página não tinha job\",\"type\":\"warning\"}";

    }

    public String uploadJob(HttpServletRequest request) throws IOException, ServletException {
        String fs =System.getProperty("file.separator");
        String name = request.getParameter("jobModelName"); // Retrieves <input type="text" name="description">
        boolean replace =Boolean.parseBoolean(request.getParameter("replaceJob"));

        File directory = new File(System.getProperty("reportsTemplates")+fs+name);
        String path = directory.getCanonicalPath();

        Part filePartHtml = request.getPart("htmlFile");
        Part filePartRssql = request.getPart("rssqlFile");

        if(filePartHtml.getSize()>0 || filePartRssql.getSize()>0){
            if(!directory.exists()){
                if(directory.mkdirs()){
                    if(filePartHtml.getSize()>0&&filePartHtml.getContentType().equals("text/html")){
                        Resource.setFileContent(path+fs+name+".html",filePartHtml);
                    }

                    if(filePartRssql.getSize()>0&&filePartRssql.getContentType().equals("application/json")){
                        Resource.setFileContent(path+fs+name+".rssql.json",filePartRssql);
                    }
                    return "{\"msg\":\"JobModel criado com sucesso\",\"type\":\"success\"}";
                }else{
                    return "{\"msg\":\"Erro: não foi possível criar arquivos de job\",\"type\":\"error\"}";
                }
            }else if(replace){

                Resource res = new Resource();
                res.findResource(directory,"html",false);
                if(filePartHtml.getSize()>0&&filePartHtml.getContentType().equals("text/html")){
                    for(File file:res.files)file.delete();
                    Resource.setFileContent(path+fs+name+".html",filePartHtml);
                }

                res.findResource(directory,"rssql.json",false);
                if(filePartRssql.getSize()>0&&filePartRssql.getContentType().equals("application/json")){
                    for(File file:res.files)file.delete();
                    Resource.setFileContent(path+fs+name+".rssql.json",filePartRssql);
                }
                return "{\"msg\":\"JobModel substituído com sucesso\",\"type\":\"success\"}";
            }else{
                return "{\"action\":\"replace\"}";
            }
        }else{
            return "{\"msg\":\"Erro: não há arquivos para salvar\",\"type\":\"error\"}";
        }
    }

    public String deleteJob(HttpServletRequest request) throws IOException {
        String fs =System.getProperty("file.separator");

        JobManager jobManager = new JobManager();
        String jobName = request.getParameter("jobModel");

        File jobDir=new File(System.getProperty("reportsTemplates")+fs+jobName);

        if(jobDir.exists()){
            if(Resource.deleteDir(jobDir)){
                Map<String, JobManager.JobFormat> jobs = jobManager.getJobs();
                Set<String> keys = jobs.keySet();
                for(String key:keys){
                    if(jobs.get(key).folder.equals(jobName)){
                        jobManager.clearJob(key);
                    }
                }
                return "{\"msg\":\"Sucesso ao deletar JobModel e jobs associados\",\"type\":\"success\"}";
            }else{
                return "{\"msg\":\"Erro ao tentar deletar JobModel\",\"type\":\"error\"}";
            }
        }else{
            Map<String, JobManager.JobFormat> jobs = jobManager.getJobs();
            Set<String> keys = jobs.keySet();
            for(String key:keys){
                if(jobs.get(key).folder.equals(jobName)){
                    jobManager.clearJob(key);
                }
            }
            return  "{\"msg\":\"Esse jobModel não existe\",\"type\":\"warning\"}";
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        if(Permission.isSuperAdmin(request)){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");

            String out;
            switch (action){
                case "getJobs":out = this.listPaths(request);break;
                case "saveJob":out = this.saveJob(request);break;
                case "clearJob":out = this.clearJob(request);break;
                case "uploadJob":out = this.uploadJob(request);break;
                case "deleteJob":out = this.deleteJob(request);break;
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
                default:out = "{\"msg\":\"Não foi possível encontrar função\",\"type\":\"error\"}";break;
            }
            writer.write(out);
        }else if(!request.getParameter("action").equals("openConfig")){
            writer.write("{\"msg\":\"Você não tem permissão para executar esta ação\",\"type\":\"error\"}");
        }else{
            throw new ServletException("Permissão Negada!!");
        }
    }

    public ServletContext getContext(){
        return super.getServletContext();
    }

    public String getName(){
        return super.getServletName();
    }
    public Class<? extends ConfigServlet> getClasse(){
        return this.getClass();
    }

}