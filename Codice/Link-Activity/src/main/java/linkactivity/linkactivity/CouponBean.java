package linkactivity.linkactivity;

public class CouponBean {

    private Double couponDiscount;
    private int points;
    private int quantity;
    private String string;


    public CouponBean(Double couponDiscount){
        setCouponDiscount(couponDiscount);
    }
    public CouponBean(int quantity, String string){
        setQuantity(quantity);
        setString(string);
    }

    public void setQuantity(int quantity){
        this.quantity= quantity;
    }
    public void setString(String string){
        this.string=string;
    }
    public String getString(){
        return string;
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
