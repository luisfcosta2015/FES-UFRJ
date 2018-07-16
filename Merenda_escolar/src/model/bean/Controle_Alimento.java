/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author joaof
 */
public class Controle_Alimento {
    
    private int Id_Controle;
    private int Id_Escola;
    private String Modalidade;
    private int Alunos_Matric;
    private int Alunos_Atendidos;
    private int Total_Ref_Servidas;

    public int getId_Controle() {
        return Id_Controle;
    }

    public void setId_Controle(int Id_Controle) {
        this.Id_Controle = Id_Controle;
    }

    public int getId_Escola() {
        return Id_Escola;
    }

    public void setId_Escola(int Id_Escola) {
        this.Id_Escola = Id_Escola;
    }

    public String getModalidade() {
        return Modalidade;
    }

    public void setModalidade(String Modalidade) {
        this.Modalidade = Modalidade;
    }

    public int getAlunos_Matric() {
        return Alunos_Matric;
    }

    public void setAlunos_Matric(int Alunos_Matric) {
        this.Alunos_Matric = Alunos_Matric;
    }

    public int getAlunos_Atendidos() {
        return Alunos_Atendidos;
    }

    public void setAlunos_Atendidos(int Alunos_Atendidos) {
        this.Alunos_Atendidos = Alunos_Atendidos;
    }

    public int getTotal_Ref_Servidas() {
        return Total_Ref_Servidas;
    }

    public void setTotal_Ref_Servidas(int Total_Ref_Servidas) {
        this.Total_Ref_Servidas = Total_Ref_Servidas;
    }
    
    
    
}
