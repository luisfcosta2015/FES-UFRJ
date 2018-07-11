/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author w1n3
 */
public class Pedido {
    private int id, id_instituicao;
    private String data;
    
    // TODO: Ser Transaction
    public boolean cadastrar(){
        
        Conexao conn = new Conexao();
        String query = "INSERT INTO pedido (id_instituicao, data) VALUES";
        query += "(" + getId_instituicao() + ",\'" + getData()+ "\')" ;
        boolean sucesso = conn.query_update(query);
        if (!sucesso) return false;
        
        query = "SELECT max(id) as id FROM pedido;";
        List<Map<String,Object>> lst = conn.query_select(query);
        if (lst.isEmpty()) return false;
        //System.out.println(lst.get(0).get("id"));
        this.setId((int)lst.get(0).get("id"));        
        
        return true;
        
    }
    
    // TODO: SER UMA TRANSACTION PRA CADASTRAR OU TUDO OU NADA
    public boolean cadastraLotes(List<LotePedido> lst){        
        boolean sucesso = true;
        for (int i = 0; i < lst.size(); i++){ 
            lst.get(i).setId(getId());
            sucesso = sucesso && lst.get(i).cadastrar();
        }        
        return sucesso;    
    }
    
    public List<Map<String,Object>> consultaLotes(){
        
        Conexao conn = new Conexao();
        String query = "SELECT lp.id_alimento, (select a.nome from alimento a where a.id = lp.id_alimento) as alimento, lp.qtd_alimento "
                + "FROM lote_pedido lp where lp.id=" + getId();
        
        return conn.query_select(query);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(int id_instituicao) {
        this.id_instituicao = id_instituicao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }   
    
}
