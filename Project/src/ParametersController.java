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

//        PrintWriter out = response.getWriter();
//        String tipo;
//        tipo = request.getParameter("tipo");

        List list = new ArrayList();
        list.add("item1");
        list.add(1);
        list.add("item3");

        String json = new Gson().toJson(list);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);


//        switch (tipo){
//            case "escola":
//                out.println(getEscolas());
//                break;
//            case "ano":
//                out.println(getAnos(request.getParameter("escola")));
//                break;
//            case "turmas":
//                out.println(getTurmas(request.getParameter("escola"),request.getParameter("ano")));
//                break;
//            default:
//                out.println("{Error: Incorrect Type of Parameter}");
//        }
//

    }
//    protected String getEscolas(){
//        return db.query("SELECT DISTINCT nome_escola FROM escola;");
//    }
//    protected String getAnos(String escola){
//        return db.query("SELECT DISTINCT ano from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = "+escola+" ;");
//    }
//    protected String getTurmas(String escola, String ano){
//        return db.query("SELECT DISTINCT * from turma INNER JOIN escola ON (turma.fk_escola=escola.id_escola) WHERE nome_escola = "+escola+" AND ano="+ano+" ;");
//    }



}
