import com.google.gson.Gson;
import sslRel.config.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class TestMockController extends HttpServlet{

    protected DBHelper db = new DBHelper();
    public TestMockController(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.db.connect();
        String tipo;
        tipo = request.getParameter("tipo");

        String json="";

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        switch (tipo){
            case "escolas":
                json = new Gson().toJson(getEscolas());
                break;
            case "anos":
                json = new Gson().toJson(getAnos(request.getParameter("escola")));
                break;
            case "turmas":
                json = new Gson().toJson(getTurmas(request.getParameter("escola"),request.getParameter("ano")));
                break;
            default:
                json = "{Error: \"Incorrect Type of Parameter\"}";
        }

        response.getWriter().write(json);
        db.close();

    }
    private ArrayList<ArrayList<String>> getEscolas(){
        return this.db.query("SELECT DISTINCT nome_escola FROM escola");
    }
    private ArrayList<ArrayList<String>> getAnos(String escola){
        return this.db.query("SELECT DISTINCT ano from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = ?",escola);
    }
    private ArrayList<ArrayList<String>> getTurmas(String escola, String ano){
        return this.db.query("SELECT DISTINCT nome_turma from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = ? AND ano=?",escola,Integer.parseInt(ano));
    }
}
