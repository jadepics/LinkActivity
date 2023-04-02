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
    void joinEventButton() {
        EventBean k= y;
        int x= new ItemController().joinEvent(k);

    }

    @FXML
    void setDescriptionText(EventBean x){
        //descriptionText.setText(x);
        y= x;
        descriptionText.setText(x.getDescription());
    }

}
