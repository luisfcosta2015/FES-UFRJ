/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import FMF.models.Relatorio;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.util.Pair;

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
    
    private Relatorio escolhido;
    
    private List<Pair<String, TextField> > preenchidos= new ArrayList<Pair<String, TextField>>();
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
    
    public void fecharAct(){
        Stage stage = (Stage) fecharBtn.getScene().getWindow();

        stage.close();
    }
    
    public void gerarAct(){
        Map<String, String> resultado = new HashMap<String, String>();
        for(Pair<String, TextField> i: preenchidos){
            resultado.put( i.getKey(), i.getValue().getText());
        }
        escolhido.geraPDFPreenchido(resultado);

        Stage stage = (Stage) fecharBtn.getScene().getWindow();

        stage.close();
        
    }
    
    
    public void addInsertField(String Label, int idx){
        TextField txt = new TextField();
        preenchidos.add(new Pair<String, TextField>(Label, txt));
        
        AnchorPane.setTopAnchor(txt, 50.0 + idx*30.0);
        AnchorPane.setRightAnchor(txt, 100.0);
        Label l1 = new Label(Label+":");
        AnchorPane.setTopAnchor(l1, 53.0 + idx*30.0);
        AnchorPane.setRightAnchor(l1, 280.0);
        background.getChildren().addAll(txt, l1);        
    }
    
    public void setParams(Map<String, String> params, Relatorio esc){
        this.escolhido = esc;
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
