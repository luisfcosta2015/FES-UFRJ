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
    
    private ArrayList<DuplaDataCardapio> cardapioList;
    private Calendario calendario;
    
    public Cardapio(Calendario calendar) {
        cardapioList = new ArrayList<DuplaDataCardapio>();
        for(Date dt: calendar.getList()) {
            cardapioList.add(new DuplaDataCardapio(dt,""));
        }
        this.calendario = calendar;
    }
    
    public Cardapio(ArrayList<DuplaDataCardapio> cardapio) {
        this.cardapioList = cardapio;
        //to do construir calendario a partir do cardapio
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
    
    public ArrayList<DuplaDataCardapio> getList() {
        return this.cardapioList;
    }
    
    public boolean remove(Date data) {
        for(DuplaDataCardapio dupla: cardapioList) {
            if(dupla.data.compareTo(data)==0) {
                cardapioList.remove(dupla);
                return true;
            }
        }
        return false;
    }
    
    public int getMes() {
        if(calendario!= null) {
            return this.calendario.getMes();
        }
        return this.cardapioList.get(0).data.getMonth();
    }
    public int getAno() {
        if(calendario!= null) {
            return this.calendario.getAno();
        }
        return this.cardapioList.get(0).data.getDate();
    }
}
