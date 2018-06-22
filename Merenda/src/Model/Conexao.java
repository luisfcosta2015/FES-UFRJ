package Model;

import Model.Sessao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andrecsq
 */
public class Conexao {
    
    private List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (rs.next()){
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }
    /*
    There are multiple ways to read the list. Following few ways for reference:
    #1 first way -
    for (Map<String, Object> row:dataList) {
        for (Map.Entry<String, Object> rowEntry : row.entrySet()) {
            System.out.print(rowEntry.getKey() + " = " + rowEntry.getValue() + ", ");
        }
    }

    #2 second way -
    for (int i=0; i<dataList.size(); i++) {
        System.out.print(" " + dataList.get(i).get("REPORT_SECTION"));
    }
    */
    
    
    public static void testeConexao() {
        try {
            // create a java mysql database connection            
            //String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/merenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            System.out.println("Conectou!!!");
    
        } catch (Exception e) {
            Auxiliar.DBError(e.getMessage());
        }
    }
    
    private Connection getConnection(){
        try {
        String DBUrl = "jdbc:mysql://localhost:3306/merenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DBUser = "root";
        String DBPass = "root";
        return DriverManager.getConnection(DBUrl, DBUser, DBPass);
        } catch (Exception e) {
            Auxiliar.DBError(e.getMessage());
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
                int funcao = rs.getInt("id_funcao");
            
                Sessao.createInstance(id, funcao);    
            }
            
            st.close();  
            conn.close();
        } catch (Exception e) {
            Auxiliar.DBError(e.getMessage());
        }
        
        return logou;
    }
    
    // Executar select, 
    public List<Map<String, Object>> query_select(String query){
        List<Map<String, Object>> l = null;
        try {
            Connection conn;
            conn = getConnection();
            
            // create the java statement
            Statement st;
            st = conn.createStatement();

            // execute the query, and get a java resultset
            // nesse resultset que vem os paranaues
            ResultSet rs = st.executeQuery(query);
            
            l = resultSetToList(rs);

            st.close();  
            
            conn.close();
        } catch (Exception e) {
            Auxiliar.DBError(e.getMessage());
        }
        
        return l;
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
            Auxiliar.DBError(e.getMessage());
        }
        
        return sucesso;
    }
    
   
    
    
    
    public List<Map<String, Object>> tiposDeInstituicao(){
        
        String query = "SELECT * FROM tipo";
        
        return query_select(query);
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