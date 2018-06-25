/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author lucca
 */
public class DeslizadorMiniaturasController implements Initializable {
    
    @FXML
    private HBox listaMiniaturas;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    /*
        miniaturas: Uma lista que define o título da miniatura e o evento que irá ocorrer ao pressionar
                    a miniatura.    
    */
    public void setMiniaturas(List< Pair< String,EventHandler<? super MouseEvent> > > miniaturas){
        listaMiniaturas.setSpacing(10);
        
        try {
            for(Pair<String, EventHandler<? super MouseEvent> > miniatura : miniaturas){
                String title = miniatura.getKey();
                EventHandler<? super MouseEvent> evento = miniatura.getValue();
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/FMF/views/Miniatura.fxml"));
                Pane p1 = (Pane) loader1.load();
                MiniaturaController mini1 = loader1.<MiniaturaController>getController();
                mini1.setTitle(title);
                p1.setOnMousePressed(evento);
                listaMiniaturas.getChildren().add(p1);
            }            
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    /*
    botaoNovo : caso queira adicionar um botão ao final, esse método irá definí-lo e passar o EventHandler
    */
    public void setMiniaturas(List< Pair< String,EventHandler<? super MouseEvent> > > miniaturas, EventHandler<? super MouseEvent> botaoNovo){
        this.setMiniaturas(miniaturas);
        try {
            EventHandler<? super MouseEvent> evento = botaoNovo;
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/FMF/views/Miniatura.fxml"));
            Pane p1 = (Pane) loader1.load();
            MiniaturaController mini1 = loader1.<MiniaturaController>getController();
            p1.setOnMousePressed(evento);
            listaMiniaturas.getChildren().add(p1);            
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    
}
