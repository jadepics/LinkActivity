package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class WhoAreUGraphicController {

    @FXML
    private Button companyButton;

    @FXML
    private Button userButton;

    @FXML
    private void regEnti() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegEnti.fxml")));
        Scene scene = new Scene(root, 690, 518);
        /*Stage stage = (Stage) UniversityButton.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();*/

        Stage stage2= (Stage) companyButton.getScene().getWindow();

        stage2.setTitle("Link-Activity");
        stage2.setScene(scene);
        stage2.setResizable(false);
        stage2.show();
    }

    @FXML
    private void regUser() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Registration.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) userButton.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}

