/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Cardapio;
import Controller.Instituicao;
import Model.Auxiliar;
import Model.Sessao;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author w1n3
 */
public class CadastroCardapio extends javax.swing.JFrame {

    /**
     * Creates new form CadastroCardapio
     */
    public CadastroCardapio() {
        initComponents();
        
        // ***
        // Mostrar o nome da instituição ao cadastrar
        Instituicao I = new Instituicao();
        I.instituicaoPorId(Sessao.getInstance().getIdInstituicao());
        lblInsituicao.setText("Instituição : "+I.getNome());
        // ***
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        lblLancheDaManha = new javax.swing.JLabel();
        txtLancheDaManha = new javax.swing.JTextField();
        txtAlmoco = new javax.swing.JTextField();
        lblAlmoco = new javax.swing.JLabel();
        txtLancheDaTarde = new javax.swing.JTextField();
        txtJanta = new javax.swing.JTextField();
        lblJanta = new javax.swing.JLabel();
        lblLancheDaTarde = new javax.swing.JLabel();
        chkLancheDaManha = new javax.swing.JCheckBox();
        chkAlmoco = new javax.swing.JCheckBox();
        chkLancheDaTarde = new javax.swing.JCheckBox();
        chkJanta = new javax.swing.JCheckBox();
        lblInsituicao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mItemPrincipal = new javax.swing.JMenuItem();
        mItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Data");

        lblLancheDaManha.setText("Lanche da Manhã");

        lblAlmoco.setText("Almoço");

        lblJanta.setText("Janta");

        lblLancheDaTarde.setText("Lanche da Tarde");

        chkLancheDaManha.setText("Não há");
        chkLancheDaManha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLancheDaManhaActionPerformed(evt);
            }
        });

        chkAlmoco.setText("Não há");
        chkAlmoco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAlmocoActionPerformed(evt);
            }
        });

        chkLancheDaTarde.setText("Não há");
        chkLancheDaTarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLancheDaTardeActionPerformed(evt);
            }
        });

        chkJanta.setText("Não há");
        chkJanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkJantaActionPerformed(evt);
            }
        });

        lblInsituicao.setText("Instituição : ?");

        jMenu1.setText("Arquivo");

        mItemPrincipal.setText("Menu Principal");
        mItemPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemPrincipalActionPerformed(evt);
            }
        });
        jMenu1.add(mItemPrincipal);

        mItemSair.setText("Sair");
        mItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(mItemSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblJanta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLancheDaManha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlmoco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlmoco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLancheDaTarde, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJanta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLancheDaTarde, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInsituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkLancheDaManha)
                            .addComponent(chkAlmoco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkLancheDaTarde)
                            .addComponent(chkJanta, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLancheDaManha)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInsituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(lblLancheDaManha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLancheDaManha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkLancheDaManha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlmoco)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAlmoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkAlmoco)))
                .addComponent(lblLancheDaTarde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLancheDaTarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkLancheDaTarde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblJanta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtJanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkJanta))
                .addGap(31, 31, 31)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSairActionPerformed
        if (Model.Auxiliar.confirmarSaida()) System.exit(0);
    }//GEN-LAST:event_mItemSairActionPerformed

    private void mItemPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemPrincipalActionPerformed
        this.setVisible(false);
        Auxiliar.trocarTela(new PrincipalDir());
    }//GEN-LAST:event_mItemPrincipalActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Cardapio c = new Cardapio();
        String erros = "";
        
        Date d = datePicker.getDate();
        if (d == null){
            erros += "Data inválida\n";
        } else {
            Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            c.setData_cardapio(formatter.format(d));
        }
        
        if (!chkLancheDaManha.isSelected() && txtLancheDaManha.getText().equals("")){
            erros += "Lanche da manhã inválido\n";           
        } else {
            c.setLanche_manha(txtLancheDaManha.getText());
        }
        if (!chkAlmoco.isSelected() && txtAlmoco.getText().equals("")){
            erros += "Almoço inválido\n";           
        } else {
            c.setAlmoco(txtAlmoco.getText());
        }
        if (!chkLancheDaTarde.isSelected() && txtLancheDaTarde.getText().equals("")){
            erros += "Lanche da tarde inválido\n";           
        } else {
            c.setLanche_tarde(txtLancheDaTarde.getText());
        }
        if (!chkJanta.isSelected() && txtJanta.getText().equals("")){
            erros += "Janta inválida\n";           
        } else {
            c.setJanta(txtJanta.getText());
        }
        
        Instituicao i = new Instituicao();
        i.instituicaoPorId(Sessao.getInstance().getIdPessoa());
        
        if (i.instituicaoPorId(Sessao.getInstance().getIdPessoa()) == false){
            erros += "Usuário não é diretor de nenhuma instituição ou de mais de uma\n";
        } else {
            c.setId_instituicao(Sessao.getInstance().getIdPessoa());
        }
        
        if (!erros.equals("")){
            //mensagem de erro
            JOptionPane.showMessageDialog(this, erros, "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (c.cadastrar()){
            JOptionPane.showMessageDialog(this, "Cadastro efetuado com sucesso");
        } else {
            JOptionPane.showMessageDialog(this, "Erro no BD", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void chkLancheDaManhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLancheDaManhaActionPerformed
        txtLancheDaManha.setEnabled(!chkLancheDaManha.isSelected());
        txtLancheDaManha.setText("");
    }//GEN-LAST:event_chkLancheDaManhaActionPerformed

    private void chkAlmocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAlmocoActionPerformed
        txtAlmoco.setEnabled(!chkAlmoco.isSelected());
        txtAlmoco.setText("");
    }//GEN-LAST:event_chkAlmocoActionPerformed

    private void chkLancheDaTardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLancheDaTardeActionPerformed
        txtLancheDaTarde.setEnabled(!chkLancheDaTarde.isSelected());
        txtLancheDaTarde.setText("");
    }//GEN-LAST:event_chkLancheDaTardeActionPerformed

    private void chkJantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkJantaActionPerformed
        txtJanta.setEnabled(!chkJanta.isSelected());
        txtJanta.setText("");
    }//GEN-LAST:event_chkJantaActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCardapio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JCheckBox chkAlmoco;
    private javax.swing.JCheckBox chkJanta;
    private javax.swing.JCheckBox chkLancheDaManha;
    private javax.swing.JCheckBox chkLancheDaTarde;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblAlmoco;
    private javax.swing.JLabel lblInsituicao;
    private javax.swing.JLabel lblJanta;
    private javax.swing.JLabel lblLancheDaManha;
    private javax.swing.JLabel lblLancheDaTarde;
    private javax.swing.JMenuItem mItemPrincipal;
    private javax.swing.JMenuItem mItemSair;
    private javax.swing.JTextField txtAlmoco;
    private javax.swing.JTextField txtJanta;
    private javax.swing.JTextField txtLancheDaManha;
    private javax.swing.JTextField txtLancheDaTarde;
    // End of variables declaration//GEN-END:variables
}
