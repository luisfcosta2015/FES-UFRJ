import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;




public class ParametersController extends HttpServlet{

    protected DBHelper db = new DBHelper();
    public ParametersController(){
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

    }
    private ArrayList<ArrayList<String>> getEscolas(){
        return this.db.query("SELECT DISTINCT nome_escola FROM escola;");
    }
    private ArrayList<ArrayList<String>> getAnos(String escola){
        return this.db.query("SELECT DISTINCT ano from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = '"+escola+"' ;");
    }
    private ArrayList<ArrayList<String>> getTurmas(String escola, String ano){
        return this.db.query("SELECT DISTINCT nome_turma from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = '"+escola+"' AND ano='"+ano+"' ;");
    }
}
