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
    
    public Usuario(String nome, String user, String senha, String email, String tipo, Escola escola) {
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.escola = escola;
    }
}
