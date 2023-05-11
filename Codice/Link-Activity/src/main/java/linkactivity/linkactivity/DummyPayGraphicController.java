package linkactivity.linkactivity;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class DummyPayGraphicController {

    @FXML
    private Button applyCouponButton;

    @FXML
    private Button backButton7;

    @FXML
    private Text fiftPCouponAviable;

    @FXML
    private TextField fiftpToUse;

    @FXML
    private Text fivePCouponAviable;

    @FXML
    private TextField fivepToUse;

    @FXML
    private Button paymentButton;

    @FXML
    private Text tenPCouponAviable;

    @FXML
    private TextField tenpToUse;


    String y;

    @FXML
    private void backToEventCreate() throws IOException {
        /*Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EventCreate.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) backButton7.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();*/

        Stage stage= (Stage) backButton7.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("EventCreate.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            EventCreateGraphicController a = root.getController();
            a.newSpostare(y); //da modificare il metodo
        } //PROBLEMA CON CAMBIO INTERFACCIA
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @FXML
    void applyCoupon() {

    }

    @FXML
    private void paymentDone() throws FileNotFoundException {
        CompanyBean compBean= new CompanyBean(y);
        ItemController.addPoints(compBean);
    }

    @FXML
    public void setCurrentCompany(String nomeaz){ //TODO forse cambiare con una bean
        y= nomeaz;
        System.out.println(y);
    }

}

