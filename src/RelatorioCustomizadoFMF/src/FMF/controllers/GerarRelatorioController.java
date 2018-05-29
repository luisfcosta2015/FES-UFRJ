/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
