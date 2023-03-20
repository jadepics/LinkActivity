package linkactivity.linkactivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public List<String> getEvent(String tag) {

        Connection myConnection = DBConnection.getDBConnection();

        String verifyLoginQuery;
        if(tag.equals("java")){
            verifyLoginQuery = "SELECT *  FROM evento WHERE tag= 'Java'" ;
        } else if(tag.equals("cpp")){
            verifyLoginQuery="SELECT * FROM evento WHERE tag= 'C++'";
        } else if(tag.equals("python")){
            verifyLoginQuery="SELECT *  FROM evento WHERE tag= 'Python'";
        } else {
            verifyLoginQuery="SELECT * FROM evento";
        }
        //nomeEvento,descrizioneEvento,data, expirationDate, nomeAzienda
        //String verifyLoginQuery = "SELECT * FROM evento";

        List<String> ResultList = null;
        try {
            Statement statement = myConnection.createStatement();
            ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);
            //System.out.println(queryLoginResult);
            ResultList = new ArrayList<>();
            int i=0;
            while (queryLoginResult.next()) {
                //EventBean lista= new EventBean();
                //lista.setEventName(queryLoginResult.getString("nomeEvento"));
                //ResultList.add(lista.getEventName());

                ResultList.add(queryLoginResult.getString("nomeEvento"));
                ResultList.add(queryLoginResult.getString("descrizioneEvento"));
                ResultList.add(String.valueOf(queryLoginResult.getDate("data")));
                //System.out.println(ResultList.get(2));
                ResultList.add(String.valueOf(queryLoginResult.getDate("expirationDate")));
                //System.out.println(ResultList.get(3));
                ResultList.add(queryLoginResult.getString("numeroPartecipanti"));
                ResultList.add(queryLoginResult.getString("nomeAzienda"));
                ResultList.add(queryLoginResult.getString("tag"));

                System.out.println(ResultList.get(i)+"   rrrrrrrr");
                i++;
            }
        } catch (Exception e) {
            System.out.println("erroreee");
            e.printStackTrace();
        }
        return ResultList;
    }
}

