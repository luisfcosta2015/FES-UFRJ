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
    private int id_instituicao, id_tipo, id_diretor, qtd_alunos;
    private String nome, inep, endereco, telefone;
    
     public boolean cadastrar(){
        
        String query;
        if (getId_diretor() <= 0){
            query = "INSERT INTO instituicao (nome, endereco, inep, qtd_alunos, telefone, id_tipo) VALUES";
            query += "(\'" + getNome() +"\', " + "\'" + getEndereco() + "\',\'" + getInep() + "\'," + getQtd_alunos();
            query += ",\'" + getTelefone() +"\', " + getId_tipo() + ")" ;
        } else {
            query = "INSERT INTO instituicao (nome, endereco, inep, qtd_alunos, telefone, id_tipo) VALUES";
            query += "(\'" + getNome() +"\', " + "\'" + getEndereco() + "\',\'" + getInep() + "\'," + getQtd_alunos();
            query += ",\'" + getTelefone() +"\', " + getId_diretor() + ", " + getId_tipo() + ")" ;
        }
        
        return new Conexao().query_update(query);
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
    
    public int instituicaoPorId(int id_diretor){
        String query = "SELECT id_instituicao FROM instituicao i where i.id_diretor=" + id_diretor;
        Conexao con = new Conexao();
        
        List<Map<String, Object>> lst = con.query_select(query);
        if (lst.size() == 1){
            return (int)lst.get(0).get("id_instituicao");
        } else {
            return -1;
        }
    }

    public int getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(int id_instituicao) {
        this.id_instituicao = id_instituicao;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getId_diretor() {
        return id_diretor;
    }

    public void setId_diretor(int id_diretor) {
        this.id_diretor = id_diretor;
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
