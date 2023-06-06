package linkactivity.linkactivity.utilities;

import javafx.scene.control.Alert;
import linkactivity.linkactivity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplyCouponAid {

    private static final String iomessage= "IOException error";


    private ApplyCouponAid() {

    }

    public static Double applycoupnaid(int x, int j, int z, CompanyBean y, int fivep, int tenp, int fiftp) throws NotEnoughCouponAvailableException, IOExceptionHandler {
        Double finalPrice = null;
        EventCreateController eventCreateController= new EventCreateController();

        try {
            if (x > fivep || j > tenp || z > fiftp) {
                throw new NotEnoughCouponAvailableException("Not Enough Coupon");
            } else {
                List<CouponBean> couponBeans = new ArrayList<>() {
                };

                while (z != 0) {
                    CouponBean k = new CouponBean(15.0);
                    couponBeans.add(k);
                    z--;
                }
                while (j != 0) {
                    CouponBean k = new CouponBean(10.0);
                    couponBeans.add(k);
                    j--;
                }
                while (x != 0) {
                    CouponBean k = new CouponBean(5.0);
                    couponBeans.add(k);
                    x--;
                }

                finalPrice = eventCreateController.applyCoupon(couponBeans);

                eventCreateController.removeCoupon(couponBeans, y);

            }
        } catch (NotEnoughCouponAvailableException | IOExceptionHandler e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not enough coupon available");
            alert.showAndWait();
        } catch (IOException e) {
            throw new IOExceptionHandler(iomessage);
        }
        return finalPrice;
    }
}
