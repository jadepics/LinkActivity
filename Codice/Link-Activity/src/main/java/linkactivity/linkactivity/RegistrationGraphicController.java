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
    private Button signUpGoogleButton2;

    @FXML
    private Button userRegisterButton;

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
    private void switchToSelectFavourite(ActionEvent event) throws IOExceptionHandler {
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
            throw new IOExceptionHandler("IOException error");
        }
    }

    private void switchToInsertLogo(ActionEvent event) throws IOExceptionHandler {
        String usernameText = regUsernameUser.getText();
        CompanyBean companyBean =new CompanyBean(usernameText);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("InsertLogoAzienda.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            InsertLogoAziendaGraphicalController a = root.getController();
            a.getNomeAzienda(companyBean);
        }
        catch (IOException e){
            throw new IOExceptionHandler("IOException error");
        }
    }

    @FXML
    private void userRegister(ActionEvent event) throws IOExceptionHandler {
        String emailText = "";
        String checkpass="";
        String usernameText="";
        if(regEmailUser()==1){emailText = regEmailUser.getText();}

        if(!(regUsernameUser.getText().isEmpty())){
            usernameText=regUsernameUser.getText();
        }
        if(regPassUser() && regRepPassUser()){checkpass = regPassUser.getText();}
           int i = 0;
        if(regEmailUser()==1 && regPassUser() &&regRepPassUser()) {
            if (userRB.isSelected()) {
                UserBean userBean = new UserBean(emailText, usernameText, checkpass);
                LoginController loginController= new LoginController();
                loginController.userRegistration(userBean);
                i=1;
            } else if (companyRB.isSelected()) {
                CompanyBean companyBean = new CompanyBean(emailText, usernameText, checkpass);
                LoginController loginController= new LoginController();
                loginController.companyRegister(companyBean);
                loginController.addInPoints(companyBean.getNomeAzienda());
                i = 2;
            }
        }
                if(i==1) {
                    switchToSelectFavourite(event);
                }else if(i==2){
                    switchToInsertLogo(event);
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("SignUpGoogle is a dummy function");
        alert.showAndWait();
    }


   @FXML
    private int regEmailUser() {
        String str;
        int ret=0;
        int a=0;
        int b=0;
        String[] pars = new String[10];
        str= regEmailUser.getText();
        pars[1]=str;

        String[] result = str.split("\\a");
        for (int i = 0;i < result[0].length(); i++){
            pars[0]= String.valueOf(result[0].charAt(i));

            if(pars[0].equals("@")){
                a=1;
            }
            if(a==1 && pars[0].equals(".")) {
                    b = 1;
            }
            if(a==1 &&b==1) ret=1;
        }
        if(a==0 || b==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Enter a valid email");
            alert.showAndWait();
            return ret;
        }
        else return ret;
    }

    @FXML
    private boolean regPassUser() {
       if(regPassUser.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Password is empty");
            alert.showAndWait();
            return false;
        }
       else return true;
    }

    @FXML
    private boolean regRepPassUser() {
        if(regRepPassUser.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Repeat password is empty");
            alert.showAndWait();
            return false;

        } else if (!Objects.equals(regRepPassUser.getText(), regPassUser.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Passwords do not match");
            alert.showAndWait();
            return  false;
        }
        return true;
    }
}

