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
 * @author Vitor
 */
public class MaisEducacaoTest {
    private MaisEducacao instance;
    
    public MaisEducacaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new MaisEducacao(1,3);
        TelaEditarPadroes.porcent = 0.85;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of changeAll method, of class MaisEducacao.
     */
    @Test
    public void testChangeAll() {
        System.out.println("changeAll");
        instance.changeAll(5, 4);
        assertEquals(5, instance.matriculados);
        assertEquals(4, instance.atendidos);
        assertEquals(4, instance.numDias);
        assertEquals(16, instance.totalDesjejum);
        assertEquals(16, instance.totalLanche);
        TelaEditarPadroes.porcent = 0.50;
        instance.changeAll(5, 4);
        assertEquals(5, instance.matriculados);
        assertEquals(2, instance.atendidos);
        assertEquals(4, instance.numDias);
        assertEquals(8, instance.totalDesjejum);
        assertEquals(8, instance.totalLanche);
    }
    
}
