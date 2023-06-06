package linkactivity.linkactivity;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import linkactivity.linkactivity.utilities.GUISwtichAid;

import java.io.IOException;
import java.util.Objects;

public class EventCreateGraphicController {
    @FXML
    private Button backButton5;

    @FXML
    private Button createItButton;

    @FXML
    private TextField eventName;

    @FXML
    private TextField expireDateInsert;

    @FXML
    private TextField initialDateInsert;
    @FXML
    private TextField description;

    @FXML
    private TextField maxPartecipantNumber;

    @FXML
    private ChoiceBox<String> tagInsert;

    private String[] tags ={"C++","Python","Java"};

    private CompanyBean companyBean;


    public void initialize(){
        tagInsert.getItems().addAll(tags);
    }


        @FXML
        private void backToAzioniAzienda() throws IOExceptionHandler {
            Stage stage= (Stage) backButton5.getScene().getWindow();
            FXMLLoader root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AzioniAzienda.fxml")));
            GUISwtichAid.azioniaziendaguiswitch(stage, companyBean, root);
        }

    public static int convert(String s){
        int val=0;
        try {
            val = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {

            // This is thrown when the String
            // contains characters other than digits
        }
        return val;
    }



        @FXML
        public void createItGotoPay() throws DuplicatedEventException, IOExceptionHandler {
            int partecipant= convert(maxPartecipantNumber.getText());
            EventBean eventBean = new EventBean(eventName.getText(),description.getText(),initialDateInsert.getText(),expireDateInsert.getText(), partecipant,companyBean.getNomeAzienda(),tagInsert.getValue());
            CompanyBean companyBean2= new CompanyBean(eventBean.getNomeAzienda());
            new EventCreateController.newEvent(eventBean);

            Stage stage = (Stage) createItButton.getScene().getWindow();
            FXMLLoader root;
            root = new FXMLLoader(Objects.requireNonNull(getClass().getResource("DummyPay.fxml")));
            Scene scene;
            try {
                scene = new Scene(root.load(), 690, 518);
                stage.setTitle("Link-Activity");
                stage.setScene(scene);
                stage.show();
                DummyPayGraphicController o = root.getController();
                o.setCurrentCompany(companyBean2);
            } catch (IOException e) {
                throw new IOExceptionHandler("IOException error");
            }
            assert false;

        }
    public void newSpostare(CompanyBean companyBean2){
        companyBean = companyBean2;
    }

}

