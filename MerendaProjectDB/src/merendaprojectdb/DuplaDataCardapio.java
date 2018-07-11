/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import java.util.Date;

/**
 *
 * @author joycinha
 */
public class DuplaDataCardapio {
    String nome="Pedrão";
    Date data;
    String cardapioDoDia;
    public DuplaDataCardapio(Date data, String cardapio) {
        this.data = data;
        this.cardapioDoDia = cardapio;
    }
    public void setCardapioDoDia(String cardapio) {
        this.cardapioDoDia = cardapio;
    }
}
