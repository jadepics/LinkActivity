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

    /*public static StringBuilder getLogo(String nomeaz) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\CompanyLogo-Filesystem.txt"));

        String line;
        boolean foundCompany = false;
        String companyString = "";
        StringBuilder sb = new StringBuilder();

        // Lettura del file riga per riga
        while ((line = reader.readLine()) != null) {
            // Se la riga contiene "IBM", copia la stringa successiva
            if (!foundCompany && line.contains(nomeaz)) {
                companyString = line.substring(line.indexOf(nomeaz) + nomeaz.length()+1).trim();
                foundCompany = true;
            } else if (foundCompany) {
                // Scandisce la stringa per cercare il carattere "\" e aggiunge un secondo "\"

                for (char h : companyString.toCharArray()) {
                    sb.append(h);
                    if (h == '\\') {
                        sb.append('\\');
                    }
                }
                break;
            }
        }
        reader.close();
        return sb;
    }*/

    public int modifyParticipantNumber(EventBean x) {
        Connection myConnection = DBConnection.getDBConnection();
        String updatePartecipantQuery;
        //fare prepared statment altrimenti sql injection
        int k = x.getPartecipantNumber() - 1;
        System.out.println(k);
        String a = x.getEventName();
        System.out.println(a);
          updatePartecipantQuery = String.format("UPDATE evento SET numeroPartecipanti = %d WHERE nomeEvento = '%s';",k, a);
        System.out.println("non so scoppiato");
        try {
            Statement statement = myConnection.createStatement();
            System.out.println("non so scoppiato sto nel try");
            statement.execute(updatePartecipantQuery);
            System.out.println("non so scoppiato sto nel try dopo esecuzione");

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
            System.out.println("prima della data");
            statement.setString(3, event.getEventModelData());    //come devo modifica ste date
            System.out.println("post prima data");
            statement.setString(4, event.getEventModelExpirationDate());
            statement.setInt(5, event.getEventModelPartecipantNumber());
            statement.setString(6, event.getEventModelNomeAzienda());
            System.out.println(event.getEventModelNomeAzienda());
            statement.setString(7, event.getEventModelTag());
            System.out.println("pre execute della dao");
            newKeys = statement.executeUpdate();
            System.out.println("post execute devo entrare nell'if");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newKeys;
    }
}


