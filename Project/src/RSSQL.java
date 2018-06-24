import com.google.gson.Gson;
import sslRel.helpers.DBHelper;
import model.RSSQLObject;
import sslRel.helpers.Resource;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RSSQL {

    RSSQLObject mRSO;

    public String[] dyn_keys, sta_keys, sta_values;

    public String[][] dyn_values;

    public ArrayList<String> inputs;

    //QueryObject é uma innerclasse que funciona como um wrapper contendo a string de query e os parametros de entrada
    public QueryObject querySt, queryDy;

    public RSSQL(String filename) throws Exception{
        String sb = Resource.getFileContent(new File(filename));
        Gson gson = new Gson();
        mRSO = gson.fromJson(sb,RSSQLObject.class);
        sta_keys = mRSO.getStaticField().getKey().split(",");
        sta_values = new String[sta_keys.length];
        dyn_keys = mRSO.getDynamicField().getKey().split(",");
        this.findInputlist();
    }

    public RSSQL findInputlist(){
        inputs  = new ArrayList<>();
        String allQueries = mRSO.getStaticField().getValue()+mRSO.getDynamicField().getValue();
        Pattern p = Pattern.compile("\\$\\{(\\w*)\\}");
        Matcher m = p.matcher(allQueries);
        while (m.find()) {
            String key = m.group(1);
            if(!inputs.contains(key)){
                inputs.add(key);
            }
        }
        return this;
    }

    public RSSQL loadQuery(HashMap<String,String> params){
        String sta_query = mRSO.getStaticField().getValue();
        querySt = replaceKeys(params,sta_query);
        String dyn_query = mRSO.getDynamicField().getValue();
        queryDy = replaceKeys(params,dyn_query);
        return this;
    }

    private QueryObject replaceKeys(HashMap<String,String> map, String query){
        ArrayList <Object> params = new ArrayList<>();
        QueryObject q = new QueryObject();
        Pattern p = Pattern.compile("\\$\\{(\\w*)\\}");
        Matcher m = p.matcher(query);
        while (m.find()) {//Para cada chave na query
            String key = m.group(1); //pega nome da chave
            if(map.containsKey(key)){ //Se map tem chave, então:
                query = query.replace("${"+key+"}","?");//Substitui chave por "?";
                //Adiciona valor da chave na lista de parametros
                params.add(DBHelper.convertTypes(map.get(key)));
            }
        }
        q.queryParams = params.toArray();
        q.queryString = query;
        return q;
    }

    public RSSQL queryFields(){
        DBHelper dbHelper = new DBHelper();
        dbHelper.connect();
        ArrayList<ArrayList<String>> res = dbHelper.query(querySt.queryString,querySt.queryParams);
        if((res.size()>0)&&(res.get(0).size()>0)){
            for(int i = 0; i<res.get(0).size(); i++){
                sta_values[i] = res.get(0).get(i);
            }
        }
        res = dbHelper.query(queryDy.queryString,queryDy.queryParams);
        dyn_values = new String[res.size()][];
        for(int i = 0; i < res.size(); i++){
            dyn_values[i] = new String[res.get(i).size()];
            for(int j=0; j < res.get(i).size(); j++){
                dyn_values[i][j] = res.get(i).get(j);
            }
        }
        dbHelper.close();
        return this;
    }

    public String[] getStaticKeys(){
        return sta_keys.clone();
    }

    public String[] getDynamicKeys(){
        return dyn_keys.clone();
    }

    public HashMap<String,String> getStaticResults(){
        HashMap<String,String> ret = new HashMap<>();
        for(int i = 0; i < sta_keys.length; i++){
            ret.put(sta_keys[i],sta_values[i]);
        }
        return ret;
    }

    public HashMap<String,Object> getDynamicResults(){
        HashMap<String,Object> ret=new HashMap<>();
        HashMap<String,Integer> keys = new HashMap<>();
        for(int i=0;i<dyn_keys.length;i++){
            keys.put(dyn_keys[i],i);
        }
        ret.put("keys",keys);
        ret.put("values",dyn_values);
        return ret;
    }

    class QueryObject{
        String queryString;
        Object[] queryParams;
    }

}
