package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChooseInterfaceGraphicController {

    @FXML
    private RadioButton rbCommandLine;

    @FXML
    private RadioButton rbNormal;

    @FXML
    void switchToCommandLine() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreUSecondView.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) rbCommandLine.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToNormal() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) rbCommandLine.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
