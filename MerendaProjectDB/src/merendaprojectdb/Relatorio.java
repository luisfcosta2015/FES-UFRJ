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
    
    public Relatorio(Cardapio cardapio, CapaDados capa) {
        this.capa = capa;
        this.cardapio = cardapio;
    }
    
    public CapaDados getCapaRelatorio() {
        return this.capa;
    }
    public Cardapio getCardapioRelatorio() {
        return this.cardapio;
    }
    public void getListaComidaRelatorio() {
        
    }
}
