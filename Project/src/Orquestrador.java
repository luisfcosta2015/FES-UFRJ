import sslRel.helpers.DBHelper;
import sslRel.helpers.PdfReport;
import sslRel.helpers.Permission;
import sslRel.helpers.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Orquestrador extends HttpServlet {
    private DBHelper db = new DBHelper();
    private RSSQL rssql;
    private String fs =System.getProperty("file.separator");

    public Orquestrador(){
        super();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Permission.isLogged(request)){
            this.db.connect();
            //response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try {
                reqProc(request,response);//chama os procedimentos para processar os requerimentos vindos da página
            } catch (Exception e) {
                e.printStackTrace();
            }
            db.close();
        }else{
            throw new ServletException("Usuário não Permitido");
        }
    }




    protected void reqProc(HttpServletRequest request,HttpServletResponse response) throws Exception {//Realiza todos os procedimentos após a request vinda da página
        HashMap<String,String> stMap;//Mapa dos dados estáticos
        //inicialização inicial forçada pela sintaxe
        String html;
        JobManager jobManager = new JobManager();
        JobManager.JobFormat job = jobManager.getJobByURL(request.getParameter("_urlaction"));//Pega job necessário para tradução de parametros

        procParams(request,job); //Pega dados do banco no objeto da classe RSSQL
        html = this.createHTMLReport(request,job);//Cria String HTML com todos os dados substituidos

        PdfReport.generate(response,job.folder,html);

    }


    protected void procParams(HttpServletRequest request,JobManager.JobFormat job) throws Exception {//Procedimento de processamento de parametros
        HashMap<String,String> params = new HashMap<>();
        Resource resource = new Resource();
        Set<String> keys = job.params.keySet();
        for(String key:keys){
            params.put(key,request.getParameter(job.params.get(key)));
        }
        resource.findResource(new File(System.getProperty("reportsTemplates")+fs+job.folder),".rssql.json",false);
        String path = resource.files.get(0).getCanonicalPath();
        rssql = new RSSQL(path).loadQuery(params).queryFields();
    }

    protected String createHTMLReport(HttpServletRequest request, JobManager.JobFormat job) throws IOException {//Procedimento de geração do html
        String html="";
        Resource resource = new Resource();
        resource.findResource(new File(System.getProperty("reportsTemplates")+fs+job.folder),".html",false);
        String filename = resource.files.get(0).getCanonicalPath();

        HTMLReplacer htmlR = new HTMLReplacer(filename);
        htmlR.processStatic(rssql.getStaticResults());
        htmlR.processDynamics(rssql.getDynamicResults());

        return htmlR.doc.outerHtml();
    }


}