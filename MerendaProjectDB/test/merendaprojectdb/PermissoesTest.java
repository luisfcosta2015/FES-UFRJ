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
    private Permissoes instance;
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
        instance = new Permissoes();
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
        instance.canNewReport(false);
        assertEquals(false,instance.canNewReport);
        instance.canNewReport(true);
        assertEquals(true,instance.canNewReport);
    }

    /**
     * Test of canWriteReport method, of class Permissoes.
     */
    @Test
    public void testCanWriteReport() {
        System.out.println("canWriteReport");
        instance.canWriteReport(false);
        assertEquals(false,instance.canWriteReport);
        instance.canWriteReport(true);
        assertEquals(true,instance.canWriteReport);
    }

    /**
     * Test of canSeeReport method, of class Permissoes.
     */
    @Test
    public void testCanSeeReport() {
        System.out.println("canSeeReport");
        instance.canSeeReport(false);
        assertEquals(false,instance.canSeeReport);
        instance.canSeeReport(true);
        assertEquals(true,instance.canSeeReport);
    }

    /**
     * Test of canWriteSchool method, of class Permissoes.
     */
    @Test
    public void testCanWriteSchool() {
        System.out.println("canWriteSchool");
        instance.canWriteSchool(false);
        assertEquals(false,instance.canWriteSchool);
        instance.canWriteSchool(true);
        assertEquals(true,instance.canWriteSchool);
    }

    /**
     * Test of canSeeSchool method, of class Permissoes.
     */
    @Test
    public void testCanSeeSchool() {
        System.out.println("canSeeSchool");
        instance.canSeeSchool(false);
        assertEquals(false,instance.canSeeSchool);
        instance.canSeeSchool(true);
        assertEquals(true,instance.canSeeSchool);
    }

    /**
     * Test of canWritePermit method, of class Permissoes.
     */
    @Test
    public void testCanWritePermit() {
        System.out.println("canWritePermit");
        instance.canWritePermit(false);
        assertEquals(false,instance.canWritePermit);
        instance.canWritePermit(true);
        assertEquals(true,instance.canWritePermit);
    }

    /**
     * Test of canAddUser method, of class Permissoes.
     */
    @Test
    public void testCanAddUser() {
        System.out.println("canAddUser");
        instance.canAddUser(false);
        assertEquals(false,instance.canAddUser);
        instance.canAddUser(true);
        assertEquals(true,instance.canAddUser);
    }
    
}
