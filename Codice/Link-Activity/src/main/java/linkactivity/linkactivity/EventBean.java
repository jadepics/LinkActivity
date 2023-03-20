package linkactivity.linkactivity;

import java.util.Date;

public class EventBean {

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



    public EventBean(){}    //costruttore vuoto

    public EventBean(String eventName,Date dataEvento,Date expirationDate,String Description,int partecipantNumber,String nomeAzienda, String tag ){

    }

    public String getEventName() {
        return eventName;
    }

    /*public void setEventName(String eventName){
        eventName.add(eventName);
        //System.out.println(eventName2);
    }*/

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /*public List<String> getDataEvento() {
        return dataEvento2;
    }*/

    public Date getDataEvento() {
        return dataEvento;
    }

    /*public void setDataEvento(String dataEvento) {
        dataEvento2.add(dataEvento);
    }*/

    public void setDataEvento(Date dataEvento) {
        this.dataEvento=dataEvento;
    }

    /*public List<String> getExpirationDate() {
        return expirationDate2;
    }*/

    public Date getExpirationDate() {
        return expirationDate;
    }

    /*public void setExpirationDate(String expirationDate) {
        expirationDate2.add(expirationDate);
    }*/

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate=expirationDate;
    }

    /*public List<String> getDescription() {
        return description2;
    }*/

    public String getDescription() {
        return description;
    }

    /*public void setDescription(String description) {
        description2.add(description);
    }*/

    public void setDescription(String description) {
        this.description=description;
    }

    /*public List<Integer> getPartecipantNumber() {
        return partecipantNumber2;
    }*/

    public Integer getPartecipantNumber() {
        return partecipantNumber;
    }

    /*public void setPartecipantNumber(int partecipantNumber) {
        partecipantNumber2.add(partecipantNumber);
    }*/

    public void setPartecipantNumber(int partecipantNumber) {
        this.partecipantNumber=partecipantNumber;
    }

    /*public List<String> getNomeAzienda() {
        return nomeAzienda2;
    }*/

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    /*public void setNomeAzienda(String nomeAzienda) {
        nomeAzienda2.add(nomeAzienda);
    }*/

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda=nomeAzienda;
    }

    /*public List<String> getTag() {
        return tag2;
    }*/

    public String getTag() {
        return tag;
    }

    /*public void setTag(String tag) {
        tag2.add(tag);
    }*/

    public void setTag(String tag) {
        this.tag=tag;
    }
}