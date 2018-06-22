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
public class Funcao {
    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }     
    
    public void popular(Map<String, Object> m){
        setId((int)m.get("id"));
        setDescricao( String.valueOf(m.get("descricao")));
    }
    
    public boolean funcaoPorId(int id){
        
        String query = "SELECT * FROM funcao f where f.id=" + id;
        
        Conexao con = new Conexao();
        
        List<Map<String, Object>> lst = con.query_select(query);
        if (lst.size() == 1){
            popular(lst.get(0));
            return true;
        } else {
            return false;
        }   
    }
}
