/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Auxiliar;
import Model.Conexao;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andre
 */
public class TipoConta {
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
    
    /*
    public void popular(Map<String, Object> m){
        setId((int)m.get("id"));
        setDescricao( String.valueOf(m.get("descricao")));
    }
    */
    Auxiliar.PreencheDados preenche_dados = (m) -> {
        setId((int)m.get("id"));
        setDescricao( String.valueOf(m.get("descricao")));
    };
    
    public boolean tipoContaPorId(int id){
        
        String query = "SELECT * FROM tipo_conta t where t.id=" + id;
        
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    }
}
