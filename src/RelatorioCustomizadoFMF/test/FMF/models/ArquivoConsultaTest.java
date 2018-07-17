/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucca
 */
public class ArquivoConsultaTest {
    
    public ArquivoConsultaTest() {
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

    @Test
    public void testgetAtributos(){
        /*Start:Teste 1*/
        //Objetivo: Testar se os atributos estão sendo capturados corretamente
        if(true){return ;}
        Map<String, String> exp1 = new HashMap<>();
        exp1.put("teste1", "");
        exp1.put("parametros", "");
        exp1.put("barra de espaço e ç", "");
        ArquivoConsulta teste1 = null;
        try{
            teste1 = new ArquivoConsulta("teste1.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
        Map<String, String> res1 = teste1.getAtributos();
        assertEquals(exp1, res1);
        /*End: Teste 1*/
       
        /*Start:Teste 2*/
        // Objetivo: Testar se ele notifica erro ao abrir arquivo não existente
        ArquivoConsulta teste2 = null;
        Boolean deuerrado = false;
        try{
            teste2 = new ArquivoConsulta("testequenaoexiste.txt");
        } catch (FileNotFoundException ex) {
            deuerrado = true;
        }
        assertEquals(deuerrado, true);
        /*End: Teste 2*/
        
    }
    
    @Test
    public void testgetConsulta(){
         /*Start:Teste 1*/
        // Objetivo: Testar se as consultas estão sendo produzidas corretamente
        ArquivoConsulta teste2 = null;
        try{
            teste2 = new ArquivoConsulta("cons_1.sql");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
        Map<String, String> res2 = teste2.getAtributos();
        res2.put("matricula", "1");
        String resultado = teste2.getConsulta(res2);
        String esperado = "#Query que retorna dados para a geracao de um boletim do aluno com matricula=1\n" +
"Select a.nome AS 'Nome', \n" +
"ava.Nota1,ava.Nota2,ava.Nota3, \n" +
"ava.Disciplina, \n" +
"t.Serie, \n" +
"alut.Ano, \n" +
"t.N_Turma \n" +
"from \n" +
"Avaliacao ava INNER JOIN Aluno a ON a.Matricula=ava.Matricula \n" +
"INNER JOIN Aluno_Turma alut ON alut.Matricula=a.Matricula\n" +
"INNER JOIN Turma t ON t.ID_Turma=alut.ID_Turma\n" +
"WHERE ava.Matricula=1;";
        //assertEquals(resultado, esperado);
        System.out.print(QueryToJSON.valorQuery(res2, resultado, 1, "Nome"));
        /*End:Teste 1*/
    }
    
    public void testConsultaReal(){
    } 
    
}
