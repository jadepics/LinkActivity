package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class JoinEventSecondViewGraphicController {

    @FXML
    private Text descriptionText;

    @FXML
    private TextField joinEventCommandLine;

    EventBean y= new EventBean();


    @FXML
    void executeCommand(ActionEvent event) {
        EventBean k=y;
        String s= joinEventCommandLine.getText();
        joinEventCommandLine.setText("");

        if(s.compareTo("joinEvent")==0){
            new ItemController().joinEvent(k);
        } else if(s.compareTo("back")==0){
            //TODO kill window
        }
    }

    @FXML
    void setDescriptionText(EventBean x){
        y= x;
        descriptionText.setText(x.getDescription());
    }

}

