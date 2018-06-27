package sslRel.helpers;

import com.itextpdf.html2pdf.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PdfReport {

    public static void generate(HttpServletResponse response,String reportFolderName,String htmlText) throws IOException, ServletException{
        ConverterProperties properties = new ConverterProperties();
        String baseReportPath = System.getProperty("reportsTemplates");
        String baseURI = baseReportPath+System.getProperty("file.separator")+reportFolderName;
        properties.setBaseUri(baseURI);
        ServletOutputStream out = response.getOutputStream();
        HtmlConverter.convertToPdf(htmlText, out,properties);
    }
}
