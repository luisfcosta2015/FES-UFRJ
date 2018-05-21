package merendaprojectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

//@author Vitor Milioni
 
public class MerendaProjectDB {
    
    public static void main(String[] args) {
        
        PreparedStatement ps = null;
        Connection con; 
        Itens itens;
        Login login  = new Login();
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        Calendario cardapio = new Calendario(1,2018);
        Escola escola = new Escola("ESTADO DO RIO DE JANEIRO","PREFEITURA DE DUQUE DE CAXIAS",
        "SECRETARIA MUNICIPAL DE EDUCAÇÃO", "SUBSECRETARIA DE EDUCAÇÃO EM INFRAESTRUTURA...", 
        "DEPARTAMENTO DE INFRAESTRUTURA EDUCACIONAL", 33151750, "Luana Lopes", "E.M. ANA DE SOUSA HERDY", "(21)3656-0364");
        itens = new Itens();
        //so pra ter um valor inicial
        itens.add(new ItemComida("banana", "kg"));
        itens.add(new ItemComida("pera", "kg"));
        itens.add(new ItemComida("uva", "kg"));
        itens.add(new ItemComida("maçã", "kg"));
        itens.add(new ItemComida("abacaxi", "kg"));
        
        login.setVisible(true);
        
        
       try{
            String host = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "@Vitor1997";
            con = DriverManager.getConnection(host, username, password);
            Map map = con.getTypeMap();
            ps = con.prepareStatement("insert into escola(inep,unidade,telefone,estado,prefeitura,secretaria,subSecretaria,departamento) values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, escola.getINEP());
            ps.setString(2, escola.getUnidade());
            ps.setString(3, escola.getTelefone());
            ps.setString(4, escola.getEstado());
            ps.setString(5, escola.getPrefeitura());
            ps.setString(6, escola.getSecretaria());
            ps.setString(7, escola.getSubsecretaria());
            ps.setString(8, escola.getDepartamento());
            ps.execute();
            
       }
       catch(SQLException err)
       {
           System.out.println(err.getMessage());
       }

   
    }
    
}
