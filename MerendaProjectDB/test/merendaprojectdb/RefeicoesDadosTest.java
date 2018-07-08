/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joycinha
 */
public class RefeicoesDadosTest {
    private RefeicoesDados dados;
    public RefeicoesDadosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.dados = new RefeicoesDados(15,20,85,30,10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of changeAll method, of class RefeicoesDados.
     */
    @Test
    public void testChangeAll() {
        System.out.println("changeAll");
        int turno1 = 5;
        int turno2 = 5;
        int turno3 = 5;
        int turno4 = 5;
        int atendidos = 17;
        int numDias = 2;
        this.dados.changeAll(turno1, turno2, turno3, turno4, numDias);
        assertEquals(turno1, this.dados.turnos[0]);
        assertEquals(turno2, this.dados.turnos[1]);
        assertEquals(turno3, this.dados.turnos[2]);
        assertEquals(turno4, this.dados.turnos[3]);
        assertEquals(atendidos, this.dados.atendidos);
        assertEquals(numDias, this.dados.numDias);
        
    }
    
}
