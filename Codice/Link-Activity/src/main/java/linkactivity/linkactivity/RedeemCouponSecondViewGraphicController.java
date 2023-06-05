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
import linkactivity.linkactivity.utilities.GUISwtichAid;

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



    @FXML
    public void executeCommand(ActionEvent event) throws FileNotFoundException {
        String s= redeemCouponCommandLine.getText();
        redeemCouponCommandLine.setText("");
        if(s.compareTo("redeem 5% coupon")==0){
            setPoints(300);
        } else if(s.compareTo("redeem 10% coupon")==0){
            setPoints(550);
        } else if(s.compareTo("redeem 15% coupon")==0){
            setPoints(800);
        } else if(s.compareTo("back")==0){
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
            GUISwtichAid.azioniaziendasecondviewguiswitch(event, y, root);
        }
    }

    private void setPoints(int points) throws FileNotFoundException {
        if(pts >= points){
            EventCreateController.removePoints(y, points);
            setCurrentCompanyPoints();
        } else {
            errorMessage();
        }
    }

    private void errorMessage(){
        String p= "Not Enough Points";
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(p);
        alert.showAndWait();
    }



    public void currentCompany(CompanyBean x){
        y=x;
        setCurrentCompanyPoints();
    }

    private void setCurrentCompanyPoints(){
        CouponBean couponBean= EventCreateController.getCurrentPoints(y);
        pts= couponBean.getPoints();
        aviablePoints.setText("Your Aviable Points: "+pts);
    }

}
