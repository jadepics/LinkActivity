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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DummyPaySecondViewGraphicController {

    @FXML
    private Text fiftPCouponAvailable;

    @FXML
    private Text fiftPCouponToUse;

    @FXML
    private Text fivePCouponAvailable;

    @FXML
    private Text fivePCouponToUse;

    @FXML
    private TextField dummyPayCommandLine;

    @FXML
    private Text tenPCouponAvailable;

    @FXML
    private Text tenPCouponToUse;

    @FXML
    private Text total;

    private CompanyBean y;

    private Integer fivep;
    private Integer tenp;
    private Integer fiftp;

    @FXML
    void executeCommand(ActionEvent event) throws FileNotFoundException {
        String s= dummyPayCommandLine.getText();
        dummyPayCommandLine.setText("");

        if(s.matches("use 5% coupon .*")){
            String fivepcoup= s.replace("use 5% coupon ","");
            fivePCouponToUse.setText(fivepcoup);

        } else if(s.matches("use 10% coupon .*")){
            String tenpcoup= s.replace("use 10% coupon ", "");
            tenPCouponToUse.setText(tenpcoup);

        } else if(s.matches("use 15% coupon .*")) {
            String fiftpcoup = s.replace("use 15% coupon ", "");
            fiftPCouponToUse.setText(fiftpcoup);

        } else if(s.compareTo("submit coupons and pay")==0){
            int x=0;
            int j=0;
            int z=0;

            try {
                if (fivePCouponToUse.getText().isEmpty() || tenPCouponToUse.getText().isEmpty() || fiftPCouponToUse.getText().isEmpty()) {
                    throw new NotNullCouponToUseException("Coupon fields can't be null");

                } else {
                    x = Integer.parseInt(fivePCouponToUse.getText());
                    j = Integer.parseInt(tenPCouponToUse.getText());
                    z = Integer.parseInt(fiftPCouponToUse.getText());

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
                            setCurrentCompanyCoupons();

                            EventCreateController.addPoints(y);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText("Event creation successfully completed");
                            alert.showAndWait();
                            dummyPayCommandLine.setText("back");
                            dummyPayCommandLine.fireEvent(event);
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

        } else if(s.compareTo("back")==0){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("EventCreateSecondView.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                EventCreateSecondViewGraphicController a = root.getController();
                a.currentCompany(y);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    public void currentCompany(CompanyBean x){
        y=x;
        setCurrentCompanyCoupons();
    }

    private void setCurrentCompanyCoupons(){
        List<Integer> coupList= EventCreateController.getAvailableCoupons(y);
        fivep= coupList.get(0);
        tenp= coupList.get(1);
        fiftp= coupList.get(2);
        fivePCouponAvailable.setText("Available 5% coupons: "+ fivep);
        tenPCouponAvailable.setText("Available 10% coupons: "+ tenp);
        fiftPCouponAvailable.setText("Available 15% coupons: "+ fiftp);
    }

}

