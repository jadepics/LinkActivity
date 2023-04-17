package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    private Button backButton3;
    @FXML
    private RadioButton companyRB;
    @FXML
    private RadioButton userRB;

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
    public void switchToAziendaProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
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
            String insertToRegister=null;
           int i=0;
            if(userRB.isSelected()) {
                String insertFields = "INSERT INTO user(Email, Username, Password) VALUES ('";
                String insertValues = emailText + "','" + usernameText + "','" + checkpass + "')";
                insertToRegister = insertFields + insertValues;
            } else if (companyRB.isSelected()) {
                String insertFields = "INSERT INTO azienda_u(Email, NomeAzienda, Password) VALUES ('";
                String insertValues = emailText + "','" + usernameText + "','" + checkpass + "')";
                insertToRegister = insertFields + insertValues;
                i=1;
            }
        try {

                Statement statement = myConnection.createStatement();
                statement.executeUpdate(insertToRegister);
                if(i==0) {
                    switchToDashboard(event);
                }else {
                    switchToAziendaProfile(event);
                }
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("SignUpGoogle is a dummy function");
        alert.showAndWait();
    }


   @FXML
    private void regEmailUser() {
        String str;
        int a=0;
        int b=0;
        String[] pars = new String[10];
        str= regEmailUser.getText();
        pars[1]=str;

        String[] result = str.split("\\a");
        for (int i = 0;i < result[0].length(); i++){
            pars[0]= String.valueOf(result[0].charAt(i)); //parsa la parola in lettere per controllare se c'è la @

            if(pars[0].equals("@")){
                a=1;
            }
            if(a==1 && pars[0].equals(".")) {
                    b = 1;
            }
        }
        if(a==0 || b==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Immettere una mail valida");
            alert.showAndWait();
        }
    }

    @FXML
    private void regUsernameUser() {
    }

    @FXML
    private void regPassUser() {
       if(regPassUser.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Password Vuota");
            alert.showAndWait();

        }
    }

    @FXML
    private void regRepPassUser() {
        if(regRepPassUser.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Il campo non può essere vuoto");
            alert.showAndWait();

        } else if (!Objects.equals(regRepPassUser.getText(), regPassUser.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Le password non coincidono");
            alert.showAndWait();

        }
    }
}

