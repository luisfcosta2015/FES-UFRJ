/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package merendaproject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author joycinha
 */
public class MerendaProject {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        Cardapio cardapio = new Cardapio(1,2018);
        Escola escola = new Escola("ESTADO DO RIO DE JANEIRO","PREFEITURA DE DUQUE DE CAXIAS",
        "SECRETARIA MUNICIPAL DE EDUCAÇÃO", "SUBSECRETARIA DE EDUCAÇÃO EM INFRAESTRUTURA...", 
        "DEPARTAMENTO DE INFRAESTRUTURA EDUCACIONAL", 33151750, "E.M. ANA DE SOUSA HERDY", "(21)3656-0364");
        /*ArrayList<Date> lista = cardapio.getList();
        for(Date data : lista) {
            System.out.println(df.format(data));
        }*/
    }
    
}
