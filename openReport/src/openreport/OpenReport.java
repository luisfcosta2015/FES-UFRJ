package openreport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pdfexport.*;

public class OpenReport extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("layouts/scene_bd-menu.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("layouts/scene_main-menu.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("layouts/scene_customization-menu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
