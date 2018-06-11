package relatorio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 
 * Example written by Bruno Lowagie in answer to:
 * http://stackoverflow.com/questions/27780756/adding-footer-with-itext-doesnt-work
 */

//import com.itextpdf.io.image.ImageDataFactory;
//import com.itextpdf.layout.element.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
 
@WrapToTest
public class Main extends Header {
	
    public static final String DEST = "results/chapter01/page_footer.pdf";
    public static final String PICT = "src/main/resources/Brasao-caxias.png";
 
    public static void main(String[] args) throws IOException , DocumentException, SQLException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Main().createPdf(DEST);
        
    }
    

	
	
 
    class MyFooterandheader extends PdfPageEventHelper {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 20, Font.ITALIC);
 
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase header = new Phrase("this is a header", ffont);
            Phrase footer = new Phrase("this is a footer", ffont);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    header,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 10, 0);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0);
        }
    }
    
    class MyFooter extends PdfPageEventHelper {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 20, Font.ITALIC);
 
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase footer = new Phrase("this is a footer", ffont);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0);
        }
    }
 /*
    class Header extends PdfPageEventHelper {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 20, Font.ITALIC);
 
        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase header = new Phrase("this is a header", ffont);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    header,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.top() + 10, 0);
        }
    }
  
   */
/*    
    public void header(PdfWriter writer,Document document,String nome_escola,int inep, int ano, int turma,String grau) throws MalformedURLException, IOException, DocumentException {
        Font headerfont = new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL);
        Font headerfont2 = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);
        Font headerfont3 = new Font(Font.FontFamily.UNDEFINED, 24, Font.BOLD);
        Phrase header		= new Phrase("ESTADO DO RIO DE JANEIRO", headerfont);
        Phrase header2 		= new Phrase("PREFEITURA MUNICIPAL DE DUQUE DE CAXIAS", headerfont);
        Phrase header3		= new Phrase("SECRETARIA MUNICIPAL DE EDUÇÃO", headerfont);
        Phrase header4 		= new Phrase(nome_escola, headerfont2);
        Phrase header5 		= new Phrase("INEP:" , headerfont2);
        Phrase header6 		= new Phrase("" + inep, headerfont);
        Phrase anoH			= new Phrase("Ano:", headerfont2);
        Phrase ano_atual 	= new Phrase("" + ano, headerfont);
        Phrase turmaH 		= new Phrase("Turma:", headerfont2);
        Phrase turma_atual 	= new Phrase("" + turma, headerfont);
        Phrase Grau 		= new Phrase("" + grau, headerfont);
        Phrase Titulo 		= new Phrase("Listagem Nominal com Situação", headerfont3);
        
 
        //add first page header
        PdfContentByte cb = writer.getDirectContent();

      //ColumnText.showTextAligned(canvas, alignment, phrase, x, y, rotation);
        Image img = Image.getInstance(PICT);
        System.out.println("2");
        img.scaleAbsolute(76, 75);
        document.add(img);
        
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,header 	,document.left() + 50 + document.leftMargin(),document.top() + -7, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,header2	,document.left() + 50 + document.leftMargin(),document.top() + -22, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,header3	,document.left() + 50 + document.leftMargin(),document.top() - 37, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,header4	,document.left() + 50 + document.leftMargin(),document.top() + -52, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT,header5	,document.right()-63,document.top() + -52, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT,header6	,document.right()-6,document.top() + -52, 0);
        
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,anoH		,document.left() + 50 + document.leftMargin(),document.top()-77, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,ano_atual ,document.left() + 80 + document.leftMargin(),document.top()-77, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,turmaH	,document.left() + 130 + document.leftMargin(),document.top()-77, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,turma_atual,document.left() + 175 + document.leftMargin(),document.top()-77, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT,Grau		,document.left() + 225 + document.leftMargin(),document.top()-77, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,Titulo 	,(document.right() - document.left()) / 2 + document.leftMargin(),document.top() - 110, 0);

    }
 */   
    
    public void createPdf(String filename) throws IOException,  DocumentException, SQLException {
    	// info to conect to DB
	    String url = "jdbc:mysql://localhost:3306/fes?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";
		
    	
		Header header = new Header();
		//Conect conect = new Conect();
		
		// our SQL SELECT query. 
	    // if you only need a few columns, specify them by name instead of using "*"
	    String query = "SELECT matricula,nome,situacao FROM alunos order by nome ";

    	// step 1
    	FileOutputStream fos = new FileOutputStream(filename);
    	//PdfWriter writer = new PdfWriter(fos);
    	//PdfDocument pdf = new PdfDocument(writer);
    	
    	
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        MyFooter event = new MyFooter();
        writer.setPageEvent(event);
        
        
        String nome_escola = "CIEP Municipalizado 330 - Maria da Glória Corrêa Lemos";
        int inep = 33101094;
        int ano = 2018;
        int turma = 401;
        String grau ="Ensino Fundamental I (Anos iniciais)";
        
        // step 3
        document.open();
        
        //setting header
        header.first_header(writer,document, nome_escola, inep, ano, turma, grau,PICT);    
        
        // step 4
        //opening connection
        Connection conexao = DriverManager.getConnection(url, user, password);
        
		System.out.println("Conectado ao Banco");
        

	    // create the java statement
	    Statement st = conexao.createStatement();
	    ResultSet rs = st.executeQuery(query);
        
        PdfPTable table = new PdfPTable(3);
        
        table.setSpacingBefore(50f);
        
        PdfPCell cell1 = new PdfPCell(new Paragraph("Cód i-Educar"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Nome do Aluno"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Situação"));
  
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

     // iterate through the java resultset, preenchendo tabela com os dados do banco
	      while (rs.next())
	      {
	        int id = rs.getInt("matricula");
	        String matricula = "00" + id;
	        table.addCell(matricula);
	        String Name = rs.getString("Nome");
	        table.addCell(Name);
	        String situacao = rs.getString("situacao");
	        table.addCell(situacao);
	        
	        // print the results
	        System.out.format("%s, %s, %s\n", id, Name, situacao);
	      }
	      st.close();
		
		
		conexao.close();
        
        
        
        
        
        document.add(table);

        
        //page 2
        document.newPage();
        
        document.add(new Paragraph("Test " + 5));
        
        //page 3
        document.newPage();

        
        
        //page 4
        document.newPage();
            
        
        
        /*
        //add last page footer
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
        */
        
        
        
        // step 5
        document.close();
        System.out.println("pronto");
    }

}