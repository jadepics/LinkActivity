package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.ShowAlertAid;

import java.io.IOException;
import java.util.Objects;

public class RegistrationSecondViewGraphicController {

    @FXML
    private TextField registrationCommandLine;

    @FXML
    private Text registrationEmailText;

    @FXML
    private Text registrationPasswordText;

    @FXML
    private Text registrationUsernameText;
    @FXML
    private Text registrationProfileTypeText;

    @FXML
    private Text registrationRepeatPasswordText;

    @FXML
    void executeCommand() throws IOException, IOExceptionHandler {
        String s = registrationCommandLine.getText();
        registrationCommandLine.setText("");

        if (s.matches("set email .*")) {
            String email = s.replace("set email ", "");
            if (email.contains("@") && email.contains(".")) {
                registrationEmailText.setText(email);
            } else {
                ShowAlertAid.showalerterror("Email is not valid ");
            }
        } else if (s.matches("set username .*")) {
            String username = s.replace("set username ", "");
            usernamecheck(username);
        } else if (s.matches("set password .*")) {
            String pass = s.replace("set password ", "");
            passcheck(pass);
        } else if (s.matches("set repeat password .*")) {
            String repPass = s.replace("set repeat password ", "");
            registrationRepeatPasswordText.setText(repPass);
            reppasscheck(repPass);
        }
        else if (s.matches("set profile .*")) {
                String profileType = s.replace("set profile ", "");
                registrationProfileTypeText.setText(profileType);
            } else if (s.compareTo("goto googleSignUp") == 0) {

                ShowAlertAid.showalertinformation("GoogleSignUp is a dummy function");

        } else if (s.compareTo("goto login") == 0) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginSecondView.fxml")));
                Scene scene = new Scene(root);
                Stage stage = (Stage) registrationCommandLine.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else if (s.compareTo("submit") == 0) {
                String type = registrationProfileTypeText.getText();
                String email = registrationEmailText.getText();
                String username = registrationUsernameText.getText();
                String pass = registrationPasswordText.getText();
                fieldscheck(type, email, username, pass);
                submitAid(type, email, username, pass);
        }
    }

    private void submitAid(String type, String email, String username, String pass) throws IOExceptionHandler {
        if (!(registrationPasswordText.getText().matches(registrationRepeatPasswordText.getText()))) {
            ShowAlertAid.showalerterror("Passwords not match");
        } else {
            if (type.matches("user")) {
                UserBean userBean = new UserBean(email, username, pass);
                new LoginController.UserRegistration(userBean);
                Stage stage = (Stage) registrationCommandLine.getScene().getWindow();
                FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("FavouriteTagInsertSecondView.fxml")));
                Scene scene;
                try {
                    scene = new Scene(root.load(), 690, 518);
                    stage.setScene(scene);
                    stage.show();
                    FavouriteTagInsertSecondViewGraphicController a = root.getController();
                    a.setUserBean(userBean);
                } catch (IOException e) {
                    throw new IOExceptionHandler("IOException error");
                }
            } else if (type.matches("company")) {
                CompanyBean companyBean = new CompanyBean(email, username, pass);
                new LoginController.CompanyRegister(companyBean);
                Stage stage = (Stage) registrationCommandLine.getScene().getWindow();
                FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("InsertLogoAziendaSecondView.fxml")));
                Scene scene;
                try {
                    scene = new Scene(root.load(), 690, 518);
                    stage.setScene(scene);
                    stage.show();
                    InsertLogoAziendaSecondViewGraphicController a = root.getController();
                    a.setCompanyName(companyBean);
                } catch (IOException e) {
                    throw new IOExceptionHandler("IOException error");
                }
            }
        }
    }

    private void fieldscheck(String type, String email, String username, String pass) {
        if(type.isEmpty() || email.isEmpty()|| username.isEmpty()|| pass.isEmpty()){
            ShowAlertAid.showalerterror("Fields are empty");
        }
    }

    private void reppasscheck(String repPass) {
        if (repPass.isEmpty()) {
            ShowAlertAid.showalerterror("Repeat password is empty");
        }
    }

    private void passcheck(String pass) {
        if (pass.isEmpty()) {
            ShowAlertAid.showalerterror("Password is empty");
        } else {
            registrationPasswordText.setText(pass);
        }
    }

    private void usernamecheck(String username) {
        if (username.isEmpty()) {
            ShowAlertAid.showalerterror("Username is not valid ");
        } else {
            registrationUsernameText.setText(username);
        }
    }
}
