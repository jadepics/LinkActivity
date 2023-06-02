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
    void executeCommand() throws IOException {
        String s = registrationCommandLine.getText();
        registrationCommandLine.setText("");

        if (s.matches("set email .*")) {
            String email = s.replace("set email ", "");
            if (email.contains("@") && email.contains(".")) {
                registrationEmailText.setText(email);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Email is not valid ");
                alert.showAndWait();
            }
        } else if (s.matches("set username .*")) {
            String username = s.replace("set username ", "");
            if (username.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Username is not valid ");
                alert.showAndWait();
            } else registrationUsernameText.setText(username);
        } else if (s.matches("set password .*")) {
            String pass = s.replace("set password ", "");
            if (pass.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Password is empty");
                alert.showAndWait();
            } else registrationPasswordText.setText(pass);
        } else if (s.matches("set repeat password .*")) {
            String repPass = s.replace("set repeat password ", "");
            registrationRepeatPasswordText.setText(repPass);
            if (repPass.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Repeat password is empty");
                alert.showAndWait();
            }
        }

        else if (s.matches("set profile .*")) {
                String profileType = s.replace("set profile ", "");
                registrationProfileTypeText.setText(profileType);
            } else if (s.compareTo("goto googleSignUp") == 0) {
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setHeaderText("GoogleSignUp is a dummy function");
                alert2.showAndWait();
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
                if(type.isEmpty() ||email.isEmpty()||username.isEmpty()||pass.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Fields are empty");
                    alert.showAndWait();
                }
            if (!(registrationPasswordText.getText().matches(registrationRepeatPasswordText.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Passwords not match");
                alert.showAndWait();
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
                        throw new RuntimeException(e);
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
                        throw new RuntimeException(e);
                    }

                }


            }
        }
    }
}
