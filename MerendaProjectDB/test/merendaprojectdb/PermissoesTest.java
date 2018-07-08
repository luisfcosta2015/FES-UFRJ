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
public class PermissoesTest {
    
    public PermissoesTest() {
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
     * Test of canNewReport method, of class Permissoes.
     */
    @Test
    public void testCanNewReport() {
        System.out.println("canNewReport");
        boolean m = false;
        Permissoes instance = new Permissoes();
        instance.canNewReport(m);
        assertEquals(instance.canNewReport, false);
        m = true;
        instance.canNewReport(m);
        assertEquals(instance.canNewReport, true);
    }

    /**
     * Test of canWriteReport method, of class Permissoes.
     */
    @Test
    public void testCanWriteReport() {
        System.out.println("canWriteReport");
        boolean m = false;
        Permissoes instance = new Permissoes();
        instance.canWriteReport(m);
        assertEquals(instance.canWriteReport, false);
        m = true;
        instance.canWriteReport(m);
        assertEquals(instance.canWriteReport, true);
    }

    /**
     * Test of canSeeReport method, of class Permissoes.
     */
    @Test
    public void testCanSeeReport() {
        System.out.println("canSeeReport");
        boolean m = false;
        Permissoes instance = new Permissoes();
        instance.canSeeReport(m);
        assertEquals(instance.canSeeReport, false);
        m = true;
        instance.canSeeReport(m);
        assertEquals(instance.canSeeReport, true);
    }

    /**
     * Test of canWriteSchool method, of class Permissoes.
     */
    @Test
    public void testCanWriteSchool() {
        boolean m = false;
        Permissoes instance = new Permissoes();
        instance.canWriteSchool(m);
        assertEquals(instance.canWriteSchool, false);
        m = true;
        instance.canWriteSchool(m);
        assertEquals(instance.canWriteSchool, true);
    }

    /**
     * Test of canSeeSchool method, of class Permissoes.
     */
    @Test
    public void testCanSeeSchool() {
        boolean m = false;
        Permissoes instance = new Permissoes();
        instance.canSeeSchool(m);
        assertEquals(instance.canSeeSchool, false);
        m = true;
        instance.canSeeSchool(m);
        assertEquals(instance.canSeeSchool, true);
    }

    /**
     * Test of canWritePermit method, of class Permissoes.
     */
    @Test
    public void testCanWritePermit() {
        boolean m = false;
        Permissoes instance = new Permissoes();
        instance.canWritePermit(m);
        assertEquals(instance.canWritePermit, false);
        m = true;
        instance.canWritePermit(m);
        assertEquals(instance.canWritePermit, true);
    }

    /**
     * Test of canAddUser method, of class Permissoes.
     */
    @Test
    public void testCanAddUser() {
        boolean m = false;
        Permissoes instance = new Permissoes();
        instance.canAddUser(m);
        assertEquals(instance.canAddUser, false);
        m = true;
        instance.canAddUser(m);
        assertEquals(instance.canAddUser, true);
    }
    
}
