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
    private int id, id_funcao;
    private String nome, cpf, matricula, usuario, senha;   
    
    public boolean cadastrar(){
        
        String query = "INSERT INTO pessoa (id_funcao, nome, cpf, matricula, usuario, senha) VALUES";
        query += "("+ getId_funcao() +", " + "\'" + getNome() + "\',\'" + getCpf() + "\',\'" + getMatricula();
        query += "\',\'" + getUsuario() + "\',\'" + getSenha() +"\')" ;
        
        return new Conexao().query_update(query);
    }
    
    // Retorna uma String com a mensagem de erro
    // Se for vazia, não há erro
    public String validar(){
        
        String erros = "";
        
        if (getNome().length() >= 255 || getNome().length() == 0)
            erros += "Nome inválido\n";      
            
        // testa se é uma string com apenas digitos de tamanho 11
        if (!Auxiliar.isNumeric(getCpf()) || getCpf().length() != 11)
            erros += "CPF inválido\n";
        
        // ASSUME Q MATRICULA TEM 10 DIGITOS
        if (!Auxiliar.isNumeric(getMatricula()) || getMatricula().length() != 10)
            erros += "Matricula inválida\n";
        
        if (getId_funcao() < 1 || getId_funcao() > 3)
            erros += "Permissão inválida\n";    
            
        if (getUsuario().length() >= 255 || getUsuario().length() == 0)
            erros += "Usuário inválido\n";              
            
        if (getSenha().length() >= 255 || getSenha().length() == 0)
            erros += "Senha inválida\n";              
        
        return erros;        
    }       
    
    // Retorna true se foi possivel achar uma unica pessoa com esse Id
    public boolean pessoaPorId(int id){
        
        String query = "SELECT * FROM pessoa p where p.id=" + id;
        Conexao con = new Conexao();
        
        List<Map<String, Object>> lst = con.query_select(query);
        if (lst.size() == 1){
            popular(lst.get(0));
            return true;
        } else {
            return false;
        }
    }    
    
    public boolean pessoaPorNome(String nome){
        
        String query = "SELECT * FROM pessoa p where p.nome like \'" + nome + "%\'";
        Conexao con = new Conexao();
        
        List<Map<String, Object>> lst = con.query_select(query);
        if (lst.size() == 1){
            popular(lst.get(0));
            return true;
        } else {
            return false;
        }        
    } 
    
    // Popula a classe a partir de um Map
    public void popular(Map<String, Object> m){
        setId((int)m.get("id"));
        setId_funcao((int)m.get("id_funcao"));
        setNome( String.valueOf(m.get("nome")));
        setCpf(String.valueOf(m.get("cpf")));
        setMatricula(String.valueOf(m.get("matricula")));
        setUsuario(String.valueOf(m.get("usuario")));
        setSenha(String.valueOf(m.get("senha")));
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public int getId_funcao() {
        return id_funcao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
