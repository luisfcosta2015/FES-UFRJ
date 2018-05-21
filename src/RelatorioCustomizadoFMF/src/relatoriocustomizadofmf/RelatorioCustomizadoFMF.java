
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriocustomizadofmf;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import MysqlCon.MysqlCon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author lucca
 */
public class RelatorioCustomizadoFMF extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        MysqlCon BD = new MysqlCon();
        
        /*Button btn = new Button();
        btn.setText("Criar Template34454534");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Set<String> valores = new HashSet<String>(); 
                String path = "../data/teste.txt";
                
                TelaTemplate telatemplate = new TelaTemplate(primaryStage);
                //TemplateStatement stmt = new TemplateStatement(path);
                
                //System.out.println(Leitor.getConsulta(path,stmt.mapeiaAtributos()));
                          
                //String resultado = Leitor.getConsulta("../data/teste.txt", valores);
                //BD.query("SELECT Nome FROM Professor WHERE Disciplina='Matematica III';");
                //System.out.println(resultado);
            } 
        });*/ 
        
        Pane root= FXMLLoader.load(getClass().getResource("Layout_TelaPrincipal.fxml"));
        
        //Pane root = new StackPane();
        //root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Tela Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
