/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexao;

/**
 *
 * @author Andre
 */
public class LotePedido extends Lote{
    
    public boolean cadastrar(){
        
        String query = "INSERT INTO lote_pedido (id, id_alimento, qtd_alimento) VALUES";
        query += "(" + getId()+", " + getId_alimento()+ "," + getQtd_alimento()+ ")" ;
        
        return new Conexao().query_update(query);
    }

}
