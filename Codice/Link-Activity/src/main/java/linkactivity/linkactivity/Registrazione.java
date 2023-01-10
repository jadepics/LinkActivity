package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class Registrazione {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField email;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField rippassword;

    @FXML
    private Button BackButton3;

    @FXML
    private void BackToWhoAreU() throws IOException { //todo levare shortcut register su login
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) BackButton3.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToDashboard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CarreerBonaGraphicController.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void registerUser(ActionEvent event){

        Connection myConnection = DBConnection.getDBConnection();

        String emailText = email.getText();
        String usernameText = username.getText();
        String checkpass = password.getText();
        String password = rippassword.getText();
        //String role = "User";
        if (!Objects.equals(checkpass, password)) {
            System.out.println("password errata");
        }


        String insertFields = "INSERT INTO user(Email, Username, Password) VALUES ('";
        String insertValues = emailText + "','" + usernameText + "','" + password + "')" ;
        String insertToRegister = insertFields + insertValues;

        try{

            Statement statement = myConnection.createStatement();
            statement.executeUpdate(insertToRegister);
            switchToDashboard(event);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }



    }

}
