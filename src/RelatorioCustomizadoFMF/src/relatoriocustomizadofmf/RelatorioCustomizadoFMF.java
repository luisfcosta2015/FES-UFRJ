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

/**
 *
 * @author lucca
 */
public class RelatorioCustomizadoFMF extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                //new MysqlCon().Conectar();
                try {
                  FileReader arq = new FileReader("../data/teste.txt");
                  BufferedReader lerArq = new BufferedReader(arq);

                  String temp_linha = lerArq.readLine();
                  String linha = temp_linha + "\n"; // lê a primeira linha
                  while (true) { 
                    temp_linha = lerArq.readLine(); // lê da segunda até a última linha
                    if(temp_linha==null){break;}
                    linha+= temp_linha+ "\n";
                  }

                  System.out.printf("%s", linha);
 
                    arq.close();
                } catch (IOException e) {
                    System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
