package front.IdadeAnoEscolar;

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
import javafx.stage.Stage;
import report.DatabaseConnection;
import report.RelatorioIdade;

import java.io.IOException;

public class IdadeAnoEscolarController {

    @FXML
    private Button gera_relatorio;

    @FXML
    private ChoiceBox box_escola;

    @FXML
    private ChoiceBox box_turma;

    @FXML
    private ChoiceBox box_grafico;

    DatabaseConnection db = new DatabaseConnection();
    // ObservableList<String> lista_escolas = FXCollections.observableArrayList("Todas as escolas", "Escola 1", "Escola 2", "escola 3");
    ObservableList<String> lista_escolas = db.getEscolas();
    ObservableList<String> lista_turma = FXCollections.observableArrayList("Selecione uma turma", "Turma 1", "Turma 2", "Turma 3");
    //ObservableList<String> lista_turma = FXCollections.observableArrayList();
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
        box_escola.setValue("Selecione uma escola");
        System.out.println();
        box_escola.setItems(lista_escolas);

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
    public String geraRelatorio(ChoiceBox<String> box_escola, ChoiceBox<String> box_turma, ChoiceBox<String> box_grafico) {

        escola = getChoice(box_escola);
        turma = getChoice(box_turma);
        grafico = getChoice(box_grafico);

        System.out.println(escola);

        RelatorioIdade relatorioIdade = new RelatorioIdade(escola, turma);

        if (grafico.equals("Barra")) {
            relatorioIdade.buildBarra();
        } else if (grafico.equals("Pizza")) {
            relatorioIdade.buildPizza();
        } else {
            System.out.println("Um tipo inválido de gráfico foi selecionado.");
        }

        //relatorio.buildIdadeAnoEscolar(escola, turma, grafico);

        return grafico;

    }

    public String getChoice(ChoiceBox<String> choiceBox) {
        return choiceBox.getValue();
    }


}
