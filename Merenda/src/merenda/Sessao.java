/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merenda;

/**
 *
 * @author Andre
 */
public class Sessao {
    // Variável estática que conterá a instancia da classe
    private static Sessao instance;
    private int id;
    private int funcao;

    // Construtor privado (suprime o construtor público padrão).
    private Sessao(int id, int funcao) {
        this.id = id;
        this.funcao = funcao;
    }

    // Método público estático de acesso único ao objeto!
    // retorna null
    public static Sessao getInstance() {
        return instance;
    }
    
    public static void createInstance(int id, int funcao){
        if (instance == null)
            instance = new Sessao(id, funcao);        
    }
    
    public int getId() {
        return instance.id;
    }
    
    public int getFuncao() {
        return instance.funcao;
    }

    /*
    Pode criar outros métodos que precise aqui, como getters e setters.
    */
}