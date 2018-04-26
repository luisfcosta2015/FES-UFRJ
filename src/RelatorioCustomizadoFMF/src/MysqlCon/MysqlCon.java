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
    public static void Conectar(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306","root","FMF");  
            //here sonoo is database name, root is username and password  
            System.out.println("Conectado ao BD");  
            con.close();  
        }catch(Exception e){
            System.out.println(e);
        }  
}  
}  