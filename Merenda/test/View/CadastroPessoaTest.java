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
 * @author convidado
 */
public class CadastroPessoaTest {
    
    public CadastroPessoaTest() {
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
     * Test of reset method, of class CadastroPessoa.
     */
    @Test
    public void testReset() {
        CadastroPessoa p = new CadastroPessoa();
        p.preenchertest("dawfw","65465165");
        p.reset();
        assertEquals("",p.retornaValores(0));
        assertEquals("",p.retornaValores(1));
    }

    /**
     * Test of main method, of class CadastroPessoa.
     */
    @Test
    public void testMain() {
        CadastroPessoa p = new CadastroPessoa();
        p.telasInvisiveis();
        String nomenovo;
        Random ran = new Random();
        while(true){
                nomenovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
                p.preenchernometest(nomenovo);
                p.BotaoPesquisar().doClick();
                String cpfteste = p.retornaValores(1);
                if("".equals(cpfteste)){
                    break;
                }
            }
        p.reset();
        String cpfnovo = Auxiliar.CriaNumero(11);
        p.preenchertest(nomenovo,cpfnovo);
        p.BotaoCadastrar().doClick();
        p.reset();
        p.preenchernometest(nomenovo);
        p.BotaoPesquisar().doClick();
        String nome = p.retornaValores(0);
        assertEquals(nomenovo,nome);
        String cpf = p.retornaValores(1);
        assertEquals(cpfnovo,cpf);
        p.BotaoDeletar().doClick();
    }
    
    @Test
    public void testInvalid() {
        CadastroPessoa p = new CadastroPessoa();
        p.telasInvisiveis();
        Random ran = new Random();
        String nomenovo;
        String Cpfnovo;
        int novoint;
        int erro;
        erro = ran.nextInt(2);
        if(erro==0 || ran.nextInt(2)==1 ){
            if(ran.nextInt(2)==1){
                while(true){
                    nomenovo = Auxiliar.CriaPalavra(50);
                    p.preenchernometest(nomenovo);
                    p.BotaoPesquisar().doClick();
                    String cpfteste = p.retornaValores(1);
                    if("".equals(cpfteste)){
                        break;
                    }
                }
            }else{
                while(true){
                    nomenovo = "";
                    p.preenchernometest(nomenovo);
                    p.BotaoPesquisar().doClick();
                    String cpfteste = p.retornaValores(1);
                        if("".equals(cpfteste)){
                            break;
                        }
                    }    
                }
        }else{
            while(true){
                nomenovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
                p.preenchernometest(nomenovo);
                p.BotaoPesquisar().doClick();
                String cpfteste = p.retornaValores(1);
                if("".equals(cpfteste)){
                    break;
                }
            }
        }
        
        if(erro==1 || ran.nextInt(2)==1 ){
                 if(ran.nextInt(2)==1){
                    Cpfnovo = Auxiliar.CriaNumero(50);
                }else{
                    Cpfnovo = "";
                }
            }else{
                Cpfnovo = Auxiliar.CriaNumero(11);
            }
        
        p.preenchertest(nomenovo,Cpfnovo);
        p.BotaoCadastrar().doClick();
        p.reset();
        p.preenchernometest(nomenovo);
        p.BotaoPesquisar().doClick();
        String cpf = p.retornaValores(1);
        assertEquals("",cpf);
        p.BotaoDeletar().doClick();
    }
    
}
