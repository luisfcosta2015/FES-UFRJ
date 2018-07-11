/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;
/**
 *
 * @author w1n3
 */
public class Saida {
    private int id, id_instituicao, id_alimento, qtd_alimento;
    private String data;
    
    public boolean cadastrar(){
        
        Conexao conn = new Conexao();
        
        String query = "INSERT INTO saida(id_alimento, id_instituicao, qtd_alimento, data) ";
        query += "values (" + getId_alimento() + "," + getId_instituicao()
              + "," + getQtd_alimento() + ",\'" + getData() + "\')";
        
        boolean sucesso = conn.query_update(query);
        
        // se falhou já mete o pé
        if (!sucesso) return sucesso;
        
        // senão, atualiza o estoque
        LoteEstoque le = new LoteEstoque();
        le.setId(getId_instituicao());
        le.setId_alimento(getId_alimento());
        le.setQtd_alimento(getQtd_alimento());
        return le.cadastrar_saida();
    }
        
    public String validar(){
        return "";
    }
    
    public int getId() {
        return id;
    } 

    public int getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(int id_instituicao) {
        this.id_instituicao = id_instituicao;
    }   

    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }

    public int getQtd_alimento() {
        return qtd_alimento;
    }

    public void setQtd_alimento(int qtd_alimento) {
        this.qtd_alimento = qtd_alimento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }      
}
