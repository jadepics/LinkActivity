package linkactivity.linkactivity;

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

public class RegistrationSecondViewGraphicController {

    @FXML
    private TextField registrationCommandLine;

    @FXML
    private Text registrationEmailText;

    @FXML
    private Text registrationPasswordText;

    @FXML
    private Text registrationProfileTypeText;

    @FXML
    private Text registrationRepeatPasswordText;

    @FXML
    void executeCommand() throws IOException {
        String s= registrationCommandLine.getText();
        registrationCommandLine.setText("");

        if(s.matches("set email .*")){
            String email= s.replace("set email ","");
            registrationEmailText.setText(email);
        } else if(s.matches("set password .*")){
            String pass= s.replace("set password ", "");
            registrationPasswordText.setText(pass);
        } else if(s.matches("set repeat password .*")){
            String repPass= s.replace("set repeat password ", "");
            registrationRepeatPasswordText.setText(repPass);
        } else if(s.matches("set profile type .*")){
            String profileType= s.replace("set profile type ","");
            if(!profileType.matches("user") || !profileType.matches("company")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Choose between user or company");
                alert.showAndWait();
            } else {
                registrationProfileTypeText.setText(profileType);
            }
        } else if(s.compareTo("goto googleSignUp")==0){
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("GoogleSignUp is a dummy function");
            alert2.showAndWait();
        } else if(s.compareTo("goto login")==0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) registrationCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else if(s.compareTo("submit")==0){
            String passw= registrationPasswordText.getText();
            String email= registrationEmailText.getText();
            String type= registrationProfileTypeText.getText();

            //TODO query per richiesta registrazione
            // controlli su email @ e .com/it ecc

            // PER ORA PASSA DIRETTO IN DASHBOARD
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DashboardSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) registrationCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }

}
