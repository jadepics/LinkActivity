package linkactivity.linkactivity;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    public static EventBean getLogo(EventBean item) throws IOException {
        EventModel eventModel= new EventModel(null,null,null,null,0,item.getNomeAzienda(), null){};
        EventModel eventModel1= EvetLogoDAO.getLogo(eventModel);
        item= new EventBean(eventModel1.getEventModelPath());
        return item;
    }

    public static void addPoints(CompanyBean companyBean) throws FileNotFoundException {
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        CouponPointsDAO.addPoints(company, "add",0); //TODO passare MODEL non string estratta da Bean
    }

    public static int getCurrentPoints(CompanyBean companyBean){ //TODO forse cambiare con una bean
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        int points= CouponPointsDAO.getCurrentPoints(company);
        System.out.println(points);
        return points;
    }

    public static void removePoints(CompanyBean companyBean, int points) throws FileNotFoundException { //TODO no stringa si model
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        CouponPointsDAO.addPoints(company, "", points);
        CouponPointsDAO.redeemCoupon(company,points);
    }

    public static List<Integer> getAvailableCoupons(CompanyBean companyBean){ //TODO replace List<Integer> con bean di coupon
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        return CouponPointsDAO.getAvailableCoupons(company);
    }

}
