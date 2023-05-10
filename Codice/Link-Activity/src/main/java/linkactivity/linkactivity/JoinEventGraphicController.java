package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class JoinEventGraphicController{

    @FXML
    private Text descriptionText;

    @FXML
    private Button joinEventButton;

    EventBean y= new EventBean();

    @FXML
    public void joinEventButton() {
        EventBean k= y;
        new ItemController().joinEvent(k);
    }

    @FXML
    public void setDescriptionText(EventBean x){
        y= x;
        descriptionText.setText(x.getDescription());
    }
}
