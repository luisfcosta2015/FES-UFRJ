/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Andre
 */
public class Sessao {
    
    // Variável estática que conterá a instancia da classe
    private static Sessao instance;
    private int id_pessoa;
    private int id_instituicao;
    private int funcao;

    // Construtor privado (suprime o construtor público padrão).
    private Sessao(int id_pessoa, int id_instituicao, int funcao) {
        this.id_pessoa = id_pessoa;
        this.id_instituicao = id_instituicao;
        this.funcao = funcao;
    }

    // Método público estático de acesso único ao objeto!
    // retorna null
    public static Sessao getInstance() {
        return instance;
    }
    
    public static void createInstance(int id_pessoa, int id_instituicao, int funcao){
        if (instance == null)
            instance = new Sessao(id_pessoa, id_instituicao, funcao);        
    }
    
    public static void destroy(){
        instance = null;
    }
    
    public int getIdPessoa() {
        return instance.id_pessoa;
    }
    
    public int getIdInstituicao() {
        return instance.id_instituicao;
    }
    
    public int getFuncao() {
        return instance.funcao;
    }
}