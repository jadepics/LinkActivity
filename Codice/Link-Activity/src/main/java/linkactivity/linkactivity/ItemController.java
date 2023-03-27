package linkactivity.linkactivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ItemController {
    public /*List<String>*/ List<EventBean> item(String tag) throws ParseException {
        Date c= new Date();
        DateFormat d= DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
        Calendar v= d.getCalendar();
        v.setTime(c);
        c.toString();
        System.out.println(c);


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
        //ArrayList list = new ArrayList<>();
        List<EventBean> list = new ArrayList<>();
        //List<String> z= new EventDAO().getEvent();
        System.out.println(z+"  zzzzzzzzz");

        //System.out.println(z.get(0));

        while(z.size()>0) {

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

            /*
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

            */


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
}
