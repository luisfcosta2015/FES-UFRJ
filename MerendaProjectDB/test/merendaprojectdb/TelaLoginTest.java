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
public class TelaLoginTest {
    private Usuario usuarioValido;
    public TelaLoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.usuarioValido = BdManager.findUser("admin");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verificaLogin method, of class TelaLogin.
     */
    @Test
    public void testVerificaLogin() {
        TelaLogin instance = new TelaLogin();
        instance.setSenha(this.usuarioValido.getSenha());
        instance.setUser(this.usuarioValido.getUser());
        if(!instance.verificaLogin()) {
            fail("Falha ao validar um usuário existente no banco");
        }
        // TODO review the generated test code and remove the default call to fail.   
    }    
}
