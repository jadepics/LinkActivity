package linkactivity.linkactivity.Utilities;

import javafx.scene.control.Alert;
import linkactivity.linkactivity.CompanyBean;
import linkactivity.linkactivity.CouponBean;
import linkactivity.linkactivity.EventCreateController;
import linkactivity.linkactivity.NotEnoughCouponAvailableException;

import java.util.ArrayList;
import java.util.List;

public class ApplyCouponAid {

    public static Double applycoupnaid(int x, int j, int z, CompanyBean y, int fivep, int tenp, int fiftp) throws NotEnoughCouponAvailableException {
        Double finalPrice = null;

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

                finalPrice = EventCreateController.applyCoupon(couponBeans);

                EventCreateController.removeCoupon(couponBeans, y);

            }
        } catch (NotEnoughCouponAvailableException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not enough coupon available");
            alert.showAndWait();
        }
        return finalPrice;
    }
}
