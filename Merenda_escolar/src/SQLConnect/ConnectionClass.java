/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLConnect;

import java.sql.*;


/**
 *
 * @author joaof
 */
public class ConnectionClass {
    
    public static Connection conector(){
        
        java.sql.Connection getConnection = null;
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "";       
        
        try {
            Class.forName(driver);            
            getConnection = DriverManager.getConnection(url, user, pass);
            return getConnection;                    
                    
        } catch (Exception e) {
            System.out.println(e);
            return null;                   
        }
        
    }
    /*
    public static void closeConnection(Connection con) {
        try {           
            if(con != null){
                con.close();
            } 
        }catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        
        try { 
            
            if(stmt != null){
                stmt.close();
            }
     
        }catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con);
        
        try { 
            
            if(rs != null){
                rs.close();
            }
     
        }catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
       
    }
       
   
    
    

