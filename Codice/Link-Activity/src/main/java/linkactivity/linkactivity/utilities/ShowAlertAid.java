package linkactivity.linkactivity.utilities;

import javafx.scene.control.Alert;

public class ShowAlertAid {

    public static void showalerterror(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    public static void showalertinformation(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
