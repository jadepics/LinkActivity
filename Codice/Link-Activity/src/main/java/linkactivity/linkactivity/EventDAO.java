package linkactivity.linkactivity;


import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


public class EventDAO {

    public List<EventModel> getEvent(String tag) {

        Connection myConnection = DBConnection.getDBConnection();

        String verifyLoginQuery ="SELECT * FROM evento";
        if (tag.equals("java")) {
            verifyLoginQuery = "SELECT *  FROM evento WHERE tag= 'Java'";
        } else if (tag.equals("cpp")) {
            verifyLoginQuery = "SELECT * FROM evento WHERE tag= 'C++'";
        } else if (tag.equals("python")) {
            verifyLoginQuery = "SELECT *  FROM evento WHERE tag= 'Python'";
        }
//        } else if(tag.equals("")) {
//            verifyLoginQuery = "SELECT * FROM evento";
//        }

        List<EventModel> resultList = null;

        try {
            Statement statement = myConnection.createStatement();
            ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);
            resultList = new ArrayList<>();
            while (queryLoginResult.next()) {


                EventModel x = new EventModel(queryLoginResult.getString("nomeEvento"),
                        queryLoginResult.getDate("data"), queryLoginResult.getDate("expirationDate"),
                        queryLoginResult.getString("descrizioneEvento"), Integer.parseInt(queryLoginResult.getString("numeroPartecipanti")),
                        queryLoginResult.getString("nomeAzienda"), queryLoginResult.getString("tag"));
                resultList.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
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

    public int insertEvent(EventModel event){
        int newKeys=-1;
        System.out.println(event.eventName);
        Connection myConnection = DBConnection.getDBConnection();
        try(PreparedStatement statement =myConnection.prepareStatement("INSERT evento(nomeEvento, descrizioneEvento, data, expirationDate,numeroPartecipanti,nomeAzienda,tag) VALUES (?,?,?,?,?,?,?);")) {
            statement.setString(1, event.getEventModelNomeAzienda());
            statement.setString(2, event.getEventModelDescription());
            System.out.println("prima della data");
            statement.setDate(3, (Date) event.getEventModelData());   //come devo modifica ste date
            System.out.println("post prima data");
            statement.setDate(4, (Date) event.getEventModelExpirationDate());//todo
            statement.setInt(5, event.getEventModelPartecipantNumber());
            statement.setString(6, event.getEventModelNomeAzienda());
            statement.setString(7, event.getEventModelTag());
            System.out.println("pre execute della dao");
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            System.out.println("post execute devo entrare nell'if");
            if(resultSet.next()) {
                newKeys = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newKeys;
    }
}


