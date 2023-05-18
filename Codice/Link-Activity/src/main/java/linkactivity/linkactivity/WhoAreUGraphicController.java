package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WhoAreUGraphicController {

    @FXML
    private Button loginButton;

    @FXML
    private Button registerbutton;

    @FXML
    private void login() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage2= (Stage) loginButton.getScene().getWindow();
        stage2.setTitle("Link-Activity");
        stage2.setScene(scene);
        stage2.setResizable(false);
        stage2.show();
        }

    @FXML
    private void regUser() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Registration.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) registerbutton.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}

