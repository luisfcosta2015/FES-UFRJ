/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriocustomizadofmf;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author matheus
 */

public class TelaTemplate {
    
    Stage Secondstage;
    private boolean flag;
    public TelaTemplate(Stage stage) throws IOException{
          this.Secondstage=stage;
          flag=true;
          this.tela();
         
    }
    
    private void tela() throws IOException{
        
                
            
            Pane root = FXMLLoader.load(getClass().getResource("Layout_TelaTemplate.fxml"));
                 
            Scene scene = new Scene(root, 800, 600);
        
            Secondstage.setTitle("Criação de Template");
            Secondstage.setScene(scene);
            Secondstage.show();
            
        
    }
    
    
    private void sairTela(){ //metodo nao usado ainda
        this.flag=false;
    }
}

