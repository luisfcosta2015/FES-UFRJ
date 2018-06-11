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
public class EscolaTest {
    
    private Escola escola;
    
    public EscolaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        escola = new Escola("estado", "prefeitura", "secretaria", "subsecretaria", "departamento", 1234, "diretoria", "unidade", "telefone");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of changeEstado method, of class Escola.
     */
    @Test
    public void testChangeEstado() {
        escola.changeEstado("outroestado");
        assertEquals("outroestado",escola.getEstado());
    }

    @Test
    public void testChangePrefeitura() {
        escola.changePrefeitura("outraprefeitura");
        assertEquals("outraprefeitura", escola.getPrefeitura());
    }

    @Test
    public void testChangeSecretaria() {
        escola.changeSecretaria("outrasec");
        assertEquals("outrasec", escola.getSecretaria());
    }


    @Test
    public void testChangeSubsecretaria() {
        escola.changeSubsecretaria("outrasub");
        assertEquals("outrasub", escola.getSubsecretaria());
    }

    @Test
    public void testChangeDepartamento() {
      escola.changeDepartamento("outrodep");
      assertEquals("outrodep", escola.getDepartamento());
    }

    @Test
    public void testChangeINEP() {
        escola.changeINEP(123);
        assertEquals(123, escola.getINEP());
   
    }

    @Test
    public void testChangeDiretoria() {
        escola.changeDiretoria("outradir");
        assertEquals("outradir", escola.getDiretoria());
    }

    @Test
    public void testChangeUnidade() {
       escola.changeUnidade("outrauni");
        assertEquals("outrauni", escola.getUnidade());
    }

    @Test
    public void testChangeTelefone() {
        escola.changeTelefone("outrotel");
        assertEquals("outrotel", escola.getTelefone());
    }

    @Test
    public void testGetEstado() {
        assertEquals("estado", escola.getEstado());
    }

    @Test
    public void testGetPrefeitura() {
        assertEquals("prefeitura", escola.getPrefeitura());
    }

    @Test
    public void testGetSecretaria() {
        assertEquals("secretaria", escola.getSecretaria());
    }

    @Test
    public void testGetSubsecretaria() {
        assertEquals("subsecretaria", escola.getSubsecretaria());
    }

    @Test
    public void testGetDepartamento() {
        assertEquals("departamento", escola.getDepartamento());
    }

    @Test
    public void testGetINEP() {
        assertEquals(1234, escola.getINEP());
    }

    @Test
    public void testGetUnidade() {
        assertEquals("unidade", escola.getUnidade());
    }

    @Test
    public void testGetDiretoria() {
        assertEquals("diretoria", escola.getDiretoria());
    }

    @Test
    public void testGetTelefone() {
        assertEquals("telefone", escola.getTelefone());
    }
    
}
