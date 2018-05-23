/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
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
    static boolean verificarUser(String senha, String user){
        
        //TODO
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João","Diretor","123","","",new Escola(""+"","", "", "", "", 123, "", "", "")));
        usuarios.add(new Usuario("João","admin","321","","",new Escola(""+"","", "", "", "", 123, "", "", "")));
        usuarios.add(new Usuario("João","outro","12345678","","",new Escola(""+"","", "", "", "", 123, "", "", "")));
        //entre isso aqui vai receber o array com todos os usuarios
        
        for(int i=0;i<usuarios.size();i++)
        {
            System.out.println(usuarios.get(i).user.equals(user));
            if(usuarios.get(i).user.equals(user) && usuarios.get(i).senha.equals(senha))
            {
                return true;
            }
        }
        
        return false;
    }
    static boolean cadastraEscola(Escola escola){
        //TODO
        //aqui o codigo recebera uma escola e adicionará ela as escolas cadastradas no banco
        return true;
    }
    static ArrayList pegarEscolas(){
        //aqui tem que retornar todas as escolas cadastradas no sistema em um arrayList
        // TODO
        ArrayList<Escola> escolas = new ArrayList<>();
        escolas.add(new Escola(""+"","", "", "", "", 1, "", "tia totoca", ""));
        escolas.add(new Escola(""+"","", "", "", "", 1, "", "tia maria", ""));
        escolas.add(new Escola(""+"","", "", "", "", 1, "", "tio Pedrão", ""));
        escolas.add(new Escola(""+"","", "", "", "", 1, "", "tio Carlão", ""));
        
        return escolas;
    }
    static boolean AdicionarItemListaCardapio(String Item){
        //TODO
        //aqui o codigo recebera um item e adcionará ele aos itens que podem ser usados no cardapio, esse item será pego com
        //o metodo "pegarItensDoCardapio"
        
        
        return true;
    }
    static Escola findEscolaUnidade(String unidade) {
        return null;
    }
    static ArrayList pegarItensDoCardapio() {
        //aqui tem que retornar todos os itens do cardapio mas como não sei o que fazer, to retornando coisas aleatorias
        //tem que retornar em um array List
        // TODO
        ArrayList<String> itens = new ArrayList<>();
        itens.add("batata");
        itens.add("feijão");
        itens.add("macarrão");
        return itens;
    }
    static ArrayList getRelatoriosExistentes(){
        //TODO
        //aqui tem que retornar em um arrayList todos(ou talvez os mais recentes) os relatorios
        
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        
        relatorios.add(new Relatorio(new Cardapio(new Calendario(1,2018)),new CapaDados(),"Relatorio 01/2018"));
        relatorios.add(new Relatorio(new Cardapio(new Calendario(2,2018)),new CapaDados(),"Relatorio 02/2018"));
        relatorios.add(new Relatorio(new Cardapio(new Calendario(3,2018)),new CapaDados(),"Relatorio 03/2018"));
        relatorios.add(new Relatorio(new Cardapio(new Calendario(4,2018)),new CapaDados(),"Relatorio 04/2018"));
        relatorios.add(new Relatorio(new Cardapio(new Calendario(5,2018)),new CapaDados(),"Relatorio 05/2018"));
        relatorios.add(new Relatorio(new Cardapio(new Calendario(6,2018)),new CapaDados(),"Relatorio 06/2018"));
        
        return relatorios;
        
    }
}
