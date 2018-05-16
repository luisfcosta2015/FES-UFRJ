
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReportController extends HttpServlet {
    protected DBHelper db = new DBHelper();
    public ReportController(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.db.connect();
        //response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(request.getParameter("escola")+request.getParameter("ano")+request.getParameter("turma"));
//        response.getWriter().write("");
    }
}
