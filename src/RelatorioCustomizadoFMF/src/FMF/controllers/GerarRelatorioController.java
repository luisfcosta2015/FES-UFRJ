/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import FMF.models.Relatorio;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author lucca
 */
public class GerarRelatorioController implements Initializable {

    @FXML
    private Button voltarBtn;

    @FXML
    private AnchorPane background;

    @FXML
    private Button gerarBtn;

    @FXML
    private Text RelatorioEscolhido;    
    
    private Map<String, String> parametros;
    
    private Relatorio escolhido;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Iterar sobre o array global de modelos, obter o título a partir da classe modelo e usá-lo pra setar
        
        List<Pair< String,EventHandler<? super MouseEvent> > > miniaturas = new ArrayList<>();
        for(Relatorio rel: Relatorio.Relatorios){
            String title = rel.nome;
            miniaturas.add(new Pair<>(title, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        RelatorioEscolhido.setText(title);
                        parametros = rel.listaPreenchimentosNecessarios();
                        escolhido = rel;
                    }
            }));
        }
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FMF/views/DeslizadorMiniaturas.fxml"));
            ScrollPane SP = (ScrollPane) loader.load();
            DeslizadorMiniaturasController deslizador = loader.<DeslizadorMiniaturasController>getController();
            deslizador.setMiniaturas(miniaturas);
            background.getChildren().add(SP);
        } catch (IOException ex) {
            Logger.getLogger(GerarRelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    
    
    public void voltarAct() throws IOException{
        AnchorPane x = (AnchorPane) FXMLLoader.load(getClass().getResource("/FMF/views/index.fxml"));
        background.getChildren().setAll(x);
    }
    
    public void gerarAct(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FMF/views/popupGerarRel.fxml"));

        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(GerarRelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        PopupGerarRelController controller = fxmlLoader.<PopupGerarRelController>getController();
        controller.setParams(this.parametros, this.escolhido);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));  
        stage.show();    

    }
    
    

    
}
