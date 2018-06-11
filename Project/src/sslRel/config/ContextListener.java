package sslRel.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext context =arg0.getServletContext();
        String RootProject =context.getRealPath("/").split("/out")[0];
        this.loadSystemVars(RootProject);
    }

    public void loadSystemVars(String RootProject){
        System.setProperty("RootProject",RootProject);
        System.setProperty("ResProject",RootProject+"/res");
        System.setProperty("reportsTemplates",RootProject+"/res/reportsTemplates");
        Dotenv.load(RootProject+"/.env");
    }
    public void contextDestroyed(ServletContextEvent arg0) {  }
}