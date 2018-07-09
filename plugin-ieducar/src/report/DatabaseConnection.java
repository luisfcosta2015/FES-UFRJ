package report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnection {
    // Campos para conexão, execução e captação de queries com o banco de dados local
    private Connection cn;
    private Statement st;
    private ResultSet rs;

    private static ObservableList<String> listaDeEscolas = FXCollections.observableArrayList();
    private static ObservableList<String> listaDeTurmas = FXCollections.observableArrayList();

    // Construtor para estabelecer a conexão com o banco de dados local e preparar a variável para execução de queries
    public DatabaseConnection() {
        try {
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ieducar", "postgres", "");
            st = cn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        listaDeEscolas.add("Selecione uma escola");
        String query = "SELECT DISTINCT pmieducar.escola.sigla FROM pmieducar.escola";
        try {
            rs = st.executeQuery(query);
            while (rs.next()){
                listaDeEscolas.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        listaDeTurmas.add("Selecione uma turma");
    }

    // Método que retorna uma lista de nomes de escolas baseado nas tabelas de instituições e escolas
    public ObservableList<String> getEscolas() {
        return listaDeEscolas;
    }

    public ObservableList<String> getTurmasPorEscola() {
        return listaDeTurmas;
    }

    public void gerarListaDeTurmasPorEscola(String nomeDaEscola) {
        ObservableList<String> novaLista = FXCollections.observableArrayList();
        novaLista.add("Selecione uma turma");
        String query = "SELECT DISTINCT pmieducar.turma.nm_turma " +
                "FROM pmieducar.turma, pmieducar.escola " +
                "WHERE pmieducar.turma.ref_ref_cod_escola = (SELECT DISTINCT pmieducar.escola.cod_escola " +
                "FROM pmieducar.escola " +
                " WHERE pmieducar.escola.SIGLA = '" + nomeDaEscola + "')";

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                novaLista.add(rs.getString(1));
            }
            listaDeTurmas.setAll(novaLista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
