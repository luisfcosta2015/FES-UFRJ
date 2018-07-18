package report;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TelaAlimentoTest {

    private TelaAlimento alimento;

    @Before
    public void setUp() throws Exception {
        alimento = new TelaAlimento("Batata");
    }

    @Test
    public void adicionarTest() {
        assertNotNull(alimento.adicionar());
    }

    @Test
    public void editarTest() {
        assertNotNull(alimento.editar("Batata Baroa"));
    }

    @Test
    public void excluirTest() {
        assertEquals(true, alimento.excluir());
    }

    @Test
    public void pesquisar_alimentoTest() {
        assertEquals(true, alimento.pesquisar_alimento());
    }

    @Test
    public void setar_camposTest() {
        assertEquals(true, alimento.setar_campos("Nome"));
    }
}


