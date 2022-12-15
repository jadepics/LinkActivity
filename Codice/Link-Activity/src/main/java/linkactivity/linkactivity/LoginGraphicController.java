package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginGraphicController {

    @FXML
    private Button backButton3;

    @FXML
    private Button loginButton3;

    @FXML
    private Button loginWithGoogleButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField emailUsernameLogin;

    @FXML
    private PasswordField passLogin;

    @FXML
    private void backToWhoAreU() throws IOException { //todo levare shortcut register su login
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) backButton3.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void login() throws IOException{
        int a=0,b=0;

        if(emailUsernameLogin.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Immettere Email/Username validi");
            alert.showAndWait();
        }

        //TODO da qui partirebbe controllo al database per esistenza e correttezza credenziali

        if(passLogin.getText().isEmpty()){
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Immettere Password");
            alert.showAndWait();
        }
        //TODO da qui partirebbe controllo al datbase per esistenza e correttezza credenziali
        // e se tutto è andato a buon fine viene caricata la schermata di destinazione in base a se credenziali utente
        // o credenziali azienda

    }

    @FXML
    private void loginGoogle() {
    }

    @FXML
    void emailUsernameLogin() {

    }

    @FXML
    void passLogin() {

    }
}

