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
        properties.setBaseUri(baseReportPath+System.getProperty("file.separator")+reportFolderName);
        ServletOutputStream out = response.getOutputStream();
        HtmlConverter.convertToPdf(htmlText, out,properties);
    }
}
