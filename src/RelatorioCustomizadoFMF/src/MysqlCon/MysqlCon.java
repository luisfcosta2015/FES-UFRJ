package MysqlCon;

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
            "jdbc:mysql://localhost:3306/FMF","root","timeFMF");
            //here sonoo is database name, root is username and password
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
            Conectar();
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery(consulta);
            while (rs.next()) {
                System.out.println(rs.getString("Nome"));
            }
            Desconectar();
            return rs;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    
}  