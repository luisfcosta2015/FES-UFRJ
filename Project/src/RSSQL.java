import com.google.gson.Gson;
import model.RSSQLObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RSSQL {

    public RSSQL(String filename, ArrayList<RSSQLObject.RSSQLField> params) throws Exception{

        RSSQLObject mRSO;
        HashMap<String,String> namespace = new HashMap<>();
        for(RSSQLObject.RSSQLField param: params){
            namespace.put(param.getKey(),param.getValue());
        }

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while(scanner.hasNext()){
            sb.append(scanner.nextLine());
        }
        Gson gson = new Gson();
        mRSO = gson.fromJson(sb.toString(),RSSQLObject.class);

        for(RSSQLObject.RSSQLField key: mRSO.getStaticFields()){

        }



    }
}
