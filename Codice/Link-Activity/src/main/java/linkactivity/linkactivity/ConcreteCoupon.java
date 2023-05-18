package linkactivity.linkactivity;

public class ConcreteCoupon extends CouponModel{

    public ConcreteCoupon(Double couponDiscount) {
        super(couponDiscount);
    }

    @Override
    public Double getPrice() {
        Double finalPrice = getAppliedPrice().getPrice() * (1 - getCouponDiscount() / 100.0);
        System.out.println("porcodedioooo");
        return Math.round(finalPrice * 100) / 100.0;
    }

}
