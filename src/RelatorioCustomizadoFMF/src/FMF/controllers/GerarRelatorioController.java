/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Iterar sobre o array global de modelos, obter o título a partir da classe modelo e usá-lo pra setar
        
        List<Pair< String,EventHandler<? super MouseEvent> > > miniaturas = new ArrayList<>();
        for(Integer i=0;i<10;i++){
            String title = "Teste "+ i.toString();
            miniaturas.add(new Pair<>(title, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        RelatorioEscolhido.setText(title);
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
    
    public void gerarAct() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FMF/views/popupGerarRel.fxml"));

        Parent root1 = (Parent) fxmlLoader.load();

        PopupGerarRelController controller = fxmlLoader.<PopupGerarRelController>getController();
        List<String> messages = Arrays.asList("Matrícula", "Semestre", "CódigoEscola");
        controller.setParams(messages);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));  
        stage.show();    

    }

    
}
