import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import sslRel.helpers.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JobManager {
    private Resource res=new Resource();
    private File jobsFile;
    private Map<String,JobFormat> jobsContent;

    public JobManager() throws IOException {
        this.jobManager(System.getProperty("ResProject")+"/mainConfig/jobs.json");
    }

    public JobManager(String jsonPath) throws  IOException{
        jobManager(jsonPath);
    }

    public void jobManager(String jsonPath)  throws IOException {
        this.jobsFile= new File(jsonPath);
        boolean fileExists=this.jobsFile.exists();
        if(!jobsFile.exists()){
            fileExists = this.jobsFile.createNewFile();
        }
        if(fileExists){
            String content = Resource.getFileContent(this.jobsFile);
            if(content.equals(""))content="{}";
            Type type = new TypeToken<Map<String, JobFormat>>(){}.getType();
            this.jobsContent = new Gson().fromJson(content, type);
        }else{
            throw new FileNotFoundException("Arquivo de jobs não existe e não pode ser criado");
        }
    }

    public Map<String, JobFormat> getJobs() {
        return jobsContent;
    }


    public String convertDiretoriesListToJson(ArrayList<File> directories){
        StringBuilder out = new StringBuilder();
        out.append("[");
        int size = directories.size();
        for(int i=0;i<size;i++){
            out.append("\""+directories.get(i).getName()+"\"");
            if(i<(size-1)){
                out.append(",");
            }
        }
        out.append("]");
        return  out.toString();
    }

    public ArrayList<File> listAllDirectories(){
        res.findResource(new File(System.getProperty("reportsTemplates")),"",false);
        return res.directories;
    }

    public String[] listJobsURLs() {
        if(this.jobsContent!=null){
            Set<String> keys = this.jobsContent.keySet();
            return keys.toArray(new String[keys.size()]);
        }else{
            return null;
        }

    }

    public JobFormat getJobByURL(String url)throws NullPointerException{
        return this.jobsContent.get(url);
    }

    private HashMap<String,String> paramsHashMap(String paramsJson){
        Type type = new TypeToken<HashMap<String, String>>(){}.getType();
        return new Gson().fromJson(paramsJson, type);
    }

    public void saveJob(String url,String folder,String paramsJSON) throws IOException {
        JobFormat job = new JobManager.JobFormat();
        job.params=this.paramsHashMap(paramsJSON);
        job.folder=folder;
        this.jobsContent.put(url,job);
        String json = new Gson().toJson(this.jobsContent);
        Resource.setFileContent(this.jobsFile,json);
    }

    public boolean clearJob(String url) throws IOException {
        if(this.jobsContent.containsKey(url)){
            this.jobsContent.remove(url);
            String json = new Gson().toJson(this.jobsContent);
            Resource.setFileContent(this.jobsFile,json);
            return true;
        }
        return false;
    }

    public static class JobFormat{
        public String folder;
        public HashMap<String,String> params;
    }

}
