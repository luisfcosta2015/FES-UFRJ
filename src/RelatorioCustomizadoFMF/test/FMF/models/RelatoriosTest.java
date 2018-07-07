/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiag
 */
public class RelatoriosTest {
    
    public RelatoriosTest() {
    }

    @Test
    public void testGetModelos() {
        Relatorios rel = new Relatorios();
        List<Modelo> lista = rel.getModelos();
        boolean contem = false;
        
        /* Teste de modelo que deve estar na lista */
        for(Modelo mod: lista) {
            if("Boletim".equals(mod.getNome())) contem = true;
        }
        assertTrue(contem);
        
        /* Teste de modelo que não deve estar na lista */
        contem = false;
        for(Modelo mod: lista) {
            if("Certidão de Nascimento".equals(mod.getNome())) contem = true;
        }
        assertFalse(contem);
    }

    @Test
    public void testAddModelo() {
        /* TODO */
    }
    
}
