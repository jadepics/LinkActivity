package linkactivity.linkactivity;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;


public class EventDAO {

    public List<EventModel> getEvent(String tag) {

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

        List<EventModel> ResultList = null;

        try {
            Statement statement = myConnection.createStatement();
            ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);
            //System.out.println(queryLoginResult);
            ResultList = new ArrayList<>();
            int i=0;
            while (queryLoginResult.next()) {



                EventModel x= new EventModel(queryLoginResult.getString("nomeEvento"),
                        queryLoginResult.getDate("data"), queryLoginResult.getDate("expirationDate"),
                        queryLoginResult.getString("descrizioneEvento"), Integer.parseInt(queryLoginResult.getString("numeroPartecipanti")),
                        queryLoginResult.getString("nomeAzienda"), queryLoginResult.getString("tag"));
                ResultList.add(x);
            }
        } catch (Exception e) {
            System.out.println("erroreee");
            e.printStackTrace();
        }

        return ResultList;
    }
}

