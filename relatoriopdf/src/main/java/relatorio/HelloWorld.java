package relatorio;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;


//import com.itextpdf.text.PdfImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *Hello World example 
 */

public class HelloWorld {

	public static final String DEST = "results/chapter01/hello_world.pdf";
	public static final String PICT = "picture.png";
	public static final String PICT2 = "Brasao-caxias.png";
	
	
	public static void main(String args[]) throws IOException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new HelloWorld().createPdf(DEST);
	}
	
	
	public void createPdf(String dest) throws IOException{
		//Initialize PDF writer
		FileOutputStream fos = new FileOutputStream(dest);
		PdfWriter writer = new PdfWriter(fos);
		
		//Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);
	
		System.out.println("1");
		//Initialize document
		Document document = new Document(pdf,new PageSize(PageSize.A4));
       
		Image img = new Image(ImageDataFactory.create(PICT2));
        System.out.println("2");
        img.scaleAbsolute(76, 75);
        System.out.println("3");
        
        
       
		document.add(img);
		System.out.println("4");
		
		//Add paragraph to the document		
		document.add(new Paragraph("Hello World!11"));
		document.add(img);
		
		//Add Image
		document.add(new Paragraph ("------------------------"));
		Image img2 = new Image(ImageDataFactory.create(PICT));
		document.add(img2);
		document.add(img);
	
		
		document.add(new Paragraph ("------------------------"));
		//Close document
		document.close();
		System.out.println("sou eu bola de fogo");
		
	}	
	
	
	

	

}
