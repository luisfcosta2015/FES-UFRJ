/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiago
 */
public class CalendarioTest {
    
    public CalendarioTest() {
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

    /**
     * Test of getList method, of class Calendario.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        Calendario instance = null;
        ArrayList<Date> expResult = null;
        ArrayList<Date> result = instance.getList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Calendario.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int pos = 0;
        Calendario instance = null;
        Date expResult = null;
        Date result = instance.get(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Calendario.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int pos = 0;
        Calendario instance = null;
        Date expResult = null;
        Date result = instance.remove(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Calendario.
     */
    @Test
    public void testRemove_Date() {
        System.out.println("remove");
        Date data = null;
        Calendario instance = null;
        boolean expResult = false;
        boolean result = instance.remove(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        /*assertEquals(valor que se espera,função(dados de teste));*/
    }
    
}
