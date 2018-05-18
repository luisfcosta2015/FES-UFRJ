package front.PagRelatorio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import report.Report;
import java.io.IOException;

public class PagRelatorioController {

    @FXML
    private MenuButton selector_escola;
    @FXML
    private MenuItem item_escola;

    Report relatorio = new Report();

    /**
     * Método para voltar para página Home
     *
     */
    @FXML
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
    @FXML
    public void geraRelatorio(ActionEvent e) {
        System.out.println("yaaaaaaaaaaaaaaaaaaaaaaaaaay");
        relatorio.build();
    }

}
