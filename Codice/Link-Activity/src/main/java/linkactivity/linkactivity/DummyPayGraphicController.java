package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DummyPayGraphicController {

    @FXML
    private Button applyCouponButton;

    @FXML
    private Button backButton7;

    @FXML
    private Text fiftPCouponAvailable;

    @FXML
    private TextField fiftpToUse;

    @FXML
    private Text fivePCouponAvailable;

    @FXML
    private TextField fivepToUse;

    @FXML
    private Button paymentButton;

    @FXML
    private Text tenPCouponAvailable;

    @FXML
    private TextField tenpToUse;


    CompanyBean y;

    @FXML
    private void backToEventCreate(){

        Stage stage= (Stage) backButton7.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("EventCreate.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            EventCreateGraphicController a = root.getController();
            a.newSpostare(y); //da modificare il metodo
        } //PROBLEMA CON CAMBIO INTERFACCIA
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @FXML
    void applyCoupon() {

    }

    @FXML
    private void paymentDone() throws FileNotFoundException {
        eventCreateController.addPoints(y);
        paymentButton.setDisable(true);
    }

    @FXML
    public void setCurrentCompany(CompanyBean companyBean){ //TODO forse cambiare con una bean
        y= companyBean;
        setAvailableCoupons(y);
        System.out.println(y);
    }

    private void setAvailableCoupons(CompanyBean companyBean){ //TODO cambiare con bean
        List<Integer> coupList= eventCreateController.getAvailableCoupons(companyBean);
        fivePCouponAvailable.setText("- Available 5% coupons: "+ coupList.get(0));
        tenPCouponAvailable.setText("- Available 10% coupons: "+ coupList.get(1));
        fiftPCouponAvailable.setText("- Available 15% coupons: "+ coupList.get(2));
    }
}

