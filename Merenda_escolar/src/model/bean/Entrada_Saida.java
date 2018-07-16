/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import javafx.scene.chart.PieChart;

/**
 *
 * @author joaof
 */
public class Entrada_Saida {
    
    private int Id_Escola;
    private int Id_Alimento;
    private PieChart.Data data;
    private double Entrada;
    private double Saida;

    public int getId_Escola() {
        return Id_Escola;
    }

    public void setId_Escola(int Id_Escola) {
        this.Id_Escola = Id_Escola;
    }

    public int getId_Alimento() {
        return Id_Alimento;
    }

    public void setId_Alimento(int Id_Alimento) {
        this.Id_Alimento = Id_Alimento;
    }

    public PieChart.Data getData() {
        return data;
    }

    public void setData(PieChart.Data data) {
        this.data = data;
    }

    public double getEntrada() {
        return Entrada;
    }

    public void setEntrada(double Entrada) {
        this.Entrada = Entrada;
    }

    public double getSaida() {
        return Saida;
    }

    public void setSaida(double Saida) {
        this.Saida = Saida;
    }
    
    
    
}
