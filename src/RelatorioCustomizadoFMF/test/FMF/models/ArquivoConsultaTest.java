/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucca
 */
public class ArquivoConsultaTest {
    
    public ArquivoConsultaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testgetAtributos(){
        /*Start:Teste 1*/
        Set<String> exp1 = new HashSet<String>(Arrays.asList("teste1" ,"parametros", "barra de espaço e ç"));
        ArquivoConsulta teste1 = null;
        try{
            teste1 = new ArquivoConsulta("teste1.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
        Set<String> res1 = teste1.getAtributos();
        assertEquals(exp1, res1);
        /*End: Teste 1*/
       
        /*Start:Teste 2*/
        Set<String> exp2 = new HashSet<String>(Arrays.asList("teste1" ,"parametros", "barra de espaço e ç"));
        ArquivoConsulta teste2 = null;
        Boolean deuerrado = false;
        try{
            teste1 = new ArquivoConsulta("testequenaoexiste.txt");
        } catch (FileNotFoundException ex) {
            deuerrado = true;
        }
        assertEquals(deuerrado, true);
        /*End: Teste 1*/
        
    }
    
}
