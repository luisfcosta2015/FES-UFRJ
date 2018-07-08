package report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnection {
    // Campos para conexão, execução e captação de queries com o banco de dados local
    private Connection cn;
    private Statement st;
    private ResultSet rs;

    // Construtor para estabelecer a conexão com o banco de dados local e preparar a variável para execução de queries
    public DatabaseConnection() {
        try {
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ieducar", "postgres", "");
            st = cn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método que retorna uma lista de nomes de escolas baseado nas tabelas de instituições e escolas
    public ObservableList<String> getEscolas() {
        ObservableList<String> listaDeEscolas = FXCollections.observableArrayList();
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
        return listaDeEscolas;
    }

    public ObservableList<String> getTurmasPorEscola(String nomeDaEscola) {
        ObservableList<String> listaDeTurmas = FXCollections.observableArrayList();
        listaDeTurmas.add("Selecione uma turma");
        String query = "SELECT DISTINCT pmieducar.turma.nm_turma " +
                "FROM pmieducar.turma, pmieducar.escola " +
                "WHERE pmieducar.turma.ref_ref_cod_escola = (SELECT DISTINCT pmieducar.escola.cod_escola " +
                "FROM pmieducar.escola " +
                " WHERE pmieducar.escola.SIGLA = '" + nomeDaEscola + "')";

        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                listaDeTurmas.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDeTurmas;
    }
}
