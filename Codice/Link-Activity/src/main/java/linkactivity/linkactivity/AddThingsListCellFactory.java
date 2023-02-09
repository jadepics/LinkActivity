package linkactivity.linkactivity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

public class AddThingsListCellFactory extends /*ListCell<infoView>*/ ListCell<EventBean> {
    private Parent parentNode = null;

    public /*List<String>*/ EventBean item(){
        /*Date c= new Date();
        DateFormat d= DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        Calendar v= d.getCalendar();
        v.setTime(c);
        c.toString();
        System.out.println(c);
        */

        List<String> z= new EventDAO().getEvent();
        System.out.println(z+"  zzzzzzzzz");
        EventBean x= new EventBean();
        System.out.println(z.get(0));
        while(z.size()>0) {
            x.setEventName(z.get(0));
            z.remove(0);
            x.setDescription(z.get(0));
            z.remove(0);
            x.setDataEvento(z.get(0));
            z.remove(0);
            x.setExpirationDate(z.get(0));
            z.remove(0);
            x.setPartecipantNumber(Integer.parseInt(z.get(0)));
            z.remove(0);
            x.setNomeAzienda(z.get(0));
            z.remove(0);
            x.setTag(z.get(0));
            z.remove(0);
            //System.out.println(z.size());
            //System.out.println(z);

            System.out.println(x.getEventName());
            System.out.println(x.getDescription());
            System.out.println(x.getDataEvento());
            System.out.println(x.getExpirationDate());
            System.out.println(x.getPartecipantNumber());
            System.out.println(x.getNomeAzienda());
            System.out.println(x.getTag());
        }
        /*int i=0;
        while(i!=2){
            x.setEventName(Collections.singletonList(z.get(0)));
            z.remove(0);
            x.setTag(z.get(0));
            System.out.println(x.getEventName()+ "aaaaaaaaaaa");
            i++;
        }*/

        return x;
    }


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
                Text productNameLabel = (Text) parentNode.lookup("#" + "testo1") ;
                Text productPriceLabel = (Text) parentNode.lookup("#" + "testo2") ;
                Text tagText= (Text) parentNode.lookup("#"+"testo3");
                ImageView immToChange= (ImageView) parentNode.lookup("#"+"immToChange");

                productNameLabel.setText(item.getEventName().get(0));
                productPriceLabel.setText(String.format("%s",item.getDescription().get(0)));
                tagText.setText(String.format("%s",item.getTag().get(0)));

                if(item.getEventName().equals("ciao")) {
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