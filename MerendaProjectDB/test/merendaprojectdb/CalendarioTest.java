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
    private ArrayList<Date> expResult;
    
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
        System.out.println("setUp");
        this.ano=2018;
        this.mes=5;
        calendar = Calendar.getInstance();
        this.calendario= new Calendario(this.mes, this.ano);
        this.inicial = new Date(this.ano, this.mes, 1);
        this.calendar.setTime(this.inicial);
        System.out.println("setUp");
        //dt.setDate(calendario.getActualMaximum(this.mes));
        this.fim = new Date(this.ano, mes,calendar.getActualMaximum(calendar.DAY_OF_MONTH));
        System.out.println("setUp");
        this.expResult = new ArrayList<>();
        for(Date dt = this.inicial; dt.compareTo(this.fim) <= 0;) {
            if(calendar.get(calendar.DAY_OF_WEEK) != 1 && calendar.get(calendar.DAY_OF_WEEK) != 7) {
                this.expResult.add(new Date(dt.getTime()));
            }
            calendar.add(Calendar.DATE, +1);
            dt = calendar.getTime();
        }
        System.out.println("setUp");
    }
    
    @After
    public void tearDown() {
    }
    private boolean compareCalendarList(ArrayList<Date> calendar1, ArrayList<Date> calendar2) {
        if(calendar1.size() != calendar2.size()) {
            return false;
        }
        for(int i=0; i < calendar1.size(); i++) {
            if(calendar1.get(i).compareTo(calendar2.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Test of getList method, of class Calendario.
     */
    @Test
    public void testGetList() {
        System.out.println("testGetList");
        ArrayList<Date> result = calendario.getList();
        assertEquals(compareCalendarList(this.expResult, result), true);
    }

    /**
     * Test of get method, of class Calendario.
     */
    @Test
    public void testGet() {
        System.out.println("testGet");
        int pos = 0;
        Date expResult = this.expResult.get(pos);
        Date result = this.calendario.get(pos);
        assertEquals(expResult.getTime(), result.getTime());
    }

    /**
     * Test of remove method, of class Calendario.
     */
    @Test
    public void testRemove_int() {
        System.out.println("testRemoveInt");
        int pos = 0;
        Date expResult = this.expResult.get(pos);
        Date removed = this.calendario.remove(pos);
        assertEquals(expResult.getTime(), removed.getTime());
        assertEquals(this.calendario.getList().contains(removed), false);
    }

    /**
     * Test of remove method, of class Calendario.
     */
    @Test
    public void testRemove_Date() {
        System.out.println("testRemoveDate");
        int pos = 10;
        Date toBeRemoved = this.calendario.getList().get(pos);
        boolean result1 = this.calendario.remove(toBeRemoved);
        assertEquals(true, result1);
        assertEquals(this.calendario.getList().contains(toBeRemoved), false);
        
        Date notExistingDate = new Date(this.ano + 10, this.mes, 1);
        boolean result = this.calendario.remove(notExistingDate);
        assertEquals(false, result);
        assertEquals(this.calendario.getList().contains(notExistingDate), false);
    }
    @Test
    public void testGetAno() {
        int result = this.calendario.getAno();
        assertEquals(result, this.ano);
    }
    @Test
    public void testGetMes() {
        int result = this.calendario.getMes();
        assertEquals(result, this.mes);
    }
    
}
