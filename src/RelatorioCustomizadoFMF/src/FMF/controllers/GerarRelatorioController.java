/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private HBox listaModelos;

    @FXML
    private Text RelatorioEscolhido;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaModelos.setSpacing(10);
        
        try {
            // TODO: Iterar sobre o array global de modelos, obter o título a partir da classe modelo e usá-lo pra setar
            for(Integer i=0;i<10;i++){
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/FMF/views/Miniatura.fxml"));
                Pane p1 = (Pane) loader1.load();
                MiniaturaController mini1 = loader1.<MiniaturaController>getController();
                String title;
                title = "Teste "+ i.toString();
                mini1.setTitle(title);
                p1.setOnMousePressed(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        RelatorioEscolhido.setText(title);
                    }
                });
                listaModelos.getChildren().add(p1);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }    
    
    public void voltarAct() throws IOException{
        AnchorPane x = (AnchorPane) FXMLLoader.load(getClass().getResource("/FMF/views/index.fxml"));
        background.getChildren().setAll(x);
    }
    
    public void gerarAct() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FMF/views/popupGerarRel.fxml"));

        Parent root1 = (Parent) fxmlLoader.load();

        /* TESTE-------------------------------------------
        PopupGerarRelController controller = fxmlLoader.<PopupGerarRelController>getController();
        List<String> messages = Arrays.asList("Matrícula", "Semestre", "CódigoEscola");
        controller.setParams(messages);
        --------------------------------------------------*/
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));  
        stage.show();    

    }

    
}
