package linkactivity.linkactivity;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;


public class EventDAO {

    public List<EventModel> getEvent(String tag) {

        Connection myConnection = DBConnection.getDBConnection();

        String verifyLoginQuery;
        if (tag.equals("java")) {
            verifyLoginQuery = "SELECT *  FROM evento WHERE tag= 'Java'";
        } else if (tag.equals("cpp")) {
            verifyLoginQuery = "SELECT * FROM evento WHERE tag= 'C++'";
        } else if (tag.equals("python")) {
            verifyLoginQuery = "SELECT *  FROM evento WHERE tag= 'Python'";
        } else {
            verifyLoginQuery = "SELECT * FROM evento";
        }

        List<EventModel> ResultList = null;

        try {
            Statement statement = myConnection.createStatement();
            ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);
            ResultList = new ArrayList<>();
            int i = 0;
            while (queryLoginResult.next()) {


                EventModel x = new EventModel(queryLoginResult.getString("nomeEvento"),
                        queryLoginResult.getDate("data"), queryLoginResult.getDate("expirationDate"),
                        queryLoginResult.getString("descrizioneEvento"), Integer.parseInt(queryLoginResult.getString("numeroPartecipanti")),
                        queryLoginResult.getString("nomeAzienda"), queryLoginResult.getString("tag"));
                ResultList.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultList;
    }

    public int modifyParticipantNumber(EventBean x) {
        /*Connection myConnection = DBConnection.getDBConnection();
        String updatePartecipantQuery;

        //mettere UNIQUE il nome dell'evento affinche non ci siano eventi con lo stesso nome
        //fare prepared statment altrimenti sql injection
        //UPDATE Evento set NumeroPartecipanti = k  WHERE NomeEvento = x.getNomeEvento();
        int k = x.getPartecipantNumber() - 1;
        System.out.println(k);
        String a = x.getEventName();
       // updatePartecipantQuery = "UPDATE evento set numeroPartecipanti = '" + k + "'  WHERE nomeEvento = '" + a + "'";
          updatePartecipantQuery = "UPDATE evento SET `numeroPartecipanti` ='"+ (x.getPartecipantNumber()-1) +"' WHERE (`nomeEvento` = x.getEventName())";
       // updatePartecipantQuery = "UPDATE evento SET numeroPartecipanti = '"+k+"' WHERE nomeEvento = '"+a+"')";
        System.out.println("non so scoppiato");
        try {
            Statement statement = myConnection.createStatement();
            System.out.println("non so scoppiato sto nel try");
            statement.executeQuery(updatePartecipantQuery);
            System.out.println("non so scoppiato sto nel try dopo esecuzione");
            //if(queryUpdateResult){
            //    System.out.println("query di update ok");
            //}

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return 1;
    }
}

