package Controller;

import Model.Conexao;
import java.util.List;
import java.util.Map;


public class LoteEstoque extends Lote{
        
    public boolean cadastrar_entrada(){
        Conexao conn = new Conexao();
        String query = "SELECT * FROM lote_estoque le where le.id=" + getId()
            + " and le.id_alimento=" + getId_alimento();
        List<Map<String, Object>> lst = conn.query_select(query);
        
        //System.out.println(lst.get(0));
        
        // se não tiver nenhum já cadastrado
        if (lst.isEmpty()){        
            query = "INSERT INTO lote_estoque (id, id_alimento, qtd_alimento) VALUES";
            query += "(" + getId()+", " + getId_alimento()+ "," + getQtd_alimento()+ ")" ;
            return conn.query_update(query);
        // se já tiver cadastrado, apenas atualiza. soma o qtd_alimento
        } else {
            // que Deus me perdoe por ter feito essa gambiarra
            int novo = Integer.parseInt(String.valueOf(lst.get(0).get("qtd_alimento")));
            novo += getQtd_alimento();
            query = "UPDATE lote_estoque SET qtd_alimento=" + novo
            + " WHERE id=" + getId() + " AND id_alimento=" + getId_alimento();   
            return conn.query_update(query);
        }        
    }
    
     public boolean cadastrar_saida(){
        Conexao conn = new Conexao();
        String query = "SELECT * FROM lote_estoque le where le.id=" + getId()
            + " and le.id_alimento=" + getId_alimento();
        List<Map<String, Object>> lst = conn.query_select(query);
        
        //System.out.println(lst.get(0));
        
        // se não tiver nenhum já cadastrado
        if (lst.isEmpty()){        
            return false;
        // se já tiver cadastrado, apenas atualiza. soma o qtd_alimento
        } else {
            // que Deus me perdoe por ter feito essa gambiarra
            int novo = Integer.parseInt(String.valueOf(lst.get(0).get("qtd_alimento")));
            novo -= getQtd_alimento();
            // QUANDO O BAGULHO FICA NEGATIVO
            if (novo < 0) return false;
            query = "UPDATE lote_estoque SET qtd_alimento=" + novo
            + " WHERE id=" + getId() + " AND id_alimento=" + getId_alimento();   
            return conn.query_update(query);
        }        
    }
     
     public List<Map<String,Object>> carregarEstoque(int id_instituicao){
         Conexao conn = new Conexao();
        String query = "SELECT (select a.nome from alimento a where a.id = le.id_alimento) as alimento, le.qtd_alimento "
                + "FROM lote_estoque le where le.id=" + id_instituicao;
        
        return conn.query_select(query);
     }
    
}
