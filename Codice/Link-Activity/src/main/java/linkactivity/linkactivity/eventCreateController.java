package linkactivity.linkactivity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//qui ci arrivo dal controller grafico
public class eventCreateController {
    public static class newEvent {
        public newEvent(EventBean createEBean) /*throws DuplicatedEventException*/ {
            //chiama dao per vedere se evento esiste già altrimenti eccezione(specifica)
            CompanyDAO companyDAO = new CompanyDAO();
            UserDAO userDAO = new UserDAO(); //mi serve? forse per observer e notifica
            EventDAO eventDAO = new EventDAO();
            EventModel addEvent; //model del nuovo evento
            //Company company =companyDAO.loadCompany(companyBean.getCompanyEmail());
            // mi carico l'azienda perche la devo mette nella dao evento, ma la devo recuperare dalla sessione

            //TODO BOUNDARY
            //eventCreateSendEmailBoundary con observer tramite boundary

            /* List <UserBean> userBeans = new ArrayList<>();
            List <User> users;
            users loadUserFromFavoriteTag sempre per observer da DAO
             for(User user : users){
             userBeans.add(new UserBean(user.getEmail()));
                            }             */
            addEvent = new EventModel(createEBean.getEventName(), createEBean.getDataEvento(), createEBean.getExpirationDate(), createEBean.getDescription(), createEBean.getPartecipantNumber(), createEBean.getNomeAzienda(), createEBean.getTag());
            //addEvent.setEventModelNomeAzienda(company); quando togli commento al caricamento della mail dell'azienda

            List <EventModel> checkEvents = eventDAO.getEvent("");
            while(!(checkEvents.isEmpty())) {
                //devo scorrere checkevents
                if (controlDuplicatedEvent(checkEvents.get(0), addEvent))
                  //  throw new DuplicatedEventException("evento già esistente");
                //riga 145 di manageServiceController
            checkEvents.remove(0);
            }
            int m= eventDAO.insertEvent(addEvent);
            if(m!=-1)System.out.println("inserimento andato a buon fine");
        }
    }


private static boolean controlDuplicatedEvent(EventModel localEvent, EventModel addEvent){
    return Objects.equals(localEvent.getEventModelName(), addEvent.getEventModelName()) && Objects.equals(localEvent.getEventModelData(), addEvent.getEventModelData()) &&
            Objects.equals(localEvent.getEventModelDescription(), addEvent.getEventModelDescription()) && Objects.equals(localEvent.getEventModelTag(), addEvent.getEventModelTag());
}
}


