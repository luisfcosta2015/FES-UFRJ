/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractAction;

/**
 *
 * @author joycinha
 */
public class BotaoExcluir extends AbstractAction {
    public DefaultTableModel tabela1;
    public DefaultTableModel tabela2;
    public DefaultTableModel tabela3;
    public int linha;
    
    public BotaoExcluir(DefaultTableModel tabela1, DefaultTableModel tabela2, DefaultTableModel tabela3, int linha) {
        super("Excluir");
        this.tabela1 = tabela1;
        this.tabela2 = tabela2;
        this.tabela3 = tabela3;
        this.linha = linha;
    }
    public void excluirLinha() {
        this.tabela1.removeRow(this.linha);
        this.tabela2.removeRow(this.linha);
        this.tabela3.removeRow(this.linha);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        excluirLinha();
    }
}
