package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtility {
    public static String driver;
    public static String url;
    public static String username;
    public static String password;
    static {
        ResourceBundle rd =ResourceBundle.getBundle("dbdetails");
        driver=rd.getString("db.driver");
        url=rd.getString("db.url");
        username=rd.getString("db.username");
        password=rd.getString("db.password");
    }
    public static Connection provideConnection(){
        Connection conn=null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        String url="jdbc:mysql://localhost:3306/teambanao";

        try {
            conn=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }
}
