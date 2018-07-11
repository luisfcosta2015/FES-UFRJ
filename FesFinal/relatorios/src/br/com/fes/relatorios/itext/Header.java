package br.com.fes.relatorios.itext;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;



public class Header extends PdfPageEventHelper {
    Font ffont = new Font(Font.FontFamily.UNDEFINED, 20, Font.ITALIC);

    public void onTopPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Phrase header = new Phrase("this is a header", ffont);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                header,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.top() + 10, 0);
    }


	public int first_header(PdfWriter writer,Document document,String nome_escola,int inep, int ano, String turma,String grau,String PICT) throws MalformedURLException, IOException, DocumentException {
	    Font headerfont = new Font(Font.FontFamily.UNDEFINED, 10, Font.NORMAL);
	    Font headerfont2 = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);
	    Font headerfont3 = new Font(Font.FontFamily.UNDEFINED, 24, Font.BOLD);
	    Phrase header		= new Phrase("ESTADO DO RIO DE JANEIRO", headerfont);
	    Phrase header2 		= new Phrase("PREFEITURA MUNICIPAL DE DUQUE DE CAXIAS", headerfont);
	    Phrase header3		= new Phrase("SECRETARIA MUNICIPAL DE EDUCA��O", headerfont);
	    Phrase header4 		= new Phrase(nome_escola, headerfont2);
	    Phrase header5 		= new Phrase("INEP:" , headerfont2);
	    Phrase header6 		= new Phrase("" + inep, headerfont);
	    Phrase anoH			= new Phrase("Ano:", headerfont2);
	    Phrase ano_atual 	= new Phrase("" + ano, headerfont);
	    Phrase turmaH 		= new Phrase("Turma:", headerfont2);
	    Phrase turma_atual 	= new Phrase("" + turma, headerfont);
	    Phrase Grau 		= new Phrase("" + grau, headerfont);
	    Phrase Titulo 		= new Phrase("Listagem Nominal com Situa��o", headerfont3);
	    
	    System.out.println("turma = " + turma);
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
	
	    return 4;
	}
	
}