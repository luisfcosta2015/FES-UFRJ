import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import sslRel.helpers.DBHelper;
import sslRel.helpers.Permission;
import sslRel.helpers.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Orquestrador extends HttpServlet {
    private DBHelper db = new DBHelper();
    private RSSQL rssql;
    private HashMap<String,String> params;

    public Orquestrador(){
        super();
    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String baseUri = getServletContext().getRealPath("").split("out")[0];
        baseUri = baseUri+Paths.get("res/reportsTemplates");

//        File htmlSource = new File(baseUri+"/ListagemNominal.html");
        File htmlSource = new File(baseUri+"/DiarioDeClasses/DiarioDeClasse.html");
        File pdfDest = new File(baseUri+"/output.pdf");
        // pdfHTML specific code
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(baseUri);
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource), new FileOutputStream(pdfDest), converterProperties);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(Permission.isAny(request)){
            System.out.println("Passou");
            this.db.connect();
            //response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            try {
                reqProc(request);//chama os procedimentos para processar os requerimentos vindos da página
            } catch (Exception e) {
                e.printStackTrace();
            }
            db.close();
        }else{
            throw new ServletException("Usuário não Permitido");
        }
    }




    protected void reqProc(HttpServletRequest request) throws Exception {//Realiza todos os procedimentos após a request vinda da página
        HashMap<String,String> stMap;//Mapa dos dados estáticos
        //inicialização inicial forçada pela sintaxe
        String[] dynamK ; //chaves dos dados dinâmicos
        String[][] dynamResult ;//os dados dinâmicos em si
        HTMLReplacer htmlR;
        HashMap<String,String> namespace = new HashMap<>();


        //String querySt = new Scanner(new File("C:\\Users\\00\\Documents\\Programação\\FES-UFRJ\\Project\\res\\reportsTemplates\\Consultas\\DiarioDeClasses\\DiarioDeClasses.static.sql")).useDelimiter("\\A").next();
        //String queryDy = new Scanner(new File("C:\\Users\\00\\Documents\\Programação\\FES-UFRJ\\Project\\res\\reportsTemplates\\Consultas\\DiarioDeClasses\\DiarioDeClasses.din.sql")).useDelimiter("\\A").next();
        String q1;
        String q2;

        RSSQL rssql =  procParams(request);

        dynamK=rssql.getDynamicKeys();//funcionando obtendo as chaves dinâmicas

        q1=rssql.querySt;//query estática com variáveis não substituídas
        q2=rssql.queryDy;//query dinâmica com variáveis não substituídas

        //System.out.println(rssql.getStaticResults().size());
        //getStaticResults contém nulos nos resultados
        //getDynamicResults contém nulos nos resultados
        dynamResult=rssql.getDynamicResults();

        stMap=rssql.getStaticResults();


        //System.out.println(stMap.entrySet().iterator().next());

        //criaNamespace(stMap,dynamK,dynamResult,namespace);

    }


    protected RSSQL procParams(HttpServletRequest request) throws Exception {
        JobManager jobManager = new JobManager();

            HashMap<String,String> params = new HashMap<>();
            JobManager.JobFormat job = jobManager.getJobByURL(request.getParameter("_urlaction"));
            Set<String> keys = job.params.keySet();
            for(String key:keys){
                params.put(key,request.getParameter(job.params.get(key)));
                System.out.println(key+","+params.get(key));
            }


//            Resource resource = new Resource();

//            resource.findResource(new File(System.getProperty("reportsTemplates")+"/"+job.folder),".rssql.json",false);
//            rssql = new RSSQL(resource.files.get(0).getCanonicalPath());
//
            return rssql;
    }


    protected void criaNamespace(HashMap<String,String> staticData, String[] dynamK, String[][] dynamResult, HashMap<String,String> namespace){//Cria o namespace para seguir com o HTMLReplacer
        namespace.putAll(staticData);
       // namespace.put(dynamK, dynamResult);

    }
}