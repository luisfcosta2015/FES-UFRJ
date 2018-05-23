/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author joycinha
 */
public class TelaListaRelatorios extends javax.swing.JFrame {
    
    TelaEditaRelatorio editaRelatorio;
    Relatorio relatorioSelecionado;
    BdManager banco;
    /**
     * Creates new form TelaListaRelatorios
     */
    public TelaListaRelatorios() {
        initComponents();
        carregarLista();
        Cardapio cardapio = new Cardapio(new Calendario(5,2018));
        CapaDados capa = new CapaDados();
        int[] turnos;
        turnos = new int[] {10,20,30,40};
        capa.setVetorMatriculados(0, turnos, 20, 30);
        capa.setVetorMatriculados(1,new int[] {8,51,35,12},32,15);
        relatorioSelecionado = new Relatorio(cardapio, capa, "nome");
    }
    private void carregarLista()
    {
        
        //TEM QUE CONSERTAR AQUI PELO AMOR DE DEUS
        // TO CANSADO DEMAIS PRA ACHAR O ERRO
        
        /*System.out.println("oiiii");
        DefaultListModel modelo = (DefaultListModel) listaRelatorios.getModel();
        System.out.println("oiiii");
        ArrayList<Relatorio> relatorios=banco.getRelatoriosExistentes();
        System.out.println("oiiii");
        for(int i=0;i<relatorios.size();i++)
        {
            modelo.addElement(relatorios.get(i).getTitulo());
        }System.out.println("oiiii");*/
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRelatorios = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listaRelatorios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ITEM1", "ITEM2", "ITEM3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaRelatorios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.editaRelatorio = new TelaEditaRelatorio(this.relatorioSelecionado);
        this.editaRelatorio.setLocationRelativeTo(null);
        this.editaRelatorio.setVisible(true);
        this.editaRelatorio.setResizable(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaRelatorios;
    // End of variables declaration//GEN-END:variables
}
