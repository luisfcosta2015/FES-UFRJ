
import sslRel.config.Permission;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StartServlet extends HttpServlet{

    public StartServlet(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.getWriter().println("OI");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String json;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if(Permission.check(request)){
            json = "{\"token\": \"foi\"}";
        }else{
            json = "{\"token\": \"não foi\"}";
        }

        response.getWriter().write(json);


    }





}
