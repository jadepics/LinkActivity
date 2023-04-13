package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WhoAreUSecondViewGraphicController {

    @FXML
    private TextField whoAreUCommandLine;

    @FXML
    void executeCommand(ActionEvent event) throws IOException {
        String s= whoAreUCommandLine.getText();

        if(s.compareTo("goto login")== 0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) whoAreUCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else if(s.compareTo("goto register")==0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegistrationSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) whoAreUCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

}
