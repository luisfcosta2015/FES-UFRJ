/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Cliente
 */
public class TelaCardapio extends javax.swing.JFrame {

    /**
     * Creates new form Cardapio
     */
    private boolean editando;
    Calendario calendario;
    Cardapio cardapio;
    CapaDados capa;
    TelaPrincipal principal;
    TelaItensRelatorio itensRel;
    int ano;
    int mes;
    DefaultTableModel tabelinha;
    ArrayList<Date>datasExcluidas;
    Relatorio relatorio;
    // Collection of items currently selected via checkboxes in the table 
    // This will be passed to the TableCell implementation.
    // ObservableSet<Object> selectedItems = FXCollections.observableSet();

    //mes de 0 a 11
    public TelaCardapio(int ano, int mes, CapaDados capa) {
        initComponents();
        this.capa = capa;
        this.ano = ano;
        this.mes = mes;
        DateFormat df = new SimpleDateFormat("dd/MM");
        
        tabelinha = (DefaultTableModel) tabela.getModel();
        
        calendario = new Calendario(mes,ano);
        ArrayList<Date> dias = calendario.getList();
        for(Date data : dias)
        {
            Object[] dado = {df.format(data)};
            tabelinha.addRow(dado);
        }
    }
    
    /**
     * Creates new form TelaEditaCardapio
     */
    public TelaCardapio(Relatorio relatorio) {
        initComponents();
        this.editando = true;
        this.relatorio = relatorio;
        this.cardapio = relatorio.getCardapioRelatorio();
        tabelinha = (DefaultTableModel) tabela.getModel();
        DateFormat df = new SimpleDateFormat("dd/MM");
        ArrayList<DuplaDataCardapio> cardapioList = cardapio.getList();
        for(DuplaDataCardapio dupla : cardapioList) {
            Object[] obj = new Object[2];
            obj[0] = df.format(dupla.data);
            if(dupla.cardapioDoDia != null ) {
                obj[1] = dupla.cardapioDoDia;
            }
            else {
                obj[1] = "";
            }
            tabelinha.addRow(obj);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        proxButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        linha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        excluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Cardapio"
            }
        ));
        tabela.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabelaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        proxButton.setText("Próximo");
        proxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("excluir elemento");

        jLabel4.setText("linha");

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(proxButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excluir)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(proxButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(linha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(excluir))))
                .addGap(0, 101, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 30)); // NOI18N
        jLabel1.setText("Cardápio");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("voltar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabelaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPropertyChange

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        /*principal=new TelaPrincipal();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        principal.setResizable(true);
        this.setVisible(false);*/
    }//GEN-LAST:event_jLabel2MouseClicked

    private void proxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxButtonActionPerformed
        // salva de alguma forma o que foi feito
        if(this.editando) {
            for(int i=0; i < this.tabelinha.getRowCount(); i++) {
                this.cardapio.setCardapio(i, ""+ this.tabelinha.getValueAt(i, 1));
            }   
            itensRel = new TelaItensRelatorio(this.relatorio);
            itensRel.setLocationRelativeTo(null);
            itensRel.setVisible(true);
            itensRel.setResizable(true);
            this.dispose();
            return;
        }
        cardapio = new Cardapio(calendario);
        for(int i=0; i < this.tabelinha.getRowCount(); i++) {
            if(this.tabelinha.getValueAt(i, 1) != null) {
                cardapio.setCardapio(i, this.tabelinha.getValueAt(i, 1).toString());
            }
        }
        itensRel = new TelaItensRelatorio("Relatorio " + (this.mes + 1) + "/" + this.ano, this.capa, this.cardapio);
        itensRel.setLocationRelativeTo(null);
        itensRel.setVisible(true);
        itensRel.setResizable(true);
        this.setVisible(false);
    }//GEN-LAST:event_proxButtonActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        if(this.editando) {
            try {
                if(!this.linha.getText().isEmpty()) {
                    int lin = Integer.parseInt(this.linha.getText());
                    if(lin < this.tabelinha.getRowCount()) {
                        DateFormat df = new SimpleDateFormat("dd/MM");
                        Date data = df.parse(this.tabelinha.getValueAt(lin, 0).toString());
                        this.cardapio.remove(data);
                        tabelinha.removeRow(lin);
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Linha precisa estar preenchida");
                    return;
                }
                System.out.println("linha em branco");
                return;
            }
            catch (ParseException e) {
                System.out.println(e);
                return;
            }
        }
        try {
            if(!this.linha.getText().isEmpty()) {
                int lin = Integer.parseInt(this.linha.getText());
                if(lin < this.tabelinha.getRowCount()) {
                    DateFormat df = new SimpleDateFormat("dd/MM");
                    Date data = df.parse(this.tabelinha.getValueAt(lin, 0).toString());
                    calendario.remove(data);
                    tabelinha.removeRow(lin);
                    return;
                }
                System.out.println("numero da linha invalido");
                return;
            }
            System.out.println("linha em branco");
            return;
        }
        catch (ParseException e) {
            System.out.println("erro no parse da data");
        }
    }//GEN-LAST:event_excluirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField linha;
    private javax.swing.JButton proxButton;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
