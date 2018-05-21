/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriocustomizadofmf;

import java.net.URL;
import javafx.application.Platform;

import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author matheus
 */
public class Layout_TelaTemplateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void AddTemplate(){
       System.out.println("TENHO Q ADD UM TEMPLATE");
    }
    
    public void IrPrincipal(){
       System.out.println("TENHO Q voltar para principal");
       //Platform.exit(); isso fecha todas as telas
    }
}
