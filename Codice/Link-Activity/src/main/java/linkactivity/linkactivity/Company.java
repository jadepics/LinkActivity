package linkactivity.linkactivity;

import java.io.Serializable;

public class Company implements Serializable {

    String nomeaz;

    public Company(String nomeAzienda, String password){
        super(/*email,nomeAzienda,password,logo*/);}

    public Company(String nomeaz){
        setCompanyNomeaz(nomeaz);
    }

    public void setCompanyNomeaz(String nomeaz){
        this.nomeaz= nomeaz;
    }
    public String getCompanyNomeaz(){
        return nomeaz;
    }


    // E' UN MODEL? SE SI SCRIVERE MODEL NEL NOME!!!
}
