package sslRel.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DotenvContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext context =arg0.getServletContext();
        String RootProject =context.getRealPath("/").split("/out")[0];
        System.setProperty("RootProject",RootProject);
        Dotenv.load(RootProject+"/.env");
    }

    public void contextDestroyed(ServletContextEvent arg0) {  }

}