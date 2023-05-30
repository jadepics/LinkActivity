package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DummyPayGraphicController {

    @FXML
    private Button applyCouponButton;

    @FXML
    private Button backButton7;

    @FXML
    private Text total;

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

    private Integer fivep;
    private Integer tenp;
    private Integer fiftp;

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

        int x=0;
        int j=0;
        int z=0;

        try {
            if (fivepToUse.getText().isEmpty() || tenpToUse.getText().isEmpty() || fiftpToUse.getText().isEmpty()) {

                throw new NotNullCouponToUseException("Coupon fields can't be null");

            } else {
                x = Integer.parseInt(fivepToUse.getText());
                j = Integer.parseInt(tenpToUse.getText());
                z = Integer.parseInt(fiftpToUse.getText());

                try {
                    if (x > fivep || j > tenp || z > fiftp) {
                        throw new NotEnoughCouponAvailableException("Not Enough Coupon");
                    } else {
                        List<CouponBean> couponBeans= new ArrayList<>(){};

                        while(z!=0){
                            CouponBean k= new CouponBean(15.0);
                            couponBeans.add(k);
                            z--;
                        }
                        while(j!=0){
                            CouponBean k= new CouponBean(10.0);
                            couponBeans.add(k);
                            j--;
                        }
                        while(x!=0){
                            CouponBean k= new CouponBean(5.0);
                            couponBeans.add(k);
                            x--;
                        }

                        Double finalPrice = EventCreateController.applyCoupon(couponBeans);
                        /*CouponApplier instance = new CouponApplier(new Priceable() {
                            @Override
                            public Double getPrice() {
                                return 10.0;
                            }
                        }) ;
                        instance.getFinalPrice() ;
                        */
                        total.setText("Total: "+finalPrice);

                        EventCreateController.removeCoupon(couponBeans, y);
                        setAvailableCoupons(y);

                        applyCouponButton.setDisable(true);
                    }
                } catch (NotEnoughCouponAvailableException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Not enough coupon available");
                    alert.showAndWait();
                }

            }

        } catch(NotNullCouponToUseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Complete all coupon fields");
            alert.showAndWait();
        }


        //TODO forse eccezione coupon slezionati vs coupon disponibili


    }

    @FXML
    private void paymentDone() throws FileNotFoundException {
        EventCreateController.addPoints(y);
        paymentButton.setDisable(true);
        applyCouponButton.setDisable(true);
    }

    @FXML
    public void setCurrentCompany(CompanyBean companyBean){
        y= companyBean;
        setAvailableCoupons(y);
        System.out.println(y);
    }

    private void setAvailableCoupons(CompanyBean companyBean){
        List<Integer> coupList= EventCreateController.getAvailableCoupons(companyBean);
        fivep= coupList.get(0);
        tenp= coupList.get(1);
        fiftp= coupList.get(2);
        fivePCouponAvailable.setText("- Available 5% coupons: "+ fivep);
        tenPCouponAvailable.setText("- Available 10% coupons: "+ tenp);
        fiftPCouponAvailable.setText("- Available 15% coupons: "+ fiftp);
    }
}

