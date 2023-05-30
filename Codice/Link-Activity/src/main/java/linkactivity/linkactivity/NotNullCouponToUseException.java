package linkactivity.linkactivity;

import javafx.scene.control.Alert;

public class NotNullCouponToUseException extends Exception{

    public NotNullCouponToUseException(){
        super();
    }

    public NotNullCouponToUseException(String errorMessage){
        super(errorMessage);

    }

}
