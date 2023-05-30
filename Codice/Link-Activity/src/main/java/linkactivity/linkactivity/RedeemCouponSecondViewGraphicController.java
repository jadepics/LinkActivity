package linkactivity.linkactivity;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class RedeemCouponSecondViewGraphicController {

    @FXML
    private Text aviablePoints;

    @FXML
    private TextField redeemCouponCommandLine;

    CompanyBean y;
    int pts;

    String p= "Not Enough Points";

    @FXML
    public void executeCommand(ActionEvent event) throws FileNotFoundException {
        String s= redeemCouponCommandLine.getText();
        redeemCouponCommandLine.setText("");
        if(s.compareTo("redeem 5% coupon")==0){
            if(pts >= 300){
                EventCreateController.removePoints(y, 300);
                setCurrentCompanyPoints();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(p);
                alert.showAndWait();
            }
        } else if(s.compareTo("redeem 10% coupon")==0){
            if(pts>=550){
                EventCreateController.removePoints(y,550);
                setCurrentCompanyPoints();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(p);
                alert.showAndWait();
            }
        } else if(s.compareTo("redeem 15% coupon")==0){
            if(pts>=800){
                EventCreateController.removePoints(y,800);
                setCurrentCompanyPoints();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(p);
                alert.showAndWait();
            }
        } else if(s.compareTo("back")==0){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                AzioniAziendaSecondViewGraphicController a = root.getController();
                a.currentCompany(y);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void currentCompany(CompanyBean x){
        y=x;
        setCurrentCompanyPoints();
    }

    private void setCurrentCompanyPoints(){
        pts= EventCreateController.getCurrentPoints(y);
        aviablePoints.setText("Your Aviable Points: "+pts);
    }

}
