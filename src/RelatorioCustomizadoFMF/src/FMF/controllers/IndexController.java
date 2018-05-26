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
 * @author lucca
 */
public class IndexController implements Initializable {

    @FXML
    private Button gerarRelBtn;
    
    @FXML
    private Button editarRelBtn;

    @FXML
    private Button addAtribBtn;

    @FXML
    private AnchorPane background;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void gerarRelAct() throws IOException{
        AnchorPane x = (AnchorPane) FXMLLoader.load(getClass().getResource("/FMF/views/gerarRelatorio.fxml"));
        background.getChildren().setAll(x);
    }

    public void editarRelAct() throws IOException{
        //TODO
    }
    public void addAtribAct() throws IOException{
        //TODO
    }
    
}
