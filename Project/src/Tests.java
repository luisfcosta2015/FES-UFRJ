import junit.framework.TestCase;
import org.apache.catalina.*;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sslRel.config.Dotenv;
import sslRel.helpers.DBHelper;


import static org.mockito.Mockito.*;


import java.io.IOException;





public class Tests extends TestCase  {
    Tomcat mTomcat = new Tomcat();
    String appDir = "out/artifacts/Project_war_exploded/WEB-INF";
    String webPort = System.getenv("PORT");


    public void testDBHelper()  {
        Dotenv.load(".env");



        DBHelper banco = new DBHelper();

        assertTrue(banco.connect());
        assertNotSame(null,banco);
        assertTrue(banco.close());




    }
    public void testTomcat() throws ServletException, IOException, LifecycleException {
        ConfigServlet servlet = mock(ConfigServlet.class);
        Tomcat tom = new Tomcat();
        boolean serv;

        servlet.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.doPost(request,response);
        tom.start();
        tom.setPort(8081);
        servlet.init();
        assertNotNull(servlet);//Testa inicialização do servlet mock
        tom.stop();


    }

    public void testOrquestrador() throws ServletException, IOException {
        Orquestrador orq = mock(Orquestrador.class);
        String doc = new String();
        JobManager.JobFormat jf = mock(JobManager.JobFormat.class);
        HttpServletRequest servreq = mock(HttpServletRequest.class);
        orq.init();
        assertNotSame(null,orq);
        doc = orq.createHTMLReport(servreq,jf);



    }

    public void testRSSQL()  {

        RSSQL rssql;



        JobManager jobManager = mock(JobManager.class);
        HttpServletRequest request = mock(HttpServletRequest.class);


        rssql = mock(RSSQL.class);

        //configurar dados do banco
        assertNotSame(null,rssql);//testa instância do RSSQL



    }






}

