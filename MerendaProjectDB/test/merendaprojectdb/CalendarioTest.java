/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import java.util.ArrayList;
import java.util.Calendar;
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
    
    private Calendario calendario;
    private Calendar calendar;
    private int ano;
    private int mes;
    private Date inicial;
    private Date fim;

    
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
        calendar = Calendar.getInstance();
        this.calendario= new Calendario(5,2018+1900);
        this.ano=2018;
        this.mes=5;
        this.inicial = new Date(ano-1900, mes, 1);
        this.calendar.setTime(this.inicial);
        //dt.setDate(calendario.getActualMaximum(this.mes));
        this.fim = new Date(ano-1900, mes,calendar.getActualMaximum(calendar.DAY_OF_MONTH));
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getList method, of class Calendario.
     */
    @Test
    public void testGetList() {
        ArrayList<Date> datas = new ArrayList<>();

        for(Date dt = this.inicial; dt.compareTo(this.fim) <= 0;) {
            if(calendar.get(calendar.DAY_OF_WEEK) != 1 && calendar.get(calendar.DAY_OF_WEEK) != 7) {
                datas.add(new Date(dt.getTime()));
            }
        }
        
        
        
        ArrayList<Date> expResult = datas;
        ArrayList<Date> result = calendario.getList();
        assertEquals(expResult, result);
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
