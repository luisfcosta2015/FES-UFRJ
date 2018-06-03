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
    boolean canAddUser;
    
    UsuarioAdm adm;
    UsuarioDir dir;
    UsuarioLei lei;
    
    public Usuario(String nome, String user, String senha, String email, String tipo) {
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        
        setPermits();
    }
    
    private void setPermits(){
        System.out.println("oiiiii");
        System.out.println(tipo);
        System.out.println("Administrador");
       
    if (tipo.equals("Administrador")){
        System.out.println("AAAAAAAAA");
        this.adm = new UsuarioAdm();
        canNewReport = adm.canNewReport;
        canWriteReport = adm.canWriteReport;
        canSeeReport = adm.canSeeReport;
        canWriteSchool = adm.canWriteSchool;
        canSeeSchool = adm.canSeeSchool;
        canWritePermit = adm.canWritePermit;
        canAddUser = adm.canAddUser;
    }
    else if(tipo.equals("Diretor")){
        this.dir = new UsuarioDir();
        canNewReport = dir.canNewReport;
        canWriteReport = dir.canWriteReport;
        canSeeReport = dir.canSeeReport;
        canWriteSchool = dir.canWriteSchool;
        canSeeSchool = dir.canSeeSchool;
        canWritePermit = dir.canWritePermit;
        canAddUser = dir.canAddUser;
    }
    else if(tipo.equals("Leitor")){
        this.lei = new UsuarioLei();
        canNewReport = lei.canNewReport;
        canWriteReport = lei.canWriteReport;
        canSeeReport = lei.canSeeReport;
        canWriteSchool = lei.canWriteSchool;
        canSeeSchool = lei.canSeeSchool;
        canWritePermit = lei.canWritePermit;
        canAddUser = lei.canAddUser;
    }
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public boolean canNewReport(){
        return canNewReport;
    }
    
    public boolean canWriteReport(){
        return canWriteReport;
    }
    
    public boolean canSeeReport(){
        return canSeeReport;
    }
    
    public boolean canWriteSchool(){
        return canWriteSchool;
    }
    
    public boolean canSeeSchool(){
        return canSeeSchool;
    }
    
    public boolean canWritePermit(){
        return canWritePermit;
    }
    public boolean canAddUser(){
        return canAddUser;
    }
    
    
    
}
