package FMF.models;

import java.sql.*;  

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucca
 */
public class MysqlCon{
    public Connection con;
    
    public MysqlCon(){
    }
    public void Conectar(){  
    	try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Escola_Teste?useSSL=false","root","FMF");
            //alterem a senha ou o nome do banco de dados em cada situação
            System.out.println("Conectado ao BD");
        }catch(Exception e){
            System.out.println(e);
        }        
    }
    
    public void Desconectar(){
        try{ 
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public ResultSet query(String consulta){
        try{
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery(consulta);
            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    
}  