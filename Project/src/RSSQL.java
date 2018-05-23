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

        for(RSSQLObject.RSSQLField field: mRSO.getStaticFields()){
            String query = field.getValue();
            for(String key:namespace.keySet()){
                query = query.replace("${"+key+"}",namespace.get(key));
            }

            String result;
            if(query.startsWith("sql:")){
                DBHelper db = new DBHelper();
                db.connect();
                result = db.querySingleData(query.replace("sql:",""));
            }else{
                result = query;
            }
            namespace.put(field.getKey(), result);
        }

        System.out.println(namespace);

    }
}
