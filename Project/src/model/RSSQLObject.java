package model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class RSSQLObject {

    class RSSQLField{

        String key;
        String value;

        RSSQLField(String key, String value){
            this.key = key;
            this.value = value;
        }

    }

    ArrayList<RSSQLField> static_field;
    RSSQLField dynamic_field;

    // default constructor for GSON
    public RSSQLObject(){

    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
