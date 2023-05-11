package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class RedeemCouponGraphicController {

    @FXML
    private Button backButtonX;

    @FXML
    private Text aviablePoints;

    @FXML
    private Button redeemFiftpCoupButton;

    @FXML
    private Button redeemFivepCoupButton;

    @FXML
    private Button redeemTenpCoupButton;

    String y;
    int pts;

    @FXML
    void backToAzioniAzienda() throws IOException {
        /*Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) backButtonX.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();*/

        Stage stage= (Stage) backButtonX.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            AzioniAziendaGraphicController a = root.getController();
            a.spostare(y); //da modificare il metodo
        } //PROBLEMA CON CAMBIO INTERFACCIA
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @FXML
    void redeemFiftpCoup() throws FileNotFoundException {
        if(pts>=800){
            ItemController.removePoints(y,800);
            setCurrentCompanyPoints();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not Enough Points");
            alert.showAndWait();
        }
    }

    @FXML
    void redeemFivepCoupButton() throws FileNotFoundException {
        if(pts>=300){
            ItemController.removePoints(y,300);
            setCurrentCompanyPoints();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not Enough Points");
            alert.showAndWait();
        }
    }

    @FXML
    void redeemTenpCoup() throws FileNotFoundException {
        if(pts>=550){
            ItemController.removePoints(y,550);
            setCurrentCompanyPoints();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not Enough Points");
            alert.showAndWait();
        }
    }

    public void setCurrentCompany(String nomeaz){
        y=nomeaz;
        setCurrentCompanyPoints();
    }

    private void setCurrentCompanyPoints(){
        int points= ItemController.getCurrentPoints(y);
        pts= points;
        aviablePoints.setText("Your Aviable Points: "+pts);
    }

}

