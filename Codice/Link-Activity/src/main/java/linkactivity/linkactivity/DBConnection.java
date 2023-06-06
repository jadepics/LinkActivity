package linkactivity.linkactivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String databaseName = "mydb";
    private static final String databaseUser = "root";
    private static final String databasePass = "toor";
    private static final String urlDB = "jdbc:mysql://127.0.0.1/"+ databaseName;
    private static Connection connection;

    private DBConnection(){

    }

    public static Connection getDBConnection(){

        try{
            if(connection==null){
                connection = DriverManager.getConnection(urlDB, databaseUser, databasePass);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}