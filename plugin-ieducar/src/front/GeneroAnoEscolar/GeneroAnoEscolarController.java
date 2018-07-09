package front.GeneroAnoEscolar;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import report.DatabaseConnection;
import report.RelatorioGenero;

import java.io.IOException;

public class GeneroAnoEscolarController {

    @FXML
    private Button gera_relatorio;

    @FXML
    private ChoiceBox<String> box_escola;

    @FXML
    private ChoiceBox box_turma;

    @FXML
    private ChoiceBox box_grafico;

    DatabaseConnection db = new DatabaseConnection();
    //ObservableList<String> lista_escolas = FXCollections.observableArrayList("Todas as escolas", "Escola 1", "Escola 2", "escola 3");
    ObservableList<String> lista_escolas;
    ObservableList<String> lista_turma = FXCollections.observableArrayList("Selecione uma turma");
    ObservableList<String> lista_grafico = FXCollections.observableArrayList("Pizza", "Barra");


    private String escola;
    private String turma;
    private String grafico;

    /**
     * Método que ocorre assim que a página é aberta, definindo minhas ações e campos
     *
     */
    @FXML
    private void initialize() {
        db.gerarListaDeEscolas();
        lista_escolas = db.getEscolas();
        lista_turma = db.getTurmasPorEscola();

        box_escola.setValue("Selecione uma escola");
        box_escola.setItems(lista_escolas);
        box_escola.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                db.gerarListaDeTurmasPorEscola(box_escola.getItems().get((Integer) t1));
                box_turma.setValue("Selecione uma turma");
            }
        });

        box_turma.setValue("Selecione uma turma");
        box_turma.setItems(lista_turma);

        box_grafico.setValue("Pizza");
        box_grafico.setItems(lista_grafico);

        gera_relatorio.setOnAction(e -> geraRelatorio(box_escola, box_turma, box_grafico));

    }

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
    public void geraRelatorio(ChoiceBox<String> box_escola, ChoiceBox<String> box_turma, ChoiceBox<String> box_grafico) {
        escola = getChoice(box_escola);
        turma = getChoice(box_turma);
        grafico = getChoice(box_grafico);

        RelatorioGenero relatorioGenero = new RelatorioGenero(escola, turma);
        if (grafico.equals("Barra")) {
            relatorioGenero.buildBarra();
        } else if (grafico.equals("Pizza")) {
            relatorioGenero.buildPizza();
        } else {
            System.out.println("Um tipo inválido de gráfico foi selecionado.");
        }

        //relatorio.buildGeneroAnoEscolar(escola, turma, grafico);

    }

    private String getChoice(ChoiceBox<String> choiceBox) {
        return choiceBox.getValue();
    }
}
