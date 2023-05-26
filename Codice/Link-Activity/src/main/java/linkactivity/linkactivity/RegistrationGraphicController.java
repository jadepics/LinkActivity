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
    public void switchToSelectFavourite(ActionEvent event) throws IOException {
        String emailText = regEmailUser.getText();
        String usernameText = regUsernameUser.getText();
        String checkpass = regPassUser.getText();
        UserBean userBean = new UserBean(emailText, usernameText, checkpass);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("FavouriteTagInsert.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            FavouriteTagInsertGraphicController a = root.getController();
            a.spostare(userBean); // devo portarmi il nome dello user in favouriteTagInsert per la query in cui metto nel db i tag preferiti
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
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


            String emailText = regEmailUser.getText();
            String usernameText = regUsernameUser.getText();
            String checkpass = regPassUser.getText();
           int i=0;
            if(userRB.isSelected()) {
                UserBean userBean = new UserBean(emailText, usernameText, checkpass);
                System.out.println(userBean.getUsername());
                new LoginController.UserRegistration(userBean);
            } else if (companyRB.isSelected()) {
                CompanyBean companyBean = new CompanyBean(emailText,usernameText,checkpass);
                new LoginController.CompanyRegister(companyBean);
                i=1;
            }

                if(i==0) {
                    switchToSelectFavourite(event);
                }else {
                    switchToAziendaProfile(event);
                }

        }

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
    private void signUpGoogle(){
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

