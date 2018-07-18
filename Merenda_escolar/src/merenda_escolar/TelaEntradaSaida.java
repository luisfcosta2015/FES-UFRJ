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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.StyleConstants.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;

/**
 *
 * @author joaof
 */
public class TelaEntradaSaida extends javax.swing.JFrame {

    Connection getConnection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaEntradaSaida
     */
    public TelaEntradaSaida() {
        initComponents();
        getConnection = ConnectionClass.conector();
        pnlTeste.setVisible(false);
    }

    private void pesquisar_alimento() {
        String sql = "select Id_Alimento, Descricao, Qtde from alimento where Descricao like ?";
        try {
            pst = getConnection.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1, txtPesquisarAlimento.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblAlimento.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método para setar os campos do formulário com o conteúdo da tabela
    public void setar_camposAlimento() {
        int setar = tblAlimento.getSelectedRow();
        txtIdAlimento.setText(tblAlimento.getModel().getValueAt(setar, 0).toString());
        txtDescrAli.setText(tblAlimento.getModel().getValueAt(setar, 1).toString());

    }

    private void pesquisar_escola() {
        String sql = "select Id_Escola, nome from escola where Nome like ?";
        try {
            pst = getConnection.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1, txtPesquisarEscola.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblEscola.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método para setar os campos do formulário com o conteúdo da tabela
    public void setar_campos_escola() {
        int setar = tblEscola.getSelectedRow();
        txtIdEscola.setText(tblEscola.getModel().getValueAt(setar, 0).toString());
        txtEscola.setText(tblEscola.getModel().getValueAt(setar, 1).toString());

    }

    private ResultSet adicionar() {
        String sql = "insert into Entrada_Saida(Id_Escola,Id_Alimento,Data,estoque_inicial,Entrada,Saida,entrada2,saida2,entrada3,saida3,entrada4,saida4,entrada5,saida5,recebido,cedido,atasaida) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, txtIdEscola.getText());
            pst.setString(2, txtIdAlimento.getText());
            String dia = tfData.getText().substring(0, 2);
            String mes = tfData.getText().substring(3, 5);
            String ano = tfData.getText().substring(6);
            String data = ano + "-" + mes + "-" + dia;
            pst.setString(3, data);
            pst.setString(4, txtEstInicial.getText());
            pst.setString(5, txtEntrada1.getText());
            pst.setString(6, txtSaida1.getText());
            pst.setString(7, txtEntrada2.getText());
            pst.setString(8, txtSaida2.getText());
            pst.setString(9, txtEntrada3.getText());
            pst.setString(10, txtSaida3.getText());
            pst.setString(11, txtEntrada4.getText());
            pst.setString(12, txtSaida4.getText());
            pst.setString(13, txtEntrada5.getText());
            pst.setString(14, txtSaida5.getText());
            pst.setString(15, txtRecebido.getText());
            pst.setString(16, txtCedido.getText());
            pst.setString(17, txtATASaida.getText());

            //a linha abaixo atualiza a tabela usuario com os dados do formulário
            //a etrutura abaixo é usada para confirmar a inserção dos dados na tabela
            int adicionado = pst.executeUpdate();
            //a linha abaixo serve de apoio ao entendimento da lógica
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso");
                String sql2 = "select E.Nome, A.Descricao, A.Qtde, ES.*  from Entrada_Saida ES inner join Alimento A on ES.Id_Alimento = A.Id_Alimento inner join Escola E on ES.Id_Escola = E.Id_Escola";
                pst = getConnection.prepareStatement(sql2);
                rs = pst.executeQuery();
                tblEntSaida.setModel(DbUtils.resultSetToTableModel(rs));
                tfData.setText(null);
                txtEstInicial.setText(null);
                txtEntrada1.setText(null);
                txtSaida1.setText(null);
                txtEntrada2.setText(null);
                txtSaida2.setText(null);
                txtEntrada3.setText(null);
                txtSaida3.setText(null);
                txtEntrada4.setText(null);
                txtSaida4.setText(null);
                txtEntrada5.setText(null);
                txtSaida5.setText(null);
                txtRecebido.setText(null);
                txtCedido.setText(null);
                txtATASaida.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }

    public void setar_campos() {
        int setar = tblEntSaida.getSelectedRow();
        txtIdEntSai.setText(tblEntSaida.getModel().getValueAt(setar, 3).toString());
        txtIdEscola.setText(tblEntSaida.getModel().getValueAt(setar, 4).toString());
        txtIdAlimento.setText(tblEntSaida.getModel().getValueAt(setar, 5).toString());
        tfData.setText(tblEntSaida.getModel().getValueAt(setar, 6).toString());
        txtEstInicial.setText(tblEntSaida.getModel().getValueAt(setar, 7).toString());
        txtEntrada1.setText(tblEntSaida.getModel().getValueAt(setar, 8).toString());
        txtSaida1.setText(tblEntSaida.getModel().getValueAt(setar, 9).toString());
        txtEntrada2.setText(tblEntSaida.getModel().getValueAt(setar, 10).toString());
        txtSaida2.setText(tblEntSaida.getModel().getValueAt(setar, 11).toString());
        txtEntrada3.setText(tblEntSaida.getModel().getValueAt(setar, 12).toString());
        txtSaida3.setText(tblEntSaida.getModel().getValueAt(setar, 13).toString());
        txtEntrada4.setText(tblEntSaida.getModel().getValueAt(setar, 14).toString());
        txtSaida4.setText(tblEntSaida.getModel().getValueAt(setar, 15).toString());
        txtEntrada5.setText(tblEntSaida.getModel().getValueAt(setar, 16).toString());
        txtSaida5.setText(tblEntSaida.getModel().getValueAt(setar, 17).toString());
        txtRecebido.setText(tblEntSaida.getModel().getValueAt(setar, 18).toString());
        txtCedido.setText(tblEntSaida.getModel().getValueAt(setar, 19).toString());
        txtATASaida.setText(tblEntSaida.getModel().getValueAt(setar, 20).toString());
    }

    //POSSO ARRUMAR O EDITAR E O EXCUIR CRIANDO A CHAVE PRIMÁRIA ID_ENTRADA_SAIDA LÁ NO BANCO,
    //VOU FAZER ISSO DEPOIS
    private void editar() {
        String sql = "update Entrada_Saida set Data=?,estoque_inicial=?,Entrada=?,Saida=?,entrada2=?,saida2=?,entrada3=?,saida3=?,entrada4=?,saida4=?,entrada5=?,saida5=?,recebido=?,cedido=?,atasaida=? where Id_Ent_Sai=?";
        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, tfData.getText());
            pst.setString(2, txtEstInicial.getText());
            pst.setString(3, txtEntrada1.getText());
            pst.setString(4, txtSaida1.getText());
            pst.setString(5, txtEntrada2.getText());
            pst.setString(6, txtSaida2.getText());
            pst.setString(7, txtEntrada3.getText());
            pst.setString(8, txtSaida3.getText());
            pst.setString(9, txtEntrada4.getText());
            pst.setString(10, txtSaida4.getText());
            pst.setString(11, txtEntrada5.getText());
            pst.setString(12, txtSaida5.getText());
            pst.setString(13, txtRecebido.getText());
            pst.setString(14, txtCedido.getText());
            pst.setString(15, txtATASaida.getText());
            pst.setString(16, txtIdEntSai.getText());
            //a linha abaixo atualiza a tabela cliente com os dados do formulário
            //a etrutura abaixo é usada para confirmar a alteração dos dados na tabela
            int adicionado = pst.executeUpdate();
            //a linha abaixo serve de apoio ao entendimento da lógica
            System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                tfData.setText(null);
                txtEstInicial.setText(null);
                txtEntrada1.setText(null);
                txtSaida1.setText(null);
                txtEntrada2.setText(null);
                txtSaida2.setText(null);
                txtEntrada3.setText(null);
                txtSaida3.setText(null);
                txtEntrada4.setText(null);
                txtSaida4.setText(null);
                txtEntrada5.setText(null);
                txtSaida5.setText(null);
                txtRecebido.setText(null);
                txtCedido.setText(null);
                txtATASaida.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void excluir() {
        //a estrutura abaixo confirma a remoção do cliente
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover estes dados ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from Entrada_Saida where Id_Ent_Sai=?";
            try {
                pst = getConnection.prepareStatement(sql);
                //id_entrada_saida
                pst.setString(1, txtIdEntSai.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados Removidos com sucesso");
                    tfData.setText(null);
                    txtEstInicial.setText(null);
                    txtEntrada1.setText(null);
                    txtSaida1.setText(null);
                    txtEntrada2.setText(null);
                    txtSaida2.setText(null);
                    txtEntrada3.setText(null);
                    txtSaida3.setText(null);
                    txtEntrada4.setText(null);
                    txtSaida4.setText(null);
                    txtEntrada5.setText(null);
                    txtSaida5.setText(null);
                    txtRecebido.setText(null);
                    txtCedido.setText(null);
                    txtATASaida.setText(null);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlimento = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPesquisarAlimento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPesquisarEscola = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEscola = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIdAlimento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdEscola = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEntrada1 = new javax.swing.JTextField();
        txtSaida1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEntrada2 = new javax.swing.JTextField();
        txtSaida2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEntrada3 = new javax.swing.JTextField();
        txtSaida3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEntrada4 = new javax.swing.JTextField();
        txtSaida4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEntrada5 = new javax.swing.JTextField();
        txtSaida5 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtRecebido = new javax.swing.JTextField();
        txtCedido = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtATASaida = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtEstInicial = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEntSaida = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        tfData = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtIdEntSai = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        txtGerarPDF = new javax.swing.JButton();
        pnlTeste = new javax.swing.JPanel();
        txtEscola = new javax.swing.JTextField();
        txtDescrAli = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada, Saída e Remanejamento");
        setResizable(false);

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

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/merenda_escolar/imagepackage/search.png"))); // NOI18N

        jLabel7.setText("Alimento");

        txtPesquisarAlimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarAlimentoKeyReleased(evt);
            }
        });

        jLabel8.setText("Escola");

        txtPesquisarEscola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarEscolaKeyReleased(evt);
            }
        });

        tblEscola.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEscola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEscolaMouseClicked(evt);
            }
        });
        tblEscola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblEscolaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblEscola);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/merenda_escolar/imagepackage/search.png"))); // NOI18N

        jLabel1.setText("Id Alimento");

        txtIdAlimento.setEnabled(false);

        jLabel2.setText("Id Escola");

        txtIdEscola.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("1ª Semana");

        jLabel4.setText("Entrada");

        jLabel5.setText("Saída");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("2ª Semana");

        jLabel11.setText("Entrada");

        jLabel12.setText("Saída");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("3ª Semana");

        jLabel14.setText("Entrada");

        jLabel15.setText("Saída");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("4ª Semana");

        jLabel17.setText("Entrada");

        jLabel18.setText("Saída");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("5ª Semana");

        jLabel20.setText("Entrada");

        jLabel21.setText("Saída");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaida1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEntrada2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaida2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEntrada3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaida3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEntrada4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaida4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEntrada5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaida5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel19)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntrada5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaida5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntrada4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaida4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntrada3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaida3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntrada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaida2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSaida1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Remanejamento");

        jLabel23.setText("Recebido");

        jLabel24.setText("Cedido");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("ATA");

        jLabel26.setText("Saída");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24))
                        .addComponent(jLabel22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtCedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtATASaida, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtATASaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel27.setText("Estoque");

        tblEntSaida.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEntSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEntSaidaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEntSaida);

        btnAdd.setText("Adicionar");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
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

        tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel28.setText("Data");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Inicial");

        jLabel30.setText("Id");

        txtIdEntSai.setEditable(false);

        btnConsultar.setText("Consultar");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        txtGerarPDF.setText("Gerar PDF");
        txtGerarPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTesteLayout = new javax.swing.GroupLayout(pnlTeste);
        pnlTeste.setLayout(pnlTesteLayout);
        pnlTesteLayout.setHorizontalGroup(
            pnlTesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTesteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescrAli, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        pnlTesteLayout.setVerticalGroup(
            pnlTesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTesteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTesteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescrAli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtEstInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel29))
                                            .addComponent(jLabel27)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(82, 82, 82)
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(77, 77, 77)
                                            .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(88, 88, 88)
                                            .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(113, 113, 113))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel28)
                                            .addGap(26, 26, 26)
                                            .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(39, 39, 39)
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtIdAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(21, 21, 21)
                                            .addComponent(jLabel2))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPesquisarAlimento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtPesquisarEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtIdEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(jLabel30)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtIdEntSai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(15, 15, 15)
                                            .addComponent(pnlTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(txtGerarPDF)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPesquisarAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtPesquisarEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtIdAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtIdEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30)
                                .addComponent(txtIdEntSai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(952, 666));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblAlimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlimentoMouseClicked
        // TODO add your handling code here:
        setar_camposAlimento();
    }//GEN-LAST:event_tblAlimentoMouseClicked

    private void tblAlimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAlimentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAlimentoKeyReleased

    private void txtPesquisarAlimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarAlimentoKeyReleased
        // TODO add your handling code here:
        pesquisar_alimento();
    }//GEN-LAST:event_txtPesquisarAlimentoKeyReleased

    private void txtPesquisarEscolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarEscolaKeyReleased
        // TODO add your handling code here:
        pesquisar_escola();
    }//GEN-LAST:event_txtPesquisarEscolaKeyReleased

    private void tblEscolaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEscolaMouseClicked
        // TODO add your handling code here:
        setar_campos_escola();
    }//GEN-LAST:event_tblEscolaMouseClicked

    private void tblEscolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEscolaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEscolaKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAddActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void tblEntSaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEntSaidaMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblEntSaidaMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            // TODO add your handling code here:
            String sql2 = "select E.Nome, A.Descricao, A.Qtde, ES.*  from Entrada_Saida ES inner join Alimento A on ES.Id_Alimento = A.Id_Alimento inner join Escola E on ES.Id_Escola = E.Id_Escola";
            try {
                pst = getConnection.prepareStatement(sql2);
            } catch (SQLException ex) {
                Logger.getLogger(TelaEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
            rs = pst.executeQuery();
            tblEntSaida.setModel(DbUtils.resultSetToTableModel(rs));
            tfData.setText(null);
            txtEstInicial.setText(null);
            txtEntrada1.setText(null);
            txtSaida1.setText(null);
            txtEntrada2.setText(null);
            txtSaida2.setText(null);
            txtEntrada3.setText(null);
            txtSaida3.setText(null);
            txtEntrada4.setText(null);
            txtSaida4.setText(null);
            txtEntrada5.setText(null);
            txtSaida5.setText(null);
            txtRecebido.setText(null);
            txtCedido.setText(null);
            txtATASaida.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(TelaEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGerarPDFActionPerformed
        Document doc = new Document(PageSize.A4);
        String escola = txtEscola.getText();
        String data = tfData.getText();
        String alimento = txtDescrAli.getText();
        String est_ini = txtEstInicial.getText();
        String entrada = txtEntrada1.getText();
        String saida = txtSaida1.getText();
        String entrada2 = txtEntrada2.getText();
        String saida2 = txtSaida2.getText();
        String entrada3 = txtEntrada3.getText();
        String saida3 = txtSaida3.getText();
        String entrada4 = txtEntrada4.getText();
        String saida4 = txtSaida4.getText();
        String entrada5 = txtEntrada5.getText();
        String saida5 = txtSaida5.getText();
        String recebido = txtRecebido.getText();
        String cedido = txtCedido.getText();
        String atasaida = txtATASaida.getText();

        int e1, e2, e3, e4, e5;
        int s1, s2, s3, s4, s5;
        int soma1, soma2, c;

        e1 = Integer.parseInt(entrada);
        e2 = Integer.parseInt(entrada2);
        e3 = Integer.parseInt(entrada3);
        e4 = Integer.parseInt(entrada4);
        e5 = Integer.parseInt(entrada5);
        soma1 = e1 + e2 + e3 + e4 + e5;

        s1 = Integer.parseInt(saida);
        s2 = Integer.parseInt(saida2);
        s3 = Integer.parseInt(saida3);
        s4 = Integer.parseInt(saida4);
        s5 = Integer.parseInt(saida5);
        soma2 = s1 + s2 + s3 + s4 + s5;

        c = soma1 - soma2;

        //pnlTeste.setVisible(false);
        try {
            //ResultSet relatorio = adicionar();
            PdfWriter.getInstance(doc, new FileOutputStream("relatorio_geral.pdf"));

            doc.open();
            //Paragraph p1 = new Paragraph("Meu primeiro arquivo PDF!", f);
            //p1.setAlignment(Element.ALIGN_CENTER);

            //Font subtitleFont = FontFactory.getFont("Times Roman", 9);
            //Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
            Font f = FontFactory.getFont("Times Roman", 12);
            Font f2 = FontFactory.getFont("Times Roman", 8);
            Font f3 = FontFactory.getFont("Times Roman", 6);

            //p1.setAlignment(Element.ALIGN_CENTER);
            Paragraph p1 = new Paragraph("UNIDADE: " + escola + "                                   " + "                              " + "  " + "    " + "Data: " + data, f);
            doc.add(p1);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            Paragraph p2 = new Paragraph("GÊNEROS" + "           " + "1ª Semana" + "         " + "2ª Semana" + "          " + "3ª Semana" + "         " + "4ª Semana" + "          " + "5ª Semana" + "        " + "Remanejamento    " + "ATA" + "            " + "TOTAL", f2);
            p2.setAlignment(Element.ALIGN_LEFT);
            p2.setSpacingAfter(5);
            doc.add(p2);

            PdfPTable table = new PdfPTable(new float[]{0.065f, 0.06f, 0.055f, 0.04f, 0.055f, 0.04f, 0.055f, 0.04f, 0.055f, 0.04f, 0.055f, 0.04f, 0.06f, 0.055f, 0.04f, 0.055f, 0.04f, 0.055f});
            table.setWidthPercentage(110.0f);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            //header.setColspan(9);
            //table.addCell(header);
            table.addCell(new Paragraph("Descrição", f2));
            table.addCell(new Paragraph("Estoque Inicial", f2));
            table.addCell(new Paragraph("Entrada", f2));
            table.addCell(new Paragraph("Saída", f2));
            table.addCell(new Paragraph("Entrada", f2));
            table.addCell(new Paragraph("Saída", f2));
            table.addCell(new Paragraph("Entrada", f2));
            table.addCell(new Paragraph("Saída", f2));
            table.addCell(new Paragraph("Entrada", f2));
            table.addCell(new Paragraph("Saída", f2));
            table.addCell(new Paragraph("Entrada", f2));
            table.addCell(new Paragraph("Saída", f2));
            table.addCell(new Paragraph("Recebido", f2));
            table.addCell(new Paragraph("Cedido", f2));
            table.addCell(new Paragraph("Saída", f2));
            table.addCell(new Paragraph("Entrada", f2));
            table.addCell(new Paragraph("Saída", f2));
            table.addCell(new Paragraph("Estoque Final", f2));
            table.addCell(new Paragraph(alimento, f2));
            table.addCell(new Paragraph(est_ini, f2));
            table.addCell(new Paragraph(entrada, f2));
            table.addCell(new Paragraph(saida, f2));
            table.addCell(new Paragraph(entrada2, f2));
            table.addCell(new Paragraph(saida2, f2));
            table.addCell(new Paragraph(entrada3, f2));
            table.addCell(new Paragraph(saida3, f2));
            table.addCell(new Paragraph(entrada4, f2));
            table.addCell(new Paragraph(saida4, f2));
            table.addCell(new Paragraph(entrada5, f2));
            table.addCell(new Paragraph(saida5, f2));
            table.addCell(new Paragraph(recebido, f2));
            table.addCell(new Paragraph(cedido, f2));
            table.addCell(new Paragraph(atasaida, f2));
            table.addCell(new Paragraph("teste", f2));
            table.addCell(new Paragraph("teste", f2));
            table.addCell(new Paragraph("teste", f2));
            doc.add(table);
            //table.addCell(new Paragraph(Integer.toString(soma1), f2));
            //table.addCell(new Paragraph(Integer.toString(soma2), f2));
            //table.addCell(new Paragraph(Integer.toString(c), f2));

            //System.out.println("AQUI: " + relatorio);

            /*while (relatorio.next()) {
                String descricao = relatorio.getString("Descricao");
                String est_inicial = relatorio.getString("estoque_inicial");
                String entrada = relatorio.getString("Entrada");
                String saida = relatorio.getString("Saida");
                String entrada2 = relatorio.getString("entrada2");
                String saida2 = relatorio.getString("saida2");
                String entrada3 = relatorio.getString("entrada3");
                String saida3 = relatorio.getString("saida3");
                String entrada4 = relatorio.getString("entrada4");
                String saida4 = relatorio.getString("saida4");
                String entrada5 = relatorio.getString("entrada5");
                String saida5 = relatorio.getString("saida5");
                String recebido = relatorio.getString("recebido");
                String cedido = relatorio.getString("cedido");
                String atasaida = relatorio.getString("atasaida");
                
                table.addCell(new Paragraph(descricao, f2));
                table.addCell(new Paragraph(est_inicial, f2));
                table.addCell(new Paragraph(entrada, f2));
                table.addCell(new Paragraph(saida, f2));
                table.addCell(new Paragraph(entrada2, f2));
                table.addCell(new Paragraph(saida2, f2));
                table.addCell(new Paragraph(entrada3, f2));
                table.addCell(new Paragraph(saida3, f2));
                table.addCell(new Paragraph(entrada4, f2));
                table.addCell(new Paragraph(saida4, f2));
                table.addCell(new Paragraph(entrada5, f2));
                table.addCell(new Paragraph(saida5, f2));
                table.addCell(new Paragraph(recebido, f2));
                table.addCell(new Paragraph(cedido, f2));
                table.addCell(new Paragraph(atasaida, f2));
                table.addCell(new Paragraph("teste", f2));
                table.addCell(new Paragraph("teste", f2));
                table.addCell(new Paragraph("teste", f2));
            }*/
            

        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            doc.close();
        }

        try {
            Desktop.getDesktop().open(new File("relatorio_geral.pdf"));
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        }
    }//GEN-LAST:event_txtGerarPDFActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEntradaSaida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEntradaSaida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlTeste;
    private javax.swing.JTable tblAlimento;
    private javax.swing.JTable tblEntSaida;
    private javax.swing.JTable tblEscola;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JTextField txtATASaida;
    private javax.swing.JTextField txtCedido;
    private javax.swing.JTextField txtDescrAli;
    private javax.swing.JTextField txtEntrada1;
    private javax.swing.JTextField txtEntrada2;
    private javax.swing.JTextField txtEntrada3;
    private javax.swing.JTextField txtEntrada4;
    private javax.swing.JTextField txtEntrada5;
    private javax.swing.JTextField txtEscola;
    private javax.swing.JTextField txtEstInicial;
    private javax.swing.JButton txtGerarPDF;
    private javax.swing.JTextField txtIdAlimento;
    private javax.swing.JTextField txtIdEntSai;
    private javax.swing.JTextField txtIdEscola;
    private javax.swing.JTextField txtPesquisarAlimento;
    private javax.swing.JTextField txtPesquisarEscola;
    private javax.swing.JTextField txtRecebido;
    private javax.swing.JTextField txtSaida1;
    private javax.swing.JTextField txtSaida2;
    private javax.swing.JTextField txtSaida3;
    private javax.swing.JTextField txtSaida4;
    private javax.swing.JTextField txtSaida5;
    // End of variables declaration//GEN-END:variables
}
