package linkactivity.linkactivity;

import java.util.Date;

public class EventModel {

    String eventName;
    //List<String> eventName2= new ArrayList<>();
    Date dataEvento;
    //List<String> dataEvento2= new ArrayList<>();
    Date expirationDate;
    //List<String> expirationDate2= new ArrayList<>();
    String description;
    //List<String> description2= new ArrayList<>();
    int partecipantNumber;
    //List<Integer> partecipantNumber2= new ArrayList<>();
    String nomeAzienda;
    //List<String> nomeAzienda2= new ArrayList<>();
    String tag;
    //List<String> tag2= new ArrayList<>();



    public EventModel(){}    //costruttore vuoto

    public EventModel(String eventName,Date dataEvento,Date expirationDate,String description,int partecipantNumber,String nomeAzienda, String tag ){
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

    /*public void setEventName(String eventName){
        eventName.add(eventName);
        //System.out.println(eventName2);
    }*/

    public void setEventModelName(String eventName) {
        this.eventName = eventName;
    }

    /*public List<String> getDataEvento() {
        return dataEvento2;
    }*/

    public Date getEventModelData() {
        return dataEvento;
    }

    /*public void setDataEvento(String dataEvento) {
        dataEvento2.add(dataEvento);
    }*/

    public void setEventModelData(Date dataEvento) {
        this.dataEvento=dataEvento;
    }

    /*public List<String> getExpirationDate() {
        return expirationDate2;
    }*/

    public Date getEventModelExpirationDate() {
        return expirationDate;
    }

    /*public void setExpirationDate(String expirationDate) {
        expirationDate2.add(expirationDate);
    }*/

    public void setEventModelExpirationDate(Date expirationDate) {
        this.expirationDate=expirationDate;
    }

    /*public List<String> getDescription() {
        return description2;
    }*/

    public String getEventModelDescription() {
        return description;
    }

    /*public void setDescription(String description) {
        description2.add(description);
    }*/

    public void setEventModelDescription(String description) {
        this.description=description;
    }

    /*public List<Integer> getPartecipantNumber() {
        return partecipantNumber2;
    }*/

    public Integer getEventModelPartecipantNumber() {
        return partecipantNumber;
    }

    /*public void setPartecipantNumber(int partecipantNumber) {
        partecipantNumber2.add(partecipantNumber);
    }*/

    public void setEventModelPartecipantNumber(int partecipantNumber) {
        this.partecipantNumber=partecipantNumber;
    }

    /*public List<String> getNomeAzienda() {
        return nomeAzienda2;
    }*/

    public String getEventModelNomeAzienda() {
        return nomeAzienda;
    }

    /*public void setNomeAzienda(String nomeAzienda) {
        nomeAzienda2.add(nomeAzienda);
    }*/

    public void setEventModelNomeAzienda(String nomeAzienda) {
        this.nomeAzienda=nomeAzienda;
    }

    /*public List<String> getTag() {
        return tag2;
    }*/

    public String getEventModelTag() {
        return tag;
    }

    /*public void setTag(String tag) {
        tag2.add(tag);
    }*/

    public void setEventModelTag(String tag) {
        this.tag=tag;
    }
}
