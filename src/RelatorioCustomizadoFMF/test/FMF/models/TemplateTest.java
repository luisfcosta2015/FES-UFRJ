/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

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
    public void testTemplate() {
        Template t1 = new Template("1");
        Template t2 = new Template("2");
        Template t3 = new Template("3");
        Template.generatePDF(t1, t3, t2);
    }
    
}
