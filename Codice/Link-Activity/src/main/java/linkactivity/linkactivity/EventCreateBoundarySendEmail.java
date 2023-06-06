package linkactivity.linkactivity;

import linkactivity.linkactivity.pattern.observer.Observer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EventCreateBoundarySendEmail implements Observer {

   private EventBean eventBean;
   private String aziendaMail;
   private List<UserBean> userBeanList;

    public EventCreateBoundarySendEmail(EventBean eventBean, String aziendaMail){
        this.eventBean = eventBean;
        this.eventBean.attach(this);    //perchè
        this.aziendaMail = aziendaMail;
    }
    @Override
    public void update() throws IOExceptionHandler {
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter( "EmailAddressFile.txt")))){

            printWriter.print("Azienda mail address:    ");
            printWriter.println(aziendaMail);
            printWriter.println("");
            printWriter.print("New event added:   ");
            printWriter.println(eventBean.getEventName());
            printWriter.println("");
            printWriter.println("Send to users mail address:");
            printWriter.println("");

            for(UserBean userBean : userBeanList) {

                printWriter.println(userBean.getUserEmail());

            }


        }catch (IOException e) {
            throw new IOExceptionHandler("IOException error");
        }
    }
    public void setUserBeans(List<UserBean> userBeans) {

        this.userBeanList = userBeans;

    }

    public List<UserBean> getUserBeans() {

        return userBeanList;

    }
}
