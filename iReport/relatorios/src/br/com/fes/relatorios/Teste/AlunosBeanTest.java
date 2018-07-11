package br.com.fes.relatorios.Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.fes.relatorios.bean.AlunosBean;
import br.com.fes.relatorios.domain.Dados;
import junit.framework.Assert;

public class AlunosBeanTest {
	AlunosBean A;
	@Before
	public void setUp() throws Exception {
		A = new AlunosBean();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSetDadosRegistro() {
		Dados dadosRegistro = null;
		Assert.assertEquals(1, A.setDadosRegistro(dadosRegistro));
	}

	@Test
	public void testConsultar() {
		Assert.assertEquals(2, A.consultar());
	}

}
