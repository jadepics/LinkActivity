package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    void executeCommand(ActionEvent event) throws IOException {
        String s= eventCreateCommandLine.getText();
        eventCreateCommandLine.setText("");

        if(s.matches("set event name .*")){
            String name= s.replace("set event name ","");
            eventCreateEventNameText.setText(name);
        } else if(s.matches("set event date .*")){
             String date= s.replace("set event date ","");
             eventCreateEventDateText.setText(date);
        } else if(s.matches("set expiration date .*")){
            String expdate= s.replace("set expiration date ","");
            eventCreateExpirationDateText.setText(expdate);
        } else if(s.matches("set tag .*")){
            String tag= s.replace("set tag ","");
            if(!(tag.matches("java") || tag.matches("python") || tag.matches("cpp"))){
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setHeaderText(tag+" is not a valid tag");
                alert2.showAndWait();
            } else {
                eventCreateTagText.setText(tag);
            }
        } else if(s.matches("set participant number .*")){
            String num= s.replace("set participant number ", "");
            eventCreatePartecipantNumberText.setText(num);
        } else if(s.compareTo("submit")==0){
            //TODO take all from fxml text and push su db
            //TODO convertire string num partecipanti in INT e forse data
        } else if(s.compareTo("back")==0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) eventCreateCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
}
