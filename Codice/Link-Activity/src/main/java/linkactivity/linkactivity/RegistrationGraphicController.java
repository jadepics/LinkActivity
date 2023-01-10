package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class RegistrationGraphicController {

    @FXML
    private Button backButton1;

    @FXML
    private TextField regEmailUser;

    @FXML
    private TextField regUsernameUser;

    @FXML
    private Button loginButton2;

    @FXML
    private Button bottoneokreg;

    @FXML
    private Button signUpGoogleButton2; //todo forse va levato il button in quanto funzione dummy, potrebbe portare problemi su sonarcloud

    @FXML
    private Button userRegisterButton; //todo parte di registrazione vera e propria senza la quale torna errore minore al passaggio di schermata

    @FXML
    private PasswordField regPassUser;

    @FXML
    private PasswordField regRepPassUser;

    @FXML
    private Button BackButton3;

    @FXML
    private void backToWhoAreU() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) backButton1.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CareerBona.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void userRegister(ActionEvent event) throws IOException {
         //tutto ok quindi push sul db
            Connection myConnection = DBConnection.getDBConnection();

            String emailText = regEmailUser.getText();
            String usernameText = regUsernameUser.getText();
            String checkpass = regPassUser.getText();


            String insertFields = "INSERT INTO user(Email, Username, Password) VALUES ('";
            String insertValues = emailText + "','" + usernameText + "','" + checkpass + "')";
            String insertToRegister = insertFields + insertValues;

            try {

                Statement statement = myConnection.createStatement();
                statement.executeUpdate(insertToRegister);
                switchToDashboard(event);

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        }


//login ok, push su database ok
    @FXML
    private void login() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) loginButton2.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void signUpGoogle() /*throws IOException*/ {
        //todo  SIGNUPGOOGLE
        System.out.println("to be done SIGNUPGOOGLE");
    }


   @FXML
    private void regEmailUser() {
        String str;
        int a=0,b=0;
        String[] pars = new String[10];
        str= regEmailUser.getText();
        pars[1]=str;

        String[] result = str.split("\\a");
        for (int i = 0;i < result[0].length(); i++){
            pars[0]= String.valueOf(result[0].charAt(i)); //parsa la parola in lettere per controllare se c'è la @

            if(pars[0].equals("@")){
                a=1;
            }
            if(a==1) {
                if (pars[0].equals(".")) {
                    b = 1;
                }
            }
        }
        if(a==0 || b==0){
            System.out.println("Direi quello che direbbe Germano Mosconi");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Immettere una mail valida");
            alert.showAndWait();
        } else {
            System.out.println("ye");
        }
    }

    @FXML
    private void regUsernameUser() {
    }

    @FXML
    private void regPassUser() {
       if(regPassUser.getText().isEmpty()){
            System.out.println("PassVuota");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Password Vuota");
            alert.showAndWait();

        } else {
            System.out.println("Pass presa");
        }
    }

    @FXML
    private void regRepPassUser() {
        if(regRepPassUser.getText().isEmpty()){
            System.out.println("Repeat Password");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Il campo non può essere vuoto");
            alert.showAndWait();

        } else if (!Objects.equals(regRepPassUser.getText(), regPassUser.getText())) {
            System.out.println("Pass di conf non coincide");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Le password non coincidono");
            alert.showAndWait();

        } else {
            System.out.println("Pass okk");
        }
    }

}

