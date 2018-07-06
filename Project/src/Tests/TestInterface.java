package Tests;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;
import java.io.IOException;

public interface TestInterface {
    public void testDBHelper()throws ClassNotFoundException, ServletException, IOException, LifecycleException;
    public void setTomcat () throws LifecycleException, ClassNotFoundException;
    public int getTomcatPort();
}
