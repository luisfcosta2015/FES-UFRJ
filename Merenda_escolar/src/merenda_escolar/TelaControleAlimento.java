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
import javax.swing.JTextField;

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
public class TelaControleAlimento extends javax.swing.JFrame {

    Connection getConnection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    int totalMatric, totalAtend, totalRef;
    int matric1, matric2, matric3, matric4;
    int atend1, atend2, atend3, atend4;
    int ref1, ref2, ref3, ref4;

    /**
     * Creates new form TelaControleAlimento
     */
    public TelaControleAlimento() {
        initComponents();
        getConnection = ConnectionClass.conector();
    }

    private void pesquisar_escola() {
        String sql = "select Id_Escola, Nome, Endereco, Telefone from escola where Nome like ?";
        try {
            pst = getConnection.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1, txtPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblEscola.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setar_campos() {
        int setar = tblEscola.getSelectedRow();
        txtIdEscola.setText(tblEscola.getModel().getValueAt(setar, 0).toString());
        lblNome.setText(tblEscola.getModel().getValueAt(setar, 1).toString());
        lblEnd.setText(tblEscola.getModel().getValueAt(setar, 2).toString());
        lblTel.setText(tblEscola.getModel().getValueAt(setar, 3).toString());

    }

    public void adicionar() {

        matric1 = Integer.parseInt(txtMatric1.getText());
        matric2 = Integer.parseInt(txtMatric2.getText());
        matric3 = Integer.parseInt(txtMatric3.getText());
        matric4 = Integer.parseInt(txtMatric4.getText());

        atend1 = Integer.parseInt(txtAtend1.getText());
        atend2 = Integer.parseInt(txtAtend2.getText());
        atend3 = Integer.parseInt(txtAtend3.getText());
        atend4 = Integer.parseInt(txtAtend4.getText());

        ref1 = Integer.parseInt(txtRef1.getText());
        ref2 = Integer.parseInt(txtRef2.getText());
        ref3 = Integer.parseInt(txtRef3.getText());
        ref4 = Integer.parseInt(txtRef4.getText());

        totalMatric = matric1 + matric2 + matric3 + matric4;
        totalAtend = atend1 + atend2 + atend3 + atend4;
        totalRef = ref1 + ref2 + ref3 + ref4;

        String sql = "insert into controle_alimento(Id_Escola,Alunos_Matric,Alunos_Atendidos,Total_Ref_Servidas) values(?,?,?,?)";

        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, txtIdEscola.getText());
            pst.setInt(2, totalMatric);
            pst.setInt(3, totalAtend);
            pst.setInt(4, totalRef);

            //a linha abaixo atualiza a tabela usuario com os dados do formulário
            //a etrutura abaixo é usada para confirmar a inserção dos dados na tabela
            int adicionado = pst.executeUpdate();
            //a linha abaixo serve de apoio ao entendimento da lógica
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                //txtNome.setText(null);
                //txtEnd.setText(null);
                //txtTel.setText(null);
                //txtDir.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /*private void editar() {
        String sql = "update controle_alimento set Alunos_Matric=?,Alunos_Atendidos=?,Total_Ref_Servidas=? where Id_Controle=?";
        try {
            pst = getConnection.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtEnd.getText());
            pst.setString(3, txtTel.getText());
            pst.setString(4, txtDir.getText());
            pst.setString(5, txtIdEsc.getText());

            if ((txtNome.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                //a linha abaixo atualiza a tabela cliente com os dados do formulário
                //a etrutura abaixo é usada para confirmar a alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                //a linha abaixo serve de apoio ao entendimento da lógica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados da escola alterados com sucesso");
                    txtNome.setText(null);
                    txtEnd.setText(null);
                    txtTel.setText(null);
                    txtDir.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    private void excluir() {
        //PRECISA ARRUMAR O EXCLUIR
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover os dados ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from controle_alimento where Id_Controle=?";
            try {
                pst = getConnection.prepareStatement(sql);
                pst.setString(1, txtIdCon.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados removidos com sucesso");
                    txt1T1.setText(null);
                    txt1T2.setText(null);
                    txt1T3.setText(null);
                    txt1T4.setText(null);
                    txt2T1.setText(null);
                    txt2T2.setText(null);
                    txt2T3.setText(null);
                    txt2T4.setText(null);
                    txt3T1.setText(null);
                    txt3T2.setText(null);
                    txt3T3.setText(null);
                    txt3T4.setText(null);
                    txt4T1.setText(null);
                    txt4T2.setText(null);
                    txt4T3.setText(null);
                    txt4T4.setText(null);
                    txtMatric1.setText(null);
                    txtMatric2.setText(null);
                    txtMatric3.setText(null);
                    txtMatric4.setText(null);
                    txtAtend1.setText(null);
                    txtAtend2.setText(null);
                    txtAtend3.setText(null);
                    txtAtend4.setText(null);
                    txtRef1.setText(null);
                    txtRef2.setText(null);
                    txtRef3.setText(null);
                    txtRef4.setText(null);

                    //btnAdd.setEnabled(true);
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
        tblEscola = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt1T1 = new javax.swing.JTextField();
        txt1T2 = new javax.swing.JTextField();
        txt1T3 = new javax.swing.JTextField();
        txt1T4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt2T1 = new javax.swing.JTextField();
        txt2T2 = new javax.swing.JTextField();
        txt2T3 = new javax.swing.JTextField();
        txt2T4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt3T1 = new javax.swing.JTextField();
        txt3T2 = new javax.swing.JTextField();
        txt3T3 = new javax.swing.JTextField();
        txt3T4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt4T1 = new javax.swing.JTextField();
        txt4T2 = new javax.swing.JTextField();
        txt4T3 = new javax.swing.JTextField();
        txt4T4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMatric1 = new javax.swing.JTextField();
        txtMatric2 = new javax.swing.JTextField();
        txtMatric3 = new javax.swing.JTextField();
        txtMatric4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAtend1 = new javax.swing.JTextField();
        txtAtend2 = new javax.swing.JTextField();
        txtAtend3 = new javax.swing.JTextField();
        txtAtend4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtRef1 = new javax.swing.JTextField();
        txtRef2 = new javax.swing.JTextField();
        txtRef3 = new javax.swing.JTextField();
        txtRef4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtNDias1 = new javax.swing.JTextField();
        txtNDias2 = new javax.swing.JTextField();
        txtNDias3 = new javax.swing.JTextField();
        txtNDias4 = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtIdCon = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIdEscola = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblEnd = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        txtGerarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Alimento");
        setResizable(false);

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
        jScrollPane1.setViewportView(tblEscola);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/merenda_escolar/imagepackage/search.png"))); // NOI18N

        jLabel8.setText("Nome da Escola");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Modalidade de Ensino");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Pré Escolar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Ensino Fundamental");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Jovens e Adultos");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Ensino Especial");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("1º Turno");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("2º Turno");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("3º Turno");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("4º Turno");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Total Matriculados");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Total Atendidos");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Total de Refeições \nServidas");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nº de Dias de Distribuição de Refeições ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel10)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt1T1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt2T1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt3T1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt4T1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt1T2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt2T2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt3T2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt4T2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt1T3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt2T3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt3T3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt4T3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt1T4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt2T4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt3T4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt4T4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatric4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatric3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatric2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatric1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAtend4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtend3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtend2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtend1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNDias4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNDias3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNDias2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNDias1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRef4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt1T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtend1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt1T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtend2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt1T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtend3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt1T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt2T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt3T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt4T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtend4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRef4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNDias1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNDias2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNDias3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNDias4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        btnAdd.setText("Adicionar");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        BtnExcluir.setText("Excluir");
        BtnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        jLabel15.setText("Id Controle");

        txtIdCon.setEnabled(false);

        jLabel16.setText("Id Escola");
        jLabel16.setToolTipText("");

        txtIdEscola.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Unidade:");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("--");

        jLabel18.setText("Endereço:");

        lblEnd.setText("--");

        jLabel19.setText("Telefone:");

        lblTel.setText("--");

        txtGerarPDF.setText("Gerar PDF");
        txtGerarPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdEscola))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(34, 34, 34)
                                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTel)
                                    .addComponent(lblEnd)
                                    .addComponent(lblNome)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(txtGerarPDF)
                        .addGap(126, 126, 126)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15)
                            .addComponent(txtIdCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtIdEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblEnd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(lblTel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1145, 577));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblEscolaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEscolaMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblEscolaMouseClicked

    private void tblEscolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEscolaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEscolaKeyReleased

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar_escola();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAddActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void txtGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGerarPDFActionPerformed
        Document doc = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(doc, new FileOutputStream("relatorio_controle_alimento.pdf"));

            doc.open();
            //Paragraph p1 = new Paragraph("Meu primeiro arquivo PDF!", f);
            //p1.setAlignment(Element.ALIGN_CENTER);
            
            //Font subtitleFont = FontFactory.getFont("Times Roman", 9);
            //Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
            Font f = FontFactory.getFont("Times Roman", 20);
            Font f2 = FontFactory.getFont("Times Roman", 7);

            Paragraph p1 = new Paragraph("Controle da Alimentação Escolar", f);
            p1.setAlignment(Element.ALIGN_CENTER);
            doc.add(p1);
            doc.add(new Paragraph(" "));
            
            String unidade = lblNome.getText();
            String endereco = lblEnd.getText();
            String telefone = lblTel.getText();
            
            doc.add(new Paragraph("UNIDADE: " + unidade));
            doc.add(new Paragraph("ENDEREÇO: " + endereco));
            doc.add(new Paragraph("TELEFONE: " + telefone));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
            String t1 = txt1T1.getText();
            String t2 = txt1T2.getText();
            String t3 = txt1T3.getText();
            String t4 = txt1T4.getText();
            String t5 = txt2T1.getText();
            String t6 = txt2T2.getText();
            String t7 = txt2T3.getText();
            String t8 = txt2T4.getText();
            String t9 = txt3T1.getText();
            String t10 = txt3T2.getText();
            String t11 = txt3T3.getText();
            String t12 = txt3T4.getText();
            String t13 = txt4T1.getText();
            String t14 = txt4T2.getText();
            String t15 = txt4T3.getText();
            String t16 = txt4T4.getText();
            
            int ta, tb, tc, td, te, tf, tg, th, ti, tj, tk, tl, tm, tn, to, tp;
            int s1, s2, s3, s4;
            
            ta = Integer.parseInt(t1);
            tb = Integer.parseInt(t2);
            tc = Integer.parseInt(t3);
            td = Integer.parseInt(t4);
            s1 = ta + tb + tc + td;
            
            te = Integer.parseInt(t5);
            tf = Integer.parseInt(t6);
            tg = Integer.parseInt(t7);
            th = Integer.parseInt(t8);
            s2 = te + tf + tg + th;
            
            ti = Integer.parseInt(t9);
            tj = Integer.parseInt(t10);
            tk = Integer.parseInt(t11);
            tl = Integer.parseInt(t12);
            s3 = ti + tj + tk + tl;
            
            tm = Integer.parseInt(t13);
            tn = Integer.parseInt(t14);
            to = Integer.parseInt(t15);
            tp = Integer.parseInt(t16);
            s4 = tm + tn + to + tp;
            
            PdfPTable table = new PdfPTable(new float[]{0.15f, 0.0875f, 0.0875f, 0.0875f, 0.0875f, 0.08f, 0.14f, 0.1250f, 0.1380f});
            PdfPCell header = new PdfPCell(new Paragraph("ALUNOS MATRICULADOS"));
            table.setWidthPercentage(100.0f);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            header.setColspan(9);
            table.addCell(header);
            table.addCell("MODALIDADE DE ENSINO");
            //table.addCell(new Paragraph("MODALIDADE DE ENSINO", f2));
            table.addCell("1º turno");
            table.addCell("2º turno");
            table.addCell("3º turno");
            table.addCell("4º turno");
            table.addCell("TOTAL MATRICULADOS");
            table.addCell("TOTAL ATENDIDOS 86%");
            table.addCell("Nº DE DIAS DE DISTRIBUIÇÂO DE REFEIÇÃO");
            table.addCell("TOTAL DE REFEIÇÕES SERVIDAS");
            table.addCell("PRÉ ESCOLA");
            table.addCell(t1);
            table.addCell(t5);
            table.addCell(t9);
            table.addCell(t13);
            table.addCell(txtMatric1.getText());
            table.addCell(txtAtend1.getText());
            table.addCell(txtNDias1.getText());
            table.addCell(txtRef1.getText());
            table.addCell("ENSINO FUNDAMENTAL");
            table.addCell(t2);
            table.addCell(t6);
            table.addCell(t10);
            table.addCell(t14);
            table.addCell(txtMatric2.getText());
            table.addCell(txtAtend2.getText());
            table.addCell(txtNDias2.getText());
            table.addCell(txtRef2.getText());
            table.addCell("JOVENS E ADULTOS");
            table.addCell(t3);
            table.addCell(t7);
            table.addCell(t11);
            table.addCell(t15);
            table.addCell(txtMatric3.getText());
            table.addCell(txtAtend3.getText());
            table.addCell(txtNDias3.getText());
            table.addCell(txtRef3.getText());
            table.addCell("ENSINO ESPECIAL");
            table.addCell(t4);
            table.addCell(t8);
            table.addCell(t12);
            table.addCell(t16);
            table.addCell(txtMatric4.getText());
            table.addCell(txtAtend4.getText());
            table.addCell(txtNDias4.getText());
            table.addCell(txtRef4.getText());
            table.addCell("TOTAL");
            table.addCell(Integer.toString(s1));
            table.addCell(Integer.toString(s2));
            table.addCell(Integer.toString(s3));
            table.addCell(Integer.toString(s4));
            table.addCell(Integer.toString(totalMatric));
            table.addCell(Integer.toString(totalAtend));
            table.addCell("--------");
            table.addCell(Integer.toString(totalRef));
            doc.add(table);

        } catch (DocumentException | FileNotFoundException ex) {
            System.out.println("Error:" + ex);
        } finally {
            doc.close();
        }

        try {
            Desktop.getDesktop().open(new File("relatorio_controle_alimento.pdf"));
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
            java.util.logging.Logger.getLogger(TelaControleAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaControleAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaControleAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaControleAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaControleAlimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton btnAdd;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTel;
    private javax.swing.JTable tblEscola;
    private javax.swing.JTextField txt1T1;
    private javax.swing.JTextField txt1T2;
    private javax.swing.JTextField txt1T3;
    private javax.swing.JTextField txt1T4;
    private javax.swing.JTextField txt2T1;
    private javax.swing.JTextField txt2T2;
    private javax.swing.JTextField txt2T3;
    private javax.swing.JTextField txt2T4;
    private javax.swing.JTextField txt3T1;
    private javax.swing.JTextField txt3T2;
    private javax.swing.JTextField txt3T3;
    private javax.swing.JTextField txt3T4;
    private javax.swing.JTextField txt4T1;
    private javax.swing.JTextField txt4T2;
    private javax.swing.JTextField txt4T3;
    private javax.swing.JTextField txt4T4;
    private javax.swing.JTextField txtAtend1;
    private javax.swing.JTextField txtAtend2;
    private javax.swing.JTextField txtAtend3;
    private javax.swing.JTextField txtAtend4;
    private javax.swing.JButton txtGerarPDF;
    private javax.swing.JTextField txtIdCon;
    private javax.swing.JTextField txtIdEscola;
    private javax.swing.JTextField txtMatric1;
    private javax.swing.JTextField txtMatric2;
    private javax.swing.JTextField txtMatric3;
    private javax.swing.JTextField txtMatric4;
    private javax.swing.JTextField txtNDias1;
    private javax.swing.JTextField txtNDias2;
    private javax.swing.JTextField txtNDias3;
    private javax.swing.JTextField txtNDias4;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtRef1;
    private javax.swing.JTextField txtRef2;
    private javax.swing.JTextField txtRef3;
    private javax.swing.JTextField txtRef4;
    // End of variables declaration//GEN-END:variables
}
