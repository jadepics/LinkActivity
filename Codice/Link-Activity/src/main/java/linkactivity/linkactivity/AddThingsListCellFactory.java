package linkactivity.linkactivity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class AddThingsListCellFactory extends ListCell<infoView> {
    private Parent parentNode = null;

    @Override
    protected void updateItem(infoView item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            try {
                System.out.println("eccomi3");
                if (parentNode == null) {
                    parentNode = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Singolo.fxml")));
                    System.out.println("eccomi5");
                }
                Text productNameLabel = (Text) parentNode.lookup("#" + "testo1") ;
                Text productPriceLabel = (Text) parentNode.lookup("#" + "testo2") ;
                ImageView immToChange= (ImageView) parentNode.lookup("#"+"immToChange");

                productNameLabel.setText(item.getBeanName());
                productPriceLabel.setText(String.format("%s",item.getBeanNum()));

                if(item.getBeanName().equals("ciao")) {
                    String x = "C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png";
                    Image imm = new Image(x);
                    immToChange.setImage(imm);
                } else {
                    String y= "C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png";
                    Image imm= new Image(y);
                    immToChange.setImage(imm);
                }

                //System.out.println(productPriceLabel);

                /*if (Objects.equals(caller, SECOND_VIEW)) {
                    Label productIndexLabel = (Label) parentNode.lookup("#" + INDEX_LABEL_ID) ;
                    productIndexLabel.setText("Index " + this.getIndex());
                }*/
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