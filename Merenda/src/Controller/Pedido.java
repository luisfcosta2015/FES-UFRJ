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
 * @author w1n3
 */
public class Pedido {
    private int id, id_instituicao;
    private String data;
    
    // variavel usada pra sinalizar se o pedido que está carregado já foi cadastrado ou não
    private boolean carregado = false;
    
    public boolean cadastrar(){
        
        String query = "INSERT INTO pedido (id, id_instituicao, data) VALUES";
        query += "(" + getId() +"," + getId_instituicao() + ",\'" + getData()+ "\')" ;
        
        return carregado = new Conexao().query_update(query);
        
    }
    
    // ISSO DEVERIA SER UMA TRANSACTION PRA CADASTRAR OU TUDO OU NADA
    public boolean cadastraLotes(List<Lote> lst){
        if (!carregado) return false;
        
        boolean sucesso = true;
        for (int i = 0; i < lst.size(); i++){ 
            lst.get(i).setId_pedido(getId());
            sucesso = sucesso && lst.get(i).cadastrar();
        }
        
        return sucesso;    
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
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
