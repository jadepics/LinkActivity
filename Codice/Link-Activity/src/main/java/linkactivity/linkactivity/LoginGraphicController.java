package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.GUISwtichAid;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class LoginGraphicController {

    @FXML
    public PasswordField passLogin;
    @FXML
    private TextField emailUsernameLogin;

    @FXML
    private Button backButton3;

    @FXML
    private Button loginButton3;

    @FXML
    private Button loginWithGoogleButton;

    @FXML
    private Button registerButton;

    @FXML
    private RadioButton companyRB;
    @FXML
    private RadioButton userRB;
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


    public void switchToUserProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CareerBona.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAziendaProfile(ActionEvent event) throws IOExceptionHandler {
        String companyName=(emailUsernameLogin.getText());
        CompanyBean companyBean= new CompanyBean(companyName);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
        GUISwtichAid.azioniaziendaguiswitch(stage, companyBean, root);
    }


    public void validateLogin(ActionEvent event) throws IOException, NotExistentUserException, IOExceptionHandler {
        int i=-1;
        if(emailUsernameLogin.getText().isEmpty() || passLogin.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Username or Password are empty");
            alert.showAndWait();
        } else if (!(userRB.isSelected() || companyRB.isSelected())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Select User Type");
            alert.showAndWait();

        } else {
            if (userRB.isSelected()) {
                UserBean userBean = new UserBean(emailUsernameLogin.getText(), passLogin.getText());
                i = new LoginController().LoginUser(userBean);
            } else if (companyRB.isSelected()) {
                CompanyBean companyBean = new CompanyBean(emailUsernameLogin.getText(), passLogin.getText());
                i = new LoginController().LoginCompany(companyBean);
            }
            if (i == 0) {
                switchToUserProfile(event);
            } else if (i == 1) {
                switchToAziendaProfile(event);
            }
        }

    }

    @FXML
    private void loginGoogle () {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Google Login is not available right now");
            alert.showAndWait();
    }
}