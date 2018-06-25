/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author lucca
 */
public class MiniaturaController implements Initializable {

    @FXML
    private Text titulo;

    @FXML
    private Text addRel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setTitle(String txt){
        titulo.setText(txt);
        addRel.setVisible(false);
    }
    
}
