package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    CompanyBean y;

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
                throw new RuntimeException(e);
            }

            //TODO take all from fxml text and push su db
            //TODO convertire string num partecipanti in INT e forse data
        } else if(s.compareTo("back")==0){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                AzioniAziendaSecondViewGraphicController a = root.getController();
                a.currentCompany(y);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void currentCompany(CompanyBean x){
        y=x;
    }

}
