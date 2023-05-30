package linkactivity.linkactivity.Utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import linkactivity.linkactivity.CompanyBean;
import linkactivity.linkactivity.EventCreateSecondViewGraphicController;

import java.io.IOException;
import java.util.Objects;

public class GUISwtichAid {

    public static void eventcreatesecondviewguiswitch(ActionEvent event, CompanyBean y, FXMLLoader root){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //FXMLLoader root = new FXMLLoader(Objects.requireNonNull(GUISwtichAid.class.getResource("src/main/resources/linkactivity/linkactivity/EventCreateSecondView.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            EventCreateSecondViewGraphicController a = root.getController();
            a.currentCompany(y);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
