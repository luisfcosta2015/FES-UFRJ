package Model;

import Model.Auxiliar;
import Model.Sessao;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
    
    public static void testeConexao() {
        Connection conn = getConnection();
        if (conn == null)
            System.out.println("Conexão falhou");
        else
            System.out.println("Conectou!!!");    
    }
    
    private static Connection getConnection() {
        JOptionPane mensagem = new JOptionPane();
        try {
            String DBUrl = "";
            String DBUser = "";
            String DBPass = "";
            
            // ***
            // Pega a Url, usuario e senha do arquivo bd.cfg para realizar
            // conexão com o BD. A mensagem de erro está relacionada com a
            // tentativa de ler o arquivo, ou seja, quem emitirá será o
            // Scanner do Java.
            try (Scanner s = new Scanner(new File("bd.cfg")).useDelimiter("\\n")) {
                DBUrl = s.next().split("'")[1];
                DBUser = s.next().split("'")[1];
                DBPass = s.next().split("'")[1];
            } catch (Exception e) {
                   Auxiliar.DBError(e.getMessage());
            }
            // ***
            return DriverManager.getConnection(DBUrl, DBUser, DBPass);
        } catch (Exception e) {
            try {
                PrintWriter writer = new PrintWriter("bd.cfg", "UTF-8");
                writer.println("link_do_banco = 'jdbc:mysql://localhost:3306/merenda?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC'");
                writer.println("usuario = 'root'");
                writer.println("senha = 'root'");
                writer.close();
            } catch (IOException ex) {
                Auxiliar.DBError(ex.getMessage());
            }
            mensagem.showMessageDialog(null, "Favor editar o arquivo 'bd.cfg' para configurar acesso ao SGBD");
        }
        return null;
    }
    
    public boolean login(String usuario, String senha){
        
        boolean logou = false;        
        try {
            Connection conn = getConnection();
            
            //System.out.println("usuario: " + usuario);
            //System.out.println("senha: " + senha);
            
            String query = "SELECT * FROM conta c where c.usuario=\'" + usuario + "\' and c.senha=\'" + senha + "\';";

            // create the java statement, execute the query, and get a java resultset
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            if (rs.next()){    
                logou = true;
                int id_pessoa = rs.getInt("id_pessoa");
                int id_instituicao = rs.getInt("id_instituicao");
                int tipo_conta = rs.getInt("id_tipo_conta");
            
                Sessao.createInstance(id_pessoa, id_instituicao, tipo_conta);    
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
            Connection conn = getConnection();
            
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
        
        String query = "SELECT * FROM tipo_instituicao";
        
        return query_select(query);
    }
    
}