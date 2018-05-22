package model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class RSSQLObject {

    public class RSSQLField{

        String key;
        String value;

        RSSQLField(String key, String value){
            this.key = key;
            this.value = value;
        }

        public String getKey(){
            return this.key;
        }

        public String getValue(){
            return this.value;
        }

    }

    ArrayList<RSSQLField> static_field;
    RSSQLField dynamic_field;

    // default constructor for GSON
    public RSSQLObject(){

    }

    public ArrayList<RSSQLField> getStaticFields(){
        return this.static_field;
    }

    public RSSQLField getDynamicField(){
        return this.dynamic_field;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
