/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merenda;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author andrecsq
 */
public class Merenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login tela = new Login();
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        tela.setLocation(dim.width/2-tela.getSize().width/2, dim.height/2-tela.getSize().height/2);
        tela.setVisible(true);
    }
    
}
