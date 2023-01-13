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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class LogEntiGraphicController {

    @FXML
    private Button backButton3;

    @FXML
    private TextField emailCompanyLog;

    @FXML
    private Button loginWithGoogleButton;

    @FXML
    private PasswordField passCompanyLog;

    @FXML
    private Button registerCompanyButton;
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


    public void switchToAziendaProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void validateLogin(ActionEvent event) {


        Connection myConnection = DBConnection.getDBConnection();
        //Connection connectDB = (Connection) myConnection.getInstance();

        String verifyLoginQuery = "SELECT count(1)  FROM azienda_u WHERE Email = '" + emailCompanyLog.getText() + "' AND password = '" + passCompanyLog.getText() + "'";

        try {
            Statement statement = myConnection.createStatement();
            ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);

            while (queryLoginResult.next()) {

                if (queryLoginResult.getInt(1) == 1) {
                    System.out.println("Benvenuto Azienda");
                    switchToAziendaProfile(event);
                }
                else { System.out.println("Errore nel login");}
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



    @FXML
    private void loginGoogle () {
    }
}
