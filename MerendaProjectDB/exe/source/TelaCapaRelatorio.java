package merendaprojectdb;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaCapaRelatorio extends javax.swing.JFrame {
    TelaCardapio cardapio;
    private CapaDados capa;
    private DefaultTableModel tabelaMatricula;
    private DefaultTableModel tabelaDesjejum;
    private DefaultTableModel tabelaMaisEducacao1;
    private DefaultTableModel tabelaMaisEducacao2;
    private DefaultTableModel tabelaTotal;
    private Relatorio relatorio;
    private int ano;
    private int mes;
    private boolean editando = false;
    public TelaCapaRelatorio(int mes, int ano) {
        initComponents();
        this.mes = mes;
        this.ano = ano;
        this.tabelaMatricula = (DefaultTableModel) tabelaMatriculados.getModel();
        this.tabelaDesjejum = (DefaultTableModel) this.desjejumTable.getModel();
        this.tabelaMaisEducacao1 = (DefaultTableModel) this.maisEducacaoTurno1.getModel();
        this.tabelaMaisEducacao2 = (DefaultTableModel) this.maisEducacaoTurno2.getModel();
        this.tabelaTotal = (DefaultTableModel) this.totalTable.getModel();
    }
    public TelaCapaRelatorio(Relatorio relatorio) {
        initComponents();
        this.editando = true;
        this.relatorio = relatorio;
        this.capa = relatorio.getCapaRelatorio();
        this.tabelaMatricula = (DefaultTableModel) tabelaMatriculados.getModel();
        inicializaMatriculados();
        this.tabelaDesjejum = (DefaultTableModel) this.desjejumTable.getModel();
        inicializaDesjejum();
        this.tabelaMaisEducacao1 = (DefaultTableModel) this.maisEducacaoTurno1.getModel();
        inicializaMaisEducacao1();
        this.tabelaMaisEducacao2 = (DefaultTableModel) this.maisEducacaoTurno2.getModel();
        inicializaMaisEducacao2();
        this.tabelaTotal = (DefaultTableModel) this.totalTable.getModel();
        this.tabelaTotal.setValueAt(this.capa.getTotalServido(), 0, 0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMatriculados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        proxButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        desjejumTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        maisEducacaoTurno2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        maisEducacaoTurno1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        totalTable = new javax.swing.JTable();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                false, true, true, true, true, false, false, true, true
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

        desjejumTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(desjejumTable);
        if (desjejumTable.getColumnModel().getColumnCount() > 0) {
            desjejumTable.getColumnModel().getColumn(0).setHeaderValue("Alunos Atendidos");
        }

        jLabel4.setText("Desjejum");

        maisEducacaoTurno2.setModel(new javax.swing.table.DefaultTableModel(
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
                false, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(maisEducacaoTurno2);

        maisEducacaoTurno1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(maisEducacaoTurno1);

        totalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Total mensal servido - Desjejum + Mais Ed."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(totalTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(proxButton)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(proxButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**Método para inicialização da tabela de alunos matriculados com os valores já contidos no Relatorio
     * @author Joyce Brum
     */
    private void inicializaMatriculados() {
        for(int i=0; i < this.tabelaMatricula.getRowCount(); i++) {
            for(int j=1; j < this.tabelaMatricula.getColumnCount(); j++) {
                tabelaMatricula.setValueAt(capa.getValueAt(i,j-1), i, j);
            }
        }
    }
    private void inicializaDesjejum() {
        this.tabelaDesjejum.setValueAt(this.capa.alunosAtendidosDesjejum, 0, 0);
        this.tabelaDesjejum.setValueAt(this.capa.desjejumTotalMensalServido, 0, 1);
    }
    private void inicializaMaisEducacao1() {
        this.tabelaMaisEducacao1.setValueAt(this.capa.maisEducacao[0].matriculados, 0,1);
        this.tabelaMaisEducacao1.setValueAt(this.capa.maisEducacao[0].atendidos, 0,2);
        this.tabelaMaisEducacao1.setValueAt(this.capa.maisEducacao[0].numDias, 0,3);
        this.tabelaMaisEducacao1.setValueAt(this.capa.maisEducacao[0].totalDesjejum , 0,4);
        this.tabelaMaisEducacao1.setValueAt(this.capa.maisEducacao[0].totalLanche , 0,5);
    }
    private void inicializaMaisEducacao2() {
        this.tabelaMaisEducacao2.setValueAt(this.capa.maisEducacao[0].matriculados, 0,1);
        this.tabelaMaisEducacao2.setValueAt(this.capa.maisEducacao[0].atendidos, 0,2);
        this.tabelaMaisEducacao2.setValueAt(this.capa.maisEducacao[0].numDias, 0,3);
        this.tabelaMaisEducacao2.setValueAt(this.capa.maisEducacao[0].totalDesjejum, 0,5);
        this.tabelaMaisEducacao2.setValueAt(this.capa.maisEducacao[0].totalLanche, 0,5);
        this.tabelaMaisEducacao2.setValueAt(this.capa.getTotalMaisEducacao() , 0,6);
    }
    /**Método para atualizar a variavel capa com os valores contidos na tabelaMatricula
     * @author Joyce Brum
     */
    private void atualizaVetorMatriculados() {
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
            this.capa.setVetorMatriculados(i, turnos, numDias);
        }
    }
    /**Método para atualizar a variavel capa com os valores contidos na tabela Desjejum
     * @author Joyce Brum
     */
    private void atualizaDesjejum() {
        int alunosAtendidos  = 0;
        int totalServido = 0;
        if(this.tabelaDesjejum.getValueAt(0, 0) != null) {
            alunosAtendidos = ((Integer)this.tabelaDesjejum.getValueAt(0, 0)).intValue();
        }
        if(this.tabelaDesjejum.getValueAt(0, 1) != null) {
            totalServido = ((Integer)this.tabelaDesjejum.getValueAt(0, 1)).intValue();
        }
        this.capa.setDesjejum(totalServido);
    }
    /**Método para atualizar a variavel capa com os valores contidos na tabela 
     * Mais Educacao dos turnos 1 e 2
     * @author Joyce Brum
     */
    private void atualizaMaisEducacao1() {
        int [] valores = new int[5];
        for(int i = 1; i< this.tabelaMaisEducacao1.getColumnCount(); i++) {
            if(i > 5) {
                continue;
            }
            if(this.tabelaMaisEducacao1.getValueAt(0, i) != null) {
                valores[i-1] = ((Integer)this.tabelaMaisEducacao1.getValueAt(0, i)).intValue();
            }
            else {
                valores[i-1] = 0;
            }
        }
        this.capa.setVetorMaisEducacao(0, valores[0], valores[1], valores[2]);
    }
    private void atualizaMaisEducacao2() {
        int [] valores = new int[5];
        for(int i = 1; i< this.tabelaMaisEducacao2.getColumnCount(); i++) {
            if(i > 5) {
                continue;
            }
            if(this.tabelaMaisEducacao2.getValueAt(0, i) != null) {
                valores[i-1] = ((Integer)this.tabelaMaisEducacao2.getValueAt(0, i)).intValue();
            }
            else {
                valores[i-1] = 0;
            }
        }
        this.capa.setVetorMaisEducacao(1, valores[0], valores[1], valores[2]);
    }
    private void atualizaTotal() {
        this.tabelaTotal.setValueAt(this.capa.getTotalServido(), 0, 0);
    }
    private void atualizaCapaDados() {
        atualizaVetorMatriculados();
        atualizaDesjejum();
        atualizaMaisEducacao1();
        atualizaMaisEducacao2();
        atualizaTotal();
    }
    private void proximaPagina(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximaPagina
        if(this.editando) {
             atualizaCapaDados();
            this.cardapio = new TelaCardapio(this.relatorio);
            this.cardapio.setLocationRelativeTo(null);
            this.cardapio.setVisible(true);
            this.cardapio.setResizable(true);
            dispose();
            return;
        }
        this.capa = new CapaDados();
        atualizaCapaDados();
        cardapio=new TelaCardapio(this.ano, this.mes-1, this.capa);
        cardapio.setLocationRelativeTo(null);
        cardapio.setVisible(true);
        cardapio.setResizable(true);
        this.dispose();
    }//GEN-LAST:event_proximaPagina

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable desjejumTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable maisEducacaoTurno1;
    private javax.swing.JTable maisEducacaoTurno2;
    private javax.swing.JButton proxButton;
    private javax.swing.JTable tabelaMatriculados;
    private javax.swing.JTable totalTable;
    // End of variables declaration//GEN-END:variables
}
