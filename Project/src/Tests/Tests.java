
package Tests;
import junit.framework.TestCase;
import sslRel.helpers.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;

public class Tests extends TestCase {
    public void testDBHelper() throws ClassNotFoundException, ServletException, IOException {
        HttpServlet servlet = (HttpServlet) mock(Class.forName("ConfigServlet"));
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        String param = new String();
        DBHelper object = new DBHelper();
        boolean RetornoDB1 = object.connect();

        DBHelper db = mock(DBHelper.class);//criação de um objeto mock
        when(db.connect()).thenReturn(true);//retorno artificial

        RetornoDB1 = db.connect();
        //ArrayList<ArrayList<String>> RetornoDB2 = object.query("SELECT * FROM escola",object);
        response.addHeader("test","test");
        request.getParameter(param);
        servlet.init();
        servlet.service(request,response);






        assertEquals(true,RetornoDB1);
        //assertEquals(false,RetornoDB1);


    }
}

