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
    public ArrayList<ItemComida> semana1;
    public ArrayList<ItemComida> semana2;
    public ArrayList<ItemComida> semana3;
    public ArrayList<ItemComida> semana4;
    public ArrayList<ItemComida> semana5;
    private String titulo;
    private int mes;
    private int ano;
    private Escola escola;
    
    Relatorio(int mes, int ano, String nome, Escola escola, Cardapio cardapio, CapaDados capa) {
        this.capa = capa;
        this.cardapio = cardapio;
        this.titulo = nome;
        this.mes = mes;
        this.ano = ano;
        this.escola = escola;
        this.semana1 = new ArrayList<ItemComida>();
        this.semana2 = new ArrayList<ItemComida>();
        this.semana3 = new ArrayList<ItemComida>();
        this.semana4 = new ArrayList<ItemComida>();
        this.semana5 = new ArrayList<ItemComida>();
    }
    
    public CapaDados getCapaRelatorio() {
        return this.capa;
    }
    public Cardapio getCardapioRelatorio() {
        return this.cardapio;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public boolean setEscola(Escola escola) {
        if(escola != null) {
            this.escola = escola;
            return true;
        }
        return false;
    }
    public int getMes() {
        return this.mes;
    }
    public int getAno() {
        return this.ano;
    }
    
    public Escola getEscola() {
        return this.escola;
    }
}
