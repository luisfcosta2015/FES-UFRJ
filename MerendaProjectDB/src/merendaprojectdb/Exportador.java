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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public String modeloOds;
    public String modeloCardapio;
    public Exportador(){
        this.documentTemplateName = "teste1.odt";
        this.tableMatriculadosName = "template";
        this.logoAdress = "./imagens/logo.png";
        this.pastaDeRepositorioParaSalvar = "./arquivos/";
        this.modeloOds = "./arquivos/template/Modelo.ods";
        this.modeloCardapio = "./arquivos/template/ModeloCardapio.ods";
    }
    public String getFileName(Relatorio relatorio, String tipo) {
        String fileName = relatorio.getTitulo().replace('/', '-');
        String pasta =(relatorio.getAno()-1900)+"/";
        fileName = fileName.replaceAll(" ", "");
        fileName = fileName + tipo;
        return this.pastaDeRepositorioParaSalvar + pasta + fileName;
    }
      
    public SpreadsheetDocument gerarArquivo(Relatorio relatorio, String fileAdress){
        try {
            // INICIO CAPA
            CapaDados capaDados = relatorio.getCapaRelatorio();
            SpreadsheetDocument doc = SpreadsheetDocument.newSpreadsheetDocument();
            SpreadsheetDocument modelo = SpreadsheetDocument.loadDocument(this.modeloOds);
            Table capa = modelo.getTableByName("Capa");
            
            doc.removeSheet(0);   
            capa.getCellByPosition(1, 3).setStringValue(relatorio.getEscola().getUnidade());
            capa.getCellByPosition(9, 3).setStringValue(""+(relatorio.getMes()+1)+"/"+(relatorio.getAno()-1900));
            capa.getCellByPosition(1, 4).setStringValue(relatorio.getEscola().getUnidade());
            capa.getCellByPosition(1, 5).setStringValue(relatorio.getEscola().getTelefone());
            capa.getCellByPosition(7, 5).setStringValue(""+relatorio.getEscola().getINEP());
            for(int i=11;i<16;i++)
            {
                for(int j=2;j<10;j++)
                {
                    capa.getCellByPosition(j, i).setStringValue(""+capaDados.getValueAt(i-11, j-2));
                }
            }
            capa.getCellByPosition(2, 17).setStringValue(""+capaDados.alunosAtendidosDesjejum);
            capa.getCellByPosition(6, 17).setStringValue(""+capaDados.desjejumTotalMensalServido);
            
            capa.getCellByPosition(2,21).setStringValue(""+capaDados.maisEducacao[0].matriculados);
            capa.getCellByPosition(4,21).setStringValue(""+capaDados.maisEducacao[0].atendidos);
            capa.getCellByPosition(6,21).setStringValue(""+capaDados.maisEducacao[0].numDias);
            capa.getCellByPosition(7,21).setStringValue(""+capaDados.maisEducacao[0].totalDesjejum);
            capa.getCellByPosition(8,21).setStringValue(""+capaDados.maisEducacao[0].totalLanche);
            
            capa.getCellByPosition(2,24).setStringValue(""+capaDados.maisEducacao[1].matriculados);
            capa.getCellByPosition(4,24).setStringValue(""+capaDados.maisEducacao[1].atendidos);
            capa.getCellByPosition(6,24).setStringValue(""+capaDados.maisEducacao[1].numDias);
            capa.getCellByPosition(8,24).setStringValue(""+capaDados.maisEducacao[1].totalLanche);
            capa.getCellByPosition(9,24).setStringValue(""+capaDados.getTotalMaisEducacao());
            capa.getCellByPosition(2,26).setStringValue(""+capaDados.getTotalServido());
            doc.appendSheet(capa, "capa");
            //FIM CAPA
            //INICIO CARDAPIO
            
            Cardapio cardapioRel = relatorio.getCardapioRelatorio();
            SpreadsheetDocument modeloCardapio = SpreadsheetDocument.loadDocument(this.modeloCardapio);
            Table cardapio = modeloCardapio.getTableByName("Cardapio");
            
            System.out.println(relatorio.getEscola().getDiretoria());
            
            cardapio.getCellByPosition(1,2).setStringValue("Unidade: " + relatorio.getEscola().getUnidade()+" / Distrio: ");
            cardapio.getCellByPosition(1,3).setStringValue("Diretoria: " + relatorio.getEscola().getDiretoria());
            cardapio.getCellByPosition(1,4).setStringValue("Descrição do cardápio - " + relatorio.getMes() + "/" + relatorio.getAno());
            
            DateFormat df = new SimpleDateFormat("dd/MM");
            ArrayList<DuplaDataCardapio> cardapioList = cardapioRel.getList();
            int i=6;
            for(DuplaDataCardapio dupla : cardapioList) {
                Object[] obj = new Object[2];
                obj[0] = df.format(dupla.data);
                if(dupla.cardapioDoDia != null ) {
                    obj[1] = dupla.cardapioDoDia;
                }
                else {
                    obj[1] = "";
                }
                cardapio.getCellByPosition(0,i).setStringValue(""+obj[0]);
                cardapio.getCellByPosition(1,i).setStringValue(""+obj[1]);
                i++;
            }
            
            doc.appendSheet(cardapio, "Cardapio");
            //FIM CARDAPIO
            return doc;
            
        } catch (Exception e) {
            System.err.println("ERROR: unable to create output file.");
            System.err.println(e);
            return null;
        }
    }
    
    public void exportarODS(Relatorio relatorio){
        System.out.println("Inicio");
        String fileAdress = getFileName(relatorio, ".ods");
        
        SpreadsheetDocument doc = gerarArquivo(relatorio, fileAdress);
        try {
            doc.save(fileAdress);

            File file = new File(fileAdress);
            System.out.println("Fim");
            OOUtils.open(file);
        } catch (IOException ex) {
            Logger.getLogger(Exportador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Exportador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exportarODT(Relatorio relatorio){
        String fileAdress = getFileName(relatorio, ".odt");
        try{
            System.out.println("Inicio");
            TextDocument outputOdt = TextDocument.newTextDocument();
            outputOdt.save(fileAdress);
            File f1 = new File(fileAdress);
            
            ODSingleXMLDocument p1 = ODSingleXMLDocument.createFromPackage(f1);

            String adressOds = getFileName(relatorio, ".ods");
            SpreadsheetDocument doc = gerarArquivo(relatorio, fileAdress);
            doc.save(adressOds);
            File f2 = new File(adressOds);
            ODSingleXMLDocument p2 = ODSingleXMLDocument.createFromPackage(f2);
            
            SpreadSheet planilhas = SpreadSheet.createFromFile(f2);
            Sheet capa = planilhas.getSheet("capa");
            Sheet cardapio = planilhas.getSheet("Cardapio");
            
            p1.add(p2,false);
            p1.saveToPackageAs(new File(fileAdress));
            f2.delete();
            System.out.println("Fim");
            OOUtils.open(f1);
            
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
