/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucca
 */
public class RelatorioTest {
    
    public RelatorioTest() {
    }

    @Test
    //testando o contrutor
    public void testConstrutor() {
        Relatorio a = new Relatorio("Boletim.json");
        Map<String, String> m1 = a.listaPreenchimentosNecessarios();
        System.out.print(m1);
        m1.put("matricula", "2");
        a.geraPDFPreenchido(m1);
    }
    
}
