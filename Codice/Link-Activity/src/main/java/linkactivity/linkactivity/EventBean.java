package linkactivity.linkactivity;

import java.time.LocalDate;
import java.util.Date;

public class EventBean {

    String eventName;
    Date dataEvento;
    Date expirationDate;
    String description;

    int partecipantNumber;

    String nomeAzienda;

    String tag;




    public EventBean(){}    //costruttore vuoto

    public EventBean(String eventName, Date dataEvento, Date expirationDate, String description, int partecipantNumber, String nomeAzienda, String tag ){


        System.out.println(eventName+" aaaaaaaaaaaaaaaa");
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento=dataEvento;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate=expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public Integer getPartecipantNumber() {
        return partecipantNumber;
    }

    public void setPartecipantNumber(int partecipantNumber) {
        this.partecipantNumber=partecipantNumber;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda=nomeAzienda;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag=tag;
    }
}