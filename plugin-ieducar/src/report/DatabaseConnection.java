package report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {

    private static ArrayList<Aluno> listaDeAlunos;

    // Campos para conexão, execução e captação de queries com o banco de dados local
    private Connection cn;
    private Statement st;
    private ResultSet rs;

    private static ObservableList<String> listaDeEscolas = FXCollections.observableArrayList();
    private static ObservableList<String> listaDeTurmas = FXCollections.observableArrayList();
    private static int cod_turma = -1;

    // Construtor para estabelecer a conexão com o banco de dados local e preparar a variável para execução de queries
    public DatabaseConnection() {
        try {
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iEducar", "postgres", "");
            st = cn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        listaDeTurmas.add("Selecione uma turma");
    }

    // Método que retorna uma lista de nomes de escolas baseado nas tabelas de instituições e escolas
    public ObservableList<String> getEscolas() {
        return listaDeEscolas;
    }

    public void gerarListaDeEscolas() {
        ObservableList<String> novaLista = FXCollections.observableArrayList();
        novaLista.add("Selecione uma escola");
        String query = "SELECT DISTINCT pmieducar.escola.sigla FROM pmieducar.escola";
        try {
            rs = st.executeQuery(query);
            while (rs.next()){
                novaLista.add(rs.getString(1));
            }
            listaDeEscolas.setAll(novaLista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void gerarListaDeAlunos(String escola, String turma) {
        listaDeAlunos = new ArrayList<Aluno>();
        int cod_escola = -1;
        //int cod_turma = -1;
        String query = "SELECT pmieducar.escola.cod_escola FROM pmieducar.escola WHERE pmieducar.escola.SIGLA = '" +
                escola + "'";
        try {
            rs = st.executeQuery(query);
            if (!rs.isBeforeFirst()) cod_escola = -1;
            while (rs.next()) {
                cod_escola = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (cod_escola == -1) throw new RuntimeException();

        query = "SELECT pmieducar.turma.cod_turma FROM pmieducar.turma WHERE pmieducar.turma.ref_ref_cod_escola = '" +
                cod_escola +"' AND pmieducar.turma.nm_turma = '" + turma + "'";
        try {
            rs = st.executeQuery(query);
            if(!rs.isBeforeFirst()) cod_turma = -1;
            while (rs.next()) {
                cod_turma = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (cod_turma == -1) throw new RuntimeException();

        query = "SELECT cadastro.pessoa.nome, cadastro.fisica.data_nasc, cadastro.fisica.idpes, cadastro.fisica.sexo\n" +
                "FROM cadastro.pessoa, cadastro.fisica, pmieducar.aluno, pmieducar.matricula, pmieducar.matricula_turma\n" +
                "WHERE cadastro.pessoa.idpes = cadastro.fisica.idpes AND cadastro.pessoa.idpes = pmieducar.aluno.ref_idpes\n" +
                "\tAND pmieducar.aluno.cod_aluno = pmieducar.matricula.ref_cod_aluno AND pmieducar.matricula_turma.ref_cod_matricula = pmieducar.matricula.cod_matricula\n" +
                "\tAND pmieducar.matricula.ref_ref_cod_escola = " + cod_escola +
                " AND pmieducar.matricula_turma.ref_cod_turma = " + cod_turma;
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                listaDeAlunos.add(new Aluno(rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public int[] getFaixaEtariaSerie() {
        int[] faixa = new int[2];
        faixa[0] = faixa[1] = -1;
        String query = "SELECT pmieducar.serie.idade_inicial, pmieducar.serie.idade_final\n" +
                "FROM pmieducar.serie, pmieducar.turma\n" +
                "WHERE pmieducar.turma.cod_turma = " + cod_turma + " AND pmieducar.turma.ref_ref_cod_serie = pmieducar.serie.cod_serie";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                faixa[0] = rs.getInt(1);
                faixa[1] = rs.getInt(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (faixa[0] == -1 || faixa[1] == -1) throw new RuntimeException();
        return faixa;
    }
}
