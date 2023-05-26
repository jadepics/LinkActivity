package linkactivity.linkactivity;

import javafx.scene.control.Alert;

public class NotExistentUserException extends Exception {

    public NotExistentUserException() {
        super() ;
    }

    public NotExistentUserException(String errorMessage) {
        super(errorMessage) ;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Username or password are not correct");
        alert.showAndWait();
    }
}