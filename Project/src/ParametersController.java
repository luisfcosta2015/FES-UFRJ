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
        String tipo;
        tipo = request.getParameter("tipo");

        String json="";

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        switch (tipo){
            case "escola":
                json = new Gson().toJson(getEscolas());
                break;
            case "ano":
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
    public ArrayList<ArrayList> getEscolas(){
        return db.query("SELECT DISTINCT nome_escola FROM escola;");
    }
    public ArrayList<ArrayList> getAnos(String escola){
        return db.query("SELECT DISTINCT ano from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = "+escola+" ;");
    }
    public ArrayList<ArrayList> getTurmas(String escola, String ano){
        return db.query("SELECT DISTINCT * from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = "+escola+" AND ano="+ano+" ;");
    }



}
