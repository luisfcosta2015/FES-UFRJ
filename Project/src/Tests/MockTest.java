package Tests;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.junit.*;
import sslRel.helpers.DBHelper;
import junit.framework.TestCase;


import javax.servlet.ServletException;
import java.io.File;

import static org.mockito.Mockito.*;

public class MockTest  {

    public static void main (String[] args) throws LifecycleException, ServletException {
        Tomcat mTomcat = new Tomcat();
        String tomcatDir = System.getProperty("java.io.tmpdir");
        String appDir = "out/artifacts/Project_war_exploded/WEB-INF/";
        String webPort = System.getenv("PORT");
        webPort="8081";
//        if(webPort == null || webPort.isEmpty()){
//            webPort="8081";
//        }
        mTomcat.setPort(Integer.valueOf(webPort));
        StandardContext ctx = (StandardContext)  mTomcat.addWebapp("out/artifacts/Project_war_exploded/WEB-INF/context.xml",new File(appDir).getAbsolutePath());
        File additionWebInfClasses = new File("out/artifacts/Project_war_exploded/WEB-INF/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources,"/out/artifacts/Project_war_exploded/WEB-INF",additionWebInfClasses.getAbsolutePath(),"/"));
        ctx.setResources(resources);

        mTomcat.start();
        mTomcat.getServer().await();


    }



//    protected int getTomcatPort() {
//        return mTomcat.getConnector().getLocalPort();
//    }

}
