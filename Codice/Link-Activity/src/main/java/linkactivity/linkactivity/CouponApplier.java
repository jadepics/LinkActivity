package linkactivity.linkactivity;

import linkactivity.linkactivity.Pattern.Decorator.Priceable;

import java.util.List;

public class CouponApplier{

    private Priceable originalPrice ;
    private Priceable finalPrice ;

    public CouponApplier(Priceable priceable) {
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
    }

    public void setOriginalPrice(Priceable originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getFinalPrice() {
        return finalPrice.getPrice() ;
    }

}
