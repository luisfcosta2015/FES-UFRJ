package br.com.fes.relatorios.itext;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.experimental.categories.Category;

import com.itextpdf.test.annotations.type.SampleTest;

/*

This file is part of the iText (R) project.
Copyright (c) 1998-2016 iText Group NV

*/


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.fes.relatorios.dao.DadosDAO;
import br.com.fes.relatorios.domain.Dados;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
 



@Category(SampleTest.class)
	public class Gerador  {

    public static final String PICT 	= "WebContent/resources/img/Brasao-caxias.png";

    public int createPdf(String filename,String query, Dados dadosRegistro) throws IOException,  DocumentException, SQLException {
    	
    	
    	// info to conect to DB
	    String url = "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		
		Header header = new Header();
		new Footer();

    	// step 1
		System.out.println("FileoutputStream filename  " + filename);
    	FileOutputStream fos = new FileOutputStream(filename);
   
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, fos);
        Footer event = new Footer();
        writer.setPageEvent(event);
          
        String nome_escola = "CIEP Municipalizado 330 - Maria da Glória Corrêa Lemos";
        int inep = 33101094;
        int ano = 2018;
        String turma = dadosRegistro.getTurma();
        String grau ="Ensino Fundamental I (Anos iniciais)";
        
        System.out.println("Turma gerador = " + turma);
        // step 3
        document.open();
        
        //setting header
        header.first_header(writer,document, nome_escola, inep, ano, turma, grau,PICT);    
     
        System.out.println("step 4");
        // step 4
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //opening connection
        Connection conexao = DriverManager.getConnection(url, user, password);
		System.out.println("Conectado ao Banco");
        
		System.out.println("java statment");
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
        
        
        // step 5
        document.close();
        
        System.out.println("pronto");
        return 3;

    }
}
	
