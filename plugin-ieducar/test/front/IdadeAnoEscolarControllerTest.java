package front;

import front.IdadeAnoEscolar.IdadeAnoEscolarController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.junit.Before;
import org.junit.Test;
import report.RelatorioIdade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IdadeAnoEscolarControllerTest {

    IdadeAnoEscolarController controller;

    @FXML
    private ChoiceBox<String> box_test;
    private ObservableList<String> lista_test = FXCollections.observableArrayList("Escola 0");


    @Before
    public void setUp() throws Exception {
        controller = new IdadeAnoEscolarController();


        box_test.setValue("Escola 0");
        box_test.setItems(lista_test);
    }

}
