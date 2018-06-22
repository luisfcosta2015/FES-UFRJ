package report;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RelatorioIdadeTest {

    private RelatorioIdade relatorio;

    @Before
    public void setUp() throws Exception {
       relatorio = new RelatorioIdade("Escola 1", "Turma 1");
    }

    @Test
    public void createBarraSourceTest() {
        assertNotNull(relatorio.createBarraSource());
    }

    @Test
    public void createPizzSourceTest() {
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
