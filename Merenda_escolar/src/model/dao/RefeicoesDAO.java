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
import model.bean.Refeicoes;

/**
 *
 * @author joaof
 */
/*public class RefeicoesDAO {

    public void create(Refeicoes r){
        
        Connection con = ConnectionClass.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Refeicoes (Desjejum, Almoco, Sobremesa, Mais)VALUES(?,?,?,?)");
            stmt.setString(1, r.getDesjejum());
            stmt.setString(2, r.getAlmoco());
            stmt.setString(3, r.getSobremesa());
            stmt.setString(4, r.getMais());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" +ex);
        }finally{
            ConnectionClass.closeConnection(con, stmt);
        }
    }
    
}*/
