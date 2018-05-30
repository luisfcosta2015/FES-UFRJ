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
    
    private Connection getConnection(){
        try {
        String DBUrl = "jdbc:mysql://localhost:3306/merenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DBUser = "root";
        String DBPass = "root";
        return DriverManager.getConnection(DBUrl, DBUser, DBPass);
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public boolean login(String usuario, String senha){
        
        boolean logou = false;        
        try {
            Connection conn = getConnection();
            
            //System.out.println("usuario: " + usuario);
            //System.out.println("senha: " + senha);
            
            String query = "SELECT * FROM pessoa p where p.usuario=\'" + usuario + "\' and p.senha=\'" + senha + "\';";

            // create the java statement, execute the query, and get a java resultset
            Statement st = conn.createStatement();
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
    
    // Executar select, 
    public ResultSet query_select(String query){
        ResultSet rs = null;
        try {
            Connection conn;
            conn = getConnection();
            
            // create the java statement
            Statement st;
            st = conn.createStatement();

            // execute the query, and get a java resultset
            // nesse resultset que vem os paranaues
            rs = st.executeQuery(query);

            st.close();  
            
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        return rs;
    }
    
    // Executar insert e update
    public boolean query_update(String query){
        
        boolean sucesso = false;
        
        try {
            Connection conn = getConnection();
            System.out.println(query);

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            st.executeUpdate(query);
            
            // se der merda vai cair no try/catch e não vai atribuir true ao sucesso
            sucesso = true;
            
            st.close();  

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        
        return sucesso;
    }
    
    
    
    public boolean cadastra_pessoa(int funcao_id, String nome, String cpf, String usuario, String senha, String oficio, String depto){
        
        String query = "INSERT INTO pessoa (funcao_id, nome, cpf, usuario, senha, oficio, depto) VALUES";
        query += "("+ funcao_id +", " + "\'" + nome + "\',\'" + cpf + "\',\'" + usuario + "\',\'" ;
        query += senha +"\',\'" + oficio + "\',\'" + depto + "\')" ;
        
        return query_update(query);
    }
    
<<<<<<< HEAD
    public boolean cadastra_escola(String nome, String endereco, String INEP, String qntAlunos, String telefone, String diretor){
        
        String query = null;
        if (diretor == null){
            query = "INSERT INTO instituicao (nome, endereco, INEP, qntAlunos, telefone) VALUES";
            query += "(\'" + nome +"\', " + "\'" + endereco + "\',\'" + INEP + "\'," + qntAlunos;
            query += ",\'" + telefone +"\')" ;
        } else {
            return false;
        }
=======
        public boolean cadastra_alimento(String Produto, String Fornecedor, String Marca, char Perecivel){
        
        String query = "INSERT INTO alimentos (Produto,Fornecedor,Marca,Perecivel) VALUES";
        query += "('"+ Produto +"', " + "\'" + Fornecedor + "\',\'" + Marca + "\',\'" + Perecivel + "\')" ;
>>>>>>> 4ef6f8e9f341701f5f1fa3728ab30e1387da52de
        
        return query_update(query);
    }
    
    
/*
    // EXEMPLO DE SELECT
    public void ConectaDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        
        
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
    */
}
