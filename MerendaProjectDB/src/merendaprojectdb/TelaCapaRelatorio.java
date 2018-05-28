package merendaprojectdb;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaCapaRelatorio extends javax.swing.JFrame {
    String usuario;
    TelaCardapio cardapio;
    private CapaDados capa;
    private DefaultTableModel tabelaMatricula;
    public TelaCapaRelatorio(String nome) {
        initComponents();
        this.tabelaMatricula = (DefaultTableModel) tabelaMatriculados.getModel();
        this.usuario = nome;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMatriculados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        proxButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        mes = new java.awt.TextField();
        ano = new java.awt.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setLabelFor(mes);
        jLabel1.setText("Mes ex: 3");

        tabelaMatriculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PRÉ ESCOLAR", null, null, null, null, null, null, null, null},
                {"FUNDAMENTAL", null, null, null, null, null, null, null, null},
                {"JOVENS E ADULT", null, null, null, null, null, null, null, null},
                {"ENSINO ESP", null, null, null, null, null, null, null, null},
                {"Total", null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Modalidade", "1º turno", "2º turno", "3º turno", "4º turno", "Total Matriculados", "Total atendidosl", "Nº dias de distribuição de refeição", "Total de refeições servidas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaMatriculados);

        jLabel2.setLabelFor(tabelaMatriculados);
        jLabel2.setText("Alunos Matriculador");

        proxButton.setText("Próximo");
        proxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximaPagina(evt);
            }
        });

        jLabel3.setLabelFor(ano);
        jLabel3.setText("Ano ex: 2018");

        mes.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });

        ano.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Alunos Atendidos", "Total mensal servido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setText("Desjejum");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Mais Educação", null, null, null, null, null, null}
            },
            new String [] {
                "Matriculados", "2º turno Matriculado", "2° turno Atendido", "Dias Distribuicao", "Total Desj. Servido", "Total lanche Servido", "Total Mais Educ."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(6).setHeaderValue("Total Mais Educ.");
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Mais Educação", null, null, null, null, null}
            },
            new String [] {
                "Matriculados", "1º turno Matriculado", "1° turno Atendido", "Dias Distribuicao", "Total Desj. Servido", "Total lanche Servido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(proxButton)
                .addGap(119, 119, 119))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(proxButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**Método para atualizar a variavel capa com os valores contidos na tabelaMatricula
     * @author Joyce Brum
     */
    private void atualizaCapaDados() {
        int [] turnos = new int[4];
        int atendidos;
        int numDias;
        for(int i = 0; i < this.tabelaMatricula.getRowCount(); i++) {
            for(int j = 1; j < 5; j++) {
                if(this.tabelaMatricula.getValueAt(i, j) != null) {
                    String valor = this.tabelaMatricula.getValueAt(i, j). toString(); 
                    turnos[j-1] = Integer.parseInt(valor);
                }
                else {
                    turnos[j-1] = 0;
                }
                
            }
            if(this.tabelaMatricula.getValueAt(i, 6) != null) {
                String valor = this.tabelaMatricula.getValueAt(i, 6).toString();
                atendidos = Integer.parseInt(valor);
            }
            else {
                atendidos = 0;
            }
            if(this.tabelaMatricula.getValueAt(i, 7) != null) {
                String valor = this.tabelaMatricula.getValueAt(i, 7).toString();
                numDias = Integer.parseInt(valor);
            }
            else {
                numDias = 0;
            }
            this.capa.setVetorMatriculados(i, turnos, atendidos, numDias);
        }
    }
    
    private void proximaPagina(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaPagina
        //String var = "aa13b";
        //var = var.replace("[a-zA-Z]", "");
        //System.out.println(var);
        if(this.mes.getText().intern() == null || this.mes.getText().intern() == "") {
            JOptionPane.showMessageDialog(null,"Campo mes obrigatório");
            return;
        }
        
        if(this.ano.getText().intern() == null || this.ano.getText().intern() == "") {
            JOptionPane.showMessageDialog(null,"Campo ano obrigatório");
            return;
        }
        
        int ano = Integer.parseInt(this.ano.getText());
        int mes = Integer.parseInt(this.mes.getText());
        this.capa = new CapaDados();
        atualizaCapaDados();
        cardapio=new TelaCardapio(usuario, ano, mes-1, this.capa);
        cardapio.setLocationRelativeTo(null);
        cardapio.setVisible(true);
        cardapio.setResizable(true);
        this.dispose();
    }//GEN-LAST:event_proximaPagina

    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesActionPerformed

    private void anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField ano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private java.awt.TextField mes;
    private javax.swing.JButton proxButton;
    private javax.swing.JTable tabelaMatriculados;
    // End of variables declaration//GEN-END:variables
}
