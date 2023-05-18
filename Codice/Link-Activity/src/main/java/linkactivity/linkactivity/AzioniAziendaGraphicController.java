package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
private CompanyBean companyBean;
    @FXML
    public void eventCreate() {
       // Stage stage = new Stage();        C E ACTION EVENT E DEVE ESSERCI!
        Stage stage= (Stage) createNewEvent.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("EventCreate.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            EventCreateGraphicController a = root.getController();
            a.newSpostare(companyBean); //da modificare il metodo
        } //PROBLEMA CON CAMBIO INTERFACCIA
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void spostare(CompanyBean companyBean2){
        companyBean = companyBean2;
    }



    @FXML
    void buyCoupon(){

        Stage stage = (Stage) buyCouponButton.getScene().getWindow();
        FXMLLoader root;
        root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("RedeemCoupon.fxml")));

        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setTitle("Link-Activity");
            stage.setScene(scene);
            stage.show();
            RedeemCouponGraphicController o = root.getController();
            o.setCurrentCompany(companyBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert false;
    }

}

