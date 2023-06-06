package linkactivity.linkactivity.utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import linkactivity.linkactivity.*;

import java.io.IOException;
import java.util.Objects;

public class GUISwtichAid {
    private static final String MESSAGE_PRINT="IOException error";
    private GUISwtichAid(){

    }

    public static void eventcreatesecondviewguiswitch(ActionEvent event, CompanyBean y, FXMLLoader root) throws IOExceptionHandler {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            EventCreateSecondViewGraphicController a = root.getController();
            a.currentCompany(y);
        }
        catch (IOException e){
            throw new IOExceptionHandler(MESSAGE_PRINT);
        }
    }
    public static void azioniaziendaguiswitch(Stage stage, CompanyBean companyBean, FXMLLoader root) throws IOExceptionHandler {
        Scene scene ;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            AzioniAziendaGraphicController a = root.getController();
            a.spostare(companyBean); ///modifica nome metodo
        }
        catch (IOException e){
            throw new IOExceptionHandler(MESSAGE_PRINT);
        }
    }

    public static void azioniaziendasecondviewguiswitch(ActionEvent event,CompanyBean y, FXMLLoader root) throws IOExceptionHandler {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        tryazioniaziendasecondviewaid(y, root, stage);
    }

    public static void tryazioniaziendasecondviewaid(CompanyBean y, FXMLLoader root, Stage stage) throws IOExceptionHandler {
        Scene scene;
        try {
            scene = new Scene(root.load(), 690, 518);
            stage.setScene(scene);
            stage.show();
            AzioniAziendaSecondViewGraphicController a = root.getController();
            a.currentCompany(y);
        }
        catch (IOException e){
            throw new IOExceptionHandler(MESSAGE_PRINT);
        }
    }

}
