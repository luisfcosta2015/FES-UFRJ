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
    public int adicionar(Date data) {
        ArrayList<DuplaDataCardapio> temp = new ArrayList<DuplaDataCardapio>();
        boolean inserido = false;
        int pos=0;
        for(int i = 0; i < this.cardapioList.size(); i++)  {
            if(!inserido && this.cardapioList.get(i).data.getDate() > data.getDate()) {
                
                temp.add(i, new DuplaDataCardapio(data,""));
                inserido = true;
                temp.add(i+1,this.cardapioList.get(i));
                pos=i;
                continue;
            }
            if(!inserido && this.cardapioList.get(i).data.getDate()==data.getDate())
            {
                return -1;
            }
            temp.add(this.cardapioList.get(i));
        }
        if(!inserido)
        {
            temp.add(new DuplaDataCardapio(data,""));
        }
        this.cardapioList=temp;
        return pos;
    }
    /*public void removeDF(Date data){
        int dia = data.getDate();
        for(DuplaDataCardapio dupla : this.cardapioList)
        {
            if(dupla.data.getDate()==dia)
            {
                cardapioList.remove(dupla);
            }
        }
    }*/
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
