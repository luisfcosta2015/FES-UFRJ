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
public class Conta {
    int id_pessoa, id_instituicao, id_tipo_conta;
    String usuario, senha, matricula;
    
    public boolean cadastrar(){
        
        String query = "INSERT INTO conta (id_pessoa, id_instituicao, id_tipo_conta, "
                + "usuario, senha, matricula) VALUES "
                + "(" + getId_pessoa() + "," + getId_instituicao() + "," + getId_tipo_conta()
                + ",\'" + getUsuario() + "\',\'" + getSenha() + "\',\'" + getMatricula() + "\')";
        
        //System.out.println(query);
        
        return new Conexao().query_update(query);
    }
    
    public boolean deletar(){
        String query = "DELETE FROM conta WHERE id_instituicao=" + getId_instituicao() + " AND id_pessoa=" + getId_pessoa();
        
        return new Conexao().query_update(query);
    }
    
    public boolean update(){
        String query = "UPDATE conta SET"
                + " id_tipo_conta=" + getId_tipo_conta()
                + ", matricula=\'" + getMatricula()+ "\'"
                + ", usuario=\'" + getUsuario()+ "\'"
                + ", senha=\'" + getSenha()+ "\'"
                + " WHERE id_instituicao=" + getId_instituicao()
                + " AND id_pessoa=" + getId_pessoa();
        
        //System.out.println(query);
        
        return new Conexao().query_update(query);
    }
    
    public String validar(){        
        String erros = "";
        
        if (getId_pessoa() <= 0)
            erros += "Pessoa inválida\n";
        
        if (getId_instituicao() <= 0)
            erros += "Instituição inválida\n";
        
        if (getId_tipo_conta() <= 0)
            erros += "Tipo de conta inválida\n";        
        
        // ASSUME Q MATRICULA TEM 10 DIGITOS
        if (!Auxiliar.isNumeric(getMatricula()) || getMatricula().length() != 10)
            erros += "Matricula inválida\n";
            
        if (getUsuario().length() >= 255 || getUsuario().length() == 0)
            erros += "Usuário inválido\n";              
            
        if (getSenha().length() >= 255 || getSenha().length() == 0)
            erros += "Senha inválida\n";              
        
        return erros;        
    }  
    
    // Popula a classe a partir de um Map
    /*
    public void popular(Map<String, Object> m){
        setId_instituicao((int)m.get("id_instituicao"));
        setId_pessoa((int)m.get("id_pessoa"));
        setId_tipo_conta((int)m.get("id_tipo_conta"));
        setMatricula(String.valueOf(m.get("matricula")));
        setUsuario(String.valueOf(m.get("usuario")));
        setSenha(String.valueOf(m.get("senha")));
    }
    */
    
    Auxiliar.PreencheDados preenche_dados = (m) -> {
        setId_instituicao((int)m.get("id_instituicao"));
        setId_pessoa((int)m.get("id_pessoa"));
        setId_tipo_conta((int)m.get("id_tipo_conta"));
        setMatricula(String.valueOf(m.get("matricula")));
        setUsuario(String.valueOf(m.get("usuario")));
        setSenha(String.valueOf(m.get("senha")));
    };
    
    public boolean contaPorId(int id_pessoa, int id_instituicao){
        String query = "SELECT * FROM conta c where c.id_pessoa=" + id_pessoa + " AND c.id_instituicao=" + id_instituicao;
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    }   

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(int id_instituicao) {
        this.id_instituicao = id_instituicao;
    }

    public int getId_tipo_conta() {
        return id_tipo_conta;
    }

    public void setId_tipo_conta(int id_tipo_conta) {
        this.id_tipo_conta = id_tipo_conta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
