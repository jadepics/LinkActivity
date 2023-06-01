package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Objects;

public class InsertLogoAziendaGraphicalController {
    @FXML
    private Button backButton1;

    @FXML
    private Button companyActionButton;

    @FXML
    private Button insertLogoButton;


    @FXML
    private void backToLogin3() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Scene scene = new Scene(root, 690, 518);
        Stage stage = (Stage) backButton1.getScene().getWindow();

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private CompanyBean companyName ;
    public void switchToAziendaProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            AzioniAziendaGraphicController a = root.getController();
            a.spostare(companyName); ///modifica nome metodo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void setLogo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Logo Image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Immagini", "*.png", "*.jpg", "*.jpeg")
        );
        Stage stage = (Stage) insertLogoButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        // Qui puoi gestire il percorso del file selezionato e salvarlo nel filesystem
        if (selectedFile != null) {
            // Esempio: salva il percorso del file in una variabile
            String imagePath = selectedFile.getAbsolutePath();
            new LoginController().addLogoImage(imagePath,companyName);

            // Esegui le operazioni necessarie con il percorso dell'immagine selezionata
            // come salvataggio nel filesystem

        }
    }
    public void getNomeAzienda(CompanyBean companyBean2){
        companyName = companyBean2;
    }

}
