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
    private Button buyCouponButton;


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
    void buyCoupon() throws IOException {
        String nomeaz= company;
        CompanyBean companyBean= new CompanyBean(nomeaz);

        Stage stage = (Stage) buyCouponButton.getScene().getWindow();
        FXMLLoader root;
        root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("RedeemCoupon.fxml")));
        //String x = String.valueOf(elements.get(dashboard.getSelectionModel().getSelectedIndex()).getDescription());
        //EventBean x= elements.get(dashboard.getSelectionModel().getSelectedIndex());

        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setTitle("Link-Activity");
            stage.setScene(scene);
            stage.show();
            RedeemCouponGraphicController o = root.getController();
            o.setCurrentCompany(companyBean.getNomeAzienda()); //TODO forse deve passare una bean non una string
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert false;
    }

}

