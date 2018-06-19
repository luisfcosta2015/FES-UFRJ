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

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *
 * @author joycinha
 */
public class UsuarioTest {
    private Usuario userComEscola;
    private Usuario userSemEscola;
    private Escola escola;
    private Escola outraEscola;
    static ArrayList<Escola> escolas;
    public UsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        escolas = BdManager.pegarEscolas();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.escola = UsuarioTest.escolas.get(0);
        this.outraEscola = UsuarioTest.escolas.get(1);
        this.userComEscola = new Usuario("Usuario Com Escola", "dir", "123", "diretor@gmail.com", "Diretor", escola);
        this.userSemEscola = new Usuario("Usuario Sem Escola", "adm", "123", "adm@gmail.com", "Administrador");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNome method, of class Usuario.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "Usuario Com Escola";
        String result = this.userComEscola.getNome();
        assertEquals(expResult, result);
        
        expResult = "Usuario Sem Escola";
        result = this.userSemEscola.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Usuario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "diretor@gmail.com";
        String result = this.userComEscola.getEmail();
        assertEquals(expResult, result);
        expResult = "adm@gmail.com";
        result = this.userSemEscola.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Usuario.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String expResult = "dir";
        String result = this.userComEscola.getUser();
        assertEquals(expResult, result);
        expResult = "adm";
        result = this.userSemEscola.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipo method, of class Usuario.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        String expResult = "Diretor";
        String result = this.userComEscola.getTipo();
        assertEquals(expResult, result);
        expResult = "Administrador";
        result = this.userSemEscola.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSenha method, of class Usuario.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        String expResult = "123";
        String result = this.userComEscola.getSenha();
        assertEquals(expResult, result);
        expResult = "123";
        result = this.userSemEscola.getSenha();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEscola method, of class Usuario.
     */
    @Test
    public void testGetEscola() {
        System.out.println("getEscola");
        Escola expResult = escola;
        Escola result = this.userComEscola.getEscola();
        assertEquals(expResult, result);
        expResult = null;
        result = this.userSemEscola.getEscola();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNome method, of class Usuario.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Joyce";
        this.userComEscola.setNome(nome);
        assertEquals(nome, this.userComEscola.getNome());
        this.userSemEscola.setNome(nome);
        assertEquals(nome, this.userSemEscola.getNome());
    }

    /**
     * Test of setEmail method, of class Usuario.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String nome = "StringQualquer";
        this.userComEscola.setEmail(nome);
        assertEquals(nome, this.userComEscola.getEmail());
        this.userSemEscola.setEmail(nome);
        assertEquals(nome, this.userSemEscola.getEmail());
    }

    /**
     * Test of setUser method, of class Usuario.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String nome = "StringQualquer";
        this.userComEscola.setUser(nome);
        assertEquals(nome, this.userComEscola.getUser());
        this.userSemEscola.setUser(nome);
        assertEquals(nome, this.userSemEscola.getUser());
    }

    /**
     * Test of setSenha method, of class Usuario.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String senha = "StringQualquer";
        this.userComEscola.setSenha(senha);
        assertEquals(senha, this.userComEscola.getSenha());
        this.userSemEscola.setSenha(senha);
        assertEquals(senha, this.userSemEscola.getSenha());
    }

    /**
     * Test of setEscola method, of class Usuario.
     */
    @Test
    public void testSetEscola() {
        System.out.println("setEscola");
        Escola escola = this.outraEscola;
        boolean expResult = false;
        boolean result = this.userSemEscola.setEscola(escola);
        assertEquals(expResult, result);
        assertEquals(this.userSemEscola.getEscola(), null);
        expResult = true;
        result = this.userComEscola.setEscola(escola);
        assertEquals(expResult, result);
        assertEquals(this.userComEscola.getEscola(), escola);
    }    
}
