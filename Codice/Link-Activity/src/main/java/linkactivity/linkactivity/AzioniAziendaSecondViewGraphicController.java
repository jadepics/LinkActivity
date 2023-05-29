package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    CompanyBean y;

    @FXML
    void executeCommand(ActionEvent event) throws IOException {
        String s= azioniAziendaCommandLine.getText();
        azioniAziendaCommandLine.setText("");

        if(s.compareTo("goto create new event")==0) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("EventCreateSecondView.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                EventCreateSecondViewGraphicController a = root.getController();
                a.currentCompany(y);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(s.compareTo("goto redeem coupons")==0){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("RedeemCouponSecondView.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                RedeemCouponSecondViewGraphicController a = root.getController();
                a.currentCompany(y);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }

        } else if(s.compareTo("goto describe yourself to followers")==0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Describe yourself to followers is a dummy function");
            alert.showAndWait();    //leviamo todo su first gia tolto
        } else if(s.compareTo("goto view event insights")==0){
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("View event insights is a dummy function");
            alert2.showAndWait();   //leviamo todo su first gia tolto
        } else if(s.compareTo("back")==0){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RegistrationSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) azioniAziendaCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void currentCompany(CompanyBean x){
        y=x;
    }
}

