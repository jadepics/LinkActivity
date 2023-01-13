package linkactivity.linkactivity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EventCreateGraphicController {
        @FXML
        private Button backButton5;

        @FXML
        private Button createItButton;

        @FXML
        private TextField eventName;

        @FXML
        private DatePicker expireDateInsert;

        @FXML
        private DatePicker initialDateInsert;

        @FXML
        private TextField maxPartecipantNumber;

        @FXML
        private MenuButton tagInsert;

        @FXML
        void backToAzioniAzienda(ActionEvent event) {

        }


        @FXML
        private void backToAzioniAzienda() throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
            Scene scene = new Scene(root, 690, 518);
            Stage stage = (Stage) backButton5.getScene().getWindow();

            stage.setTitle("Link-Activity");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }

        @FXML
        private void createItGotoPay() throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DummyPay.fxml")));
            Scene scene = new Scene(root, 690, 518);
            Stage stage = (Stage) createItButton.getScene().getWindow();

            stage.setTitle("Link-Activity");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }

    }

