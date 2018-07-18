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

//import net.proteanit.sql.DbUtils;
/**
 *
 * @author joaof
 */
public class TelaRefeicoes extends javax.swing.JFrame {

    Connection getConnection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaRefeicoes
     */
    public TelaRefeicoes() {
        initComponents();
        getConnection = ConnectionClass.conector();
    }

    private void adicionar() {
        String sql = "insert into refeicoes(Desjejum,Almoco,Sobremesa,Mais,data) values(?,?,?,?,?)";
        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, txtDesjejum.getText());
            pst.setString(2, txtAlmoco.getText());
            pst.setString(3, txtSobr.getText());
            pst.setString(4, txtMais.getText());
            
            //lendo a data
            String dia = tfData.getText().substring(0, 2);
            String mes = tfData.getText().substring(3, 5);
            String ano = tfData.getText().substring(6);
            String data = ano+"-"+mes+"-"+dia;
            pst.setString(5, data);
            

            //a linha abaixo atualiza a tabela usuario com os dados do formulário
            //a etrutura abaixo é usada para confirmar a inserção dos dados na tabela
            int adicionado = pst.executeUpdate();
            //a linha abaixo serve de apoio ao entendimento da lógica
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Refeição adicionado com sucesso");
                txtDesjejum.setText(null);
                txtAlmoco.setText(null);
                txtSobr.setText(null);
                txtMais.setText(null);
                tfData.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método para alterar dados do cliente
    private void editar() {
        String sql = "update refeicoes set data=?,Desjejum=?,Almoco=?,Sobremesa=?,Mais=? where Id_Refeicoes=?";
        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, tfData.getText());
            pst.setString(2, txtDesjejum.getText());
            pst.setString(3, txtAlmoco.getText());
            pst.setString(4, txtSobr.getText());
            pst.setString(5, txtMais.getText());           
            pst.setString(6, txtIdRef.getText());
            

            //a linha abaixo atualiza a tabela cliente com os dados do formulário
            //a etrutura abaixo é usada para confirmar a alteração dos dados na tabela
            int adicionado = pst.executeUpdate();
            //a linha abaixo serve de apoio ao entendimento da lógica
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados da Refeição alterados com sucesso");
                txtDesjejum.setText(null);
                txtAlmoco.setText(null);
                txtSobr.setText(null);
                txtMais.setText(null);
                tfData.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método responsável pela remoção de clientes
    private void excluir() {
        //a estrutura abaixo confirma a remoção do cliente
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta refeição ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from refeicoes where Id_Refeicoes=?";
            try {
                pst = getConnection.prepareStatement(sql);
                pst.setString(1, txtIdRef.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Refeição Removida com sucesso");
                    txtDesjejum.setText(null);
                    txtAlmoco.setText(null);
                    txtSobr.setText(null);
                    txtMais.setText(null);
                    //btnAdd.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }
    
    private void pesquisar_refeicao() {
        String sql = "select * from refeicoes where data like ?";
        try {
            pst = getConnection.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1, tfPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblCardapio.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setar_campos() {
        int setar = tblCardapio.getSelectedRow();
        txtIdRef.setText(tblCardapio.getModel().getValueAt(setar, 0).toString());
        tfData.setText(tblCardapio.getModel().getValueAt(setar, 1).toString());
        txtDesjejum.setText(tblCardapio.getModel().getValueAt(setar, 2).toString());
        txtAlmoco.setText(tblCardapio.getModel().getValueAt(setar, 3).toString());
        txtSobr.setText(tblCardapio.getModel().getValueAt(setar, 4).toString());
        txtMais.setText(tblCardapio.getModel().getValueAt(setar, 5).toString());
 
        //a linha abaixo desabilita o botão adicionar
        //btnAdd.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnEditar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDesjejum = new javax.swing.JTextField();
        txtIdRef = new javax.swing.JTextField();
        txtAlmoco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSobr = new javax.swing.JTextField();
        txtMais = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfData = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCardapio = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfPesquisar = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Refeições");
        setResizable(false);

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

        jLabel3.setText("Sobremesa");

        jLabel1.setText("Desjejum");

        txtDesjejum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesjejumActionPerformed(evt);
            }
        });

        txtIdRef.setEnabled(false);

        jLabel2.setText("Almoço");

        jLabel7.setText("Mais");

        jLabel5.setText("Data");

        tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        tblCardapio.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCardapioMouseClicked(evt);
            }
        });
        tblCardapio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCardapioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCardapio);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/merenda_escolar/imagepackage/search.png"))); // NOI18N

        jLabel8.setText("Pesquisar por data");

        tfPesquisar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDesjejum, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMais, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSobr, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(270, 270, 270)
                        .addComponent(txtIdRef, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(635, 635, 635))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(txtDesjejum, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtSobr, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtMais, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(254, 254, 254))
        );

        setSize(new java.awt.Dimension(538, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtDesjejumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesjejumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesjejumActionPerformed

    private void tblCardapioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCardapioMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblCardapioMouseClicked

    private void tblCardapioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCardapioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCardapioKeyReleased

    private void tfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar_refeicao();
    }//GEN-LAST:event_tfPesquisarKeyReleased

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
            java.util.logging.Logger.getLogger(TelaRefeicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRefeicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRefeicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRefeicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRefeicoes().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCardapio;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JFormattedTextField tfPesquisar;
    private javax.swing.JTextField txtAlmoco;
    private javax.swing.JTextField txtDesjejum;
    private javax.swing.JTextField txtIdRef;
    private javax.swing.JTextField txtMais;
    private javax.swing.JTextField txtSobr;
    // End of variables declaration//GEN-END:variables
}
