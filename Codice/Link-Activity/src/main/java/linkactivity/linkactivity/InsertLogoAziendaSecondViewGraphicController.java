package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InsertLogoAziendaSecondViewGraphicController {

    @FXML
    private TextField insertLogoCommandLine;

    @FXML
    private Text insertLogoPathText;

    @FXML
    void executeCommand() {
        String s = insertLogoCommandLine.getText();
        insertLogoCommandLine.setText("");
        if (s.matches("set logo path .*")) {
            String path = s.replace("set logo path ", "");
            insertLogoPathText.setText(path);
            new LoginController().addLogoImage(path,companyName);
        } else if (s.matches("goto company action.*")) {
            Stage stage = (Stage) insertLogoCommandLine.getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAziendaSecondView.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setScene(scene);
                stage.show();
                AzioniAziendaSecondViewGraphicController a = root.getController();
                a.currentCompany(companyName);
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }


        }

    }
private CompanyBean companyName;

    public void setCompanyName(CompanyBean companyBean) {
        companyName= companyBean;
    }
}



