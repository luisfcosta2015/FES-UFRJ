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
public class Cardapio {
    
    private int Id_Cardapio;
    private PieChart.Data data;

    public int getId_Cardapio() {
        return Id_Cardapio;
    }

    public void setId_Cardapio(int Id_Cardapio) {
        this.Id_Cardapio = Id_Cardapio;
    }

    public PieChart.Data getData() {
        return data;
    }

    public void setData(PieChart.Data data) {
        this.data = data;
    }
    
    
    
}
