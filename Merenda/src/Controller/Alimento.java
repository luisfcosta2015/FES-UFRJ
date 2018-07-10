/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Auxiliar;
import Model.Auxiliar.PreencheDados;
import Model.Conexao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andre
 */
public class Alimento {
    private int id_alimento, qtd_atende;
    private boolean perecivel;
    private String nome, marca, fornecedor, medida;
    
    public Alimento() {
        this.id_alimento = 0;
        this.qtd_atende = 0;
        this.perecivel = false;
        this.nome = "";
        this.marca = "";
        this.fornecedor = "";
        this.medida = "";
    }
    
    public String validar(){
        String erros = "";
        
        if (getNome().length() >= 30 || getNome().length() == 0)
            erros += "Nome do alimento inválido\n";     
        
        if (getFornecedor().length() >= 30 || getFornecedor().length() == 0)
            erros += "Fornecedor inválido\n";             
        
        if (getMarca().length() >= 30 || getMarca().length() == 0)
            erros += "Marca inválida\n";         
                
        if (getMedida().equals("null"))
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
    
    public boolean deletar(){
        String query = "DELETE FROM alimento WHERE id=" + getId_alimento();
        
        return new Conexao().query_update(query);
    }
    
    public boolean update(){
        String query = "UPDATE alimento SET"
                + " nome=\'" + getNome() + "\'"
                + ", fornecedor=\'" + getFornecedor()+ "\'"
                + ", marca=\'" + getMarca() + "\'"
                + ", medida=\'" + getMedida()+ "\'"
                + ", perecivel=" + (isPerecivel()? 1 : 0)
                + ", qtd_atende=" + getQtd_atende()             
                + " WHERE id=" + getId_alimento();
        
        //System.out.println(query);
        
        return new Conexao().query_update(query);
    }
    
    /*
    public void popular(Map<String, Object> m){
        setId_alimento((int)m.get("id"));
        setQtd_atende((int)m.get("qtd_atende"));
        setNome(String.valueOf(m.get("nome")));
        setPerecivel((int)m.get("perecivel") != 0);        
        setMarca(String.valueOf(m.get("marca")));
        setFornecedor(String.valueOf(m.get("fornecedor")));
        setMedida(String.valueOf(m.get("medida")));
    }*/
    
    Auxiliar.PreencheDados preenche_dados = (m) -> {
        setId_alimento((int)m.get("id"));
        setQtd_atende((int)m.get("qtd_atende"));
        setNome(String.valueOf(m.get("nome")));
        setPerecivel((int)m.get("perecivel") != 0);        
        setMarca(String.valueOf(m.get("marca")));
        setFornecedor(String.valueOf(m.get("fornecedor")));
        setMedida(String.valueOf(m.get("medida")));
    };
    
    public boolean consultar_por_id(int id) {
        String query = "SELECT * FROM alimento a where a.id=" + id ;
        
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    }
    
    public boolean consultar_por_nome(String nome){
        String query = "SELECT * FROM alimento a where a.nome like \'" + nome + "%\'";
        
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    }
    

    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
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
