package sslRel.config;

import java.sql.*;
import java.util.ArrayList;

public class DBHelper {
    private String URL;
    private String USERNAME;
    private String PASSWORD;

    private Connection conn;

    public DBHelper(){
        this.URL = System.getProperty("DB_URL_ROOT")+"/"+System.getProperty("DB_NAME");
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


    public ArrayList<ArrayList<String>> query(String sql,Object... param){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {
            PreparedStatement st = this.conn.prepareStatement(sql);

            for(int i=0;i<param.length;i++){
                st.setObject( i+1,param[i]);
            }
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
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
