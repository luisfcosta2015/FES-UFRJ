/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javax.swing.JOptionPane;
/**
 *
 * @author Cliente
 */
public class TelaCardapio extends javax.swing.JFrame {

    /**
     * Creates new form Cardapio
     */
    private boolean editando;
    Calendario calendario;
    Cardapio cardapio;
    CapaDados capa;
    TelaPrincipal principal;
    TelaItensRelatorio itensRel;
    int ano;
    int mes;
    DefaultTableModel tabelinha;
    ArrayList<Date>datasExcluidas;
    Relatorio relatorio;
    // Collection of items currently selected via checkboxes in the table 
    // This will be passed to the TableCell implementation.
    // ObservableSet<Object> selectedItems = FXCollections.observableSet();

    //mes de 0 a 11
    public TelaCardapio(int ano, int mes, CapaDados capa) {
        initComponents();
        this.capa = capa;
        this.ano = ano;
        this.mes = mes;
        DateFormat df = new SimpleDateFormat("dd/MM");
        
        tabelinha = (DefaultTableModel) tabela.getModel();
        
        calendario = new Calendario(mes,ano);
        ArrayList<Date> dias = calendario.getList();
        for(Date data : dias)
        {
            Object[] dado = {df.format(data),"","Excluir"};
            tabelinha.addRow(dado);
        }
        setListenerExcluir();
    }
    
    /**
     * Creates new form TelaEditaCardapio
     */
    public TelaCardapio(Relatorio relatorio) {
        initComponents();
        this.editando = true;
        this.relatorio = relatorio;
        this.cardapio = relatorio.getCardapioRelatorio();
        tabelinha = (DefaultTableModel) tabela.getModel();
        DateFormat df = new SimpleDateFormat("dd/MM");
        ArrayList<DuplaDataCardapio> cardapioList = cardapio.getList();
        for(DuplaDataCardapio dupla : cardapioList) {
            Object[] obj = new Object[3];
            obj[0] = df.format(dupla.data);
            if(dupla.cardapioDoDia != null ) {
                obj[1] = dupla.cardapioDoDia;
            }
            else {
                obj[1] = "";
            }
            obj[2]="Excluir";
            tabelinha.addRow(obj);
        }
        setListenerExcluir();
    }
    private void setListenerExcluir() {
        this.tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            
            int row = tabela.rowAtPoint(evt.getPoint());
            int col = tabela.columnAtPoint(evt.getPoint());
            if (row >= 0 && col == 2) {
                int input = JOptionPane.showConfirmDialog(null, 
                "Esta ação irá excluir esta data da lista", 
                "Deseja prosseguir?",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(input == JOptionPane.NO_OPTION || input == JOptionPane.CANCEL_OPTION || input == JOptionPane.CLOSED_OPTION) {
                    return;
                }
                try {
                    DateFormat df = new SimpleDateFormat("dd/MM");
                    Date data = df.parse(tabelinha.getValueAt(row, 0).toString());
                    System.out.println(data);
                    if(editando)
                    {
                       cardapio.remove(findExistingDate(data));
                    }
                    else
                    {
                        calendario.remove(findExistingDate(data));
                    }
                    
                    tabelinha.removeRow(row);
                }
                catch(ParseException e) {
                    System.out.println(e);
                }
                
            }
        }});
        this.tabela.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
    }
    
    public Date findExistingDate(Date data){
        if(this.editando)
        {
            for(DuplaDataCardapio dc : this.cardapio.getList()) {
                if(dc.data.getDate() == data.getDate())
                {
                    return dc.data;
                }
            }
        }
        else
        {
            for(Date dt : this.calendario.getList()) {
                if(dt.getDate() == data.getDate())
                {
                    return dt;
                }
            }
        }
        return null;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        proxButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        diaAdicionar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Adicionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Cardapio", "Excluir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabelaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        proxButton.setText("Próximo");
        proxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("excluir elemento");

        jLabel4.setText("Dia");

        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(proxButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(Adicionar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(proxButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(Adicionar))))
                .addGap(0, 101, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 30)); // NOI18N
        jLabel1.setText("Cardápio");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("voltar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabelaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPropertyChange

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        /*principal=new TelaPrincipal();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        principal.setResizable(true);
        this.setVisible(false);*/
    }//GEN-LAST:event_jLabel2MouseClicked

    private void proxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxButtonActionPerformed
        // salva de alguma forma o que foi feito
        if(this.editando) {
            for(int i=0; i < this.tabelinha.getRowCount(); i++) {
                this.cardapio.setCardapio(i, ""+ this.tabelinha.getValueAt(i, 1));
            }   
            itensRel = new TelaItensRelatorio(this.relatorio);
            itensRel.setLocationRelativeTo(null);
            itensRel.setVisible(true);
            itensRel.setResizable(true);
            this.dispose();
            return;
        }
        cardapio = new Cardapio(calendario);
        for(int i=0; i < this.tabelinha.getRowCount(); i++) {
            if(this.tabelinha.getValueAt(i, 1) != null) {
                cardapio.setCardapio(i, this.tabelinha.getValueAt(i, 1).toString());
            }
        }
        itensRel = new TelaItensRelatorio("Relatorio " + (this.mes + 1) + "/" + this.ano, this.capa, this.cardapio);
        itensRel.setLocationRelativeTo(null);
        itensRel.setVisible(true);
        itensRel.setResizable(true);
        this.setVisible(false);
    }//GEN-LAST:event_proxButtonActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        // TODO add your handling code here:
        if(this.diaAdicionar.getText() == null || this.diaAdicionar.getText() == "" || 
           Integer.parseInt(this.diaAdicionar.getText()) <= 0 || Integer.parseInt(this.diaAdicionar.getText()) > 31) {
            return;
        }
        int pos = 0;
        Date data = new Date(this.ano, this.mes, Integer.parseInt(this.diaAdicionar.getText()));
        if(this.editando) {
            
            pos = this.cardapio.adicionar(data);
            System.out.println(this.cardapio.getList().get(pos).data);
            System.out.println(data);
            
        }
        
        else{
            pos = this.calendario.adicionar(data);
        }
        if(pos!=-1)
        {
            adicionarNaTabela(data,pos);
            System.out.println(this.tabelinha.getRowCount());
            System.out.println(this.cardapio.getList().size());
            
            
        }
// caso nao esteja editando ele preenche o campo cardapio do relatorio no action performed do proximo, entao nao
        //precisa atualizar ArrayList nenhum, apenas inserir a linha na posição desejada
    }//GEN-LAST:event_AdicionarActionPerformed

    private void adicionarNaTabela(Date data, int pos){
        DateFormat df = new SimpleDateFormat("dd/MM");
        System.out.println("AAA");
        this.tabelinha.insertRow(pos, new Object[]{df.format(data),"","Exluir"});
        System.out.println("BBB");
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JTextField diaAdicionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proxButton;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
