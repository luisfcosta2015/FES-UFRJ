/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author joycinha
 */
public class Cardapio {
    
    ArrayList<DuplaDataCardapio> cardapioList;
    
    public Cardapio(Calendario calendar) {
        cardapioList = new ArrayList<DuplaDataCardapio>();
        for(Date dt: calendar.getList()) {
            cardapioList.add(new DuplaDataCardapio(dt,""));
        }
    }
    
    public boolean setCardapio(Date dt, String valor) {
        for(DuplaDataCardapio dupla: cardapioList) {
            if(dupla.data.compareTo(dt)==0) {
                dupla.setCardapioDoDia(valor);
                return true;
            }
        }
        return false;
    }
    public void setCardapio(int pos, String valor) {
        cardapioList.get(pos).setCardapioDoDia(valor);
    }
}
