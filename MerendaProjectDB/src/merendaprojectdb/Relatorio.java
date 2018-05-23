package merendaprojectdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joycinha
 */
public class Relatorio {
    Cardapio cardapio;
    CapaDados capa;
    String titulo;
    
    public Relatorio(Cardapio cardapio, CapaDados capa, String nome) {
        this.capa = capa;
        this.cardapio = cardapio;
        this.titulo = nome;
    }
    
    public CapaDados getCapaRelatorio() {
        return this.capa;
    }
    public Cardapio getCardapioRelatorio() {
        return this.cardapio;
    }
    public void getListaComidaRelatorio() {
        
    }
    public String getTitulo(){
        return this.titulo;
    }
}
