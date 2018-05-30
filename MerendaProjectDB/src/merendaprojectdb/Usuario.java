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
    String nome;
    String user;
    String senha;
    String email;
    String tipo; 
    Escola escola;
    
    boolean canNewReport;
    boolean canWriteReport;
    boolean canWriteSchool;
    boolean canSeeReport;
    boolean canSeeSchool;
    boolean canWritePermit;
    
    UsuarioAdm adm;
    UsuarioDir dir;
    UsuarioLei lei;
    
    public Usuario(String nome, String user, String senha, String email, String tipo, Escola escola) {
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.escola = escola;
        
        setPermits();
    }
    
    private void setPermits(){
    if (tipo == "Administrador"){
        canNewReport = adm.canNewReport;
        canWriteReport = adm.canWriteReport;
        canSeeReport = adm.canSeeReport;
        canWriteSchool = adm.canWriteSchool;
        canSeeSchool = adm.canSeeSchool;
        canWritePermit = adm.canWritePermit;
    }
    else if(tipo == "Diretor"){
        canNewReport = dir.canNewReport;
        canWriteReport = dir.canWriteReport;
        canSeeReport = dir.canSeeReport;
        canWriteSchool = dir.canWriteSchool;
        canSeeSchool = dir.canSeeSchool;
        canWritePermit = dir.canWritePermit;
    }
    else{
        canNewReport = lei.canNewReport;
        canWriteReport = lei.canWriteReport;
        canSeeReport = lei.canSeeReport;
        canWriteSchool = lei.canWriteSchool;
        canSeeSchool = lei.canSeeSchool;
        canWritePermit = lei.canWritePermit;
    }
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public boolean getNR(){
        return canNewReport;
    }
    
    public boolean getWR(){
        return canWriteReport;
    }
    
    public boolean getSR(){
        return canSeeReport;
    }
    
    public boolean getWS(){
        return canWriteSchool;
    }
    
    public boolean getSS(){
        return canSeeSchool;
    }
    
    public boolean getWP(){
        return canWritePermit;
    }
    
    
    
}
