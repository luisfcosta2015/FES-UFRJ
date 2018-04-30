package merendaproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private ArrayList<Date> datas = new ArrayList<>(); //mes de 0-11
    private Date inicial;
    private Date fim;
    private Calendar calendario;
    int mes;
    int ano;
    
    Cardapio(int mes, int ano) {
        calendario = Calendar.getInstance();
        this.mes = mes;
        this.ano = ano;
        
        this.inicial = new Date(ano-1900, mes, 1);
        calendario.setTime(this.inicial);
        //dt.setDate(calendario.getActualMaximum(this.mes));
        this.fim = new Date(ano-1900, mes,calendario.getActualMaximum(calendario.DAY_OF_MONTH));
        montaArray();
    }
    private void montaArray() {
        for(Date dt = this.inicial; dt.compareTo(this.fim) <= 0;) {
            if(calendario.get(calendario.DAY_OF_WEEK) != 1 && calendario.get(calendario.DAY_OF_WEEK) != 7) {
                this.datas.add(new Date(dt.getTime()));
            }
            calendario.add (Calendar.DATE, +1);
            dt = calendario.getTime();
        }
    }
    
    public ArrayList<Date> getList() {
        return this.datas;
    }
    public Date get(int pos) {
        return this.datas.get(pos);
    }
    public Date remove(int pos) {
        return this.datas.remove(pos);
    }
    public boolean remove(Date data) {
        return this.datas.remove(data);
    }
    
}
