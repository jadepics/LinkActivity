package linkactivity.linkactivity;

import org.w3c.dom.events.Event;

import java.util.List;

public class CouponApplier{

    private Priceable originalPrice ;
    private Priceable finalPrice ;

    public CouponApplier(Priceable priceable) {
        // Creates a coupon container in order to manage all the Coupons that are added to the price
        setOriginalPrice(priceable);
        finalPrice = originalPrice ;
    }

    public void applyDiscount(List<CouponModel> couponModel){

        finalPrice= originalPrice;
        for(int i=0; i< couponModel.size(); i++){
            CouponModel currentCoupon= couponModel.get(i);
            if(currentCoupon!=null){
                currentCoupon.setAppliedPrice(finalPrice);
                finalPrice=currentCoupon;
            }
        }

        /*finalPrice = originalPrice ;
        for (int i = 0 ; i < couponContainer.getSize() ; i++) {
            Coupon currentCoupon = couponContainer.getCouponByIndex(i) ;
            if (currentCoupon != null) {
                currentCoupon.setAppliedPrice(finalPrice);
                finalPrice = currentCoupon ;
            }
        }*/
    }

    public void setOriginalPrice(Priceable originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getFinalPrice() {
        // Access to the finalPrice attribute: this starts recursive calls of Decorator Pattern
        return finalPrice.getPrice() ;
    }

}
