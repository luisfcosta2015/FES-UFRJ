
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReportController extends HttpServlet {
    protected DBHelper db = new DBHelper();
    protected RSSQL rssql;
    protected HashMap<String,String> params;

    public ReportController(){
        super();
    }



    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String baseUri = getServletContext().getRealPath("").split("out")[0];
        baseUri = baseUri+Paths.get("res/reportsTemplates");

//        File htmlSource = new File(baseUri+"/Listagem_Nominal_com_Situacao.html");
        File htmlSource = new File(baseUri+"/Diario_de_Classe.html");
        File pdfDest = new File(baseUri+"/output.pdf");
        // pdfHTML specific code
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(baseUri);
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource), new FileOutputStream(pdfDest), converterProperties);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.db.connect();
        //response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(request.getParameter("escola")+request.getParameter("ano")+request.getParameter("turma"));


        try {
            reqProc(request);//chama os procedimentos para processar os requerimentos vindos da página
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void reqProc(HttpServletRequest request) throws Exception {//Realiza todos os procedimentos após a request vinda da página
        HashMap<String,String> stMap;//Mapa dos dados estáticos
        //inicialização inicial forçada pela sintaxe
        String[] dynamK ; //chaves dos dados dinâmicos
        String[][] dynamResult ;//os dados dinâmicos em si
        HTMLReplacer htmlR;
        HashMap<String,String> namespace = new HashMap<>();



        procParams(request);


        tarefaBanco();
        dynamK=rssql.getDynamicKeys();
        dynamResult=rssql.getDynamicResults();
        stMap=rssql.getStaticResults();
        //System.out.println(stMap.entrySet().iterator().next());

        criaNamespace(stMap,dynamK,dynamResult,namespace);

    }

    protected void procParams(HttpServletRequest request){
        params = new HashMap<>();
        Map<String, String[]> parameters;


        Iterator<String> iterator;
        parameters=request.getParameterMap();
        iterator=parameters.keySet().iterator();
        while (iterator.hasNext()){
            params.put(iterator.next(),"");//prepara o HashMap params para ser utilizado no RSSQL
        }

    }

    protected void tarefaBanco() throws Exception {
        rssql = new RSSQL("test/rssql.json",params);//ocorre erro


    }

    protected void criaNamespace(HashMap<String,String> staticData, String[] dynamK, String[][] dynamResult, HashMap<String,String> namespace){//Cria o namespace para seguir com o HTMLReplacer
        namespace.putAll(staticData);
       // namespace.put(dynamK, dynamResult);

    }


}
