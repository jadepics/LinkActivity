package linkactivity.linkactivity;

import linkactivity.linkactivity.pattern.decorator.Priceable;

public abstract class CouponModel implements Priceable {
    private Double couponDiscount;
    private Priceable appliedPrice ;

    protected CouponModel(Double couponDiscount){
        setCouponDiscount(couponDiscount);
    }


    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Double getCouponDiscount(){
        return couponDiscount;
    }

    public void setAppliedPrice(Priceable appliedPrice) {
        this.appliedPrice = appliedPrice;
    }

    protected Priceable getAppliedPrice() {
        return appliedPrice ;
    }

}
