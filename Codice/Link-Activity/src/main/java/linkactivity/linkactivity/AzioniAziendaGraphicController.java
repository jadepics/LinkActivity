package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AzioniAziendaGraphicController {

    @FXML
    private Button backButton4;

    @FXML
    private Button createNewEvent;

    @FXML
    private Button describeToFollowers; //todo boh, ma deve esse dummy? no ve?

    @FXML
    private Button viewEventInsights; //todo eh va fatto, stamo sempre la

    @FXML
    private void backToLogin() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) backButton4.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
private String company;
    @FXML
    public void eventCreate() throws IOException {
       // Stage stage = new Stage();        C E ACTION EVENT E DEVE ESSERCI!
        Stage stage= (Stage) createNewEvent.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("EventCreate.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            EventCreateGraphicController a = root.getController();
            a.newSpostare(company); //da modificare il metodo
        } //PROBLEMA CON CAMBIO INTERFACCIA
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
public void spostare(String companyName){
        company = companyName;
}

    @FXML
    private void describeToFollowers() throws IOException{
        //not todo or yes
    }

    @FXML
    private void viewEventInsights() throws IOException{
        //todo or not?
    }

    @FXML
    void buyCoupon(ActionEvent event) {

    }
//    @FXML
//    protected void getNomeAzienda(String companyName) throws IOException {
//        eventCreate(event, companyName);
//    }
}

