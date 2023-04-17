package linkactivity.linkactivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String databasename = "mydb";
    private static final String databaseuser = "root";
    private static final String databasepassword = "toor";
    private static final String url = "jdbc:mysql://127.0.0.1/"+ databasename;
    private static Connection connection;

    private DBConnection(){

    }

    public static Connection getDBConnection(){

        try{
            if(connection==null){
                connection = DriverManager.getConnection(url, databaseuser, databasepassword);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}