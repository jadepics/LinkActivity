package linkactivity.linkactivity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.GUISwtichAid;

import java.io.IOException;
import java.util.Objects;

public class InsertLogoAziendaSecondViewGraphicController {

    @FXML
    private TextField insertLogoCommandLine;

    @FXML
    private Text insertLogoPathText;

    @FXML
    void executeCommand() throws IOExceptionHandler {
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
            GUISwtichAid.tryazioniaziendasecondviewaid(companyName, root, stage);


        }

    }
private CompanyBean companyName;

    public void setCompanyName(CompanyBean companyBean) {
        companyName= companyBean;
    }
}



