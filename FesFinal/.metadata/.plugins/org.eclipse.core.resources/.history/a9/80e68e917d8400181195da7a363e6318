package br.com.fes.relatorios.itext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class Footer extends PdfPageEventHelper {

    //class MyFooterandheader extends PdfPageEventHelper {
        Font ffont = new Font(Font.FontFamily.UNDEFINED, 20, Font.ITALIC);
 
      /*  public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            Phrase footer = new Phrase("this is a footer", ffont);
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                    footer,
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() - 10, 0);
        }*/
    
        
        
        public void onEndPage(PdfWriter writer, Document doc) 
        {
            Rectangle rect = writer.getPageSize();
            float width = rect.getWidth()/2;   

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();

            String footerOne = dateFormat.format(date);

            Paragraph paraOne = new Paragraph(footerOne);

            Font fontFooter = new Font();
            fontFooter.setSize(8);
            //fontFooter.setColor(Color.GREEN);

            paraOne.setFont(fontFooter);

            Phrase footerPhraseOne = new Phrase(paraOne);
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_LEFT, footerPhraseOne,
                    doc.left(), doc.bottom() - 15, 0);
        }
        


    

}