package sample.Home;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    /**
     * Método faz com que vá da páigina Principal para a página de geração de relatório
     *
     */
    public void trocaPagina(ActionEvent e) throws IOException {
        Parent pagRelatorioParent = FXMLLoader.load(getClass().getResource("../PagRelatorio/PagRelatorio.fxml"));
        Scene pagRelatorioScene = new Scene(pagRelatorioParent);
        Stage pagRelatorioStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        pagRelatorioStage.setTitle("Relatório Customizável - Prefeitura de Caxias");


        pagRelatorioStage.setScene(pagRelatorioScene);
        pagRelatorioStage.show();
    }

}
