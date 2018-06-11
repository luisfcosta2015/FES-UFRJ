package relatorio;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class DBTable {
  public static void main(String[] args) {
    Document document = new Document();

    try {
        PdfWriter.getInstance(document,
                new FileOutputStream("results/chapter01/DBT.pdf"));
        document.open();

        Image image1 = Image.getInstance("Brasao-caxias.png");
        document.add(image1);

        
            String imageUrl = "http://jenkov.com/images/" +
            "20081123-20081123-3E1W7902-small-portrait.jpg";


        document.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}