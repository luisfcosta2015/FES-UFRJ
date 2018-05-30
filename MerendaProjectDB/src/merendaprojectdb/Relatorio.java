package merendaprojectdb;

import java.util.ArrayList;

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
    private Cardapio cardapio;
    private CapaDados capa;
    private ArrayList<ItemComida> itens;
    private String titulo;
    public int mes;
    public int ano;
    
    public Relatorio(Cardapio cardapio, CapaDados capa, String nome, ArrayList<ItemComida> itens) {
        this.capa = capa;
        this.cardapio = cardapio;
        this.titulo = nome;
        this.itens = itens;
    }
    
    public CapaDados getCapaRelatorio() {
        return this.capa;
    }
    public Cardapio getCardapioRelatorio() {
        return this.cardapio;
    }
    public ArrayList<ItemComida> getItensRelatorio() {
        return this.itens;
    }
    public String getTitulo(){
        return this.titulo;
    }
}
