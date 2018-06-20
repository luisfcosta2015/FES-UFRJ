package report;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BarraTest {

    BarraIdade barra;

    @Before
    public void setUp() throws Exception {
       barra = new BarraIdade();
    }

    @Test
    public void createDataSourceTest() {
        assertNotNull(barra.createDataSource("Turma 1"));
    }
}
