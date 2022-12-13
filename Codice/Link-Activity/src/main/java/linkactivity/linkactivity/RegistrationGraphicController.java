package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegistrationGraphicController {

    @FXML
    private Button BackButton1;

    @FXML
    private Button LoginButton2;

    @FXML
    private Button SignUpGoogleButton2; //todo forse va levato il button in quanto funzione dummy, potrebbe portare problemi su sonarcloud

    @FXML
    private Button UserRegisterButton; //todo parte di registrazione vera e propria senza la quale torna errore minore al passaggio di schermata

    @FXML
    void BackToWhoAreU() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) BackButton1.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void UserRegister() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CareerBona.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) UserRegisterButton.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void Login() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) LoginButton2.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void SignUpGoogle() /*throws IOException*/{
        //todo holy shit this shit has to be done SIGNUPGOOGLE
        System.out.println("Holy shit this shit has to be done SIGNUPGOOGLE");
    }

}

