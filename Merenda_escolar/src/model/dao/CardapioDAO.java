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
import model.bean.Cardapio;

/**
 *
 * @author joaof
 */
/*public class CardapioDAO {
    
    public void create(Cardapio c){
        
        Connection con = ConnectionClass.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Cardapio(Data)VALUES(?)");
            //Arrumar aqui para o tipo data
            //stmt.setDate(1, c.getData());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" +ex);
        }finally{
            ConnectionClass.closeConnection(con, stmt);
        }
    }
    
}*/
