/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

/**
 *
 * @author joycinha
 */
public class ItensRelatorio extends javax.swing.JFrame {
    
    String usuario;
    Principal principal;
    /**
     * Creates new form ItensRelatorio
     */
    public ItensRelatorio(String nome) {
        /*usuario = nome;
        initComponents();*/
    }
    
    private void criaLista() {
       this.itens.removeAll();
        this.itens.addItem(usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itens = new javax.swing.JComboBox<>();
        voltarAoMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        criaLista();
        itens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "banana", "maçã", "Item 3", "Item 4" }));
        itens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itensActionPerformed(evt);
            }
        });

        voltarAoMenu.setText("Fim");
        voltarAoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarAoMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(itens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarAoMenu)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(itens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(voltarAoMenu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itensActionPerformed

    private void voltarAoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarAoMenuActionPerformed
        // TODO add your handling code here:
        principal=new Principal(usuario);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        principal.setResizable(true);
        this.setVisible(false);
    }//GEN-LAST:event_voltarAoMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> itens;
    private javax.swing.JButton voltarAoMenu;
    // End of variables declaration//GEN-END:variables
}
