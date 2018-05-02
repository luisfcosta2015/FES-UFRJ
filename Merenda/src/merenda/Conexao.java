/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merenda;

import java.sql.*;

/**
 *
 * @author andrecsq
 */
public class Conexao {
    
    public boolean login(String usuario, String senha){
        
        boolean logou = false;
        
        try {
            String DBUrl = "jdbc:mysql://localhost:3306/merenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String DBUser = "root";
            String DBPass = "root";
            Connection conn = DriverManager.getConnection(DBUrl, DBUser, DBPass);
            
            System.out.println("usuario: " + usuario);
            System.out.println("senha: " + senha);
            
            String query = "SELECT * FROM pessoa p where p.usuario=\'" + usuario + "\' and p.senha=\'" + senha + "\';";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()){    
                logou = true;
                int id = rs.getInt("id");
                int funcao = rs.getInt("funcao_id");
            
                Sessao.createInstance(id, funcao);    
            }
            
            st.close();  

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        return logou;
    }

    public void ConectaDB() {
/*
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }*/
        
        
        try {
            // create a java mysql database connection
            //String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/merenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            
            System.out.println("Conectou!!!");
            
            
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
    }

}
