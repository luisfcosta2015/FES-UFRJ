
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;




public class StartServlet extends HttpServlet{

    public StartServlet(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        //Testes com a conexão com o banco de dados

        String dbName = "jdbc:postgresql://localhost/struts_new";
        String dbDriver = "org.postgresql.Driver";
        String userName = "postgres";
        String password = "postgres";


        //Testes criando a página
        //response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //ServletOutputStream sos = response.getOutputStream();

        //double radius =  Double.parseDouble(request.getParameter("rad"));
        String text = request.getParameter("text");

        //  reading from submit buttons
        String str1 = request.getParameter("a1");       //  AREA submit button
        String str2 = request.getParameter("p1");       //  PERIMETER submit button

        //Fim variáveis



        //Teste de conexão com o POSTGRESQL
        /*
        try{
            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbName, userName, password);
            System.out.println("Got Connection");
            Statement statement = con.createStatement();
            String sql = "select * from login";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("uname"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/


        //Teste de geração da página

        out.println("<body>" +
                "<h3>Using Multiple Submit Buttons in a Single Form</h3>" +
                "<form method=\"get\" action=\"http://localhost:8080/st\"> <b>" +
                "</form>");

        out.println("<form method=\"get\" action=\" http://localhost:8080/st\"> <b>\""+
                "Enter Radius <input type=\"text\" name=\"text\"><br>" +
                "<input type=\"submit\" value=\"A number\" name=\"p1\">" +
                "<input type=\"submit\" value=\"What you have written\" name=\"a1\"> </b>" +
                " </form>" +
                "</body>");



        out.println("<h3>");


        if(str2 != null)                            // if AREA is clicked
        {
            out.println("You clicked " + str1 + " submit button<br>");
            out.println("Here you have "+15+"</h2>");
        }
        if(str1!= null)                       // if PERIMETER is clicked
        {
            out.println("You clicked " + str2 + " submit button<br>");
            out.println("<h2>You have written </h2>" +
                    "<h2>"+text.toString()+"</h2>")  ;
        }

        out.println("</h3>");
        out.close( );

        //processRequest(request, response);









    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet postgresServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Java version: </h1>" + System.getProperty("java.version"));


        try {
            InitialContext cxt = null;
            try {


                cxt = new InitialContext();
                out.println("Passou linha 131");


            } catch (NamingException ex) {
                out.println("<h1>NamingException for InitialContext</h1>");
                out.println(ex.getExplanation() + "<br>Remaining: ");
                out.println(ex.getRemainingName() + "<br>Resolved: ");
                out.println(ex.getResolvedName());
                out.println("Passou linha 139");
            }
            if (cxt == null) {
                out.println("<h1>No context found</h1>");
                out.println("Passou linha 143");
                return;
            }
            DataSource ds = null;
            try {
                ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres");
                out.println("Passou linha 149");
            } catch (NamingException ex) {
                out.println("<h1>NamingException for context lookup</h1>");
                out.println(ex.getExplanation() + "<br>Remaining: ");
                out.println(ex.getRemainingName() + "<br>Resolved: ");
                out.println(ex.getResolvedName());
            }


            if (ds == null) {
                out.println("<h1>No datasource</h1>");
                out.println("Passou linha 160");
                return;
            }
            Connection connection = ds.getConnection();


            PreparedStatement st;


            st = connection.prepareStatement("SELECT * FROM test_table");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                out.println("<h2>Column 2 returned " + rs.getString(2) + "</h2>");
            }
            rs.close();
            st.close();
            connection.close();


            out.println("<h1>Servlet postgresServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            out.println("<h1>SQLexception</h1>");
            out.println("<h1>"+ex.toString()+"</h1>");
        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        //ServletOutputStream sos = response.getOutputStream();

        //double radius =  Double.parseDouble(request.getParameter("rad"));
        String text = request.getParameter("text");

        //  reading from submit buttons
        String str1 = request.getParameter("a1");       //  AREA submit button
        String str2 = request.getParameter("p1");       //  PERIMETER submit button

        out.println("<body>" +
                "<h3>Using Multiple Submit Buttons in a Single Form</h3>" +
                "<form method=\"post\" action=\"http://localhost:8080/st\"> <b>");

        out.println("Enter Radius <input type=\"text\" name=\"text\"><br>" +
                "<input type=\"submit\" value=\"A number\" name=\"p1\">" +
                "<input type=\"submit\" value=\"What you have written\" name=\"a1\"> </b>" +
                " </form>" +
                "</body>");



        out.println("<h3>");

        if(str2 != null)                            // if AREA is clicked
        {
            out.println("You clicked " + str1 + " submit button<br>");
            out.println("Here you have "+15+"</h2>");
        }
        if(str1 != null)                       // if PERIMETER is clicked
        {
            out.println("You clicked " + str2 + " submit button<br>");
            out.println("<h2>You have written </h2>" +
                    "<h2>"+text.toString()+"</h2>")  ;
        }

        out.println("</h3>");
        out.close( );

    }





}
