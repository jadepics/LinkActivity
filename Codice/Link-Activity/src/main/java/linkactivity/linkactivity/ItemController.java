package linkactivity.linkactivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ItemController {
    public List<EventBean> item(String tag){
        /*Date c= new Date();
        DateFormat d= DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        Calendar v= d.getCalendar();
        v.setTime(c);
        c.toString();
        System.out.println(c);*/


        List<EventModel> z;
        if(tag.equals("java")){
            z= new EventDAO().getEvent("java");
        } else if(tag.equals("cpp")){
            z= new EventDAO().getEvent("cpp");
        } else if(tag.equals("python")){
            z=new EventDAO().getEvent("python");
        } else {
            z=new EventDAO().getEvent("");
        }

        List<EventBean> list = new ArrayList<>();

        while(!(z.isEmpty())) {

            EventBean x= new EventBean();

            EventModel y= z.get(0);
            x.setEventName(y.getEventModelName());
            x.setDescription(y.getEventModelDescription());
            x.setDataEvento(y.getEventModelData());
            x.setExpirationDate(y.getEventModelExpirationDate());
            x.setPartecipantNumber(y.getEventModelPartecipantNumber());
            x.setNomeAzienda(y.getEventModelNomeAzienda());
            x.setTag(y.getEventModelTag());
            z.remove(0);

            list.add(x);
        }
        return list;
    }

    public int joinEvent(EventBean x){
        new EventDAO().modifyParticipantNumber(x);
        return 0;
    }

    public static String getLogo(String nomeaz) throws IOException {
        String pathLogo= String.valueOf(EvetLogoDAO.getLogo(nomeaz));
        return pathLogo;
    }

    public static void addPoints(CompanyBean companyBean) throws FileNotFoundException {
        String nomeaz= companyBean.getNomeAzienda();
        System.out.println(nomeaz+"ciaeeee");
        CouponPointsDAO.addPoints(nomeaz);

    }

}
