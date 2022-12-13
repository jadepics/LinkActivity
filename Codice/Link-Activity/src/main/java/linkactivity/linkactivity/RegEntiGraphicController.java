package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegEntiGraphicController {

    @FXML
    private Button BackButton2;

    @FXML
    private Button EntiRegisterButton; //todo parte di registrazione vera e propria senza la quale torna errore minore al passaggio di schermata

    @FXML
    private Button LoginButton1;

    @FXML
    private Button SignUpGoogleButton1; //todo forse va levato il button in quanto funzione dummy, potrebbe portare problemi su sonarcloud

    @FXML
    private Button UpdateLogoButton; //todo parte di updatelogo vera e propria senza la quale torna errore minore al passaggio di schermata


    @FXML
    private void BackToWhoAreU() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) BackButton2.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void EntiRegister() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) EntiRegisterButton.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Login() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) LoginButton1.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void SignUpGoogle() /*throws IOException*/{
        //todo holy shit this shit has to be done SIGNUPGOOGLE
        System.out.println("Holy shit this shit has to be done SIGNUPGOOGLE");
    }

    @FXML
    private void UpdateLogo() /*throws IOException*/{
        //todo holy shit this shit has to be done UPDATELOGO
        System.out.println("Holy shit this shit has to be done UPDATELOGO");
    }

}
