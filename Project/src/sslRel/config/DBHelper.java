package sslRel.config;

import java.sql.*;
import java.util.ArrayList;

public class DBHelper {
    Connection db;
    protected String DB_NAME;
    protected String URL;
    protected String USERNAME;
    protected String PASSWORD;

    public DBHelper(){
        this.DB_NAME= System.getProperty("DB_NAME");
        this.URL = System.getProperty("DB_URL_ROOT")+this.DB_NAME;
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
            this.db = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ArrayList<String>> query(String sql){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        try {

            Statement st = this.db.createStatement();
            ResultSet rs = st.executeQuery(sql);
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
