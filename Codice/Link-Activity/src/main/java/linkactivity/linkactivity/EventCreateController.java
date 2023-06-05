package linkactivity.linkactivity;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//qui ci arrivo dal controller grafico
public class EventCreateController {
    public static class newEvent {  //TODO indagre se è corretta in static
        public newEvent(EventBean createEBean) throws DuplicatedEventException {
            //chiama dao per vedere se evento esiste già altrimenti eccezione(specifica)
            CompanyDAO companyDAO = new CompanyDAO();
            UserDAO userDAO = new UserDAO(); //mi serve? forse per observer e notifica
            EventDAO eventDAO = new EventDAO();
            EventModel addEvent; //model del nuovo evento
            CompanyModel company =companyDAO.loadCompany(createEBean.nomeAzienda);
            String companyMail = company.getCompanyEmail();
            // mi carico l'azienda perche la devo mette nella dao evento, ma la devo recuperare dalla sessione

            EventCreateBoundarySendEmail addEventBoundarySendEmail = new EventCreateBoundarySendEmail(createEBean,companyMail);

             List <UserBean> userBeans = new ArrayList<>();
            List <UserModel> userModels;
            userModels =userDAO.loadUserFromFavoriteTag(createEBean.tag); //sempre per observer da DAO
        //    System.out.println(userModels.get(0).getEmail());   //TODO qui email è null
             for(UserModel userModel : userModels){
             userBeans.add(new UserBean(userModel.getEmail()));
                            }
            addEvent = new EventModel(createEBean.getEventName(),createEBean.getDescription(), createEBean.getDataEvento(), createEBean.getExpirationDate(), createEBean.getPartecipantNumber(), createEBean.getNomeAzienda(), createEBean.getTag());


            List <EventModel> checkEvents = eventDAO.getEvent("");
            while(!(checkEvents.isEmpty())) {
                if (controlDuplicatedEvent(checkEvents.get(0), addEvent)){
                    throw new DuplicatedEventException("evento già esistente");
                }
                checkEvents.remove(0);
            }
            int m= eventDAO.insertEvent(addEvent);
            if(m!=-1){
                addEventBoundarySendEmail.setUserBeans(userBeans);
                createEBean.notifyChanges();
            }
        }
        private static boolean controlDuplicatedEvent(EventModel localEvent, EventModel addEvent){
            return Objects.equals(localEvent.getEventModelName(), addEvent.getEventModelName()) && Objects.equals(localEvent.getEventModelData(), addEvent.getEventModelData()) &&
                    Objects.equals(localEvent.getEventModelDescription(), addEvent.getEventModelDescription()) && Objects.equals(localEvent.getEventModelTag(), addEvent.getEventModelTag());
        }
    }

    public static void addPoints(CompanyBean companyBean) throws FileNotFoundException {
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        CouponPointsDAO.addPoints(company, "add",0);
    }

    public static CouponBean getCurrentPoints(CompanyBean companyBean){
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        CouponModel couponModel= CouponPointsDAO.getCurrentPoints(company);
        int points= couponModel.getPoints();
        return new CouponBean(points);
    }

    public static void removePoints(CompanyBean companyBean, int points) throws FileNotFoundException {
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        CouponPointsDAO.addPoints(company, "", points);
        CouponPointsDAO.redeemCoupon(company,points);
    }

    public static List<CouponBean> getAvailableCoupons(CompanyBean companyBean){
        CompanyModel company= new CompanyModel(companyBean.getNomeAzienda());
        List<CouponModel> couponModels= CouponPointsDAO.getAvailableCoupons(company);
        List<CouponBean> couponBeans= new ArrayList<>();
        while(3> couponBeans.size()){
            CouponBean couponBean= new CouponBean(couponModels.get(0).getQuantity(), "");
            couponBeans.add(couponBean);
            couponModels.remove(0);
        }
        return couponBeans;
    }

    public static Double applyCoupon(List<CouponBean> couponBean){ //TODO indagare se deve essere stiatic
        int i=0;

        List<CouponModel> couponModel= new ArrayList<>(){};
        while(i!=couponBean.size()){
            CouponModel k= new ConcreteCoupon(couponBean.get(i).getCouponDiscount()) ;
            couponModel.add(k);
            i++;
        }

        EventModel eventModel= new EventModel();

        CouponApplier couponApplier = new CouponApplier(eventModel) ;
        couponApplier.applyDiscount(couponModel);

        return couponApplier.getFinalPrice();
    }

    public static void removeCoupon(List<CouponBean> couponBeans, CompanyBean y){
        Double coupon;
        CouponModel couponModel;
        List<CouponModel> couponModels= new ArrayList<>(){};
        int i = 0;
        while(i < couponBeans.size()){
            coupon= couponBeans.get(i).getCouponDiscount();
            couponModel= new CouponModel(coupon) {
                @Override
                public Double getPrice() {
                    return null;
                }
            };
            couponModels.add(couponModel);
            i++;
        }

        CompanyModel companyModel= new CompanyModel(y.getNomeAzienda());
        CouponPointsDAO.removeCoupons(couponModels, companyModel);
    }


}


