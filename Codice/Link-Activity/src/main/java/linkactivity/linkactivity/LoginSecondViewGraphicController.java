package linkactivity.linkactivity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.GUISwtichAid;

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
    void executeCommand(ActionEvent event) throws IOException, NotExistentUserException {
        String s= loginCommandLine.getText();
        loginCommandLine.setText("");
        if(s.matches("set username .*")){
            String email= s.replace("set username ","");
            loginEmailText.setText(email);
        } else if(s.matches("set password .*")){
            String passw= s.replace("set password ","");
            loginPasswordText.setText(passw);
        } else if (s.matches("set profile .*")) {
            String profileType = s.replace("set profile ", "");
            profiletypeaid(profileType);

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



            if (type.matches("user")){
                UserBean userBean= new UserBean(email, passw);
                new LoginController().LoginUser(userBean);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("DashboardSecondView.fxml")));
                Scene scene;
                try {
                    scene = new Scene(root.load(), 690, 518);
                    stage.setScene(scene);
                    stage.show();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }


            } else if (type.matches("company")) {
                CompanyBean companyBean= new CompanyBean(email,passw);
                new LoginController().LoginCompany(companyBean);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
                Scene scene;
                GUISwtichAid.tryazioniaziendasecondviewaid(companyBean, root, stage);

            }
            // TODO controllo su email @ e .com/it ecc




        }
    }

    private void profiletypeaid(String profileType){
        if(profileType.matches("user")){
            loginProfileTypeText.setText(profileType);
        } else if(profileType.matches("company")){
            loginProfileTypeText.setText(profileType);
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Choose between user or company");
            alert.showAndWait();
        }
    }
}
