import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.*;
import javax.servlet.ServletException;
public final class PHPSession {
    public static String get(String sessionid,String param,String projectRootFolder,String phpPath){
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        StringBuffer output = new StringBuffer();
        String php = String.format("%s%s", projectRootFolder, Paths.get("getSession.php"));
        Process p;
        try {
            if (isWindows) {
                p = Runtime.getRuntime()
                        .exec(String.format("cmd.exe /c %s \"%s\" %s %s",phpPath,php ," "+sessionid," "+param));
            } else {
                p = Runtime.getRuntime()
                        .exec(String.format("sh -c %s \"%s\" %s %s",phpPath,php ," "+sessionid," "+param));
            }
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static String get(String sessionid,String param,String projectRootFolder){
        return get(sessionid,param,projectRootFolder,"php");
    }

    public static String get(String sessionid,String param){
        String catalina = System.getProperty("catalina.base");
        if(catalina==null){
            return get(sessionid,param,System.getProperty("user.dir")+Paths.get("/getSession.php"));
        }
        try {
            throw new ServletException("Você precisa fornecer o caminho para a pasta onde getSession.php se encontra");
        } catch (ServletException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String get(String sessionid){
       return get(sessionid,"");
    }
}
