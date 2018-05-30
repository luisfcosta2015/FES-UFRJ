/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author victor
 */
public class Conectar {
   
    public void metodo() {
        try {
            // create a java mysql database connection
            //String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/merenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            System.out.println("Conectou!!!");
    /*

            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM pessoa";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String Nome = rs.getString("nome");
                String Cpf = rs.getString("cpf");
                String Usuario = rs.getString("usuario");
                String Senha = rs.getString("senha");

                // print the results
                System.out.format("%s, %s, %s, %s, %s\n", id, Nome, Cpf, Usuario, Senha);
            }
            st.close();  

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

     */
        } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
        }
    
    
    }
}