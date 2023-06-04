package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.GUISwtichAid;

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
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("EventCreateSecondView.fxml")));
            GUISwtichAid.eventcreatesecondviewguiswitch(event,y,root);

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

