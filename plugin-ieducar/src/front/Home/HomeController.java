package front.Home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button idade;

    @FXML
    private Button genero;



    /**
     * Método que ocorre assim que a página é aberta, definindo as Tooltips
     *
     */
    @FXML
    private void initialize() {

        //Tooltip para o botão do Idade/Ano Escolar
        final Tooltip tooltipIdade = new Tooltip();
        tooltipIdade.setText(
                "Relatório para mostrar quantidade de alunos\n" + "na série certa levando em consideração a idade\n"
        );
        tooltipIdade.setStyle("-fx-font-family: 'Open Sans Condensed Light'; "
                + "-fx-base: black; "
                + "-fx-text-fill: #41848F;"
                + "-fx-text-alignment: justify; "
                + "-fx-background-color: #C4C4C4;"
                + "-fx-font-size: 24; "
        );
        idade.setTooltip(tooltipIdade);

        //Tooltip para o botão do Genero/Ano Escolar
        final Tooltip tooltipGenero = new Tooltip();
        tooltipGenero.setText(
                "Relatório para mostrar quantidade de meninos\n" + "e meninas em uma turma\n"
        );
        tooltipGenero.setStyle("-fx-font-family: 'Open Sans Condensed Light'; "
                + "-fx-base: black; "
                + "-fx-text-fill: #41848F;"
                + "-fx-text-alignment: justify; "
                + "-fx-background-color: #C4C4C4;"
                + "-fx-font-size: 24; "
        );
        genero.setTooltip(tooltipGenero);

    }

    /**
     * Método faz com que vá da páigina Principal para a página de geração de relatório Relação Idade/Ano escolar
     *
     */
    @FXML
    public void trocaIdadeAnoEscolar(ActionEvent e) throws IOException {
        Parent pagRelatorioParent = FXMLLoader.load(getClass().getResource("../IdadeAnoEscolar/IdadeAnoEscolar.fxml"));
        Scene pagRelatorioScene = new Scene(pagRelatorioParent);
        Stage pagRelatorioStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        pagRelatorioStage.setTitle("Relatório Customizável - Prefeitura de Caxias");


        pagRelatorioStage.setScene(pagRelatorioScene);
        pagRelatorioStage.show();
    }

    /**
     * Método faz com que vá da páigina Principal para a página de geração de relatório Relação gênero/Ano escolar
     *
     */
    @FXML
    public void trocaGeneroAnoEscolar(ActionEvent e) throws IOException {
        Parent pagRelatorioParent = FXMLLoader.load(getClass().getResource("../GeneroAnoEscolar/GeneroAnoEscolar.fxml"));
        Scene pagRelatorioScene = new Scene(pagRelatorioParent);
        Stage pagRelatorioStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        pagRelatorioStage.setTitle("Relatório Customizável - Prefeitura de Caxias");


        pagRelatorioStage.setScene(pagRelatorioScene);
        pagRelatorioStage.show();
    }


}
