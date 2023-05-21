package linkactivity.linkactivity;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    private CompanyBean companyBean;



    public void initialize(){
        tagInsert.getItems().addAll(tags);
    }


        @FXML
        private void backToAzioniAzienda(){

            Stage stage= (Stage) backButton5.getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                AzioniAziendaGraphicController a = root.getController();
                a.spostare(companyBean); //da modificare il metodo
            } //PROBLEMA CON CAMBIO INTERFACCIA
            catch (IOException e){
                throw new RuntimeException(e);
            }
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



        @FXML
        public void createItGotoPay() throws DuplicatedEventException {
            int partecipant= convert(maxPartecipantNumber.getText());
            EventBean eventBean = new EventBean(eventName.getText(),Description.getText(),initialDateInsert.getText(),expireDateInsert.getText(), partecipant,companyBean.getNomeAzienda(),tagInsert.getValue());
//BARBERADDSERVICECONTROLLER 43
            CompanyBean companyBean= new CompanyBean(eventBean.getNomeAzienda());
            new eventCreateController.newEvent(eventBean);

            Stage stage = (Stage) createItButton.getScene().getWindow();
            FXMLLoader root;
            root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("DummyPay.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setTitle("Link-Activity");
                stage.setScene(scene);
                stage.show();
                DummyPayGraphicController o = root.getController();
                o.setCurrentCompany(companyBean); //TODO forse deve passare la bean non una string
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert false;

        }
    public void newSpostare(CompanyBean companyBean2){
        companyBean = companyBean2;
    }

}

