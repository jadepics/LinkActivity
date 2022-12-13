package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginGraphicController {

    @FXML
    private Button BackButton3;

    @FXML
    private Button LoginButton3;

    @FXML
    private Button LoginWithGoogleButton;

    @FXML
    private Button RegisterButton;

    @FXML
    private void BackToWhoAreU() throws IOException { //todo levare shortcut register su login
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) BackButton3.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Login() throws IOException{

    }

    @FXML
    private void LoginGoogle() {
    }

}

