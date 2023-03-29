package linkactivity.linkactivity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.*;

public class AddThingsListCellFactory extends ListCell<EventBean> {
    private Parent parentNode = null;
    private int i=0;

    @Override
    protected void updateItem(/*infoView*/EventBean item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            try {
                System.out.println("eccomi3");
                if (parentNode == null) {
                    parentNode = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Singolo.fxml")));
                    System.out.println("eccomi5");
                }
                Text titleText = (Text) parentNode.lookup("#" + "titleText") ;
                Text descriptionText = (Text) parentNode.lookup("#" + "descriptionText") ;
                Text eventDateText = (Text) parentNode.lookup("#" + "eventDateText");
                Text expirationDateText= (Text) parentNode.lookup("#"+"expirationDateText");
                Text participantNumberText= (Text) parentNode.lookup("#"+"participantNumberText");
                Text tagText= (Text) parentNode.lookup("#"+"tagText");
                ImageView immToChange= (ImageView) parentNode.lookup("#"+"immToChange");

                titleText.setText(item.getEventName());
                descriptionText.setText(item.getDescription());
                eventDateText.setText(String.valueOf(item.getDataEvento()));
                expirationDateText.setText(String.valueOf(item.getExpirationDate()));
                participantNumberText.setText(String.valueOf(item.getPartecipantNumber()));
                tagText.setText(item.getTag());

                if(item.getEventName().equals("ciao")) {
                    String x = "C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png";
                    Image imm = new Image(x);
                    immToChange.setImage(imm);
                } else {
                    String y= "C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png";
                    Image imm= new Image(y);
                    immToChange.setImage(imm);
                }

                i++;

                System.out.println("ciaoneeeeSSSS");
                setGraphic(parentNode);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            setGraphic(null);
        }
    }
}