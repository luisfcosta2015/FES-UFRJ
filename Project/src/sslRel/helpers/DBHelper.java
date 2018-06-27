package sslRel.helpers;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBHelper {
    private String URL;
    private String USERNAME;
    private String PASSWORD;

    private Connection conn;

    public DBHelper(){
        this.URL = System.getProperty("DB_URL_ROOT")+System.getProperty("file.separator")+System.getProperty("DB_NAME");
        this.USERNAME = System.getProperty("DB_USER");
        this.PASSWORD = System.getProperty("DB_PASS");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public boolean connect() {
        try {
            this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean close(){
        try {
            this.conn.close();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Object convertTypes(String input){
        Object output = new Object();
        try {
            output = NumberFormat.getInstance().parse(input);
        } catch (Exception e) {
            try {
                SimpleDateFormat format = new java.text.SimpleDateFormat("HH:mm:ss.SSSSSS");
                output = format.parse(input);
            } catch (Exception e2) {
                try {
                    SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    format.parse(input);
                } catch (Exception e3) {
                    try {
                        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
                        format.parse(input);
                    } catch (Exception e4) {
                        try {
                            output = Boolean.valueOf(input);
                        } catch (Exception e5) {
                            output=input;
                        }
                    }
                }
            }
        }
        return output;
    }

    public ArrayList<ArrayList<String>> query(String sql,Object... param){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {
            PreparedStatement st = this.conn.prepareStatement(sql);

            for(int i=0;i<param.length;i++){
                st.setObject( i+1,param[i]);
            }
            try {
                ResultSet rs = st.executeQuery();
                int ncolumn = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    ArrayList<String> row = new ArrayList<>();
                    for(int i=1;i<=ncolumn;i++){
                        row.add(rs.getString(i));
                    }
                    result.add(row);
                }
                rs.close();
                st.close();
                return result;
            }catch (PSQLException e){
                if(e.getMessage().equals("No results were returned by the query.")){
                    return null;
                }else{
                    System.err.println(e.getMessage());
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
