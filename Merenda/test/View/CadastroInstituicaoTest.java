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
public class CadastroInstituicaoTest {
    
    public CadastroInstituicaoTest() {
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
     * Test of reset method, of class CadastroInstituicao.
     */
    @Test
    public void testReset() {
        CadastroInstituicao I = new CadastroInstituicao();
        I.preenchertest("nome","endereco","INEP","123",1,"940028922");
        I.reset();
        String nome = I.retornaValores(0);
        assertEquals("",nome);
        String Endereco = I.retornaValores(1);
        assertEquals("",Endereco);
        String Inep = I.retornaValores(2);
        assertEquals("",Inep);
        String Qnt = I.retornaValores(3);
        assertEquals("",Qnt);
    }

    /**
     * Test of main method, of class CadastroInstituicao.
     */
    @Test
    public void testMain() {
        CadastroInstituicao I = new CadastroInstituicao();
        I.telasInvisiveis();
        for(int loop = 0;loop<50;loop++){
            /*Como o código funciona:
            
                Primeiro ele cria uma palavra aleatória e coloca na caixa do nome
            Então aperta o botão de pesquisar e copia o que esta escrito na caixa de marca
            caso tenha algo escrito, então existe algum alimento nesse banco
            se não, essa palavra não faz parte do banco.
            
                Então ele cria outros dados validos e cadastra no banco.
            Após isso ele da reset e escreve novamente o nome na caixa de nome e pesquisa,
            ele ira conferir os dados retornados e os dados salvos,
            caso os dados estejam iguais então está tudo correto, então ele deleta do banco.
            */
            Random ran = new Random();
            String nomenovo;
            while(true){
                nomenovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
                I.preenchernometest(nomenovo);
                I.BotaoPesquisar().doClick();
                String Endereco = I.retornaValores(1);
                if("".equals(Endereco)){
                    break;
                }
                I.reset();
            }
            I.reset();
            String Endereco = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
            String Inep = Auxiliar.CriaNumero(8);
            int i = ran.nextInt(28) + 1;
            //fonte https://stackoverflow.com/questions/4105331/how-do-i-convert-from-int-to-string
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i);
            String quantstring = sb.toString();
            int novoint = ran.nextInt(4);
            String Telefone = Auxiliar.CriaNumero(ran.nextInt(2)+10);
            I.preenchertest(nomenovo,Endereco,Inep,quantstring,novoint,Telefone);
            I.BotaoCadastrar().doClick();
            I.reset();
            I.preenchernometest(nomenovo);
            I.BotaoPesquisar().doClick();
            String nome = I.retornaValores(0);
            assertEquals(nomenovo,nome);
            System.out.println(nome);
            String End = I.retornaValores(1);
            assertEquals(Endereco,End);
            String Ine = I.retornaValores(2);
            assertEquals(Inep,Ine);
            String quantidade = I.retornaValores(3);
            assertEquals(quantidade,quantstring);
            I.BotaoDeletar().doClick();
        }   
    }
    @Test
    public void testInvalido() {
        /*Como o código funciona:
            
            Primeiro ele cria um numero randomico para descobrir qual casa será invalida,
        o que for selecionado sera garantidamente invalido, mas os outros também poderam ser invalidos.
        Os dados invalidos em sua grande maioria tem duas possibilidades, algo invalido e vazio.
        
            Após todos os dados serem escritos eles são cadastrados, mas o esperado que eles não cadastrem.
        Mas para saber se funcionou se pesquisa o nome, caso encontre ele no banco então deu erro,
        depois clica no botao deletar para deletar caso seja encontrado.
            */
        for(int loop = 0;loop<50;loop++){
            CadastroInstituicao I = new CadastroInstituicao();
            I.telasInvisiveis();
            Random ran = new Random();
            String nomenovo;
            String Endereconovo;
            String Inepnovo;
            String quantstring;
            String Telefonenovo;
            int novoint;
            int erro;
            erro = ran.nextInt(6);
            if(erro==0 || ran.nextInt(2)==1 ){
                if(ran.nextInt(2)==1){
                    while(true){
                        nomenovo = Auxiliar.CriaPalavra(50);
                        I.preenchernometest(nomenovo);
                        I.BotaoPesquisar().doClick();
                        String Enderecoteste = I.retornaValores(1);
                        if("".equals(Enderecoteste)){
                            break;
                        }
                        I.reset();
                    }
                }else{
                    while(true){
                        nomenovo = "";
                        I.preenchernometest(nomenovo);
                        I.BotaoPesquisar().doClick();
                        String Enderecoteste = I.retornaValores(1);
                        if("".equals(Enderecoteste)){
                            break;
                        }
                        I.reset();
                    }    
                }
            }else{
                while(true){
                    nomenovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
                    I.preenchernometest(nomenovo);
                    I.BotaoPesquisar().doClick();
                    String Enderecoteste = I.retornaValores(1);
                    if("".equals(Enderecoteste)){
                        break;
                    }
                    I.reset();
                }
            }




            if(erro==1 || ran.nextInt(2)==1 ){
                 if(ran.nextInt(2)==1){
                    Endereconovo = Auxiliar.CriaPalavra(50);
                }else{
                    Endereconovo = "";
                }
            }else{
                Endereconovo = Auxiliar.CriaPalavra(ran.nextInt(28) + 1);
            }




            if(erro==2 || ran.nextInt(2)==1 ){
                if(ran.nextInt(2)==1){
                    Inepnovo = Auxiliar.CriaNumero(ran.nextInt(10) + 8);
                }else{
                    Inepnovo = Auxiliar.CriaNumero(ran.nextInt(8));
                }
            }else{
                Inepnovo = Auxiliar.CriaNumero(8);
            }





            if(erro==3 || ran.nextInt(2)==1 ){
                if(ran.nextInt(2)==1){
                    quantstring = Auxiliar.CriaPalavra(50);
                }else{
                    quantstring = "";
                }
            }else{
                StringBuilder sb = new StringBuilder();
                int i = ran.nextInt(28) + 1;
                sb.append("");
                sb.append(i);
                quantstring = sb.toString();
            }




            if(erro==4 || ran.nextInt(2)==1 ){
                    novoint = -1;
            }else{
                novoint = ran.nextInt(4);
            }

            if(erro==5 || ran.nextInt(2)==1 ){
                if(ran.nextInt(2)==1){
                    Telefonenovo = Auxiliar.CriaNumero(ran.nextInt(10) + 12);
                }else{
                    Telefonenovo = Auxiliar.CriaNumero(ran.nextInt(10));
                }
            }else{
                Telefonenovo = Auxiliar.CriaNumero(ran.nextInt(2)+10);
            }

            I.preenchertest(nomenovo,Endereconovo,Inepnovo,quantstring,novoint,Telefonenovo);
            I.BotaoCadastrar().doClick();
            I.reset();
            I.preenchernometest(nomenovo);
            I.BotaoPesquisar().doClick();
            String nome = I.retornaValores(0);
            System.out.println(nome);
            assertEquals(nomenovo,nome);
            String marca = I.retornaValores(1);
            System.out.println(Endereconovo);
            assertEquals("",marca);
            String fornecedor = I.retornaValores(2);
            System.out.println(Inepnovo);
            assertEquals("",fornecedor);
            String quantidade = I.retornaValores(3);
            System.out.println(quantstring);
            assertEquals("",quantidade);
            I.BotaoDeletar().doClick();
        }
    }
    
}
