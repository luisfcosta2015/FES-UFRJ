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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.ErrorManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdom.JDOMException;

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
    private void setVetorMatriculados(Object[][] data, Relatorio relatorio, int pos, String modalidade) {
        data[pos] = new Object[] { modalidade , relatorio.getCapaRelatorio().refeicoes[pos].turnos[0],
                relatorio.getCapaRelatorio().refeicoes[pos].turnos[1], relatorio.getCapaRelatorio().refeicoes[pos].turnos[2],
                relatorio.getCapaRelatorio().refeicoes[pos].turnos[3], relatorio.getCapaRelatorio().refeicoes[pos].totalMatriculados,
                relatorio.getCapaRelatorio().refeicoes[pos].atendidos, relatorio.getCapaRelatorio().refeicoes[pos].numDias,
                relatorio.getCapaRelatorio().refeicoes[pos].totalRefeicoes};
    }
    
    public void exportarODS(Relatorio relatorio){
        String fileName = relatorio.getTitulo();
        try{
            Object[][] data = new Object[5][9];
            String[] columns = new String[] { "Modalidade de Ensino", "1 turno", "2 turno", "3 turno", "4 turno",
                "Total Matriculados", "Total Atendidos 86%", "Número de dias de distribuição de refeições", 
                "Total de refeições servidas"
            };
            setVetorMatriculados(data, relatorio, 0, "Pré Escola");
            setVetorMatriculados(data, relatorio, 1, "Ensino Fundamental");
            setVetorMatriculados(data, relatorio, 2, "Ensino Médio");
            setVetorMatriculados(data, relatorio, 4, "Jovens e Adultos");
            
            TableModel model = new DefaultTableModel(data, columns);  

            // Save the data to an ODS file and open it.
            File file = new File("arquivos/" + fileName + ".ods");
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
    
    
    public void exportarODT(){
        try{
            
            File f1 = new File("arquivos/vazio.odt");
            ODSingleXMLDocument p1 = ODSingleXMLDocument.createFromPackage(f1);
            
            
            File f2 = new File("arquivos/teste2.ods");
            ODSingleXMLDocument p2 = ODSingleXMLDocument.createFromPackage(f2);

            p1.add(p2,false);
            p1.saveToPackageAs(new File("arquivos/Final"));
            System.out.println("terimnou");
        }
        catch (IllegalArgumentException e) {
            //ErrorManager.showErrorMessage("createOdt", e.toString());
            System.out.println("vosh");
        } 
        catch (IOException e) {
            //ErrorManager.showErrorMessage("createOdt", e.toString());
            System.out.println("vosh2");
        } catch (JDOMException ex) {
            System.out.println("vosh3");
            
        } 
    }
    
    public void exportarPDF(){
        try{
            
            // Load the ODS file
            System.out.println("passei0");
            final OpenDocument doc = new OpenDocument();
            System.out.println("passei1");
            doc.loadFrom("arquivos/teste2.ods");
            System.out.println("passei2");

            // Open the PDF document
            Document document = new Document(PageSize.A4);
            File outFile = new File("arquivos/invoice.pdf");

            PdfDocument pdf = new PdfDocument();

            document.addDocListener(pdf);

            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            PdfWriter writer = PdfWriter.getInstance(pdf, fileOutputStream);
            pdf.addWriter(writer);

            document.open();

            // Create a template and a Graphics2D object 
            Rectangle pageSize = document.getPageSize();
            int w = (int) (pageSize.getWidth() * 0.9);
            int h = (int) (pageSize.getHeight() * 0.95);
            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(w, h);

            Graphics2D g2 = tp.createPrinterGraphics(w, h, null);
            // If you want to prevent copy/paste, you can use
            // g2 = tp.createGraphicsShapes(w, h, true, 0.9f);

            tp.setWidth(w);
            tp.setHeight(h);

            // Configure the renderer
            System.out.println("passei3");
            ODTRenderer renderer = new ODTRenderer(doc);
            System.out.println("passei4");
            renderer.setIgnoreMargins(true);
            renderer.setPaintMaxResolution(true);

            // Scale the renderer to fit width
            renderer.setResizeFactor(renderer.getPrintWidth() / w);
            // Render
            renderer.paintComponent(g2);
            g2.dispose();

            // Add our spreadsheet in the middle of the page
            float offsetX = (pageSize.getWidth() - w) / 2;
            float offsetY = (pageSize.getHeight() - h) / 2;
            cb.addTemplate(tp, offsetX, offsetY);
            // Close the PDF document
            document.close();
            
            
        }
        catch (IllegalArgumentException e) {
            System.out.println("vosh");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exportador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Exportador.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
