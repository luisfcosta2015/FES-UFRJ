package br.com.fes.relatorios.itext;
/*
This file is part of the iText (R) project.
Copyright (c) 1998-2016 iText Group NV
*/


import org.junit.experimental.categories.Category;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.test.annotations.type.SampleTest;
import com.itextpdf.text.Font;

@Category(SampleTest.class)
public class PageXofY  {

Font ffont = new Font(Font.FontFamily.UNDEFINED, 20, Font.ITALIC);

public int manipulatePdf(String src,  String dest) throws Exception {
	System.out.println("Teste 1");
    PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
    System.out.println("Teste 2");
    Document doc = new Document(pdfDoc);
    System.out.println("Teste 3");
    int n = pdfDoc.getNumberOfPages();
    
    
    System.out.println("Teste 4");
    for (int i = 1; i <= n; i++) {
    	Paragraph p = new Paragraph(String.format("page %s of %s", i, n));
    //	doc.showTextAligned(p, x, y, pageNumber, textAlign, vertAlign, angle)
        doc.showTextAligned(new Paragraph(String.format("page %s of %s", i, n)),
               500, doc.getBottomMargin(), i, TextAlignment.LEFT,  VerticalAlignment.TOP , 0);
    }
    System.out.println("Teste 5");
    doc.close();
    return 5;
}




}