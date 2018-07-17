/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucca
 */
public class QueryToJSONTest {
    
    public QueryToJSONTest() {
    }

    @Test
    public void testValorQuery() {
        Map<String, String> m = new HashMap<String, String>();
        String s = "Select a.nome AS 'Nome', \n" +
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
        System.out.print(QueryToJSON.valorQuery(m ,s , 1, "Nota2"));
        System.out.print(QueryToJSON.valorQuery(m ,s , 2, "Nota2"));
        System.out.print(QueryToJSON.valorQuery(m ,s , 3, "Nota2"));
        System.out.print(QueryToJSON.valorQuery(m ,s , 4, "Nota2"));
        System.out.print(QueryToJSON.valorQuery(m ,s , 5, "Nota2"));
        System.out.print(QueryToJSON.valorQuery(m ,s , 6, "Nota2"));
    }

    @Test
    public void testRetornaQuery() {
    }
    
}
