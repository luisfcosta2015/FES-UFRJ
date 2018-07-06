/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author joycinha
 */
public class TelaItensRelatorio extends javax.swing.JFrame {
    
    TelaPrincipal principal;
    BdManager banco;
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
        
        // com essa parte podemos adicionar o dropBox com as coisas vindas do banco
    }
    public TelaItensRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
        this.itens = relatorio.getItensRelatorio();
        initComponents();
        carregarItens();
        carregarTabela();
        this.editando = true;
    }
    private void carregarTabela() {
        DefaultTableModel tabelinha = (DefaultTableModel) tabela.getModel();
        if(itens == null) {
            return;
        }
        for(ItemComida item : itens) {
            if(item == null) {
                continue;
            }
            tabelinha.addRow(new Object[] {item.tipoItem, item.entrada,item.saida, item.unidade});
        }
    }
    private void carregarItens(){
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) tipoItem.getModel();
        //modelo.addElement("thiago");
        ArrayList<String> itens = new ArrayList();
        itens=banco.pegarItensDoCardapio();
        modelo.removeAllElements();
        for(int i=0;i<itens.size();i++)
        {
            modelo.addElement(itens.get(i));
        }
    }
    
    private void criaLista() {
       this.tipoItem.removeAll();
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
        entradaItem = new javax.swing.JTextField();
        unidadeItem = new javax.swing.JComboBox<>();
        AdicionarParaALista = new javax.swing.JButton();
        voltarAoMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        novoItem = new javax.swing.JTextField();
        AdicionarItens = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        saidaItem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        criaLista();
        tipoItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Item" }));
        tipoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoItemActionPerformed(evt);
            }
        });

        unidadeItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "g", "Kg", "Uni.", "Duz.", " " }));

        AdicionarParaALista.setText("+");
        AdicionarParaALista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarParaAListaActionPerformed(evt);
            }
        });

        voltarAoMenu.setText("Fim");
        voltarAoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarAoMenuActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Entrada", "Saida", "Unidade", "Excluir"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        AdicionarItens.setText("Adicionar");
        AdicionarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarItensActionPerformed(evt);
            }
        });

        jLabel1.setText("Adicionar novo tipo de Item");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarAoMenu))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(novoItem, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(AdicionarItens))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tipoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(entradaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saidaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)))
                                .addComponent(unidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AdicionarParaALista))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {entradaItem, saidaItem});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entradaItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unidadeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarParaALista)
                    .addComponent(saidaItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdicionarItens))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(voltarAoMenu))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private void criaItensLista() {
        DefaultTableModel tabelinha = (DefaultTableModel) tabela.getModel();
        for(int i = 0; i < tabelinha.getRowCount(); i++) {
            String item = tabelinha.getValueAt(i, 0).toString();
<<<<<<< HEAD
            int entrada = Integer.parseInt(tabelinha.getValueAt(i,1).toString());
            int saida = Integer.parseInt(tabelinha.getValueAt(i,2).toString());
            String unidade = tabelinha.getValueAt(i, 3).toString();
            this.itens.add(new ItemComida(item, entrada,saida , unidade));
=======
            int quant = Integer.parseInt(tabelinha.getValueAt(i,1).toString());
            String unidade = tabelinha.getValueAt(i, 2).toString();
>>>>>>> parent of 3412fc2... modificações do joyce
        }
    }
    private void voltarAoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarAoMenuActionPerformed
        // TODO add your handling code here:
        
        // aqui tem que colocar pra pegar o que ta na tabela e jogar pro banco
        if(!this.editando) {
            criaItensLista();
            this.relatorio = new Relatorio (this.cardapio.getMes(), this.cardapio.getAno(),this.nomeRel, 
                                            TelaPrincipal.escolaAtual, this.cardapio, this.capa, itens);
            TelaPrincipal.usuarioLogado.relatorioCorrente = this.relatorio;
            BdManager.adicionarRelatorio(this.relatorio);
            
        }
        else
        {
            System.out.println("alterando relatorio");
            BdManager.alterarRelatorio(this.relatorio);
        }
        principal=new TelaPrincipal();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        principal.setResizable(true);
        this.setVisible(false);
    }//GEN-LAST:event_voltarAoMenuActionPerformed

    private void AdicionarParaAListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarParaAListaActionPerformed
        if(tipoItem.getSelectedItem()!="Selecione o Item" && !entradaItem.getText().equals(""))
        {
            DefaultTableModel tabelinha = (DefaultTableModel) tabela.getModel();
            tabelinha.addRow(new Object[] {tipoItem.getSelectedItem(), entradaItem.getText(),saidaItem.getText(), unidadeItem.getSelectedItem()});
            String nome = tipoItem.getSelectedItem().toString();
            int entrada = Integer.parseInt(entradaItem.getText());
            int saida = Integer.parseInt(saidaItem.getText());
            String unidade = unidadeItem.getSelectedItem().toString();
            ItemComida item = new ItemComida(tipoItem.getSelectedItem().toString(), Integer.parseInt(entradaItem.getText()),Integer.parseInt(saidaItem.getText()), unidadeItem.getSelectedItem().toString());
            this.itens.add(item);
        }
    }//GEN-LAST:event_AdicionarParaAListaActionPerformed

    private void AdicionarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarItensActionPerformed
        
        String newItem = novoItem.getText();
        if(banco.VerificarItemExistente(newItem)) // retorna true se o item ja existe
        {
            novoItem.setText("");
            JOptionPane.showMessageDialog(null,"Esse item já existe na Lista, procure-o na lista acima :3");
        }
        else
        {
            banco.AdicionarItemListaCardapio(newItem);
            carregarItens();
            novoItem.setText("");
            JOptionPane.showMessageDialog(null,"Item adicionado com sucesso :3");
        }
        
        
    }//GEN-LAST:event_AdicionarItensActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarItens;
    private javax.swing.JButton AdicionarParaALista;
    private javax.swing.JTextField entradaItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField novoItem;
    private javax.swing.JTextField saidaItem;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox<String> tipoItem;
    private javax.swing.JComboBox<String> unidadeItem;
    private javax.swing.JButton voltarAoMenu;
    // End of variables declaration//GEN-END:variables
}
