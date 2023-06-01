package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Objects;

public class FavouriteTagInsertSecondViewGraphicController {
    @FXML
    private TextField favouriteTagCommandLine;

    @FXML
    private Text favouriteTagText;

    private UserBean userBean1;
    @FXML
    void executeCommand() throws IOException {
        String s = favouriteTagCommandLine.getText();
        favouriteTagCommandLine.setText("");
        String tag = null;
        if (s.matches("set favourite tag .*")) {
            tag = s.replace("set favourite tag ", "");
            favouriteTagText.setText(tag);
        }
        tag= favouriteTagText.getText();
        if (s.matches("goto dashboard.*")) {
            new LoginController.UserAddTag(userBean1, tag);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DashboardSecondView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) favouriteTagCommandLine.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void setUserBean(UserBean userBean) {
        userBean1= userBean;
    }
}

