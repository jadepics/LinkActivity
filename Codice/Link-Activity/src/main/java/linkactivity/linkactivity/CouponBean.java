package linkactivity.linkactivity;

public class CouponBean {

    private Double couponDiscount;
    private int points;
    private int quantity;


    public CouponBean(Double couponDiscount){
        setCouponDiscount(couponDiscount);
    }
    public CouponBean(int quantity, String string){
        setQuantity(quantity);
    }

    public void setQuantity(int quantity){
        this.quantity= quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public CouponBean(int points){
        setPoints(points);
    }
    public void setPoints(int points){
        this.points=points;
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

}
