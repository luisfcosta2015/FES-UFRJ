import com.google.gson.Gson;
import sslRel.helpers.DBHelper;
import model.RSSQLObject;
import sslRel.helpers.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RSSQL {

    RSSQLObject mRSO;

    public String[] dyn_keys;
    public String[][] dyn_values;
    public String[] sta_keys;
    public String[] sta_values;

    DBHelper dbHelper;


    String querySt;
    String queryDy;

    // r = RSSQL("modelo1.rssql",{"idescola":10, ...
    // r.

    public RSSQL(String filename) throws Exception{

        String sb = Resource.getFileContent(new File(filename));
        Gson gson = new Gson();
        mRSO = gson.fromJson(sb,RSSQLObject.class);

        sta_keys = mRSO.getStaticField().getKey().split(",");
        sta_values = new String[sta_keys.length];
        dyn_keys = mRSO.getDynamicField().getKey().split(",");

/*TODO: Quando abre uma conexão tem que fechar ao terminar de usá-la. O banco ta reclamando por causa das conexões que abrem e não fecham*/
//        dbHelper = new DBHelper();
//        dbHelper.connect();
    }

    public void loadQuery(HashMap<String,String> params){
        String sta_query = mRSO.getStaticField().getValue();
        querySt = replaceKeys(params,sta_query);
        String dyn_query = mRSO.getDynamicField().getValue();
        queryDy = replaceKeys(params,dyn_query);
    }

    private String replaceKeys(HashMap<String,String> map, String query){

        for(String key : map.keySet()){
            query = query.replace("${"+key+"}", map.get(key));
        }

        return query;

    }

    public boolean queryFields(String sta_query, String dyn_query){

        ArrayList<ArrayList<String>> res = dbHelper.query(sta_query);

        for(int i = 0; i<sta_keys.length; i++){
            sta_values[i] = res.get(0).get(i);
        }

        res = dbHelper.query(dyn_query);
        dyn_values = new String[res.size()][];
        for(int i = 0; i < res.size(); i++){
            ArrayList<String> line = res.get(i);
            for(int j=0; j < dyn_keys.length; j++){
                dyn_values[i][j] = line.get(j);
            }
        }

        return true;
    }

    public HashMap<String,String> getStaticResults(){

        HashMap<String,String> ret = new HashMap<>();
        for(int i = 0; i < sta_keys.length; i++){
            System.out.println(sta_keys[i]+"  "+sta_values[i]);
            ret.put(sta_keys[i],sta_values[i]);
        }
        return ret;

    }

    public String[] getDynamicKeys(){

        return dyn_keys.clone();
    }
    public String[] getStaticKeys(){

        return sta_keys.clone();
    }

    public String[][] getDynamicResults(){


        return dyn_values;

    }

}
