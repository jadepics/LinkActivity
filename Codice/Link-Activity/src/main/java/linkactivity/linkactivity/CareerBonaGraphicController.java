package linkactivity.linkactivity;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import linkactivity.linkactivity.infoView;
import linkactivity.linkactivity.AddThingsListCellFactory;
import org.w3c.dom.events.Event;

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


    /*
    @FXML
    private ListView<infoView> dashboard;

    private final ArrayList<infoView> elements= new ArrayList<>();
    */

    @FXML
    private ListView<EventBean> dashboard;

    private final ArrayList<EventBean> elements= new ArrayList<>();

    //private final EventBean x = new AddThingsListCellFactory().item("");
    int i = 0;


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
    void cppFunction() throws ParseException {
        List<EventBean> y = new AddThingsListCellFactory().item("cpp");
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
        List<EventBean> y = new AddThingsListCellFactory().item("java");
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
        List<EventBean> y = new AddThingsListCellFactory().item("python");
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
    void fakeListViewInsert() { //parallelo di addName
        /*
        y++;
        infoView x= new infoView("qui ci va il testo preso dal DB",y);
        elements.add(x);
        dashboard.setItems(FXCollections.observableList(elements));
        System.out.println("eccomi2");
        */

        // CHIEDERE A NICOSANTI COME SI AUTOMATIZZA CORRETTAMENTE IL PRINTING DEGLI EVENTI CON NOMI DIVERSI
        // SENZA L'USO DEL BOTTONE MA DALL'ACCESSO ALLA DASHBOARD DOPO LOGIN

        //elements.add(x);
        //dashboard.refresh();
        //EventBean z= new AddThingsListCellFactory().item("");
        /*if(javaRButton.isSelected()){
            z = new AddThingsListCellFactory().item("java");
        } else if(cppRButton.isSelected()){
            z= new AddThingsListCellFactory().item("cpp");
        } else if(pythonRButton.isSelected()) {
            z= new AddThingsListCellFactory().item("python");
        }*/

        /*List<EventBean> y = new AddThingsListCellFactory().item("");
        elements.clear();
        dashboard.refresh();
        while(y.size()>0){
            EventBean z= y.get(0);
            //System.out.println(z.getNomeAzienda()+"eoeoeoeoeoeo");
            elements.add(z);
            System.out.println(elements.get(0));
            y.remove(0);
        }
        dashboard.setItems(FXCollections.observableList(elements));*/

    }
    void foo(){
        demoButton.fire();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("eccomi");
        //System.out.println(x);
        //while(i>0){
        //    foo();

        //while (i > 0) {
        //EventBean z= new AddThingsListCellFactory().item("");
        //    elements.add(z);

        //    dashboard.setItems(FXCollections.observableList(elements));
        elements.clear();
        dashboard.refresh();
        List<EventBean> y = null;
        try {
            y = new AddThingsListCellFactory().item("");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(y);

        while(y.size()>0){
            EventBean z= y.get(0);
            System.out.println(z.getNomeAzienda()+"eoeoeoeoeoeo");
            elements.add(z);
            System.out.println(elements.get(0));
            y.remove(0);
        }


        dashboard.setItems(FXCollections.observableList(elements));

        dashboard.setCellFactory(param -> new AddThingsListCellFactory());
        dashboard.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //qui ci sarà quello che avviene quando clicchi su una cella della listview
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CareerBona.fxml")));
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
        //i--;
        //}
        dashboard.setItems(FXCollections.observableList(elements));

    }
}




//TODO sistemare controller applicativo listCellFatory item
// controller grafico parla conc ontroller applicativo che chiede a dao, dao prende da db e crea un model (di event
// ad esempio) e la ritorna a controller applciativo, controller applciativo crea una bean e la passa al controller grafico