package linkactivity.linkactivity;

public class NotNullCouponToUseException extends Exception{

    public NotNullCouponToUseException(){
        super();
    }

    public NotNullCouponToUseException(String errorMessage){
        super(errorMessage);
    }
}
