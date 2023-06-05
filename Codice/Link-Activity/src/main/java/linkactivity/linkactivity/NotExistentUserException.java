package linkactivity.linkactivity;

import javafx.scene.control.Alert;

public class NotExistentUserException extends Exception {

    public NotExistentUserException() {
        super() ;
    }

    public NotExistentUserException(String errorMessage) {
        super(errorMessage) ;
    }
}