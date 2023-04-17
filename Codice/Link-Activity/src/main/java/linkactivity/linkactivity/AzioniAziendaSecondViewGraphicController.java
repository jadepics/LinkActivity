package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AzioniAziendaSecondViewGraphicController {

    @FXML
    private TextField azioniAziendaCommandLine;

    @FXML
    void executeCommand(ActionEvent event) throws IOException {
        String s= azioniAziendaCommandLine.getText();
        azioniAziendaCommandLine.setText("");

        if(s.compareTo("goto create new event")==0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EventCreateSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) azioniAziendaCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else if(s.compareTo("goto describe yourself to followers")==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Describe yourself to followers is a dummy function");
            alert.showAndWait();
        } else if(s.compareTo("goto view event insights")==0){
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("View event insights is a dummy function");
            alert2.showAndWait();
        } else if(s.compareTo("back")==0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegistrationSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) azioniAziendaCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
}

