/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

/**
 *
 * @author joycinha
 */
public class Usuario {
    public Relatorio relatorioCorrente=null;
    private String nome;
    private String user;
    private String senha;
    private String email;
    private String tipo; 
    private Escola escola;
    /*
    private boolean canNewReport;
    private boolean canWriteReport;
    private boolean canWriteSchool;
    private boolean canSeeReport;
    private boolean canSeeSchool;
    private boolean canWritePermit;
    private boolean canAddUser;
    
    UsuarioAdm adm;
    UsuarioDir dir;
    UsuarioLei lei;*/
    
    public Usuario(String nome, String user, String senha, String email, String tipo) {
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
    }
    
    public Usuario(String nome, String user, String senha, String email, String tipo, Escola escola) {
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.escola = escola;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getUser() {
        return this.user;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public Escola getEscola() {
        return this.escola;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public boolean setEscola(Escola escola) {
        if(this.escola != null) {
            this.escola = escola;
            return true;
        }
        return false;
    }
}
