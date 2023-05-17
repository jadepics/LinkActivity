package linkactivity.linkactivity;

public class CouponBean {

    private Double couponDiscount;

    public CouponBean(Double couponDiscount){
        setCouponDiscount(couponDiscount);
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Double getCouponDiscount(){
        return couponDiscount;
    }

}
