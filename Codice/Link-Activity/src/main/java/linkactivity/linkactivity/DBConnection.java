package linkactivity.linkactivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String DATABASE_NAME = "mydb";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASS = "toor";
    private static final String URL_DB = "jdbc:mysql://127.0.0.1/"+ DATABASE_NAME;
    private static Connection connection;

    private DBConnection(){

    }

    public static Connection getDBConnection(){

        try{
            if(connection==null){
                connection = DriverManager.getConnection(URL_DB, DATABASE_USER, DATABASE_PASS);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}