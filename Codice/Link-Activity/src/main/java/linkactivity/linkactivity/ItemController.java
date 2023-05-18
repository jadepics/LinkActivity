package linkactivity.linkactivity;

import java.io.IOException;
import java.util.*;

public class ItemController {
    public List<EventBean> item(String tag){


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

    public static EventBean getLogo(EventBean item) throws IOException {
        EventModel eventModel= new EventModel(null,null,null,null,0,item.getNomeAzienda(), null){};
        EventModel eventModel1= EvetLogoDAO.getLogo(eventModel);
        item= new EventBean(eventModel1.getEventModelPath());
        return item;
    }

}
