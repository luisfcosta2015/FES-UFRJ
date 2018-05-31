/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author matheus
 */
public class CriarNovoRelController implements Initializable {

    @FXML
    private AnchorPane background;
    
    @FXML
    private Button confirmabtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void voltarAct() throws IOException{ //estou voltando a tela anterior (CriarEditarRel.fxml)
        AnchorPane x = (AnchorPane) FXMLLoader.load(getClass().getResource("/FMF/views/CriarEditarRel.fxml"));
        background.getChildren().setAll(x);
    }
    
    public void confirmaAct(){
        //TODO
        System.out.println("TODO");
        
    }
    
}
