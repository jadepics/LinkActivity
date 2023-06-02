package linkactivity.linkactivity;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                        queryLoginResult.getString("data"), queryLoginResult.getString("expirationDate"),
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
        Connection myConnection = DBConnection.getDBConnection();
        String updatePartecipantQuery;
        int k = x.getPartecipantNumber() - 1;
        String a = x.getEventName();
          updatePartecipantQuery = String.format("UPDATE evento SET numeroPartecipanti = %d WHERE nomeEvento = '%s';",k, a);
        try {
            Statement statement = myConnection.createStatement();
            statement.execute(updatePartecipantQuery);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int insertEvent(EventModel event){
        int newKeys=-1;
        Connection myConnection = DBConnection.getDBConnection();
        try(PreparedStatement statement =myConnection.prepareStatement("INSERT evento(nomeEvento, descrizioneEvento, data, expirationDate,numeroPartecipanti,nomeAzienda,tag) VALUES (?,?,?,?,?,?,?);")) {
            statement.setString(1, event.getEventModelName());
            statement.setString(2, event.getEventModelDescription());
            statement.setString(3, event.getEventModelData());
            statement.setString(4, event.getEventModelExpirationDate());
            statement.setInt(5, event.getEventModelPartecipantNumber());
            statement.setString(6, event.getEventModelNomeAzienda());
            statement.setString(7, event.getEventModelTag());
            newKeys = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newKeys;
    }
   /* public EventModel getEventByName(String nome) { //Todo check questa è per test
        EventModel eventModel = new EventModel();
        Connection myConnection = DBConnection.getDBConnection();
        String query= "SELECT * FROM evento WHERE nomeEvento = ?;";
        try (Statement statement = myConnection.prepareStatement(query)) {
            statement.setString(1,nome);
            ResultSet resultSet = statement.executeQuery();     //questi errori non li capisco
            if (resultSet.next()) {
                eventModel.setEventModelName(resultSet.getString("nomeEvento"));
                eventModel.setEventModelDescription(resultSet.getString("descrizioneEvento"));
                eventModel.setEventModelData(resultSet.getString("data"));
                eventModel.setEventModelExpirationDate(resultSet.getString("expirationDate"));
                eventModel.setEventModelPartecipantNumber(Integer.parseInt(resultSet.getString("numeroPartecipanti")));
                eventModel.setEventModelTag(resultSet.getString("tag"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return eventModel;
    }*/

}


