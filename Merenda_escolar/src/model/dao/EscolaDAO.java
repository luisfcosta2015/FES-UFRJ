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
import model.bean.Escola;

/**
 *
 * @author joaof
 */
/*public class EscolaDAO {
       
     public void create(Escola e){
        
        Connection con = ConnectionClass.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Escola (Nome, Endereco, Telefone, Diretor)VALUES(?,?,?,?)");
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getEndereco());
            stmt.setString(3, e.getTelefone());
            stmt.setString(4, e.getDiretor());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" +ex);
        }finally{
            ConnectionClass.closeConnection(con, stmt);
        }
    }
    
}*/
