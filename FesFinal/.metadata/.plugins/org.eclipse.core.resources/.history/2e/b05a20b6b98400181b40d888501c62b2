package br.com.fes.relatorios.Teste;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fes.relatorios.dao.DadosDAO;
import br.com.fes.relatorios.domain.Dados;

public class DadosDAOTest {
	DadosDAO D;
	@Before
	public void setUp() throws Exception {
		D = new DadosDAO();
	}

	@Test
	public void testConsultar() {
		Dados dados = null;
		try {
			Assert.assertEquals("SELECT matricula,nome,situacao FROM alunos", D.consultar(dados));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
