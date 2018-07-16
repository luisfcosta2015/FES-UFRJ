/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lucca
 */
public class PopupGerarRelController implements Initializable {

    @FXML
    private Button gerarBtn;
    
    @FXML
    private Button fecharBtn;
    
    @FXML 
    private AnchorPane background;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
    
    public void fecharAct(){
        Stage stage = (Stage) fecharBtn.getScene().getWindow();

        stage.close();
    }
    
    public void gerarAct(){
    }
    
    
    public void addInsertField(String Label, int idx){
        TextField txt = new TextField();

        AnchorPane.setTopAnchor(txt, 50.0 + idx*30.0);
        AnchorPane.setRightAnchor(txt, 100.0);
        Label l1 = new Label(Label+":");
        AnchorPane.setTopAnchor(l1, 53.0 + idx*30.0);
        AnchorPane.setRightAnchor(l1, 280.0);
        background.getChildren().addAll(txt, l1);        
    }
    
    public void setParams(Map<String, String> params){
        
        try{
            int count = 0;
            for (String i : params.keySet()){
                addInsertField(i, count++);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
}
