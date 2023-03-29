package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class JoinEventGraphicController {

    @FXML
    private Text descriptionText;

    @FXML
    private Button joinEventButton;

    @FXML
    void joinEventButton() {
        System.out.println("joinevent");
    }

    @FXML
    void setDescriptionText(String x){
        descriptionText.setText(x);
    }

}
