/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriocustomizadofmf;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author matheus
 */
public class Layout_TelaPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    public void IrModelo(){
        System.out.println("TENHO QUE IR PARA PAG DE MODELO");
    }
    
  
    public void IrPaginaTemplate() throws IOException{
        Stage stage = new Stage();
        TelaTemplate telatemplate = new TelaTemplate(stage);
        System.out.println("tenho q ir para pag de criação de templates");
    }
    
}
