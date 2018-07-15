/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucca
 */
public class TemplateTest {
    
    public TemplateTest() {
    }

    @Test
    //testando o contrutor
    public void testgeneratePDF() {
        Template t1 = new Template("1");
        Template t2 = new Template("2");
        Template t3 = new Template("3");

        Map<String, String> m1 = new HashMap<String, String>();
        Map<String, String> m2 = new HashMap<String, String>();
        Map<String, String> m3 = new HashMap<String, String>();
        
        m1.put("nomeescola", "Escola de Testes");
        m1.put("titulo", "Boletim");
        
        m2.put("dia", "15");
        m2.put("mes", "julho");
        m2.put("ano", "2018");
        
        String s1 = t1.TESTgetTemplatePreenchido(m1);
        String s2 = t2.TESTgetTemplatePreenchido(m2);
        String s3 = t3.TESTgetTemplatePreenchido(m3);
        Template.generatePDF(s1, s3, s2);
    }
    
}
