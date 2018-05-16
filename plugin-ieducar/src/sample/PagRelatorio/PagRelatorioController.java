package sample.PagRelatorio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PagRelatorioController {


    /**
     * Método para voltar para página Home
     *
     */
    public void voltaHome(ActionEvent e) throws IOException {
        Parent pagRelatorioParent = FXMLLoader.load(getClass().getResource("../Home/Home.fxml"));
        Scene pagRelatorioScene = new Scene(pagRelatorioParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();

        window.setScene(pagRelatorioScene);
        window.show();


    }

    /**
     * Método que irá fazer a chamada para gerar o relatório
     *
     */
    public void geraRelatorio() {
        System.out.println("yaaaaaaaaaaaaaaaaaaaaaaaaaay");
    }
}
