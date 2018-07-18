/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merenda_escolar;

import SQLConnect.ConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

/**
 *
 * @author joaof
 */
public class TelaAlimento extends javax.swing.JFrame {
    
    Connection getConnection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaAlimento
     */
    public TelaAlimento() {
        initComponents();
        getConnection = ConnectionClass.conector();
    }
    
    private void adicionar() {
        String sql = "insert into alimento(Descricao,Genero,Qtde) values(?,?,?)";
        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, txtDescr.getText());
            pst.setString(2, txtGen.getText());
            pst.setString(3, txtQtde.getText());

            //validação dos campos obrigatórios
            if ((txtDescr.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                //a linha abaixo atualiza a tabela usuario com os dados do formulário
                //a etrutura abaixo é usada para confirmar a inserção dos dados na tabela
                int adicionado = pst.executeUpdate();
                //a linha abaixo serve de apoio ao entendimento da lógica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Alimento adicionado com sucesso");
                    txtDescr.setText(null);
                    txtGen.setText(null);
                    txtQtde.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //método para pesquisar clientes pelo nome com filtro
    private void pesquisar_alimento() {
        String sql = "select * from alimento where Descricao like ?";
        try {
            pst = getConnection.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1, txtPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblAlimento.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método para setar os campos do formulário com o conteúdo da tabela
    public void setar_campos() {
        int setar = tblAlimento.getSelectedRow();
        txtIdAli.setText(tblAlimento.getModel().getValueAt(setar, 0).toString());
        txtDescr.setText(tblAlimento.getModel().getValueAt(setar, 1).toString());
        txtGen.setText(tblAlimento.getModel().getValueAt(setar, 2).toString());
        txtQtde.setText(tblAlimento.getModel().getValueAt(setar, 3).toString());
 
        //a linha abaixo desabilita o botão adicionar
        //btnAdd.setEnabled(false);
    }

    // método para alterar dados do cliente
    private void editar() {
        String sql = "update alimento set Descricao=?,Genero=?,Qtde=? where Id_Alimento=?";
        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, txtDescr.getText());
            pst.setString(2, txtGen.getText());
            pst.setString(3, txtQtde.getText());
            pst.setString(4, txtIdAli.getText());

            if ((txtDescr.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                //a linha abaixo atualiza a tabela cliente com os dados do formulário
                //a etrutura abaixo é usada para confirmar a alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                //a linha abaixo serve de apoio ao entendimento da lógica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do alimento alterados com sucesso");
                    txtDescr.setText(null);
                    txtGen.setText(null);
                    txtQtde.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método responsável pela remoção de clientes

    private void excluir() {
        //a estrutura abaixo confirma a remoção do cliente
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este alimento ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from alimento where Id_Alimento=?";
            try {
                pst = getConnection.prepareStatement(sql);
                pst.setString(1, txtIdAli.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Alimento Removido com sucesso");
                    txtDescr.setText(null);
                    txtGen.setText(null);
                    txtQtde.setText(null);
                    btnAdd.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescr = new javax.swing.JTextField();
        txtGen = new javax.swing.JTextField();
        txtQtde = new javax.swing.JTextField();
        BtnEditar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlimento = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtIdAli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alimento");
        setResizable(false);

        jLabel1.setText("*Descrição");

        jLabel2.setText("Gênero");

        jLabel3.setText("Quantidade");

        txtDescr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescrActionPerformed(evt);
            }
        });

        BtnEditar.setText("Editar");
        BtnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnExcluir.setText("Excluir");
        BtnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        btnAdd.setText("Adicionar");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Todos os campos com asterisco(*) são obrigatórios");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        tblAlimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAlimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlimentoMouseClicked(evt);
            }
        });
        tblAlimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAlimentoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlimento);

        jLabel4.setText("Id Alimento");

        txtIdAli.setEnabled(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/merenda_escolar/imagepackage/search.png"))); // NOI18N

        jLabel7.setText("Pesquisar por descrição");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDescr, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                                            .addComponent(txtGen))
                                        .addComponent(txtIdAli, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnEditar, BtnExcluir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdAli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(385, 385, 385))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnEditar, BtnExcluir, btnAdd});

        setSize(new java.awt.Dimension(501, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescrActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblAlimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlimentoKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tblAlimentoKeyReleased

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar_alimento();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tblAlimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlimentoMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblAlimentoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlimento;
    private javax.swing.JTextField txtDescr;
    private javax.swing.JTextField txtGen;
    private javax.swing.JTextField txtIdAli;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtQtde;
    // End of variables declaration//GEN-END:variables
}
