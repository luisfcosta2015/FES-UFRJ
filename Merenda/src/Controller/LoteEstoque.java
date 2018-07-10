package Controller;

import Model.Conexao;


public class LoteEstoque extends Lote{
    
    public boolean cadastrar(){
        
        String query = "INSERT INTO lote_estoque (id_pedido, id_alimento, qtd_alimento) VALUES";
        query += "(" + getId_pedido()+", " + getId_alimento()+ "," + getQtd_alimento()+ ")" ;
        
        return new Conexao().query_update(query);
    }
    
}
