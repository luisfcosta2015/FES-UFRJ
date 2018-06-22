package report;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RelatorioGeneroTest {

    private RelatorioGenero relatorio;

    @Before
    public void setUp() throws Exception {
        relatorio = new RelatorioGenero("Escola 1", "Turma 1");
    }

    @Test
    public void createBarraSourceTest() {
        assertNotNull(relatorio.createBarraSource());
    }

    @Test
    public void createPizzaSourceTest() {
        assertNotNull(relatorio.createPizzaSource());
    }

    @Test
    public void buildBarraTest() {
        assertEquals(true, relatorio.buildBarra());
    }

    @Test
    public void buildPizzaTest() {
        assertEquals(true, relatorio.buildPizza());
    }
}
