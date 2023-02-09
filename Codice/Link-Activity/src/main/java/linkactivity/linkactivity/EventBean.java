package linkactivity.linkactivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventBean {

    String eventName;
    List<String> eventName2= new ArrayList<>();
    Date dataEvento;
    List<String> dataEvento2= new ArrayList<>();
    Date expirationDate;
    List<String> expirationDate2= new ArrayList<>();
    String description;
    List<String> description2= new ArrayList<>();
    int partecipantNumber;
    List<Integer> partecipantNumber2= new ArrayList<>();
    String nomeAzienda;
    List<String> nomeAzienda2= new ArrayList<>();
    String tag;
    List<String> tag2= new ArrayList<>();



    public EventBean(){}    //costruttore vuoto

    public EventBean(String eventName,Date dataEvento,Date expirationDate,String Description,int partecipantNumber,String nomeAzienda, String tag ){

    }

    public List<String> getEventName() {
        return eventName2;
    }

    public void setEventName(String eventName){
        eventName2.add(eventName);
        //System.out.println(eventName2);
    }

    /*public void setEventName(String eventName) {
        this.eventName = eventName;
    }*/

    public List<String> getDataEvento() {
        return dataEvento2;
    }

    public void setDataEvento(String dataEvento) {
        dataEvento2.add(dataEvento);
    }

    public List<String> getExpirationDate() {
        return expirationDate2;
    }

    public void setExpirationDate(String expirationDate) {
        expirationDate2.add(expirationDate);
    }

    public List<String> getDescription() {
        return description2;
    }

    public void setDescription(String description) {
        description2.add(description);
    }

    public List<Integer> getPartecipantNumber() {
        return partecipantNumber2;
    }

    public void setPartecipantNumber(int partecipantNumber) {
        partecipantNumber2.add(partecipantNumber);
    }

    public List<String> getNomeAzienda() {
        return nomeAzienda2;
    }

    public void setNomeAzienda(String nomeAzienda) {
        nomeAzienda2.add(nomeAzienda);
    }

    public List<String> getTag() {
        return tag2;
    }

    public void setTag(String tag) {
        tag2.add(tag);
    }
}