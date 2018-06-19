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
public class TiposDeUsuarioTest {
    private TiposDeUsuario instance;
    public TiposDeUsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.instance = new TiposDeUsuario();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPermissoesAdm method, of class TiposDeUsuario.
     */
    @Test
    public void testSetPermissoesAdm() {
        System.out.println("setPermissoesAdm all false");
        boolean nr = false;
        boolean wr = false;
        boolean sr = false;
        boolean ws = false;
        boolean ss = false;
        boolean au = false;
        this.instance.setPermissoesAdm(nr, wr, sr, ws, ss, au);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(au, instance.getAdmPermits().canAddUser);
        assertEquals(nr, instance.getAdmPermits().canNewReport);
        assertEquals(sr, instance.getAdmPermits().canSeeReport);
        assertEquals(ss, instance.getAdmPermits().canSeeSchool);
        assertEquals(wr, instance.getAdmPermits().canWriteReport);
        assertEquals(ws, instance.getAdmPermits().canWriteSchool);
        nr = true;
        wr = true;
        sr = true;
        ws = true;
        ss = true;
        au = true;
        this.instance.setPermissoesAdm(nr, wr, sr, ws, ss, au);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(au, instance.getAdmPermits().canAddUser);
        assertEquals(nr, instance.getAdmPermits().canNewReport);
        assertEquals(sr, instance.getAdmPermits().canSeeReport);
        assertEquals(ss, instance.getAdmPermits().canSeeSchool);
        assertEquals(wr, instance.getAdmPermits().canWriteReport);
        assertEquals(ws, instance.getAdmPermits().canWriteSchool);
    }

    /**
     * Test of getAdmPermits method, of class TiposDeUsuario.
     */
    @Test
    public void testGetAdmPermits() {
        System.out.println("getAdmPermits");
        Permissoes expResult = new Permissoes();
        expResult.canAddUser =true;
        expResult.canNewReport = true;
        expResult.canSeeReport = true;
        expResult.canSeeSchool = true;
        expResult.canWritePermit = true;
        expResult.canWriteReport = true;
        expResult.canWriteSchool = true;
        Permissoes result = instance.getAdmPermits();
        assertEquals(expResult.canAddUser, result.canAddUser);
        assertEquals(expResult.canNewReport, result.canNewReport);
        assertEquals(expResult.canSeeReport, result.canSeeReport);
        assertEquals(expResult.canSeeSchool, result.canSeeSchool);
        assertEquals(expResult.canWritePermit, result.canWritePermit);
        assertEquals(expResult.canWriteReport, result.canWriteReport);
        assertEquals(expResult.canWriteSchool, result.canWriteSchool);
    }

    /**
     * Test of setPermissoesLeitor method, of class TiposDeUsuario.
     */
    @Test
    public void testSetPermissoesLeitor() {
        System.out.println("setPermissoesLeitor");
        boolean nr = false;
        boolean wr = false;
        boolean sr = false;
        boolean ws = false;
        boolean ss = false;
        boolean wp = false;
        boolean au = false;
        instance.setPermissoesLeitor(nr, wr, sr, ws, ss, wp, au);
        assertEquals(au, instance.getLeitorPermits().canAddUser);
        assertEquals(nr, instance.getLeitorPermits().canNewReport);
        assertEquals(sr, instance.getLeitorPermits().canSeeReport);
        assertEquals(ss, instance.getLeitorPermits().canSeeSchool);
        assertEquals(wr, instance.getLeitorPermits().canWriteReport);
        assertEquals(ws, instance.getLeitorPermits().canWriteSchool);
        assertEquals(wp, instance.getLeitorPermits().canWritePermit);
        nr = true;
        wr = true;
        sr = true;
        ws = true;
        ss = true;
        wp = true;
        au = true;
        instance.setPermissoesLeitor(nr, wr, sr, ws, ss, wp, au);
        assertEquals(au, instance.getLeitorPermits().canAddUser);
        assertEquals(nr, instance.getLeitorPermits().canNewReport);
        assertEquals(sr, instance.getLeitorPermits().canSeeReport);
        assertEquals(ss, instance.getLeitorPermits().canSeeSchool);
        assertEquals(wr, instance.getLeitorPermits().canWriteReport);
        assertEquals(ws, instance.getLeitorPermits().canWriteSchool);
        assertEquals(wp, instance.getLeitorPermits().canWritePermit);
    }

    /**
     * Test of getLeitorPermits method, of class TiposDeUsuario.
     */
    @Test
    public void testGetLeitorPermits() {
        System.out.println("getLeitorPermits");
        TiposDeUsuario instance = new TiposDeUsuario();
        Permissoes expResult = new Permissoes();
        expResult.canAddUser = false;
        expResult.canNewReport = false;
        expResult.canSeeReport = true;
        expResult.canSeeSchool = true;
        expResult.canWritePermit = false;
        expResult.canWriteReport = false;
        expResult.canWriteSchool = false;
        Permissoes result = instance.getLeitorPermits();
        assertEquals(expResult.canAddUser, result.canAddUser);
        assertEquals(expResult.canNewReport, result.canNewReport);
        assertEquals(expResult.canSeeReport, result.canSeeReport);
        assertEquals(expResult.canSeeSchool, result.canSeeSchool);
        assertEquals(expResult.canWritePermit, result.canWritePermit);
        assertEquals(expResult.canWriteReport, result.canWriteReport);
        assertEquals(expResult.canWriteSchool, result.canWriteSchool);
    }

    /**
     * Test of setPermissoesDir method, of class TiposDeUsuario.
     */
    @Test
    public void testSetPermissoesDir() {
        System.out.println("setPermissoesDir");
        boolean nr = false;
        boolean wr = false;
        boolean sr = false;
        boolean ws = false;
        boolean ss = false;
        boolean wp = false;
        boolean au = false;
        TiposDeUsuario instance = new TiposDeUsuario();
        instance.setPermissoesDir(nr, wr, sr, ws, ss, wp, au);
        assertEquals(au, instance.getDirPermits().canAddUser);
        assertEquals(nr, instance.getDirPermits().canNewReport);
        assertEquals(sr, instance.getDirPermits().canSeeReport);
        assertEquals(ss, instance.getDirPermits().canSeeSchool);
        assertEquals(wr, instance.getDirPermits().canWriteReport);
        assertEquals(ws, instance.getDirPermits().canWriteSchool);
        assertEquals(wp, instance.getDirPermits().canWritePermit);
        nr = true;
        wr = true;
        sr = true;
        ws = true;
        ss = true;
        wp = true;
        au = true;
        instance.setPermissoesDir(nr, wr, sr, ws, ss, wp, au);
        assertEquals(au, instance.getDirPermits().canAddUser);
        assertEquals(nr, instance.getDirPermits().canNewReport);
        assertEquals(sr, instance.getDirPermits().canSeeReport);
        assertEquals(ss, instance.getDirPermits().canSeeSchool);
        assertEquals(wr, instance.getDirPermits().canWriteReport);
        assertEquals(ws, instance.getDirPermits().canWriteSchool);
        assertEquals(wp, instance.getDirPermits().canWritePermit);
    }

    /**
     * Test of getDirPermits method, of class TiposDeUsuario.
     */
    @Test
    public void testGetDirPermits() {
        System.out.println("getDirPermits");
        TiposDeUsuario instance = new TiposDeUsuario();
        Permissoes expResult = new Permissoes();
        expResult.canAddUser = false;
        expResult.canNewReport = true;
        expResult.canSeeReport = true;
        expResult.canSeeSchool = true;
        expResult.canWritePermit = false;
        expResult.canWriteReport = true;
        expResult.canWriteSchool = false;
        Permissoes result = instance.getDirPermits();
        assertEquals(expResult.canAddUser, result.canAddUser);
        assertEquals(expResult.canNewReport, result.canNewReport);
        assertEquals(expResult.canSeeReport, result.canSeeReport);
        assertEquals(expResult.canSeeSchool, result.canSeeSchool);
        assertEquals(expResult.canWritePermit, result.canWritePermit);
        assertEquals(expResult.canWriteReport, result.canWriteReport);
        assertEquals(expResult.canWriteSchool, result.canWriteSchool);
    }
    
}
