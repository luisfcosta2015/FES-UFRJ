/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiago
 */
public class MysqlConTest {
    
    public MysqlConTest() {
    }

    @Test
    public void testConectar() {
        Connection naoConectado = null;
        MysqlCon teste = new MysqlCon();
        
        teste.Conectar();
        Connection con = teste.con;
        
        try {
            /* Se a Connection é null ou não é válida, então houve um erro de conexão */
            assertFalse(con == naoConectado || !con.isValid(0));
        } catch(SQLException e) {
            System.out.println(e);
            assertTrue(false);
        }
        
        teste.Desconectar();
    }

    @Test
    public void testDesconectar() {
        Connection desconectado = null;
        MysqlCon teste = new MysqlCon();
        teste.Conectar();
        Connection con = teste.con;
        
        teste.Desconectar();
        
        try {
            /* Verifica se a Connection foi fechada */
            assertTrue(con.isClosed());
        } catch(SQLException e) {
            System.out.println(e);
            assertTrue(false);
        }
    }

    @Test
    public void testQuery() {
        ResultSet rs;
        MysqlCon teste = new MysqlCon();
        teste.Conectar();
        
        try {
            rs = teste.query("select * from aluno where nome = 'Arnaldo Pereira'");
            /* Avança para o primeiro elemento do ResultSet */
            /* Indicará erro se o ResultSet for vazio (Sabendo que Arnaldo Pereira está no BD) */
            assertTrue(rs.next());
            String strTeste1 = "Arnaldo Pereira";
            String strTeste2 = rs.getString("Nome");
            /* Verifica se o resultado condiz com o esperado */
            assertEquals(strTeste1, strTeste2);
            
            rs = teste.query("select nome,disciplina from professor where codigo = 47");
            assertTrue(rs.next());
            /* Verifica se o resultado do nome está condizente com os dados reais do banco */
            strTeste1 = "Raquel Silva";
            strTeste2 = rs.getString("Nome");
            assertEquals(strTeste1, strTeste2);
            /* Verifica se a disciplina está condizente */
            strTeste1 = "Inglês II";
            strTeste2 = rs.getString("Disciplina");
            assertEquals(strTeste1, strTeste2);
            /* Testa uma disciplina que a professora em questão não dá */
            strTeste1 = "Matemática III";
            assertFalse(strTeste1.equals(strTeste2));
            
            /* Teste com aluno não presente no banco */
            rs = teste.query("select * from aluno where nome = 'Ninguém tem esse nome aqui'");
            /* Verifica se o ResultSet com o nome inválido estará vazio */
            assertFalse(rs.next());
        } catch(SQLException e) {
            System.out.println(e);
            assertTrue(false);
        }
        
        teste.Desconectar();
    }
    
}
