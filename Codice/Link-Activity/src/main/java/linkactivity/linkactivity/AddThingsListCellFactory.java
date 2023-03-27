package linkactivity.linkactivity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class AddThingsListCellFactory extends /*ListCell<infoView>*/ ListCell<EventBean> {
    private Parent parentNode = null;
    private int i=0;


    /*
    public List<EventBean> item(String tag) throws ParseException {
        Date c= new Date();
        DateFormat d= DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        Calendar v= d.getCalendar();
        v.setTime(c);
        c.toString();
        System.out.println(c);


        List<String> z;
        if(tag.equals("java")){
            z= new EventDAO().getEvent("java");
        } else if(tag.equals("cpp")){
            z= new EventDAO().getEvent("cpp");
        } else if(tag.equals("python")){
            z=new EventDAO().getEvent("python");
        } else {
            z=new EventDAO().getEvent("");
        }
        //ArrayList list = new ArrayList<>();
        List<EventBean> list = new ArrayList<>();
        //List<String> z= new EventDAO().getEvent();
        System.out.println(z+"  zzzzzzzzz");

        //System.out.println(z.get(0));

        while(z.size()>0) {
            EventBean x= new EventBean();

            x.setEventName(z.get(0));
            z.remove(0);
            x.setDescription(z.get(0));
            z.remove(0);

            String u= z.get(0);
            SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date date= format.parse(u);
            x.setDataEvento(date);
            z.remove(0);

            String u2= z.get(0);
            //SimpleDateFormat format2= new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date date2= format.parse(u2);
            x.setExpirationDate(date2);
            z.remove(0);

            x.setPartecipantNumber(Integer.parseInt(String.valueOf(z.get(0))));
            z.remove(0);
            x.setNomeAzienda(z.get(0));
            z.remove(0);
            x.setTag(z.get(0));
            z.remove(0);
            //System.out.println(z.size());
            //System.out.println(z);



            System.out.println(x.getEventName() + " di xxxxxxxxxx");
            System.out.println(x.getDescription() + " di xxxxxxxxxx");
            System.out.println(x.getDataEvento() + " di xxxxxxxxxx");
            System.out.println(x.getExpirationDate() + " di xxxxxxxxxx");
            System.out.println(x.getPartecipantNumber() + " di xxxxxxxxxx");
            System.out.println(x.getPartecipantNumber() + " di xxxxxxxxxx");
            System.out.println(x.getNomeAzienda() + " di xxxxxxxxxx");
            System.out.println(x.getTag() + " di xxxxxxxxxx");

            list.add(x);
            System.out.println(list);
            EventBean ccc= list.get(0);
            System.out.println(ccc.getNomeAzienda()+" NOOOOOOOO");
        }
        return list;
    }
    */
    private int foo(int i){
        return i;
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