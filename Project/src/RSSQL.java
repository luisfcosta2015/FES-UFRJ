import com.google.gson.Gson;
import model.RSSQLObject;

import java.io.File;
import java.util.Scanner;

public class RSSQL {

    //for tests
    public static void main(String[] args) throws Exception{
        new RSSQL("res/test/rssql.json");

    }

    public RSSQL(String filename) throws Exception{
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String str = "";
        while(scanner.hasNext()){
            str+=scanner.nextLine();
        }
        Gson gson = new Gson();
        RSSQLObject rso = gson.fromJson(str,RSSQLObject.class);
        System.out.print(rso);
    }
}
