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
public class Consultas {
    
    
    public List<Map<String,Object>> ContasPorInstituicao(String inst){
        int id;        
        if (!Auxiliar.isNumeric(inst)){
            Instituicao i = new Instituicao();
            if (!i.instituicaoPorNome(inst)) return null;
            id = i.getId();
        } else {
            id = Integer.valueOf(inst);            
        }
        
        String query = "select p.nome, t.descricao, c.matricula, c.usuario" +
            " from conta c, instituicao i, pessoa p, tipo_conta t" +
            " where p.id=c.id_pessoa and i.id=c.id_instituicao and t.id=c.id_tipo_conta and i.id=" + id;
        List<Map<String,Object>> lst = new Conexao().query_select(query);
        
        return lst;
    }
    public List<Map<String,Object>> EntradaPorData(String inst, String data1){
        int id;        
        if (!Auxiliar.isNumeric(inst)){
            Instituicao i = new Instituicao();
            if (!i.instituicaoPorNome(inst)) return null;
            id = i.getId();
        } else {
            id = Integer.valueOf(inst);            
        }
        String query = "select (select nome from alimento a where a.id=e.id_alimento) as alimento"
                + ", e.qtd_alimento from entrada e where e.id_instituicao="+inst
                + " and e.data=\'"+data1+"\'";
        List<Map<String,Object>> lst = new Conexao().query_select(query);
        
        return lst;
    }
    
    public List<Map<String,Object>> SaidaPorData(String inst, String data1){
        int id;        
        if (!Auxiliar.isNumeric(inst)){
            Instituicao i = new Instituicao();
            if (!i.instituicaoPorNome(inst)) return null;
            id = i.getId();
        } else {
            id = Integer.valueOf(inst);            
        }
        
        String query = "select (select nome from alimento a where a.id=s.id_alimento) as alimento"
                + ", s.qtd_alimento from saida s where s.id_instituicao="+inst
                + " and s.data=\'"+data1+"\'";
        List<Map<String,Object>> lst = new Conexao().query_select(query);
        
        return lst;
    }
    
    
    
    
    
    
    
}
