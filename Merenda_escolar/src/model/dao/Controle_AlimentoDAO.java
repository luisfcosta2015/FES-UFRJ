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
import model.bean.Controle_Alimento;

/**
 *
 * @author joaof
 */
/*public class Controle_AlimentoDAO {
    
    public void create(Controle_Alimento ca){
        
        Connection con = ConnectionClass.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Controle_Alimento (Modalidade, Alunos_Matric, Alunos_Atendidos, Total_Ref_Servidas)VALUES(?,?,?,?)");
            stmt.setString(1, ca.getModalidade());
            stmt.setInt(2, ca.getAlunos_Matric());
            stmt.setInt(3, ca.getAlunos_Atendidos());
            stmt.setInt(4, ca.getTotal_Ref_Servidas());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar:" +ex);
        }finally{
            ConnectionClass.closeConnection(con, stmt);
        }
    }
    
}*/
