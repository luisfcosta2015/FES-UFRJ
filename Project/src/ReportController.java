
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
            reqProc(request);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        response.getWriter().write("");
    }

    protected void reqProc(HttpServletRequest request) throws Exception {//Realiza todos os procedimentos após a request vinda da página
        HashMap<String,String> stResults;

        String[] dynamK = new String[0];
        String[][] dynamResult = new String[0][];

        procParams(request);
        tarefaBanco(dynamK,dynamResult);
        stResults=rssql.getStaticResults();

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

    protected void tarefaBanco(String[] dynamK, String[][] dynamResult) throws Exception {
        rssql = new RSSQL("rssql.json",params);


        dynamK=rssql.getDynamicKeys();
        dynamResult=rssql.getDynamicResults();
    }


}
