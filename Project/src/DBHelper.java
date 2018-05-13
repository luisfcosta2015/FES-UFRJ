import java.sql.*;

public class DBHelper {

    Connection db;
    private final String DB_NAME = "fugzjqzd";
    private final String URL = "jdbc:postgresql://elmer.db.elephantsql.com:5432/"+DB_NAME;
    private final String USERNAME = "fugzjqzd";
    private final String PASSWORD = "YdCGgBtsj2HcFB-lsq5G54kPBq4TBWXE";

    public static void main(String[] args) throws Exception{
        DBHelper dbh = new DBHelper();
        System.out.println(dbh.connect());

    }


    public DBHelper(){
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

    public Object query(String sql){
        try {
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();

            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }



}
