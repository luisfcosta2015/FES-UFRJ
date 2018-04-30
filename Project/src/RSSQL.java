import com.google.gson.Gson;
import model.RSSQLObject;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class RSSQL {

    //for tests
    public static void main(String[] args) throws Exception{
        new RSSQL("res/test/rssql.json");

    }

    public RSSQL(String filename) throws Exception{

        RSSQLObject mRSO;

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while(scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        Gson gson = new Gson();
        mRSO = gson.fromJson(sb.toString(),RSSQLObject.class);
        System.out.print(mRSO);

    }
}
