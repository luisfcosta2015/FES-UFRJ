package sslRel.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext context =arg0.getServletContext();
        String RootProject =context.getRealPath("/")+"WEB-INF/classes/";
        this.loadSystemVars(RootProject);
    }

    public void loadSystemVars(String RootProject){
        System.setProperty("RootProject",RootProject);
        System.setProperty("ResProject",RootProject+"resources/");
        System.setProperty("reportsTemplates",RootProject+"resources/reportsTemplates/");
        Dotenv.load(RootProject+"../.env");
    }
    public void contextDestroyed(ServletContextEvent arg0) {  }
}