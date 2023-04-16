package linkactivity.linkactivity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginSecondViewGraphicController {

    @FXML
    private TextField loginCommandLine;

    @FXML
    private Text loginEmailText;

    @FXML
    private Text loginPasswordText;

    @FXML
    private Text loginProfileTypeText;

    @FXML
    void executeCommand(ActionEvent event) throws IOException {
        String s= loginCommandLine.getText();
        loginCommandLine.setText("");
        if(s.matches("set email .*")){
            String email= s.replace("set email ","");
            loginEmailText.setText(email);
        } else if(s.matches("set password .*")){
            String passw= s.replace("set password ","");
            loginPasswordText.setText(passw);
        } else if(s.matches("set profile .*")){
            String profile= s.replace("set profile ","");
            if(!profile.matches("user") || !profile.matches("company")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Choose between user or company");
                alert.showAndWait();
            } else {
                loginProfileTypeText.setText(profile);
            }
        } else if(s.compareTo("goto googleLogin")==0){
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("GoogleLogin is a dummy function");
            alert2.showAndWait();
        } else if(s.compareTo("goto register")==0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegistrationSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) loginCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else if(s.compareTo("submit")==0){
            String passw= loginPasswordText.getText();
            String email= loginEmailText.getText();
            String type= loginProfileTypeText.getText();

            //TODO query per richiesta login
            // controllo su email @ e .com/it ecc

            //PER ORA PASSA DIRETTAMENTE IN DASHBOARD o spawp per azienda

            //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DashboardSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) loginCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();


        }
    }
}
