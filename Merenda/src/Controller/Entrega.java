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
 * @author Andre
 */
public class Entrega {
    private int id_pedido;
    private String data_entrega, fornecedor;
    
    // TODO: SER TRANSACTION
    public boolean cadastrar(int id_instituicao){        
        Conexao conn = new Conexao();
        String query = "INSERT INTO entrega (id_pedido, data_entrega, fornecedor) VALUES";
        query += "(" + getId_pedido() + ",\'" +  getData_entrega() + "\',\'" + getFornecedor()+ "\')" ;
        System.out.println(query);
        
        // se deu ruim já sai fora
        if (!conn.query_update(query)) return false; 
        
        Pedido p = new Pedido();
        p.setId(getId_pedido());
        List<Map<String,Object>> lst = p.consultaLotes();
        boolean sucesso = true;
        for (int i = 0; i < lst.size(); i++){
            Entrada e = new Entrada();
            e.setId_alimento((int)lst.get(i).get("id_alimento"));
            e.setData(getData_entrega());
            e.setId_instituicao(id_instituicao);
            e.setQtd_alimento((int)lst.get(i).get("qtd_alimento"));
            sucesso = sucesso && e.cadastrar();
        }        
        
        return sucesso;     
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
