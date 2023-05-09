package linkactivity.linkactivity;

import java.time.LocalDate;
import java.util.Date;

public class EventModel {

    String eventName;
    String dataEvento;
    String expirationDate;
    String description;
    int partecipantNumber;
    String nomeAzienda;
    String tag;



    public EventModel(){}
    public EventModel(String eventName,String description,String dataEvento,String expirationDate,int partecipantNumber,String nomeAzienda, String tag ){
        setEventModelName(eventName);
        setEventModelDescription(description);
        setEventModelData(dataEvento);
        setEventModelExpirationDate(expirationDate);
        setEventModelPartecipantNumber(partecipantNumber);
        setEventModelNomeAzienda(nomeAzienda);
        setEventModelTag(tag);
    }

    public String getEventModelName() {
        return eventName;
    }

    public void setEventModelName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventModelData() {
        return dataEvento;
    }

    public void setEventModelData(String dataEvento) {
        this.dataEvento=dataEvento;
    }

    public String getEventModelExpirationDate() {
        return expirationDate;
    }

    public void setEventModelExpirationDate(String expirationDate) {
        this.expirationDate=expirationDate;
    }

    public String getEventModelDescription() {
        return description;
    }

    public void setEventModelDescription(String description) {
        this.description=description;
    }

    public Integer getEventModelPartecipantNumber() {
        return partecipantNumber;
    }

    public void setEventModelPartecipantNumber(int partecipantNumber) {
        this.partecipantNumber=partecipantNumber;
    }

    public String getEventModelNomeAzienda() {
        return nomeAzienda;
    }

    public void setEventModelNomeAzienda(String nomeAzienda) {
        this.nomeAzienda=nomeAzienda;
    }

    public String getEventModelTag() {
        return tag;
    }

    public void setEventModelTag(String tag) {
        this.tag=tag;
    }
}
