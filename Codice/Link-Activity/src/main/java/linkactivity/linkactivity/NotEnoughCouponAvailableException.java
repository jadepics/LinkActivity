package linkactivity.linkactivity;

public class NotEnoughCouponAvailableException extends Exception{

    public NotEnoughCouponAvailableException(){
        super();
    }

    public NotEnoughCouponAvailableException(String errorMessage){
        super(errorMessage);
    }

}
