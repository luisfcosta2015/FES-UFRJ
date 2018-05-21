/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author joycinha
 */
public class BdManager {
    public static String host;
    public static String username;
    public static String password;
    private static Connection con;
    
    public BdManager() {} //TODO
    
    static boolean cadastraUser(Usuario user) {
        // TODO
        return false;
    }
    
    static boolean cadastraEscola(Escola escola){
        //TODO
        return false;
    }
    
    static Escola findEscolaUnidade(String unidade) {
        return null;
    }
}
