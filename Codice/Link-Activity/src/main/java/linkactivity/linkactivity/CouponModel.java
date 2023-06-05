package linkactivity.linkactivity;

import linkactivity.linkactivity.pattern.decorator.Priceable;

public abstract class CouponModel implements Priceable {
    private Double couponDiscount;
    private Priceable appliedPrice ;
    private int points;
    private int quantity;

    protected CouponModel(Double couponDiscount){
        setCouponDiscount(couponDiscount);
    }
    protected CouponModel(int points){
        setPoints(points);
    }
    protected  CouponModel(int quantity,String string) {
        setQuantity(quantity);
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setPoints(int points){
        this.points= points;
    }
    public int getPoints(){
        return points;
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
