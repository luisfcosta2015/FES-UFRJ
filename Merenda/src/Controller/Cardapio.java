/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Auxiliar;
import Model.Conexao;

/**
 *
 * @author Andre
 */
public class Cardapio {
    int id_cardapio, id_instituicao;
    String data_cardapio, lanche_manha, almoco, lanche_tarde, janta;
    
    
    public String validar(){
        String erros = "";
        
        // só valida o id_instituicao e data     
        
        if (getId_instituicao() <= 0)
            erros += "Instituição inválida\n";
        
        if (!getData_cardapio().equals(""))
            erros += "Data inválida\n";   
        
        return erros;
    }
    
    public boolean cadastrar(){
        
        String query = "INSERT INTO cardapio (id_instituicao, data_cardapio, lanche_manha, almoco, lanche_tarde, janta) VALUES";
        query += "("+ getId_instituicao()+", " + "\'" + getData_cardapio() + "\'," + Auxiliar.nullOrQuotes(getLanche_manha()) + "," + Auxiliar.nullOrQuotes(getAlmoco());
        query += "," + Auxiliar.nullOrQuotes(getLanche_tarde()) + "," + Auxiliar.nullOrQuotes(getJanta()) +")" ;
        
        return new Conexao().query_update(query);
    }
    
    Auxiliar.PreencheDados preenche_dados = (m) -> {
        /* exemplo de como fazer essa função lambda
        setId_alimento((int)m.get("id"));
        setQtd_atende((int)m.get("qtd_atende"));
        setNome(String.valueOf(m.get("nome")));
        setPerecivel((int)m.get("perecivel") != 0);        
        setMarca(String.valueOf(m.get("marca")));
        setFornecedor(String.valueOf(m.get("fornecedor")));
        setMedida(String.valueOf(m.get("medida")));
        */
    };
    
    public boolean consultar_por_x(int x) {
        String query = /* formata a query e manda bala */"" ;
        
        return Auxiliar.consulta_e_preenche(query, preenche_dados);
    }

    public int getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(int id_instituicao) {
        this.id_instituicao = id_instituicao;
    }

    public int getId_cardapio() {
        return id_cardapio;
    }

    public void setId_cardapio(int id_cardapio) {
        this.id_cardapio = id_cardapio;
    }

    public String getData_cardapio() {
        return data_cardapio;
    }

    public void setData_cardapio(String data_cardapio) {
        this.data_cardapio = data_cardapio;
    }

    public String getLanche_manha() {
        return lanche_manha;
    }

    public void setLanche_manha(String lanche_manha) {
        this.lanche_manha = lanche_manha;
    }

    public String getAlmoco() {
        return almoco;
    }

    public void setAlmoco(String almoco) {
        this.almoco = almoco;
    }

    public String getLanche_tarde() {
        return lanche_tarde;
    }

    public void setLanche_tarde(String lanche_tarde) {
        this.lanche_tarde = lanche_tarde;
    }

    public String getJanta() {
        return janta;
    }

    public void setJanta(String janta) {
        this.janta = janta;
    }
    
    
    
}
