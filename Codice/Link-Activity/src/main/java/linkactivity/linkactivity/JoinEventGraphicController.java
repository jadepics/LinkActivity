package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import linkactivity.linkactivity.utilities.ShowAlertAid;

public class JoinEventGraphicController{

    @FXML
    private Text descriptionText;

    @FXML
    private Button joinEventButton;

    EventBean y= new EventBean();

    @FXML
    public void joinEventButton() throws IOExceptionHandler {
        EventBean k= y;
        new ItemController().joinEvent(k,"remove");
        ShowAlertAid.showalertinformation("You've joined the challange");

    }

    @FXML
    public void setDescriptionText(EventBean x){
        y= x;
        descriptionText.setText(x.getExpirationDate());
    }
}
