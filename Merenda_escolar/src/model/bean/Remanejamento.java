/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author joaof
 */
public class Remanejamento {
    
    private int Id_Esscola;
    private int Id_Alimento;
    private PieChart.Data Data;
    private  String Motivo;
    private double Recebido;
    private double Cedido;

    public int getId_Esscola() {
        return Id_Esscola;
    }

    public void setId_Esscola(int Id_Esscola) {
        this.Id_Esscola = Id_Esscola;
    }

    public int getId_Alimento() {
        return Id_Alimento;
    }

    public void setId_Alimento(int Id_Alimento) {
        this.Id_Alimento = Id_Alimento;
    }

    public PieChart.Data getData() {
        return Data;
    }

    public void setData(PieChart.Data Data) {
        this.Data = Data;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public double getRecebido() {
        return Recebido;
    }

    public void setRecebido(double Recebido) {
        this.Recebido = Recebido;
    }

    public double getCedido() {
        return Cedido;
    }

    public void setCedido(double Cedido) {
        this.Cedido = Cedido;
    }
    
    
    
    
}
