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
public class LoginTest {
    
    public LoginTest() {
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
     * Test of main method, of class Login.
     */
    
    /*
        Esse codigo cria um cadastro Pessoa, um cadastro instituição e 
    um cadastro conta validos, então ele tenta logar, com a senha correta e incorreta
    */
    
    @Test
    public void testMain() {
        CadastroInstituicao I = new CadastroInstituicao();
        I.telasInvisiveis();
        CadastroPessoa p = new CadastroPessoa();
        p.telasInvisiveis();
        CadastroConta C = new CadastroConta();
        C.telasInvisiveis();
        Random ran = new Random();
        for(int loop=0;loop<50;loop++){
            String nomenovoI;
            String nomenovoP;
            //Instituicao
            while(true){
                nomenovoI = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
                I.preenchernometest(nomenovoI);
                I.BotaoPesquisar().doClick();
                String EnderecoI = I.retornaValores(1);
                if("".equals(EnderecoI)){
                    break;
                }
                I.reset();
            }
            I.reset();
            String EnderecoI = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
            String InepI = Auxiliar.CriaNumero(8);
            int i = ran.nextInt(28) + 1;
            //fonte https://stackoverflow.com/questions/4105331/how-do-i-convert-from-int-to-string
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            String quantstringI = sb.toString();
            int novointI = ran.nextInt(4);
            String TelefoneI = Auxiliar.CriaNumero(ran.nextInt(2)+10);
            I.preenchertest(nomenovoI,EnderecoI,InepI,quantstringI,novointI,TelefoneI);
            I.BotaoCadastrar().doClick();
            
            //Instituicao
            
            //Pessoa
            while(true){
                    nomenovoP = Auxiliar.CriaPalavra(ran.nextInt(80) + 1);
                    p.preenchernometest(nomenovoP);
                    p.BotaoPesquisar().doClick();
                    String cpftesteP = p.retornaValores(1);
                    if("".equals(cpftesteP)){
                        break;
                    }
                    p.reset();
                }
            p.reset();
            String cpfnovoP = Auxiliar.CriaNumero(11);
            p.preenchertest(nomenovoP,cpfnovoP);
            p.BotaoCadastrar().doClick();
            
            //Pessoa
            
            //Conta
            
            C.preencherPessoatest(nomenovoP);
            C.preencherInstituicaotest(nomenovoI);
            C.BotaoPessoa().doClick();
            C.BotaoInstituicao().doClick();
            
            
            String Usuario = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
            String Matricula = Auxiliar.CriaNumero(10);
            String Senha = Auxiliar.CriaPalavra(ran.nextInt(3) + 5);
            String Senha2 = Senha;
            int inteiro = ran.nextInt(2);
            
            C.preenchertest(Usuario,Matricula,Senha,Senha2,inteiro);
            C.BotaoCadastrar().doClick();
            System.out.println("View.LoginTest.testMain()");
            int inte;
            if(true){
                Login L = new Login();
                L.NaoApareceTela();
                L.preencher(Usuario, Senha);
                L.BotaoLogin().doClick();
                inte = L.RetornaTipoDeLogin();
            }
            System.out.println("retornou");
            System.out.println(inte-1);
            System.out.println("Inteiro");
            System.out.println(inteiro);
            assertEquals(inte-1,inteiro);
            if(true){
                Login L = new Login();
                L.NaoApareceTela();
                L.preencher(Usuario, Senha+"aaa");
                L.BotaoLogin().doClick();
                inte = L.RetornaTipoDeLogin();
            }
            assertEquals(inte,-1);
            C.BotaoDeletar().doClick();
            I.reset();
            p.reset();
            I.preenchernometest(nomenovoI);
            p.preenchernometest(nomenovoP);
            p.BotaoPesquisar().doClick();
            p.BotaoDeletar().doClick();
            I.BotaoPesquisar().doClick();
            I.BotaoDeletar().doClick();
        }
    }
    
}
