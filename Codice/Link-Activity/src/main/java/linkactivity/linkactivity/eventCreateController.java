package linkactivity.linkactivity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//qui ci arrivo dal controller grafico
public class eventCreateController {
    public static class newEvent {
        public newEvent(EventBean createEBean) throws DuplicatedEventException {
            //chiama dao per vedere se evento esiste già altrimenti eccezione(specifica)
            CompanyDAO companyDAO = new CompanyDAO();
            UserDAO userDAO = new UserDAO(); //mi serve? forse per observer e notifica
            EventDAO eventDAO = new EventDAO();
            EventModel addEvent; //model del nuovo evento
            Company company =companyDAO.loadCompany(createEBean.nomeAzienda);   //forse non serve
            String companyMail = company.getCompanyEmail();
            // mi carico l'azienda perche la devo mette nella dao evento, ma la devo recuperare dalla sessione
            System.out.println("sto nell'inizializzazione del controller");
            //TODO BOUNDARY
            EventCreateBoundarySendEmail addEventBoundarySendEmail = new EventCreateBoundarySendEmail(createEBean,companyMail);

             List <UserBean> userBeans = new ArrayList<>();
            List <UserModel> userModels;
            userModels =userDAO.loadUserFromFavoriteTag(createEBean.tag); //sempre per observer da DAO
             for(UserModel userModel : userModels){
             userBeans.add(new UserBean(userModel.getEmail()));
                            }
            System.out.println("sto per controllare l'evento");
            addEvent = new EventModel(createEBean.getEventName(),createEBean.getDescription(), createEBean.getDataEvento(), createEBean.getExpirationDate(), createEBean.getPartecipantNumber(), createEBean.getNomeAzienda(), createEBean.getTag());


            List <EventModel> checkEvents = eventDAO.getEvent("");
            while(!(checkEvents.isEmpty())) {
                System.out.println("controllo");
                //devo scorrere checkevents
                if (controlDuplicatedEvent(checkEvents.get(0), addEvent)){
                    throw new DuplicatedEventException("evento già esistente");
                //riga 145 di manageServiceController
                }
                checkEvents.remove(0);
                System.out.println("rimuovo e vado avanti");
            }
            System.out.println("vado ad inserire l'evento");
            int m= eventDAO.insertEvent(addEvent);
            if(m!=-1){
                addEventBoundarySendEmail.setUserBeans(userBeans);
                createEBean.notifyChanges();
                System.out.println("inserimento andato a buon fine");}
        }
        private static boolean controlDuplicatedEvent(EventModel localEvent, EventModel addEvent){
            return Objects.equals(localEvent.getEventModelName(), addEvent.getEventModelName()) && Objects.equals(localEvent.getEventModelData(), addEvent.getEventModelData()) &&
                    Objects.equals(localEvent.getEventModelDescription(), addEvent.getEventModelDescription()) && Objects.equals(localEvent.getEventModelTag(), addEvent.getEventModelTag());
        }
    }



}


