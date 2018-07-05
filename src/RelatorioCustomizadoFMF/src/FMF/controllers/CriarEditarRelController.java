/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import FMF.models.Modelo;
import FMF.models.Relatorios;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author matheus
 */
public class CriarEditarRelController implements Initializable {
    
    @FXML
    private AnchorPane background;
    @FXML
    private Button editarCriarbtn;
    
    boolean flag;
    /**
     * Initializes the controller class.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Relatorios relatorios = new Relatorios();
        
        List<Pair< String,EventHandler<? super MouseEvent> > > miniaturas = new ArrayList<>();
        
        for(Modelo modelo:relatorios.getModelos()){
            miniaturas.add(new Pair<>(modelo.getNome(), new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        editarCriarbtn.setText("Editar : " + modelo.getNome());
                        flag=false;
                    }
            }));
        }
        
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FMF/views/DeslizadorMiniaturas.fxml"));
            ScrollPane SP = (ScrollPane) loader.load();
            DeslizadorMiniaturasController deslizador = loader.<DeslizadorMiniaturasController>getController();
            deslizador.setMiniaturas(miniaturas, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        editarCriarbtn.setText("Criar Novo Relatório");
                        flag=true;
                    }
            });
            background.getChildren().add(SP);
        } catch (IOException ex) {
            Logger.getLogger(GerarRelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void voltarAct() throws IOException{ //estou voltando a tela inicial
        AnchorPane x = (AnchorPane) FXMLLoader.load(getClass().getResource("/FMF/views/index.fxml"));
        background.getChildren().setAll(x);
    }
    
       
    public void AcaoRel() throws IOException{
        AnchorPane x;
        if(!flag){
            x = (AnchorPane) FXMLLoader.load(getClass().getResource("/FMF/views/EditRel.fxml")); 
        }
        else{
            x = (AnchorPane) FXMLLoader.load(getClass().getResource("/FMF/views/CriarNovoRel.fxml")); 
        }
        background.getChildren().setAll(x);
    }
    
    
}
