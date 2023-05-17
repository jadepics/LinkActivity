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

    CompanyBean y;
    int pts;

    @FXML
    void backToAzioniAzienda(){

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
            eventCreateController.removePoints(y,800);
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
            eventCreateController.removePoints(y,300);
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
            eventCreateController.removePoints(y,550);
            setCurrentCompanyPoints();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Not Enough Points");
            alert.showAndWait();
        }
    }

    public void setCurrentCompany(CompanyBean nomeaz){
        y=nomeaz;
        setCurrentCompanyPoints();
    }

    private void setCurrentCompanyPoints(){
        pts= eventCreateController.getCurrentPoints(y);
        aviablePoints.setText("Your Aviable Points: "+pts);
    }

}

