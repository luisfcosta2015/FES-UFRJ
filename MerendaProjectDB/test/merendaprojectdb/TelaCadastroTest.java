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
public class TelaCadastroTest {
    Usuario valido;
    Usuario upperCase;
    Usuario userEmBranco;
    Usuario senhaEmBranco;
    Usuario emailEmBranco;
    Usuario nomeEmBranco;
    public TelaCadastroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.valido = new Usuario("admin", "admin", "admin", "admin", "Administrador");
        upperCase= new Usuario("ADMIN", "ADMIN", "ADMIN", "admin", "Administrador");
        userEmBranco = new Usuario("admin", "", "admin", "admin", "Administrador");
        senhaEmBranco = new Usuario("admin", "admin", "", "admin", "Administrador");
        emailEmBranco = new Usuario("admin", "admin", "admin", "", "Administrador");
        nomeEmBranco = new Usuario("", "admin", "admin", "admin", "Administrador");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void verificaPreenchimentoTest() {
       TelaCadastro instance = new TelaCadastro();
       assertEquals(instance.verificaPreenchimento(this.valido), true);
       assertEquals(instance.verificaPreenchimento(this.emailEmBranco), false);
       assertEquals(instance.verificaPreenchimento(this.nomeEmBranco), false);
       assertEquals(instance.verificaPreenchimento(this.senhaEmBranco), false);
       assertEquals(instance.verificaPreenchimento(this.userEmBranco), false);
       assertEquals(instance.verificaPreenchimento(this.upperCase), true);
    }
    
}
