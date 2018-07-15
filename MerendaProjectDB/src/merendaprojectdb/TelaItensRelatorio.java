/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author joycinha
 */
public class TelaItensRelatorio extends javax.swing.JFrame {
    
    TelaPrincipal principal;
    DefaultListModel modelList = new DefaultListModel();
    private Relatorio relatorio;
    private CapaDados capa;
    private Cardapio cardapio;
    private ArrayList<ItemComida> itens;
    private boolean editando;
    private String nomeRel;
    /**
     * Creates new form ItensRelatorio
     */
    public TelaItensRelatorio(String nomeRel, CapaDados capa, Cardapio cardapio) {        
        
        initComponents();
        carregarItens();
        this.capa = capa;
        this.cardapio = cardapio;
        this.editando = false;
        this.nomeRel = nomeRel;
        this.itens = new ArrayList<ItemComida>();
        listenClickTable();
        // com essa parte podemos adicionar o dropBox com as coisas vindas do banco
    }
    public TelaItensRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
        this.itens = relatorio.getItensRelatorio();
        if(this.itens == null) {
            this.itens = new ArrayList<ItemComida>();
        }
        initComponents();
        carregarItens();
        carregarTabela();
        this.editando = true;
        listenClickTable();
    }
    private void listenClickTable() {
        this.tabelaTotais.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int input = JOptionPane.showConfirmDialog(null, 
                "Esta ação irá excluir este item da lista", 
                "Deseja prosseguir?",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(input == JOptionPane.NO_OPTION || input == JOptionPane.CANCEL_OPTION || input == JOptionPane.CLOSED_OPTION) {
                return;
            }
            int row = tabelaTotais.rowAtPoint(evt.getPoint());
            int col = tabelaTotais.columnAtPoint(evt.getPoint());
            if (row >= 0 && col == 5) {
                DefaultTableModel tabela = (DefaultTableModel) tabelaTotais.getModel();
                DefaultTableModel entrada = (DefaultTableModel) tabelaEntrada.getModel();
                DefaultTableModel saida = (DefaultTableModel) tabelaSaida.getModel();
                String tipo = tabela.getValueAt(row, 0) + "";
                ItemComida itemExistente = verificaItemJaExiste(tipo);
                itens.remove(itemExistente); 
                tabela.removeRow(row);
                entrada.removeRow(row);
                saida.removeRow(row);
            }
        }});
    }
    private void carregarTabela() {
        // tem que rever
        DefaultTableModel tabelinhaEntrada = (DefaultTableModel) tabelaEntrada.getModel();
        DefaultTableModel tabelinhaSaida = (DefaultTableModel) tabelaSaida.getModel();
        DefaultTableModel tabelinhaTotais = (DefaultTableModel) tabelaTotais.getModel();
        if(itens == null) {
            return;
        }
        int i = 0;
        for(ItemComida item : itens) {
            if(item == null) {
                continue;
            }
            tabelinhaEntrada.addRow(new Object[] {item.tipoItem, item.semana1Entrada+item.unidade,
                item.semana2Entrada+item.unidade,item.semana3Entrada+item.unidade,item.semana4Entrada+item.unidade,
                item.semana5Entrada+item.unidade, item.remanejamentoEntrada+item.unidade});
            tabelinhaSaida.addRow(new Object[] {item.tipoItem, item.semana1Saida+item.unidade,item.semana2Saida+
                    item.unidade,item.semana3Saida+item.unidade,item.semana4Saida+item.unidade,item.semana5Saida+
                            item.unidade, item.remanejamentoSaida+item.unidade, item.ataSaida});
            tabelinhaTotais.addRow(new Object[] {item.tipoItem, item.estoqueInicial,item.totalEntrada,item.totalSaida ,
                item.estoqueFinal, "Excluir"});
            /*this.tabelaTotais.getColumn("Excluir").setCellRenderer(new JTableButtonRenderer());
            this.tabelaTotais.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox(), new BotaoExcluir(tabelinhaEntrada, 
                        tabelinhaSaida, tabelinhaTotais, i)));*/
            i++;
        }
        tabelaTotais.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
    }
    private void carregarItens(){
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) tipoItem.getModel();
        //modelo.addElement("thiago");
        ArrayList<String> itens = new ArrayList();
        itens=BdManager.pegarItensDoCardapio();
        modelo.removeAllElements();
        modelo.addElement("Selecione o Item");
        for(int i=0;i<itens.size();i++)
        {
            modelo.addElement(itens.get(i));
        }
    }
    
    private void criaLista() {
       this.tipoItem.removeAll();
    }
    public void excluirLinha(int linha) {
        
        DefaultTableModel tabelaTotal = (DefaultTableModel) this.tabelaTotais.getModel();
        DefaultTableModel tabela2 = (DefaultTableModel) this.tabelaEntrada.getModel();
        DefaultTableModel tabela3 = (DefaultTableModel) this.tabelaSaida.getModel();
        String tipo = tabelaTotal.getValueAt(linha, 0) + "";
        ItemComida itemExistente = verificaItemJaExiste(tipo);
        this.itens.remove(itemExistente);
        tabelaTotal.removeRow(linha);
        tabela2.removeRow(linha);
        tabela3.removeRow(linha);
        for(int i=linha; i<tabelaTotal.getRowCount(); i++) {
            tabelaTotal.setValueAt(i, i, 5);
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
        tipoItem = new javax.swing.JComboBox<>();
        AdicionarParaALista = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaTotais = new javax.swing.JTable();
        voltarAoMenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        estoqueInicial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        semana1S = new javax.swing.JTextField();
        semana1E = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        semana3E = new javax.swing.JTextField();
        semana3S = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        semana4S = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        semana4E = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        semana5E = new javax.swing.JTextField();
        semana5S = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        semana2E = new javax.swing.JTextField();
        semana2S = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        remanejamentoS = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        remanejamentoE = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        ata = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        unidadeItem = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        novoItem = new javax.swing.JTextField();
        AdicionarItens = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaSaida = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaEntrada = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        linhaValue = new javax.swing.JTextField();
        excluirBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        criaLista();
        tipoItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Item" }));
        tipoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoItemActionPerformed(evt);
            }
        });

        AdicionarParaALista.setText("+");
        AdicionarParaALista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarParaAListaActionPerformed(evt);
            }
        });

        tabelaTotais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Estoque Inicial", "Total Entrada", "Total Saida", "Estoque Final", "Excluir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaTotais);
        if (tabelaTotais.getColumnModel().getColumnCount() > 0) {
            tabelaTotais.getColumnModel().getColumn(5).setResizable(false);
        }

        voltarAoMenu.setText("Fim");
        voltarAoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarAoMenuActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        estoqueInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoqueInicialActionPerformed(evt);
            }
        });

        jLabel2.setText("<html>\nEstoque<br />\nInicial\n</html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estoqueInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(estoqueInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        semana1S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semana1SActionPerformed(evt);
            }
        });

        jLabel10.setText("Entrada");

        jLabel22.setText("Saida");

        jLabel3.setText("Semana 1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(semana1E, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semana1S, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addGap(11, 11, 11))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semana1E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semana1S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("Saida");

        jLabel5.setText("Semana 3");

        jLabel11.setText("Entrada");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(semana3E, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(semana3S, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semana3E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semana3S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("Saida");

        jLabel6.setText("Semana 4");

        jLabel12.setText("Entrada");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(semana4E, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(semana4S, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(12, 12, 12))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semana4E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semana4S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Semana 5");

        jLabel18.setText("Saida");

        jLabel15.setText("Entrada");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(semana5E, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semana5S, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semana5S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semana5E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Semana 2");

        jLabel19.setText("Saida");

        jLabel13.setText("Entrada");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(semana2E, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semana2S, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semana2E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semana2S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setText("Saida");

        jLabel8.setText("Remanejamento");

        jLabel14.setText("Entrada");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remanejamentoE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(remanejamentoS, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remanejamentoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remanejamentoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setText("Saida");

        jLabel9.setText("ATA");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel9)))
                    .addComponent(ata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setText("Unidade");

        unidadeItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "g", "Kg", "Uni.", "Duz.", " " }));
        unidadeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadeItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(unidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AdicionarItens.setText("Adicionar");
        AdicionarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarItensActionPerformed(evt);
            }
        });

        jLabel1.setText("Adicionar novo tipo de Item na lista");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(novoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AdicionarItens)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarItens))
                .addContainerGap())
        );

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Entrada:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Saida:");

        tabelaSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Semana1", "Semana2", "Semana3", "Semana4", "Semana5", "Remanejamento", "ATA saida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelaSaida);

        tabelaEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Semana1", "Semana2", "Semana3", "Semana4", "Semana5", "Remanejamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabelaEntrada);

        jLabel26.setText("Excluir");

        linhaValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linhaValueActionPerformed(evt);
            }
        });

        excluirBotao.setText("Excluir");
        excluirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tipoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AdicionarParaALista))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(linhaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excluirBotao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(voltarAoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(AdicionarParaALista))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(tipoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(voltarAoMenu)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(linhaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(excluirBotao))
                                .addContainerGap())))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jPanel7, jPanel8, jPanel9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoItemActionPerformed

    private void voltarAoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarAoMenuActionPerformed
        // TODO add your handling code here:
        
        // aqui tem que colocar pra pegar o que ta na tabela e jogar pro banco
        if(!this.editando) {
            this.relatorio = new Relatorio (this.cardapio.getMes(), this.cardapio.getAno(),this.nomeRel, 
                                            TelaPrincipal.escolaAtual, this.cardapio, this.capa, itens);
            TelaPrincipal.usuarioLogado.idRelatorio = new IdentificacaoRelatorio(relatorio.getEscola().getINEP(), relatorio.getMes(), relatorio.getAno());
            BdManager.adicionarRelatorio(this.relatorio);
            
        }
        else
        {
            BdManager.alterarRelatorio(this.relatorio);
        }
        principal=new TelaPrincipal();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        principal.setResizable(true);
        this.setVisible(false);
    }//GEN-LAST:event_voltarAoMenuActionPerformed
    private ItemComida verificaItemJaExiste(String tipo) {
        if(this.itens == null || this.itens.size() == 0) {
            return null;
        }
        for(ItemComida item: this.itens) {
            if(item.tipoItem.compareToIgnoreCase(tipo) == 0) {
                return item;
            }
        }
        return null;
    }
    private void AdicionarParaAListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarParaAListaActionPerformed
        if(tipoItem.getSelectedItem()!="Selecione o Item")
        {   
            String unidade = unidadeItem.getSelectedItem()+"";
            String tipoItemString = tipoItem.getSelectedItem() + "";
            int valorEstoqueInicial = 0;
            int semana1Entrada = 0;
            int semana1Saida=  0;
            int semana2Entrada=  0;
            int semana2Saida=  0;
            int semana3Entrada=  0;
            int semana3Saida=  0;
            int semana4Entrada=  0;
            int semana4Saida= 0;
            int semana5Entrada= 0;
            int semana5Saida= 0;
            int remanejamentoEntrada= 0;
            int remanejamentoSaida= 0;
            int ataSaida= 0;
            
            if(this.ata.getText().length() > 0) {
                ataSaida = Integer.parseInt(ata.getText());
            }
            if(this.remanejamentoE.getText().length() > 0) {
                remanejamentoEntrada = Integer.parseInt(remanejamentoE.getText());
            }
            if(this.remanejamentoS.getText().length() > 0) {
                remanejamentoSaida = Integer.parseInt(remanejamentoS.getText());
            }
            if( estoqueInicial.getText().length() > 0) {
                valorEstoqueInicial = Integer.parseInt(estoqueInicial.getText());
            }
            if(semana1E.getText().length() > 0) {
                semana1Entrada = Integer.parseInt(semana1E.getText());
            }
            if(semana2E.getText().length() > 0) {
                semana2Entrada = Integer.parseInt(semana1E.getText());
            }
            if(semana3E.getText().length() > 0) {
                semana3Entrada = Integer.parseInt(semana1E.getText());
            }
            if(semana4E.getText().length() > 0) {
                semana4Entrada = Integer.parseInt(semana1E.getText());
            }
            if(semana5E.getText().length() > 0) {
                semana5Entrada = Integer.parseInt(semana1E.getText());
            }
            if(semana1S.getText().length() > 0) {
                semana1Saida = Integer.parseInt(semana1S.getText());
            }
            if(semana2S.getText().length() > 0) {
                semana2Saida = Integer.parseInt(semana2S.getText());
            }
            if(semana3S.getText().length() > 0) {
                semana3Saida = Integer.parseInt(semana3S.getText());
            }
            if(semana4S.getText().length() > 0) {
                semana4Saida = Integer.parseInt(semana4S.getText());
            }
            if(semana5S.getText().length() > 0) {
                semana5Saida = Integer.parseInt(semana5S.getText());
            }
                    
            int totalEntrada=semana1Entrada+semana2Entrada+semana3Entrada+semana4Entrada+semana5Entrada;
            String totalEntradaText=totalEntrada+unidade;
            int totalSaida= semana1Saida + semana2Saida + semana3Saida + semana4Saida + semana5Saida;
            String totalSaidaText=totalSaida+unidade;
            int valorEstoqueFinal= valorEstoqueInicial + remanejamentoEntrada + totalEntrada - remanejamentoSaida - ataSaida - totalSaida;
            String valorEstoqueFinalText=valorEstoqueFinal+unidade;
            
            DefaultTableModel tabelinhaEntrada = (DefaultTableModel) tabelaEntrada.getModel();
            DefaultTableModel tabelinhaTotais = (DefaultTableModel) tabelaTotais.getModel();
            DefaultTableModel tabelinhaSaida = (DefaultTableModel) tabelaSaida.getModel();
            ItemComida itemExistente = verificaItemJaExiste(tipoItemString);
            if( itemExistente == null) {
                
                tabelinhaEntrada.addRow(new Object[] {tipoItemString,semana1Entrada+unidade,semana2Entrada+unidade,
                    semana3Entrada+unidade,semana4Entrada+unidade,semana5Entrada+unidade,remanejamentoEntrada+unidade});

                tabelinhaTotais.addRow(new Object[] {tipoItemString,valorEstoqueInicial,totalEntradaText, totalSaidaText, 
                    valorEstoqueFinalText, tabelinhaTotais.getRowCount()});

                tabelinhaSaida.addRow(new Object[] {tipoItemString,semana1Saida+unidade,semana2Saida+unidade,
                    semana3Saida+unidade,semana4Saida+unidade,semana5Saida+unidade,remanejamentoSaida+unidade, ataSaida});
                
                ItemComida item = new ItemComida(tipoItemString, valorEstoqueInicial, semana1Entrada, semana1Saida, 
                        semana2Entrada, semana2Saida, semana3Entrada, semana3Saida, semana4Entrada, semana4Saida, 
                        semana5Entrada, semana5Saida, remanejamentoEntrada, remanejamentoSaida, ataSaida, totalEntrada, 
                        totalSaida, valorEstoqueFinal, unidadeItem.getSelectedItem().toString());
                this.itens.add(item);
                /*this.tabelaTotais.getColumn("Excluir").setCellRenderer(new JTableButtonRenderer());
                this.tabelaTotais.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox(), new BotaoExcluir(tabelinhaEntrada, 
                        tabelinhaSaida, tabelinhaTotais, tabelinhaTotais.getRowCount()-1)));*/
            }
            else {
                itemExistente.estoqueInicial += valorEstoqueInicial;
                itemExistente.estoqueFinal += valorEstoqueFinal;
                itemExistente.semana1Entrada += semana1Entrada;
                itemExistente.semana1Saida +=  semana1Saida;
                itemExistente.semana2Entrada += semana2Entrada;
                itemExistente.semana2Saida += semana2Saida;
                itemExistente.semana3Entrada += semana3Entrada;
                itemExistente.semana3Saida += semana3Saida;
                itemExistente.semana4Entrada += semana4Entrada;
                itemExistente.semana4Saida += semana4Saida;
                itemExistente.semana5Entrada += semana5Entrada;
                itemExistente.semana5Saida += semana5Saida;
                itemExistente.remanejamentoEntrada += remanejamentoEntrada;
                itemExistente.remanejamentoSaida += remanejamentoSaida;
                itemExistente.ataSaida += ataSaida;
                atualizaTabelas(tabelinhaSaida, tabelinhaEntrada, tabelinhaTotais, itemExistente);
            }
        }
    }//GEN-LAST:event_AdicionarParaAListaActionPerformed
    private void atualizaTabelas(DefaultTableModel saida, DefaultTableModel entrada, DefaultTableModel total, ItemComida item) {
        for(int i=0; i < total.getRowCount(); i++) {
            String valor = total.getValueAt(i, 0) + "";
            if(item.tipoItem.compareToIgnoreCase(valor)==0) {
                total.removeRow(i);
                saida.removeRow(i);
                entrada.removeRow(i);
                total.insertRow(i, new Object[] {item.tipoItem, item.estoqueInicial,item.totalEntrada,item.totalSaida ,
                    item.estoqueFinal, i});
                entrada.insertRow(i, new Object[] {item.tipoItem, item.semana1Entrada+item.unidade,
                    item.semana2Entrada+item.unidade,item.semana3Entrada+item.unidade,item.semana4Entrada+item.unidade,
                    item.semana5Entrada+item.unidade, item.remanejamentoEntrada+item.unidade});
                saida.insertRow(i, new Object[] {item.tipoItem, item.semana1Saida+item.unidade,item.semana2Saida+
                    item.unidade,item.semana3Saida+item.unidade,item.semana4Saida+item.unidade,item.semana5Saida+
                    item.unidade, item.remanejamentoSaida+item.unidade, item.ataSaida});
                return;
            }
        }
    }
    private void AdicionarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarItensActionPerformed
        
        String newItem = novoItem.getText();
        if(BdManager.VerificarItemExistente(newItem)) // retorna true se o item ja existe
        {
            novoItem.setText("");
            JOptionPane.showMessageDialog(null,"Esse item já existe na Lista, procure-o na lista acima :3");
        }
        else
        {
            BdManager.AdicionarItemListaCardapio(newItem);
            carregarItens();
            novoItem.setText("");
            JOptionPane.showMessageDialog(null,"Item adicionado com sucesso :3");
        }
        
        
    }//GEN-LAST:event_AdicionarItensActionPerformed

    private void semana1SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semana1SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semana1SActionPerformed

    private void unidadeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadeItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unidadeItemActionPerformed

    private void estoqueInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoqueInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estoqueInicialActionPerformed

    private void linhaValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linhaValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linhaValueActionPerformed

    private void excluirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBotaoActionPerformed
        if(this.linhaValue == null || this.linhaValue.getText()=="") {
            return;
        }
        excluirLinha(Integer.parseInt(this.linhaValue.getText()));
    }//GEN-LAST:event_excluirBotaoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarItens;
    private javax.swing.JButton AdicionarParaALista;
    private javax.swing.JTextField ata;
    private javax.swing.JTextField estoqueInicial;
    private javax.swing.JButton excluirBotao;
    private javax.swing.Box.Filler filler1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField linhaValue;
    private javax.swing.JTextField novoItem;
    private javax.swing.JTextField remanejamentoE;
    private javax.swing.JTextField remanejamentoS;
    private javax.swing.JTextField semana1E;
    private javax.swing.JTextField semana1S;
    private javax.swing.JTextField semana2E;
    private javax.swing.JTextField semana2S;
    private javax.swing.JTextField semana3E;
    private javax.swing.JTextField semana3S;
    private javax.swing.JTextField semana4E;
    private javax.swing.JTextField semana4S;
    private javax.swing.JTextField semana5E;
    private javax.swing.JTextField semana5S;
    private javax.swing.JTable tabelaEntrada;
    private javax.swing.JTable tabelaSaida;
    private javax.swing.JTable tabelaTotais;
    private javax.swing.JComboBox<String> tipoItem;
    private javax.swing.JComboBox<String> unidadeItem;
    private javax.swing.JButton voltarAoMenu;
    // End of variables declaration//GEN-END:variables
}
