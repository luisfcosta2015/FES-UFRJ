
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ParametersTest extends HttpServlet{

    public ParametersTest(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Testes criando a página
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Testes criando a página
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(PHPSession.get("tsulsinl6afqqjsdj1bitqh1l7","id",getServletContext().getRealPath("").split("out")[0]));
        out.close( );
    }
}
