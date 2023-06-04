package linkactivity.linkactivity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FavouriteTagInsertGraphicController {
        @FXML
        private ChoiceBox<String> favouriteTagInsert;
        @FXML
        private Button backtoregisterbutton;
         @FXML
         private Button gotodashboardButton;


    private UserBean userBean0;
    public void spostare(UserBean userBean){
        userBean0 = userBean;
    }

    private String[] tags ={"C++","Python","Java"};

    public void initialize(){favouriteTagInsert.getItems().addAll(tags);}



        @FXML
        void backtoregister() throws IOException {

                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WhoAreU.fxml")));
                        Scene scene = new Scene(root, 690, 518);
                        Stage stage = (Stage) backtoregisterbutton.getScene().getWindow();

                        stage.setTitle("Link-Activity");
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                }
    @FXML
        public void gotodashboard() throws IOException {
            new LoginController.UserAddTag(userBean0, favouriteTagInsert.getValue());
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CareerBona.fxml")));
                Scene scene = new Scene(root,690, 518);
                Stage stage = (Stage) gotodashboardButton.getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
        }


//devo fare controller applicativo

    }


