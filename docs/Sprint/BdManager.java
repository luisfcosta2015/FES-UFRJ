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
import java.util.ArrayList;
/**
 *
 * @author joycinha
 */
public class BdManager {
    public static String host;
    public static String username;
    public static String password;
    private static Connection con;
    
    public BdManager() {} //TO DO
    
    static boolean cadastraUser(Usuario user) {
        // TO DO
        return false;
    }
    
    static Escola findEscolaUnidade(String unidade) {
        // TO DO
        return null;
    }
    
    static ArrayList<String> findItens() {
        return null;
    } 
}
