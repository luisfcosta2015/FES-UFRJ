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
        TelaLogin login  = new TelaLogin();
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        Calendario calendario = new Calendario(1,2018);
        Cardapio cardapio = new Cardapio(calendario);
        login.setVisible(true);
    } 
}
