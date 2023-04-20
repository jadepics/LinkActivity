package linkactivity.linkactivity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class EventCreateGraphicController {
        @FXML
        private Button backButton5;

        @FXML
        private Button createItButton;

        @FXML
        private TextField eventName;

    @FXML
    private TextField expireDateInsert;

    @FXML
    private TextField initialDateInsert;
    @FXML
    private TextField Description;

        @FXML
        private TextField maxPartecipantNumber;

    @FXML
    private ChoiceBox<String> tagInsert;

    private String[] tags ={"C++","Python","Java"};


    public void initialize(){
        tagInsert.getItems().addAll(tags);
    }


        @FXML
        private void backToAzioniAzienda() throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
            Scene scene = new Scene(root, 690, 518);
            Stage stage = (Stage) backButton5.getScene().getWindow();

            stage.setTitle("Link-Activity");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }
//    public static LocalDate getDateFromString(String string, DateTimeFormatter format)
//    {
//        LocalDate date = LocalDate.parse(string, format);
//        return date;
//    }

    public static int convert(String s){
        int val=0;
        try {
            val = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {

            // This is thrown when the String
            // contains characters other than digits
            System.out.println("Invalid String");
        }
    return val;
    }

        private String nameA;

        @FXML
        public void createItGotoPay() throws IOException, DuplicatedEventException, ParseException {
            String date= initialDateInsert.getText();
            String expdate= expireDateInsert.getText();

            DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            Date initialDate= df.parse(date);
            Date expireDate=df.parse(expdate);

            System.out.println(initialDate);
            System.out.println(expireDate);

            /*DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM, yyyy");
            LocalDate initialDate= getDateFromString(initialDateInsert.getText(), format);
            LocalDate expireDate= getDateFromString(expireDateInsert.getText(), format);*/
            int partecipant= convert(maxPartecipantNumber.getText());
            EventBean eventBean = new EventBean(eventName.getText(),initialDate,expireDate,Description.getText(), partecipant,nameA,tagInsert.getValue());
//BARBERADDSERVICECONTROLLER 43
            new eventCreateController.newEvent(eventBean);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DummyPay.fxml")));
            Scene scene = new Scene(root, 690, 518);
            Stage stage = (Stage) createItButton.getScene().getWindow();

            stage.setTitle("Link-Activity");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }
    public void newSpostare(String companyName){
        nameA = companyName;
    }

}

