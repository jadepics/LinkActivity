package linkactivity.linkactivity;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
    private ToggleGroup tags;

    @FXML
    private RadioButton cppRButton;

    @FXML
    private RadioButton pythonRButton;

    @FXML
    private RadioButton javaRButton;

    @FXML
    private ListView<EventBean> dashboard;

    private final ArrayList<EventBean> elements= new ArrayList<>();


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
    void cppFunction() throws ParseException {
        List<EventBean> y = new ItemController().item("cpp");
        elements.clear();
        dashboard.refresh();
        while(!(y.isEmpty())){
            EventBean z= y.get(0);
            elements.add(z);
            y.remove(0);
        }
        dashboard.setItems(FXCollections.observableList(elements));
    }

    @FXML
    void javaFunction() throws ParseException {
        List<EventBean> y = new ItemController().item("java");
        elements.clear();
        dashboard.refresh();
        while(!(y.isEmpty())){
            EventBean z= y.get(0);
            elements.add(z);
            y.remove(0);
        }
        dashboard.setItems(FXCollections.observableList(elements));
    }

    @FXML
    void pythonFunction() throws ParseException {
        List<EventBean> y = new ItemController().item("python");
        elements.clear();
        dashboard.refresh();
        while(!(y.isEmpty())){
            EventBean z= y.get(0);
            elements.add(z);
            y.remove(0);
        }
        dashboard.setItems(FXCollections.observableList(elements));
    }

    @FXML
    void fakeListViewInsert() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        elements.clear();
        dashboard.refresh();
        List<EventBean> y;
        y = new ItemController().item("");

        while(!(y.isEmpty())){
            EventBean z= y.get(0);
            elements.add(z);
            y.remove(0);
        }


        dashboard.setItems(FXCollections.observableList(elements));

        dashboard.setCellFactory(param -> new AddThingsListCellFactory());
        dashboard.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            Stage stage = new Stage();
            FXMLLoader root;
            root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("JoinEvent.fxml")));
            //String x = String.valueOf(elements.get(dashboard.getSelectionModel().getSelectedIndex()).getDescription());
            EventBean x= elements.get(dashboard.getSelectionModel().getSelectedIndex());

            Scene scene;
            try {
                scene = new Scene(root.load(), 417, 359);
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
                JoinEventGraphicController o = root.getController();
                o.setDescriptionText(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert false;

        });

    }
}