package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.GUISwtichAid;

import java.io.IOException;
import java.util.Objects;

public class EventCreateSecondViewGraphicController {

    @FXML
    private TextField eventCreateCommandLine;

    @FXML
    private Text eventCreateEventDateText;

    @FXML
    private Text eventCreateEventNameText;

    @FXML
    private Text eventCreateExpirationDateText;

    @FXML
    private Text eventCreatePartecipantNumberText;

    @FXML
    private Text eventCreateTagText;
    @FXML
    private Text eventCreateEventDescriptionText;
    CompanyBean y;

    @FXML
    void executeCommand(ActionEvent event) throws IOException, DuplicatedEventException, IOExceptionHandler {
        String s= eventCreateCommandLine.getText();
        eventCreateCommandLine.setText("");

        if(s.matches("set event name .*")){
            String name= s.replace("set event name ","");
            eventCreateEventNameText.setText(name);
        }else if(s.matches("set description .*")){
            String description= s.replace("set description ","");
            eventCreateEventDescriptionText.setText(description); }
        else if(s.matches("set event date .*")){
             String date= s.replace("set event date ","");
             eventCreateEventDateText.setText(date);
        } else if(s.matches("set expiration date .*")){
            String expdate= s.replace("set expiration date ","");
            eventCreateExpirationDateText.setText(expdate);
        } else if(s.matches("set tag .*")){
            String tag= s.replace("set tag ","");
            taginsertaid(tag);
        } else if(s.matches("set participant number .*")){
            String num= s.replace("set participant number ", "");
            eventCreatePartecipantNumberText.setText(num);
        } else if(s.compareTo("submit")==0){
            String name= eventCreateEventNameText.getText();
            String descrizione= eventCreateEventDescriptionText.getText();
            String date= eventCreateEventDateText.getText();
            String exDate= eventCreateExpirationDateText.getText();
            String tag = eventCreateTagText.getText();
            int num = convert1(eventCreatePartecipantNumberText.getText()) ;
            String nomeAzienda = y.getNomeAzienda();
            EventBean eventBean = new EventBean(name, descrizione,date,exDate,num, nomeAzienda,tag);
            new EventCreateController.newEvent(eventBean);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("DummyPaySecondView.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                DummyPaySecondViewGraphicController a = root.getController();
                a.currentCompany(y);
            }
            catch (IOException e){
                throw new IOExceptionHandler("IOException error");
            }
        } else if(s.compareTo("back")==0){
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
            GUISwtichAid.azioniaziendasecondviewguiswitch(event, y, root);
        }
    }

    private void taginsertaid(String tag){
        if(!(tag.matches("Java") || tag.matches("Python") || tag.matches("C\\+\\+"))){
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText(tag+" is not a valid tag");
            alert2.showAndWait();
        } else {
            eventCreateTagText.setText(tag);
        }
    }

    public void currentCompany(CompanyBean x){
        y=x;
    }
    private static int convert1(String s){
        int val=0;
        try {
            val = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return val;
    }
}
//  TODO check not null
