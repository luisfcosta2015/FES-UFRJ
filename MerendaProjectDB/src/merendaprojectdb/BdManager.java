/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import com.google.gson.Gson;
import java.sql.Statement;
/**
 *
 * @author joycinha
 */
public class BdManager {
    public static String host = "jdbc:mysql://localhost:3306/merendafes";
    public static String username = "root";
    public static String password = "@Vitor1997";
    private static Connection con;
    //fake variaveis para fingir comunicacao com o banco
    private static ArrayList<Relatorio> relatorios = new ArrayList<>();
    
    public BdManager() {
        
    } //TODO
    static boolean cadastraUser(Usuario user) { 
        PreparedStatement ps;
        if(TelaPrincipal.usuarioLogado.getEscola() != null) {
            try{
                con = DriverManager.getConnection(host, username, password);
                ps = con.prepareStatement("insert into usuario(nome,usuario,senha,email,tipo,escola) values(?,?,?,?,?,?)");
                ps.setString(1, user.getNome());
                ps.setString(2, user.getUser());
                ps.setString(3, user.getSenha());
                ps.setString(4, user.getEmail()) ;
                ps.setString(5, user.getTipo()) ;
                ps.setInt(6, TelaPrincipal.usuarioLogado.getEscola().getINEP());
                ps.execute();
                return true;
            }
            catch (SQLException err) {
               System.out.println(err.getMessage());
               return false;
            }
        }
        else {
            try{
                con = DriverManager.getConnection(host, username, password);
                ps = con.prepareStatement("insert into usuario(nome,usuario,senha,email,tipo) values(?,?,?,?,?)");
                ps.setString(1, user.getNome());
                ps.setString(2, user.getUser());
                ps.setString(3, user.getSenha());
                ps.setString(4, user.getEmail()) ;
                ps.setString(5, user.getTipo()) ;
                ps.execute();
                return true;
            }
            catch (SQLException err) {
               System.out.println(err.getMessage());
               return false;
            }
        }
        
    }
    static Usuario findUser(String user) {    
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from usuario where usuario like ?");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String usuario = rs.getString("usuario");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                String tipo = rs.getString("tipo");
                String email = rs.getString("email");
            
                rs.close();
                ps.close();
                con.close();
                return new Usuario(nome, usuario, senha, email, tipo);
            }
            return null;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return null;
        }
        //return new Usuario("joyce", "Diretor", "123", "email@email.com", "Administrador");
    }
    static boolean verificarUser(String senha, String user){
        
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from usuario where usuario like ?");
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String pass = rs.getString("senha");
                
            
                rs.close();
                ps.close();
                con.close();
                return senha.equals(pass);
                
            }
            return false;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return false;
        }
    }
    static boolean cadastraEscola(Escola escola){
        PreparedStatement ps;
        try{ 
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("insert into escola(inep,unidade,telefone,estado,prefeitura,secretaria,subSecretaria,departamento, diretoria) values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, escola.getINEP());
            ps.setString(2, escola.getUnidade());
            ps.setString(3, escola.getTelefone());
            ps.setString(4, escola.getEstado());
            ps.setString(5, escola.getPrefeitura());
            ps.setString(6, escola.getSecretaria());
            ps.setString(7, escola.getSubsecretaria());
            ps.setString(8, escola.getDepartamento());
            ps.setString(9, escola.getDiretoria());
            ps.execute();
            return true; 
            
        }
       catch(SQLException err)
       {
           System.out.println(err.getMessage());
           return false;
       }
        //aqui o codigo recebera uma escola e adicionará ela as escolas cadastradas no banco
    }
    static boolean AdicionarItemListaCardapio(String Item){
        
        PreparedStatement ps;
       
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("insert into itens(nome) values(?)");
            ps.setString(1, Item);
            ps.execute();
            return true;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return false;
        }
    }
    static boolean VerificarItemExistente(String item){
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from itens where nome like ?");
            ps.setString(1, item);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                return true;
            }
            return false;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return false;
        }
    }
    static ArrayList pegarItensDoCardapio() {
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from itens");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> itens = new ArrayList<>();
            
            while(rs.next())
            {
                itens.add(rs.getString("nome"));
            }
            return itens;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return null;
        }
    }
    static ArrayList<Escola> pegarEscolas(){
        
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from escola");
            ResultSet rs = ps.executeQuery();
            ArrayList<Escola> escolas = new ArrayList<>();
            
            while(rs.next())
            {
                String estado = rs.getString("estado");
                String prefeitura = rs.getString("prefeitura");
                String secretaria = rs.getString("secretaria");
                String subsecretaria = rs.getString("subsecretaria");
                String departamento = rs.getString("departamento");
                String diretoria = rs.getString("diretoria"); // ops
                String unidade = rs.getString("unidade");
                String telefone = rs.getString("telefone");
                int inep = rs.getInt("inep");
                
                escolas.add(new Escola(estado, prefeitura, secretaria, subsecretaria, departamento, inep, diretoria, unidade, telefone));
            }
            rs.close();
            ps.close();
            con.close();
            return escolas;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return null;
        }
        //aqui tem que retornar todas as escolas cadastradas no sistema em um arrayList
        // TODO
    }
    static boolean verificaEscola(String inep){
       PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from escola where inep like ?");
            ps.setString(1, inep);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                rs.close();
                ps.close();
                con.close();
                return true;
            }
            return false;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return false;
        }
    }
    static Escola findEscola(int inep) {
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from escola where inep like ?");
            ps.setInt(1, inep);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                String estado = rs.getString("estado");
                String prefeitura = rs.getString("prefeitura");
                String secretaria = rs.getString("secretaria");
                String subsecretaria = rs.getString("subsecretaria");
                String departamento = rs.getString("departamento");
                int INEP = rs.getInt("inep");
                String diretoria = rs.getString("diretoria");
                String unidade = rs.getString("unidade");
                String telefone = rs.getString("telefone");
                
                rs.close();
                ps.close();
                con.close();
                return new Escola(estado, prefeitura, secretaria, subsecretaria, departamento, INEP, diretoria, unidade, telefone);
            }
            return null;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return null;
        }
    }
    static ArrayList<Relatorio> getRelatoriosExistentes(){
        ArrayList<Relatorio> relatorios = new ArrayList<Relatorio>();
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from relatorios where inep like ?");
            if(TelaPrincipal.usuarioLogado == null || TelaPrincipal.escolaAtual == null) {
                System.out.println("nenhuma escola selecionada para o usuário");
                return relatorios;
            }
            ps.setInt(1, TelaPrincipal.escolaAtual.getINEP());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String jsonString = rs.getString("relatorioJson");
                Relatorio relatorio = jsonToRelatorio(jsonString);
                relatorios.add(relatorio);
                
            }
            rs.close();
                ps.close();
                con.close();
            return relatorios;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return relatorios;
        }
    }
    static boolean adicionarRelatorio(Relatorio relatorio) {
        //simula o comportamento de um banco de dados
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("insert into relatorios(relatorioJson, inep, mes, ano) values(?, ?, ?, ?)");
            ps.setString(1, toJson(relatorio));
            ps.setInt(2, relatorio.getEscola().getINEP());
            ps.setString(3, "" + relatorio.getMes());
            ps.setInt(4, relatorio.getAno());
            ps.execute();
            ps.close();
            con.close();
            return true;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return false;
        }
    } 
    static int findIdRelatorio(int inep, int mes, int ano){
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from relatorios where inep like ?");
            ps.setInt(1, inep);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                //apenas o mes
                if(ano==0){
                    String messtr = rs.getString("mes");
                    int mestemp = Integer.parseInt(messtr);
                    
                    if(mestemp==mes)
                    {
                        int id = rs.getInt("idRelatorio");
                        rs.close();
                        ps.close();
                        con.close();
                        return id;
                    }
                }
                //apenas o ano
                if(mes==0){
                    int anotemp = rs.getInt("ano");
                    if(anotemp==ano)
                    {
                        int id = rs.getInt("idRelatorio");
                        rs.close();
                        ps.close();
                        con.close();
                        return id;
                    }
                }
                //mes e ano
                String messtr = rs.getString("mes");
                int mestemp = Integer.parseInt(messtr);
                int anotemp = rs.getInt("ano");
                if(mestemp==mes && anotemp==ano)
                {
                    int id = rs.getInt("idRelatorio");
                    rs.close();
                    ps.close();
                    con.close();
                    return id;
                }
            }
            return -1;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return -1;
        }
    }
    
    static ArrayList<Relatorio> getRelatoriosSelecionados(int mes, int ano){
        ArrayList<Relatorio> relatoriosSelecionados = new ArrayList<Relatorio>();
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from relatorios where inep like ?");
            if(TelaPrincipal.usuarioLogado == null || TelaPrincipal.escolaAtual == null) {
                System.out.println("nenhuma escola selecionada para o usuário");
                return relatoriosSelecionados;
            }
            ps.setInt(1, TelaPrincipal.escolaAtual.getINEP());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String jsonString = rs.getString("relatorioJson");
                Relatorio relatorio = jsonToRelatorio(jsonString);
                //apenas o mes
                if(ano==0){
                    String messtr = rs.getString("mes");
                    int mestemp = Integer.parseInt(messtr);
                    
                    if(mestemp==mes)
                    {
                        int id = rs.getInt("idRelatorio");
                        rs.close();
                        ps.close();
                        con.close();
                        relatoriosSelecionados.add(relatorio);
                    }
                }
                //apenas o ano
                if(mes==0){
                    int anotemp = rs.getInt("ano");
                    if(anotemp==ano)
                    {
                        int id = rs.getInt("idRelatorio");
                        rs.close();
                        ps.close();
                        con.close();
                        relatoriosSelecionados.add(relatorio);
                    }
                }
                //mes e ano
                String messtr = rs.getString("mes");
                int mestemp = Integer.parseInt(messtr);
                int anotemp = rs.getInt("ano");
                if(mestemp==mes && anotemp==ano)
                {
                    int id = rs.getInt("idRelatorio");
                    rs.close();
                    ps.close();
                    con.close();
                    relatoriosSelecionados.add(relatorio);
                }   
                
            }
            rs.close();
                ps.close();
                con.close();
            return relatoriosSelecionados;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return relatoriosSelecionados;
        }
    }
    
    static boolean alterarRelatorio (Relatorio relatorio){
        int relId = findIdRelatorio(relatorio.getEscola().getINEP(), relatorio.getMes(), relatorio.getAno());
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("update relatorios set relatorioJson = ? where idRelatorio = ?");
            ps.setString(1,toJson(relatorio));
            ps.setInt(2,relId);
            
            ps.execute();
            ps.close();
            con.close();
            return true;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return false;
        }
    }
    static String toJson(Relatorio relatorio) {
        Gson gson = new Gson();
        String rel = gson.toJson(relatorio);
        return rel;
    }
    static Relatorio jsonToRelatorio(String jsonString) {
        Gson gson = new Gson();
        Relatorio relatorio = gson.fromJson(jsonString, Relatorio.class);
        return relatorio;
    }
    static Double getPorcentagem (){
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("select * from valores_padrao where id like ?");
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            
                rs.close();
                ps.close();
                con.close();
                return rs.getDouble("porcentagem");
            }
            return -1.0;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return -1.0;
        }
    }
    static boolean setPorcentagem(double porcento){
        PreparedStatement ps;
        try{
            con = DriverManager.getConnection(host, username, password);
            ps = con.prepareStatement("insert into valores_padrao(porcentagem) values(?)");
            ps.setDouble(1, porcento);
            ps.execute();
            return true;
        }
        catch (SQLException err) {
           System.out.println(err.getMessage());
           return false;
        }
    }
}
