package linkactivity.linkactivity;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import linkactivity.linkactivity.infoView;
import linkactivity.linkactivity.AddThingsListCellFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class CareerBonaGraphicController implements Initializable {

    @FXML
    private Button backButton6;

    @FXML
    private Button gearButton;

    @FXML
    private Button demoButton;

    @FXML
    private ListView<infoView> dashboard;

    private final ArrayList<infoView> elements= new ArrayList<>();

    private int y=0;

    @FXML
    private void backToLogin2() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) backButton6.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void fakeListViewInsert(){ //parallelo di addName
        y++;
        infoView x= new infoView("qui ci va il testo preso dal DB",y);

        elements.add(x);
        dashboard.setItems(FXCollections.observableList(elements));
        System.out.println("eccomi2");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("eccomi");
        dashboard.setCellFactory(param -> new AddThingsListCellFactory());
        dashboard.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //qui ci sarà quello che avviene quando clicchi su una cella della listview
            Stage stage = new Stage();
            Parent root= null;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root, 690, 518);
            assert false;
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
            System.out.println("AOOOOOOO");
            //textWiller.setText((newValue == null) ? "" : newValue.getBeanName());
            //System.out.println(textWiller.getText());
        });

        dashboard.setItems(FXCollections.observableList(elements));
    }

}

