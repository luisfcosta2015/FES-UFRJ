import junit.framework.TestCase;
import org.apache.catalina.*;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.*;
import org.mockito.internal.matchers.Or;
import sslRel.helpers.Resource;
import sun.security.krb5.Config;

import org.apache.tomcat.*;

import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;






public class Tests extends TestCase implements ServletContextListener {
    //String tomcatDir = System.getProperty("C:\\Users\\00\\Documents\\Programação\\FES-UFRJ\\Project\\out\\artifacts\\Project_war_exploded");
    Tomcat mTomcat = new Tomcat();
    String appDir = "out/artifacts/Project_war_exploded/WEB-INF";
    String webPort = System.getenv("PORT");


    public void testDBHelper() throws ServletException, LifecycleException, IOException {
        ConfigServlet servlet = mock(ConfigServlet.class);
        Tomcat tom = new Tomcat();
        boolean serv;

        //Catalina catalina = new Catalina();
        //File file = new File("");
        //Wrapper wrapper = tom.addServlet(servlet.getContext(),"servlet",servlet.getClass());

        servlet.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.doPost(request,response);
        tom.start();
        tom.setPort(8081);
        servlet.init();
        assertNotNull(servlet);
        if (servlet == null)
            serv = true;
        else {
            serv = false;
        }
        assertEquals(false, serv);//Testa inicialização do servlet mock



//            while(true){
//                System.out.println("RODANDO");
//            }

        //catalina.start();
        //catalina.setConfigFile();
        //wrapper.start();

//          if(webPort == null || webPort.isEmpty()){
//              webPort="8081";
//          }
//          mTomcat.setPort(Integer.valueOf(webPort));
//          StandardContext ctx = (StandardContext)  mTomcat.addWebapp("/",new File(appDir).getAbsolutePath());
//          File additionWebInfClasses = new File("target/classes");
//          WebResourceRoot resources = new StandardRoot(ctx);
//          resources.addPreResources(new DirResourceSet(resources,"out/artifacts/Project_war_exploded/WEB-INF/classes",additionWebInfClasses.getAbsolutePath(),"/"));
//          ctx.setResources(resources);
//          mTomcat.start();
//          mTomcat.getServer().await();
        //setTomcat();
        //getTomcatPort();


//        HttpServlet servlet = (HttpServlet) mock(Class.forName("ConfigServlet"));
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        String param = new String();
//        DBHelper object = new DBHelper();
//        boolean RetornoDB1 = object.connect();
//
//        DBHelper db = mock(DBHelper.class);//criação de um objeto mock
//        when(db.connect()).thenReturn(true);//retorno artificial
//
//        RetornoDB1 = db.connect();
//        //ArrayList<ArrayList<String>> RetornoDB2 = object.query("SELECT * FROM escola",object);
//        response.addHeader("test","test");
//        request.getParameter(param);
//        servlet.init();
//        servlet.service(request,response);


        //assertEquals(true,RetornoDB1);
        //assertEquals(false,RetornoDB1);


    }

    public void testOrquestrador() throws ServletException, IOException {
        Orquestrador orq = mock(Orquestrador.class);
        String doc = new String();
        JobManager.JobFormat jf = mock(JobManager.JobFormat.class);
        HttpServletRequest servreq = mock(HttpServletRequest.class);
        orq.init();
        doc = orq.createHTMLReport(servreq,jf);
        System.out.println(doc);


    }

    public void testRSSQL() throws Exception {

        RSSQL rssql;
        String fs =System.getProperty("file.separator");
        Resource resource = new Resource();
        JobManager jobManager = mock(JobManager.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        JobManager.JobFormat job = jobManager.getJobByURL(request.getParameter("_urlaction"));
        boolean test1;



        resource.findResource(new File(System.getProperty("reportsTemplates")+fs+job.folder),".rssql.json",false);
        String path = resource.files.get(0).getCanonicalPath();
        rssql = new RSSQL(path).loadQuery(job.params).queryFields();

        if(rssql==null){
            test1=true;
        }
        else{
            test1=false;
        }
        //configurar dados do banco
        assertEquals(false,test1);//testa instância do RSSQL



    }

    public void setTomcat() throws LifecycleException, ClassNotFoundException {


        //server = mTomcat.getServer();
        //System.out.println(server.getAddress());

        //mTomcat.getHost().setAutoDeploy(true);
        //mTomcat.getHost().setDeployOnStartup(true);
        //mTomcat.start();


    }

    public int getTomcatPort() {
        System.out.println(mTomcat.getConnector().getLocalPort());
        return mTomcat.getConnector().getLocalPort();
    }



}

