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
import model.bean.Remanejamento;

/**
 *
 * @author joaof
 */
/*public class RemanejamentoDAO {

    public void create(Remanejamento re){
        
        Connection con = ConnectionClass.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Remanejamento(Data, Motivo, Recebido, Cedido)VALUES(?,?,?,?)");
            //stmt.setData(1, re.getData());
            stmt.setString(2, re.getMotivo());
            stmt.setDouble(3, re.getRecebido());
            stmt.setDouble(4, re.getCedido());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" +ex);
        }finally{
            ConnectionClass.closeConnection(con, stmt);
        }
    }
    
}
*/