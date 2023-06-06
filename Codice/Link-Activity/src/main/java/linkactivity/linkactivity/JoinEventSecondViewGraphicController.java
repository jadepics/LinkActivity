package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.ShowAlertAid;

public class JoinEventSecondViewGraphicController {

    @FXML
    private Text descriptionText;

    @FXML
    private TextField joinEventCommandLine;

    EventBean y= new EventBean();


    @FXML
    void executeCommand(ActionEvent event) throws IOExceptionHandler {
        EventBean k=y;
        String s= joinEventCommandLine.getText();
        joinEventCommandLine.setText("");

        if(s.compareTo("joinEvent")==0){
            new ItemController().joinEvent(k,"remove");
            ShowAlertAid.showalertinformation("You've joined the challange");

        } else if(s.compareTo("back")==0){
            Stage stage= (Stage) joinEventCommandLine.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    void setDescriptionText(EventBean x){
        y= x;
        descriptionText.setText(x.getExpirationDate());
    }

}

