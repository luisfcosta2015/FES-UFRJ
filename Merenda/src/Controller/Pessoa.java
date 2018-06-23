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
public class Pessoa {
    private int id;
    private String nome, cpf;   
    
    public boolean cadastrar(){
        
        String query = "INSERT INTO pessoa (nome, cpf) VALUES";
        query += "(\'" + getNome() + "\',\'" + getCpf() + "\')" ;
        
        return new Conexao().query_update(query);
    }
    
    // Retorna uma String com a mensagem de erro
    // Se for vazia, não há erro
    public String validar(){
        
        String erros = "";
        
        // não precisa validar id pois é auto_increment
        
        if (getNome().length() >= 255 || getNome().length() == 0)
            erros += "Nome inválido\n";      
            
        // testa se é uma string com apenas digitos de tamanho 11
        if (!Auxiliar.isNumeric(getCpf()) || getCpf().length() != 11)
            erros += "CPF inválido\n";      
        
        return erros;        
    }    
    
    public boolean deletar(){
        String query = "DELETE FROM pessoa WHERE id=" + getId();
        
        return new Conexao().query_update(query);
    }   
    
    public boolean update(){
        String query = "UPDATE pessoa SET"
                + " nome=\'" + getNome() + "\'"
                + ", cpf=\'" + getCpf()+ "\'"         
                + " WHERE id=" + getId();
        
        return new Conexao().query_update(query);
    }
    
    // Retorna true se foi possivel achar uma unica pessoa com esse Id
    public boolean pessoaPorId(int id){        
        String query = "SELECT * FROM pessoa p where p.id=" + id;
        return pesquisaEPopula(query);
    }    
    
    public boolean pessoaPorNome(String nome){        
        String query = "SELECT * FROM pessoa p where p.nome like \'" + nome + "%\'";
        return pesquisaEPopula(query);
    } 
    
    // Popula a classe a partir de um Map
    public void popular(Map<String, Object> m){
        setId((int)m.get("id"));
        setNome(String.valueOf(m.get("nome")));
        setCpf(String.valueOf(m.get("cpf")));
    }
    
    public boolean pesquisaEPopula(String query){
        
        Conexao con = new Conexao();
        
        List<Map<String, Object>> lst = con.query_select(query);
        if (lst.size() == 1){
            popular(lst.get(0));
            return true;
        } else {
            return false;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
