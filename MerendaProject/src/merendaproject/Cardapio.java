package merendaproject;

import java.util.ArrayList;
import java.util.Calendar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joycinha
 */
public class Cardapio {
    public ArrayList<Calendar> calendar = new ArrayList<>(); //mes de 0-11
    private Calendar diaUm = Calendar.getInstance();
    int mes;
    int ano;
    Cardapio(int mes, int ano) {
        this.mes = mes;
        this.ano = ano;
        geraVetor();
        diaUm.set(Calendar.YEAR, ano);
        diaUm.set(Calendar.MONTH, mes);
        diaUm.set(Calendar.DAY_OF_MONTH,1);
    }
    
    private void criarData(Calendar t, int dia) {
        t.set(Calendar.YEAR, ano);
        t.set(Calendar.MONTH, mes);
        t.set(Calendar.DAY_OF_MONTH,dia);
    }
    
    private void geraVetor() {
        int diaMaximo = diaUm.getActualMaximum(diaUm.DAY_OF_MONTH);
        for(int i=0; i< diaMaximo; i++) {
            Calendar t = Calendar.getInstance();
            t.set(Calendar.YEAR, ano);
            t.set(Calendar.MONTH, mes);
            t.set(Calendar.DAY_OF_MONTH,i+1);
            System.out.print("dia: " + t.DAY_OF_MONTH + " " + t.DAY_OF_WEEK + " i = " + i + "\n");
            
            if(t.DAY_OF_WEEK ==1 || t.DAY_OF_WEEK ==7) { //se e um fim de semana 
                continue;
            }
            else {
                
                calendar.add(t);
            }
        }
        System.out.print(calendar.size());
        
    }
    
}
