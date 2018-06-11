package relatorio;
/*

This file is part of the iText (R) project.
Copyright (c) 1998-2016 iText Group NV

*/

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.test.annotations.type.SampleTest;
import org.junit.experimental.categories.Category;
import java.sql.*;
import java.io.File;

@Category(SampleTest.class)
	public class SimpleTable  {
	public static final String DEST = "results/chapter01/SimpleTable.pdf";
	public static final String DEST2 = "results/chapter01/listagem.pdf";
	
	public static void main(String[] args) throws Exception {
	    File file = new File(DEST);
	    file.getParentFile().mkdirs();
	    //new SimpleTable().manipulatePdf(DEST);
	    new SimpleTable().listagemGeral(DEST2);
	    

	    
	    
	}

	
	protected void listagemGeral(String dest) throws Exception {
	    PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
	    Document doc = new Document(pdfDoc);
	    
	    Table table = new Table(3);
	    
	
	    String url = "jdbc:mysql://localhost:3306/fes?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		Connection conexao = DriverManager.getConnection(url, user, password);
		System.out.println("Conectado ao Banco");
		
		// our SQL SELECT query. 
	    // if you only need a few columns, specify them by name instead of using "*"
	    String query = "SELECT matricula,nome,situacao FROM alunos where escola = 'Brizolaum' ";
		
	    // create the java statement
	    Statement st = conexao.createStatement();
	    ResultSet rs = st.executeQuery(query);
	      
	    //Cabe�ario da tabela
	    table.addCell("C�d i-Educar");
	    table.addCell("Nome do Aluno");
	    table.addCell("Situa��o");
	    
	    
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
	    
	    doc.add(table);
	
	    doc.close();
	    System.out.println("yoga fire");
	}
	
	
	
	
	protected void manipulatePdf(String dest) throws Exception {
	    PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
	    Document doc = new Document(pdfDoc);
	    
	    Table table = new Table(5);
	
	    String url = "jdbc:mysql://localhost:3306/fes?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		Connection conexao = DriverManager.getConnection(url, user, password);
		System.out.println("Conectado ao Banco");
		
		// our SQL SELECT query. 
	    // if you only need a few columns, specify them by name instead of using "*"
	    String query = "SELECT * FROM alunos where escola = 'Brizolaum'";
	   

		
	    // create the java statement
	    Statement st = conexao.createStatement();
	    
	    ResultSet rs = st.executeQuery(query);
	      
	    //Cabe�ario da tabela
	    table.addCell("matricula");
	    table.addCell("Nome");
	    table.addCell("Nascimento");
	    table.addCell("Escola");
	    table.addCell("serie");
	    
	    
	    // iterate through the java resultset, preenchendo tabela com os dados do banco
	      while (rs.next())
	      {
	        int id = rs.getInt("matricula");
	        String matricula = "00" + id;
	        table.addCell(matricula);
	        String Name = rs.getString("Nome");
	        table.addCell(Name);
	        Date dateCreated = rs.getDate("dataNascimento");
	        table.addCell(String.valueOf(dateCreated));
	        String escola = rs.getString("escola");
	        table.addCell(escola);
	        String serie = rs.getString("serie");
	        table.addCell(serie);
	        
	        // print the results
	        System.out.format("%s, %s, %s, %s, %s\n", id, Name,  dateCreated, escola, serie);
	      }
	      st.close();
		
		
		conexao.close();
	    
	    doc.add(table);
	
	    doc.close();
	    System.out.println("yoga fire");
	}
}