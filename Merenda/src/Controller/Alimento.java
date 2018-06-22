/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andre
 */
public class Alimento {
    private int id_item, qtd_atende;
    private boolean perecivel;
    private String nome, marca, fornecedor, medida;        
    
    public String validar(){
        String erros = "";
        
        if (getNome().length() >= 30 || getNome().length() == 0)
            erros += "Nome do alimento inválido\n";     
        
        if (getFornecedor().length() >= 30 || getFornecedor().length() == 0)
            erros += "Fornecedor inválido\n";             
        
        if (getMarca().length() >= 30 || getMarca().length() == 0)
            erros += "Marca inválida\n";         
                
        if (getMedida().equals(""))
            erros += "Selecione uma Unidade de Medida\n";                       
        
        if (getQtd_atende() <= 0)
            erros += "Quantidade de alunos atendida inválida\n"; 
                
        return erros;
    }
    
    public boolean cadastrar(){        
        String query = "INSERT INTO alimento (nome,fornecedor, marca, perecivel, medida ,qtd_atende) VALUES";
        query += "(\'"+ getNome() +"\', \'" + getFornecedor() + "\',\'" + getMarca() + "\'" ;
        query += ", "+ isPerecivel() +", " + "\'" + getMedida() + "\'," + getQtd_atende() + ")" ;
        
        return new Conexao().query_update(query);
    } 
    
    public void popular(Map<String, Object> m){
        setId_item((int)m.get("id_item"));
        setQtd_atende((int)m.get("qtd_atende"));
        setNome(String.valueOf(m.get("nome")));
        setPerecivel((int)m.get("perecivel") != 0);        
        setMarca(String.valueOf(m.get("marca")));
        setFornecedor(String.valueOf(m.get("fornecedor")));
        setMedida(String.valueOf(m.get("medida")));
    }
    
    public boolean consultarPorNome(String nome){
        String query = "SELECT * FROM alimento a where a.nome like \'" + nome + "%\'";
        Conexao con = new Conexao();
        
        List<Map<String, Object>> lst = con.query_select(query);
        if (lst.size() == 1){
            popular(lst.get(0));
            return true;
        } else {
            return false;
        }
    }  

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getQtd_atende() {
        return qtd_atende;
    }

    public void setQtd_atende(int qtd_atende) {
        this.qtd_atende = qtd_atende;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
}
