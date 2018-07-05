/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Auxiliar;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matheus Feitosa
 */
public class CadastroAlimentoTest {
    
    public CadastroAlimentoTest() {
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
     * Test of reset method, of class CadastroAlimento.
     */
    @Test
    public void testReset() {
        CadastroAlimento cad = new CadastroAlimento();
        cad.preenchertest("nome","marca","fornecedor","123",1,true);
        cad.reset();
        String nome = cad.retornaValores(0);
        assertEquals("",nome);
        String marca = cad.retornaValores(1);
        assertEquals("",marca);
        String fornecedor = cad.retornaValores(2);
        assertEquals("",fornecedor);
        String quantidade = cad.retornaValores(3);
        assertEquals("",quantidade);
    }

    /**
     * Test of main method, of class CadastroAlimento.
     */
    @Test
    public void testMain() {
        CadastroAlimento cad = new CadastroAlimento();
        /*Como o código vai funcionar
        
        Primeiro ira criar uma String para Nome valida
        escrevera o Nome, e procurara no banco
        Caso não ache, preenchera no banco de dados com esse nome e outras informações validas
        */
        Random ran = new Random();
        String nomenovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
        while(true){
            cad.preenchernometest(nomenovo);
            cad.BotaoPesquisar().doClick();
            String marcateste = cad.retornaValores(1);
            if("".equals(marcateste)){
                break;
            }
        }
        cad.reset();
        String marcanovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
        String fornecedornovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
        int i = ran.nextInt(28) + 1;
        //fonte https://stackoverflow.com/questions/4105331/how-do-i-convert-from-int-to-string
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        String quantstring = sb.toString();
        int novoint = ran.nextInt(4);
        i = ran.nextInt(2);
        boolean booleano;
        booleano = i != 0;
        System.out.println(booleano);
        cad.preenchertest(nomenovo,marcanovo,fornecedornovo,quantstring,novoint,booleano);
        cad.BotaoCadastrar().doClick();
        cad.reset();
        cad.preenchernometest(nomenovo);
        cad.BotaoPesquisar().doClick();
        String nome = cad.retornaValores(0);
        System.out.println(nome);
        String marca = cad.retornaValores(1);
        System.out.println(marcanovo);
        String fornecedor = cad.retornaValores(2);
        System.out.println(fornecedornovo);
        String quantidade = cad.retornaValores(3);
        System.out.println(quantstring);
        cad.BotaoDeletar().doClick();
        
    } 

}
    

    