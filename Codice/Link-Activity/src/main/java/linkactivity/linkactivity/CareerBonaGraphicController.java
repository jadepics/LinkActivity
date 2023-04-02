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
    private ToggleGroup Tags;

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
        while(y.size()>0){
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
        while(y.size()>0){
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
        while(y.size()>0){
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
        System.out.println("eccomi");

        elements.clear();
        dashboard.refresh();
        List<EventBean> y;
        try {
            y = new ItemController().item("");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(y);

        while(y.size()>0) {
            EventBean z = y.get(0);
            System.out.println(z.getNomeAzienda() + "eoeoeoeoeoeo");
            elements.add(z);
            System.out.println(elements.get(0));
            y.remove(0);
        }

        dashboard.setItems(FXCollections.observableList(elements));
        dashboard.setCellFactory(param -> new AddThingsListCellFactory());
        dashboard.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            Stage stage = new Stage();
            FXMLLoader root;
            root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("JoinEvent.fxml")));
            String x = String.valueOf(elements.get(dashboard.getSelectionModel().getSelectedIndex()).getDescription());

            Scene scene;
            try {
                scene = new Scene(root.load(), 417, 359);
                stage.setTitle("Hello!");
                stage.setScene(scene);
                stage.show();
                JoinEventGraphicController o = root.getController();
                o.setDescriptionText(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            assert false;
        });
    }
}




//TODO 1 --Upload logo di ogni evento su ListView da Filesystem perché codice sparito (bouch rifare gg) MANNAIA LA MAGNOLIA
// 2 --fare schermata di join dell'evento fxml e 3 ---relativi metodi per la join che incrementano/diminuiscono nel DB
// i posti disponibili