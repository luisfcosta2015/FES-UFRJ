/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import java.util.ArrayList;
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
public class RelatorioTest {
    private Relatorio instance;
    private Escola escola;
    private Escola outraescola;
    private Calendario calendario;
    private Cardapio cardapio;
    private CapaDados capaDados;
    private ArrayList<ItemComida> itensComida;
    private ItemComida banana;
    private ItemComida maca;
    
    public RelatorioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //banana = new ItemComida("banana",10,"rio");
        //maca = new ItemComida("maca",20,"rio");
        itensComida.add(maca);
        itensComida.add(banana);
        
        capaDados = new CapaDados();
        calendario = new Calendario(7,2018);
        cardapio = new Cardapio(calendario);
        escola = new Escola("estado", "prefeitura", "secretaria", "subsecretaria","departamento",123,"diretoria","unidade","telefone");
        outraescola= new Escola("oestado", "oprefeitura", "osecretaria", "osubsecretaria","odepartamento",1234,"odiretoria","ounidade","otelefone");
        
        instance = new Relatorio(7,2018,"relatorio", escola, cardapio, capaDados);
        this.instance.semana1 = itensComida;
        instance = new Relatorio(7,2018,"relatorio", escola, cardapio, capaDados, itensComida);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCapaRelatorio method, of class Relatorio.
     */
    @Test
    public void testGetCapaRelatorio() {
        assertEquals(capaDados, instance.getCapaRelatorio());;
    }

    /**
     * Test of getCardapioRelatorio method, of class Relatorio.
     */
    @Test
    public void testGetCardapioRelatorio() {
        assertEquals(cardapio, instance.getCardapioRelatorio());
    }

    /**
     * Test of getTitulo method, of class Relatorio.
     */
    @Test
    public void testGetTitulo() {
        assertEquals("relatorio", instance.getTitulo());
    }

    /**
     * Test of setEscola method, of class Relatorio.
     */
    @Test
    public void testSetEscola() {
        assertEquals(true, instance.setEscola(outraescola));
        assertEquals(outraescola, instance.getEscola());
    }

    /**
     * Test of getMes method, of class Relatorio.
     */
    @Test
    public void testGetMes() {
        assertEquals(7, instance.getMes());
    }

    /**
     * Test of getAno method, of class Relatorio.
     */
    @Test
    public void testGetAno() {
        assertEquals(2018, instance.getAno());
    }

    /**
     * Test of getEscola method, of class Relatorio.
     */
    @Test
    public void testGetEscola() {
        assertEquals(escola, instance.getEscola());
    }
    
}
