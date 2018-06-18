package Model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Auxiliar {
    
    // TODO: Mensagem de erro generica
    public static void errMsg(String msg){
    }
    
    public static ImageIcon createImageIcon(java.net.URL imgURL, String description) {
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file");
            return null;
        }
    }
    
    // TESTA SE STRING É COMPOSTA APENAS DE NÚMEROS
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
            if (!Character.isDigit(c)) return false;
        return true;
    }
    
    // CONFIRMAÇÃO DE SAÍDA COM JOPTIONPANE
    public static boolean confirmarSaida(){
        int reply = JOptionPane.showConfirmDialog(null, "Deseja finalizar o programa?", "Merenda", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)  return true; 
        return false;
    }
    
    // Configuraçõoes personalizadas de telas: Centralizar e etc
    public static void trocarTela(JFrame tela){        
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.pack();
        String title = "MERENDEX";
        if (Sessao.getInstance() != null){
            title += " | " + getUser() + " - " + getPermission();
        }
        tela.setTitle(title);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        tela.setLocation(dim.width/2-tela.getSize().width/2, dim.height/2-tela.getSize().height/2);
        tela.setVisible(true);        
    }
    
    // RETORNA NOME DE USUÁRIO PELO ID
    public static String getUser(){
        Conexao con = new Conexao();
        List<Map<String, Object>> l = con.pessoaPorId(Sessao.getInstance().getId());
        try {
            String str = String.valueOf(l.get(0).get("nome"));
            // Se o nome for muito grande, só mostra os 15 primeiro caracteres
            if (str.length() > 15){
                return str.substring(0, 15) + "...";
            }
            return str;
        } catch (Exception e) {
            Auxiliar.DBError(e.getMessage());
        }
        return null;
    }
    
    // RETORNA PERMISSÃO 
    // TODO: E COLÉGIO?
    public static String getPermission(){
        Conexao con = new Conexao();
        List<Map<String, Object>> l = con.funcaoPorId(Sessao.getInstance().getFuncao());
        try {
            return String.valueOf(l.get(0).get("descricao"));
        } catch (Exception e) {
            Auxiliar.DBError(e.getMessage());
        }
        return null;
    }
    
    // ERRO GENÉRICO NO BD
    public static void DBError(String msg){
        System.err.println("Got an exception! ");
        System.err.println(msg);        
    }
    
    // TODO: Criptografia da senha
    public static String criptografar(String senha){
        return senha;
    }
    
}
