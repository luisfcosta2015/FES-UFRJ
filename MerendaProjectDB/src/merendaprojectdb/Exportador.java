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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

import java.net.URI;
import org.odftoolkit.simple.SpreadsheetDocument;

import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.text.list.List;
/**
 *
 * @author thiago
 */
public class Exportador {
    public String documentTemplateName;
    public String tableMatriculadosName;
    public String logoAdress;
    public String pastaDeRepositorioParaSalvar;
    public Exportador(){
        this.documentTemplateName = "teste1.odt";
        this.tableMatriculadosName = "template";
        this.logoAdress = "./imagens/logo.png";
        this.pastaDeRepositorioParaSalvar = "./arquivos/";
    }
    private void setVetorMatriculados(Object[][] data, Relatorio relatorio, int pos, String modalidade) {
        data[pos] = new Object[] { modalidade , relatorio.getCapaRelatorio().refeicoes[pos].turnos[0],
                relatorio.getCapaRelatorio().refeicoes[pos].turnos[1], relatorio.getCapaRelatorio().refeicoes[pos].turnos[2],
                relatorio.getCapaRelatorio().refeicoes[pos].turnos[3], relatorio.getCapaRelatorio().refeicoes[pos].totalMatriculados,
                relatorio.getCapaRelatorio().refeicoes[pos].atendidos, relatorio.getCapaRelatorio().refeicoes[pos].numDias,
                relatorio.getCapaRelatorio().refeicoes[pos].totalRefeicoes};
    }
    
    public String exportarODS(Relatorio relatorio){
        String fileName = relatorio.getTitulo();
        //System.out.println(fileName);
        try{
            Object[][] data = new Object[6][9];
            String[] columns = new String[] { "Modalidade de Ensino", "1 turno", "2 turno", "3 turno", "4 turno",
                "Total Matriculados", "Total Atendidos 86%", "Número de dias de distribuição de refeições", 
                "Total de refeições servidas"
            };
            setVetorMatriculados(data, relatorio, 0, "Pré Escola");
            setVetorMatriculados(data, relatorio, 1, "Ensino Fundamental");
            setVetorMatriculados(data, relatorio, 2, "Ensino Médio");
            setVetorMatriculados(data, relatorio, 3, "Jovens e Adultos");
            data[5] = new Object[] {};
            
            //tabela sobre total desjejum
            
            TableModel model = new DefaultTableModel(data, columns);
            // Save the data to an ODS file and open it.
            File file = new File("arquivos/" + fileName + ".ods");
            File fileEstilos = new File("arquivos/estilos.ods");
            SpreadSheet spread = SpreadSheet.createEmpty(model);
            Sheet sheet = spread.getSheet(0);
            System.out.println("!!");
            spread.addSheet("arquivos/estilos.ods");
            System.out.println("!!");
            Sheet sheetEstilos = SpreadSheet.createFromFile(fileEstilos).getSheet(0);
            
            sheetEstilos.getCellAt("A1").getStyle();
            System.out.println("!!");
            spread.saveAs(file);
            System.out.println("!!");
            
            
            
            File f1 = new File("template/ooo2flyer_p1.odt");
            ODSingleXMLDocument p1 = ODSingleXMLDocument.createFromPackage(file);
            // System.out.println(p1);
            OOUtils.open(file);
        }
          
        catch (IllegalArgumentException e) {
            System.out.println("vish");
        } 
        catch (IOException e) {
            System.out.println("vish2");
        }
        catch(JDOMException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
    
    private void cabecalho(TextDocument outputOdt, Relatorio relatorio) throws Exception {
        // add image
        outputOdt.newImage(new URI(this.logoAdress));

        // add paragraph
        Escola escola = relatorio.getEscola();
        outputOdt.addParagraph(escola.getEstado());
        outputOdt.addParagraph(escola.getPrefeitura());
        outputOdt.addParagraph(escola.getSecretaria());
        outputOdt.addParagraph(escola.getSubsecretaria());
        outputOdt.addParagraph(escola.getDepartamento());
        outputOdt.addParagraph(escola.getDiretoria());
    }
    private void matriculadosFixedCampos(Table table) {
        Cell cell = table.getCellByPosition(0, 0);
        cell.setStringValue("ALUNOS MATRICULADOS");
        cell = table.getCellByPosition(5,0);
        cell.setStringValue("TOTAL MATRICULADOS");
        cell = table.getCellByPosition(6,0);
        cell.setStringValue("TOTAL ATENDIDOS 86%");
        cell = table.getCellByPosition(7,0);
        cell.setStringValue("Nº DE DIAS DE DISTRIBUIÇÃO DE REFEIÇÃO");
        cell = table.getCellByPosition(8,0);
        cell.setStringValue("TOTAL DE REFEICOES SERVIDAS");
        
        cell = table.getCellByPosition(0,1);
        cell.setStringValue("MODALIDADE DE ENSINO");
        cell = table.getCellByPosition(0,2);
        cell.setStringValue("PRÉ ESCOLAR");
        cell = table.getCellByPosition(0,3);
        cell.setStringValue("ENSINO FUNDAMENTAL");
        cell = table.getCellByPosition(0,4);
        cell.setStringValue("JOVENS E ADULTOS");
        cell = table.getCellByPosition(0,5);
        cell.setStringValue("ENSINO ESPECIAL");
        cell = table.getCellByPosition(0,6);
        cell.setStringValue("TOTAL");
        
        cell = table.getCellByPosition(1,1);
        cell.setStringValue("1º TURNO");
        cell = table.getCellByPosition(2,1);
        cell.setStringValue("2º TURNO");
        cell = table.getCellByPosition(3,1);
        cell.setStringValue("3º TURNO");
        cell = table.getCellByPosition(4,1);
        cell.setStringValue("4º TURNO");
    }
    private void setDesjejumTable(Table desjejum, CapaDados capa) {
        Cell cell = desjejum.getCellByPosition(0,0);
        cell.setStringValue("DESJEJUM - ALUNOS ATENDIDOS 86%");
        cell = desjejum.getCellByPosition(1,0);
        cell.setStringValue(Integer.toString(capa.alunosAtendidosDesjejum));
        cell = desjejum.getCellByPosition(2,0);
        cell.setStringValue("TOTAL MENSAL DESJEJUM SERVIDO");
        cell = desjejum.getCellByPosition(3,0);
        cell.setStringValue(Integer.toString(capa.desjejumTotalMensalServido));
    }
    private void setMaisEduc(Table maisEduc1, Table maisEduc2, CapaDados capa) {
        Cell cell = maisEduc1.getCellByPosition(0,0);
        cell.setStringValue("Matriculados");
        cell = maisEduc1.getCellByPosition(1,0);
        cell.setStringValue("1º turno Matriculados");
        cell = maisEduc1.getCellByPosition(2,0);
        cell.setStringValue("1º turno Atendidos");
        cell = maisEduc1.getCellByPosition(3,0);
        cell.setStringValue("Dias Distribuição Mais Educação");
        cell = maisEduc1.getCellByPosition(4,0);
        cell.setStringValue("Total Desjejum Servido");
        cell = maisEduc1.getCellByPosition(5,0);
        cell.setStringValue("Total Lanche Servido");
        
        cell = maisEduc2.getCellByPosition(0,0);
        cell.setStringValue("Matriculados");
        cell = maisEduc2.getCellByPosition(1,0);
        cell.setStringValue("1º turno Matriculados");
        cell = maisEduc2.getCellByPosition(2,0);
        cell.setStringValue("1º turno Atendidos");
        cell = maisEduc2.getCellByPosition(3,0);
        cell.setStringValue("Dias Distribuição Mais Educação");
        cell = maisEduc2.getCellByPosition(4,0);
        cell.setStringValue("Total Desjejum Servido");
        cell = maisEduc2.getCellByPosition(5,0);
        cell.setStringValue("Total Lanche Servido");
        cell = maisEduc2.getCellByPosition(6,0);
        cell.setStringValue("Total Mais Educação");
        
    }
    
    public void exportarODT(Relatorio relatorio){
        String fileName = relatorio.getTitulo().replace('/', '-');
        fileName = fileName.replaceAll(" ", "");
        fileName = fileName + ".odt";
        String fileAdress = this.pastaDeRepositorioParaSalvar + fileName;
        try{
            TextDocument outputOdt = TextDocument.newTextDocument();
            outputOdt.save(fileAdress);
            File f1 = new File(fileAdress);
            
            ODSingleXMLDocument p1 = ODSingleXMLDocument.createFromPackage(f1);

            String adressOds = exportarODS(relatorio);
            File f2 = new File(adressOds);
            ODSingleXMLDocument p2 = ODSingleXMLDocument.createFromPackage(f2);

            p1.add(p2,false);
            p1.saveToPackageAs(new File(fileAdress));
            f2.delete();
        }
        catch (IllegalArgumentException e) {
            //ErrorManager.showErrorMessage("createOdt", e.toString());
            System.out.println(e.toString());
        } 
        catch (IOException e) {
            //ErrorManager.showErrorMessage("createOdt", e.toString());
            System.out.println(e.toString());
        } 
        catch (JDOMException ex) {
            System.out.println(ex.toString());
            
        } 
        catch (Exception e) {
            System.out.println(e.toString());
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
