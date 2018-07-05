package Model;

import Controller.TipoConta;
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
import Controller.Pessoa;
import java.util.Random;

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
        } else {
            System.out.println("Sessao nula.");
        }
        tela.setTitle(title);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        tela.setLocation(dim.width/2-tela.getSize().width/2, dim.height/2-tela.getSize().height/2);
        tela.setVisible(true);        
    }
    
    // RETORNA NOME DE USUÁRIO PELO ID
    public static String getUser(){        
        Pessoa p = new Pessoa();
        if (p.pessoaPorId(Sessao.getInstance().getIdPessoa())){
            String nome = p.getNome();
            
            // Se o nome for muito grande, só mostra os 20 primeiro caracteres
            if (nome.length() > 20) nome = nome.substring(0, 17) + "...";
            
            return nome;
        } else {
            Auxiliar.DBError("Nome por Id não encontrado");
            return null;
        }
    }
    
    // RETORNA PERMISSÃO 
    public static String getPermission(){
        TipoConta tc = new TipoConta();
        if (tc.tipoContaPorId(Sessao.getInstance().getFuncao())){
            return tc.getDescricao();
        } else {
            Auxiliar.DBError("Id não encontrado");    
            return null;
        }
    }
    
    // ERRO GENÉRICO NO BD
    public static void DBError(String msg){
        System.err.println("ERRO: " + msg);
    }
    
    // TODO: Criptografia da senha
    public static String criptografar(String senha){
        return senha;
    }
    
    /*
        Essa função cria palavras aleatórias para auxiliar nos testes.
    */
    public static String CriaPalavra(int tamanho){
        String palavra;
        String[] letrinhas = {"A","B","C","D","E","F","G","H","I","J","K","L","M","O","P","Q","R","S","T","U","V","X","Z"};
        palavra ="";
        Random ran = new Random();
        for(int i = 0;i<tamanho;i++){
            int k;
            k = ran.nextInt(letrinhas.length);
            palavra += letrinhas[k];
        }
        return palavra;
    }
    
}
