package linkactivity.linkactivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public EventDAO(){

        Connection myConnection = DBConnection.getDBConnection();

        String verifyLoginQuery = "SELECT * FROM evento";

        try {
            Statement statement = myConnection.createStatement();
            ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);
            System.out.println(queryLoginResult);
            List<String> ResultList= new ArrayList<>();
            while (queryLoginResult.next()) {
                EventBean lista= new EventBean();
                lista.setEventName(queryLoginResult.getString("nomeEvento"));
                ResultList.add(lista.getEventName());
                System.out.println(ResultList);
            }
        }
        catch(Exception e){
            System.out.println("erroreee");
            e.printStackTrace();
        }
    }
}

