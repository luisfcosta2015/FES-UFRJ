/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Auxiliar;
import Model.Conexao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andre
 */
public class Instituicao {
    private int id, id_tipo, qtd_alunos;
    private String nome, inep, endereco, telefone;
    
    public boolean cadastrar(){
        
        String query;
            query = "INSERT INTO instituicao (nome, endereco, inep, qtd_alunos, telefone, id_tipo) VALUES";
            query += "(\'" + getNome() +"\', " + "\'" + getEndereco() + "\',\'" + getInep() + "\'," + getQtd_alunos();
            query += ",\'" + getTelefone() +"\', " + getId_tipo() + ")" ;
        
        return new Conexao().query_update(query);
    }
     
    public boolean deletar(){
        String query = "DELETE FROM instituicao WHERE id=" + getId();
        
        return new Conexao().query_update(query);
    }
    
    public boolean update(){
        String query = "UPDATE instituicao SET"
                + " nome=\'" + getNome() + "\'"
                + ", inep=\'" + getInep()+ "\'"
                + ", endereco=\'" + getEndereco()+ "\'"
                + ", telefone=\'" + getTelefone() + "\'"
                + ", qtd_alunos=" + getQtd_alunos()
                + ", id_tipo=" + getId_tipo()
                + " WHERE id=" + getId();
        
        //System.out.println(query);
        
        return new Conexao().query_update(query);
    }
    
    /*
    public void popular(Map<String, Object> m){
        setEndereco(String.valueOf(m.get("endereco")));
        setId_instituicao((int)m.get("id_instituicao"));
        setId_tipo((int)m.get("id_tipo"));
        setInep(String.valueOf(m.get("inep")));
        setNome(String.valueOf(m.get("nome")));
        setQtd_alunos((int)m.get("qtd_alunos"));
        setTelefone(String.valueOf(m.get("telefone")));
    }*/
    Auxiliar.PreencheDados preenche_dados = (m) -> {
        setEndereco(String.valueOf(m.get("endereco")));
        setId((int)m.get("id"));
        setId_tipo((int)m.get("id_tipo"));
        setInep(String.valueOf(m.get("inep")));
        setNome(String.valueOf(m.get("nome")));
        setQtd_alunos((int)m.get("qtd_alunos"));
        setTelefone(String.valueOf(m.get("telefone")));
    };
    
    public boolean instituicaoPorNome(String nome){
        String query = "SELECT * FROM instituicao i where i.nome like \'" + nome + "%\'";
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    } 
    
    public boolean instituicaoPorId(int id){
        String query = "SELECT * FROM instituicao i where i.id=" + id;
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    } 
    
    public String validar(){
        String erros = "";
        
        if (getNome().length() >= 255 || getNome().length() == 0)
            erros += "Nome invalido\n";          
        
        // testa se é uma string com apenas digitos de tamanho 11
        if (!Auxiliar.isNumeric(getInep()) || getInep().length() != 8)
            erros += "INEP invalido\n";
        
        if (!Auxiliar.isNumeric(getTelefone()) || (getTelefone().length() != 11 && getTelefone().length() != 10))
            erros += "Telefone invalido\n";  
        
        if (getEndereco().length() >= 255 || getEndereco().length() == 0)
            erros += "Endereco invalido\n";    
        
        if (getQtd_alunos() <= 0)
            erros += "Quantidade de alunos invalida\n";
        
        if (getId_tipo() < 0)
            erros += "Selecione um tipo de escola\n";  
        
        return erros;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getQtd_alunos() {
        return qtd_alunos;
    }

    public void setQtd_alunos(int qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInep() {
        return inep;
    }

    public void setInep(String inep) {
        this.inep = inep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
