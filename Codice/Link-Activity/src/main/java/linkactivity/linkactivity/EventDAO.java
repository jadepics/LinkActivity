package linkactivity.linkactivity;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

        List<EventModel> resultList = null;

        try (Statement statement = myConnection.createStatement()){

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


    public int modifyParticipantNumber(EventBean x, String todo) throws IOExceptionHandler {
        Connection myConnection = DBConnection.getDBConnection();
        String updatePartecipantQuery;
        int k;
        if(Objects.equals(todo, "remove")) {
            k = x.getPartecipantNumber() - 1;
        } else {
            k= x.getPartecipantNumber()+1;
        }
        String a = x.getEventName();
          updatePartecipantQuery = String.format("UPDATE evento SET numeroPartecipanti = %d WHERE nomeEvento = '%s';",k, a);
        try(Statement statement = myConnection.createStatement()){
            statement.execute(updatePartecipantQuery);

        } catch (Exception e) {
            throw new IOExceptionHandler("IOException error");
        }
        return 1;
    }

    public int insertEvent(EventModel event) throws IOExceptionHandler {
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
            throw new IOExceptionHandler();
        }
        return newKeys;
    }


    public static int getPartecipantNumber(String eventName) throws IOExceptionHandler {
        int num = 0;
        Connection myConnection = DBConnection.getDBConnection();
        String query=String.format("SELECT numeroPartecipanti FROM evento WHERE nomeEvento ='%s'", eventName);
        try(Statement statement =myConnection.createStatement())
        {  ResultSet result=  statement.executeQuery(query);
            num= result.getInt(1);
            System.out.println(num);
            return num;
        }


        catch(SQLException e){
            throw new IOExceptionHandler();
        }

    }







   public EventModel getEventByName(String nome) { //Todo check questa è per test
        EventModel eventModel = new EventModel();
        Connection myConnection = DBConnection.getDBConnection();
        String query = String.format("SELECT * FROM evento WHERE nomeEvento = '%s';",nome);
        try (Statement statement = myConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);     //questi errori non li capisco
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
    }

}


