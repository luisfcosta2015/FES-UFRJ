/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import com.itextpdf.text.pdf.*;
import com.itextpdf.text.*;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.ErrorManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jopendocument.dom.ODPackage;
import org.jopendocument.dom.ODSingleXMLDocument;
import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.jopendocument.dom.text.Heading;
import org.jopendocument.dom.text.Paragraph;
import org.jopendocument.model.OpenDocument;
import org.jopendocument.renderer.ODTRenderer;
/**
 *
 * @author thiago
 */
public class Exportador {
    
    public Exportador(){
        
    }
    
    public void exportarODS(){
        try{
            Object[][] data = new Object[6][2];
            data[0] = new Object[] { "January", 1 };
            data[1] = new Object[] { "February", 3 };
            data[2] = new Object[] { "March", 8 };
            data[3] = new Object[] { "April", 10 };
            data[4] = new Object[] { "May", 15 };
            data[5] = new Object[] { "June", 18 };

            String[] columns = new String[] { "Month", "Temp" };

            TableModel model = new DefaultTableModel(data, columns);  

            // Save the data to an ODS file and open it.
            File file = new File("arquivos/teste2.ods");
            SpreadSheet.createEmpty(model).saveAs(file);
            System.out.println("fim");

            //OOUtils.open(file);
        }
          
        catch (IllegalArgumentException e) {
            System.out.println("vish");
        } 
        catch (IOException e) {
            System.out.println("vish2");
        }
    }
    
    
    public void exportarPDF(){
        try{
            /*System.out.println("passei0");
            final OpenDocument doc = new OpenDocument();
            
            System.out.println("passei0.5");
            doc.loadFrom("arquivos/teste2.ods");

            // Open the PDF document
            System.out.println("passei1");
            Document document = new Document(PageSize.A4);
            File outFile = new File("invoice.pdf");
            
            System.out.println("passei2");

            PdfDocument pdf = new PdfDocument();

            document.addDocListener(pdf);
            
            System.out.println("passei3");

            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            PdfWriter writer = PdfWriter.getInstance(pdf, fileOutputStream);
            pdf.addWriter(writer);
            
            System.out.println("passei4");

            document.open();
            
            System.out.println("passei5");

            // Create a template and a Graphics2D object 
            Rectangle pageSize = document.getPageSize();
            int w = (int) (pageSize.getWidth() * 0.9);
            int h = (int) (pageSize.getHeight() * 0.95);
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(w, h);
            
            System.out.println("passei6");

            Graphics2D g2 = tp.createPrinterGraphics(w, h, null);
            // If you want to prevent copy/paste, you can use
            // g2 = tp.createGraphicsShapes(w, h, true, 0.9f);

            tp.setWidth(w);
            tp.setHeight(h);
            
            System.out.println("passei7");

            // Configure the renderer
            ODTRenderer renderer = new ODTRenderer(doc);
            System.out.println("passeiA");
            renderer.setIgnoreMargins(true);
            System.out.println("passeiB");
            renderer.setPaintMaxResolution(true);

            
            System.out.println("passei8");
            // Scale the renderer to fit width
            renderer.setResizeFactor(renderer.getPrintWidth() / w);
            // Render
            renderer.paintComponent(g2);
            g2.dispose();
            
            System.out.println("passei9");

            // Add our spreadsheet in the middle of the page
            float offsetX = (pageSize.getWidth() - w) / 2;
            float offsetY = (pageSize.getHeight() - h) / 2;
            cb.addTemplate(tp, offsetX, offsetY);
            
            System.out.println("passei10");
            // Close the PDF document
            document.close();*/
            System.out.println("passei");
            ODPackage p = new ODPackage(new File("arquivos/teste.odt")); 
            ODSingleXMLDocument doc = p.toSingle();
            
            System.out.println("passei");
            ODPackage a = new ODPackage(new File("arquivos/teste2.ods")); 
            ODSingleXMLDocument thiago = a.toSingle();
            System.out.println("passei");
            
            doc.add(thiago);
        }
        catch (IllegalArgumentException e) {
            //ErrorManager.showErrorMessage("createOdt", e.toString());
            System.out.println("vosh");
        } 
        catch (IOException e) {
            //ErrorManager.showErrorMessage("createOdt", e.toString());
            System.out.println("vosh2");
        } 
    }
    
}
