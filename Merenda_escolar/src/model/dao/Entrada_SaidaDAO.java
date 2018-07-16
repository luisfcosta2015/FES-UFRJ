/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import SQLConnect.ConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Entrada_Saida;

/**
 *
 * @author joaof
 */
/*public class Entrada_SaidaDAO {
    
    public void create(Entrada_Saida es){
        
        Connection con = ConnectionClass.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Entrada_Saida (Data, Entrada, Saida)VALUES(?,?,?)");
            //stmt.setString(1, es.getData());
            stmt.setDouble(2, es.getEntrada());
            stmt.setDouble(3, es.getSaida());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" +ex);
        }finally{
            ConnectionClass.closeConnection(con, stmt);
        }
    }
    
}*/
