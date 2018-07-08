/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author w1n3
 */
public class ModeloLote {
    private int id;
    private int id_alimento;
    private float preco;
    private int qtd_alimento;
    private Date data_validade;
    
    public ModeloLote() {
        this.id = 0;
        this.id_alimento = 0;
        this.preco = 0;
        this.qtd_alimento = 0;
        this.data_validade = new Date();
    }
    
    public boolean criar() {
        String query = "INSERT INTO lote (id, id_alimento, preco, qtd_alimento, data_validade) VALUES";
        query += "(" + this.get_id() + ", ";
        query += this.get_id_alimento() + ", ";
        query += this.get_preco() + ", ";
        query += this.get_qtd_alimento() + ", ";
        query += "\'"+ new SimpleDateFormat("dd/MM/yyyy").format(this.get_data_validade()) + "\')";

        return new Conexao().query_update(query);
    }
    
    // Popula a classe a partir de um Map
    Auxiliar.PreencheDados preenche_dados = (m) -> {
        this.set_id((int)m.get("id"));
        this.set_id_alimento((int)m.get("id_alimento"));
        this.set_preco((float)m.get("preco"));
        this.set_qtd_alimento((int)m.get("qtd_alimento"));
        this.set_data_validade(new Date(String.valueOf(m.get("data_validade"))));
    };
    
    public boolean consultar_do_cadastro_lote(String nome_alimento, int qtd_alimento, String data_de_validade, float preco) {
        String query;
        /*query = "select l.* from lote l inner join alimento a on l.id_alimento = a.id where a.nome like \'%"+
                nome_alimento+"%\' or l.qtd_alimento="+qtd_alimento+
                " or l.data_validade=\'"+data_de_validade+"\' or preco=\'"+preco+"\'";
        */
        query = "select l.* from lote l";
        
        if(!nome_alimento.equals("")) {
            query += " inner join alimento a on l.id_alimento = a.id where a.nome=\'"+nome_alimento+"\'" ;
        }
        if(qtd_alimento != 0 && !nome_alimento.equals("")) {
            query += " or l.qtd_alimento="+qtd_alimento;
        }
        else if(qtd_alimento != 0 && nome_alimento.equals("")) {
            query += " where l.qtd_alimento="+qtd_alimento;
        }
        else if(qtd_alimento != 0 && !data_de_validade.equals("") && (new Date()).compareTo(new Date(data_de_validade)) < 0) {
            query += " or l.data_validade=DATE(\'"+data_de_validade+"\')";
        }
        // consertar esta merda de IllegalArgumentException em algum momento
        else if(qtd_alimento == 0 && data_de_validade.equals("") && (new Date()).compareTo( new Date(data_de_validade)) >= 0) {
            query += " where l.data_validade=DATE(\'"+data_de_validade+"\')";
        }
        else if(!data_de_validade.equals("") && new Date().compareTo(new Date(data_de_validade)) >= 0 && preco != 0.0) {
            query += " or l.preco="+Float.toString(preco);
        }
        else if(data_de_validade.equals("") && new Date().compareTo(new Date(data_de_validade)) < 0 && preco != 0.0) {
            query += " or l.preco="+Float.toString(preco);
        }
        
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    }
    
    public boolean atualizar() {
        String query = "UPDATE lote SET"
                + " id_alimento=\'" + this.get_id_alimento() + "\'"
                + ", preco=\'" + this.get_preco()+ "\'"
                + ", qtd_alimento=\'" + this.get_qtd_alimento()+ "\'"
                + ", data_validade=\'" + new SimpleDateFormat("dd/MM/yyyy").format(this.get_data_validade()) + "\'"
                + " WHERE id=" + this.get_id();
        
        return new Conexao().query_update(query);
    }
    public boolean excluir() {
        String query = "DELETE FROM lote WHERE id=" + this.get_id();
        
        return new Conexao().query_update(query);
    }
    
    public void set_id(int novo_id) {
        this.id = novo_id;
    }
    public int get_id() {
        return this.id;
    }
    public void set_id_alimento(int novo_id_alimento) {
        this.id_alimento = novo_id_alimento;
    }
    public int get_id_alimento() {
        return this.id_alimento;
    }
    public void set_preco(float novo_preco) {
        this.preco = novo_preco;
    }
    public float get_preco() {
        return this.preco;
    }
    public void set_qtd_alimento(int novo_qtd_itens) {
        this.qtd_alimento = novo_qtd_itens;
    }
    public int get_qtd_alimento() {
        return this.qtd_alimento;
    }
    public void set_data_validade(Date novo_data_validade) {
        this.data_validade = novo_data_validade;
    }
    public Date get_data_validade() {
        return this.data_validade;
    }
}
