package linkactivity.linkactivity;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EventCreateGraphicController {

    @FXML
    private Button BackButton5;

    @FXML
    private Button CreateItButton;

    @FXML
    private void BackToAzioniAzienda() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) BackButton5.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void CreateItGotoPay() throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DummyPay.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) CreateItButton.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}

