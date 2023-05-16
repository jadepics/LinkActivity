package linkactivity.linkactivity;

import java.io.Serializable;

public class Company implements Serializable {

    String nomeaz;
    String email;

    public Company(String email, String nomeAzienda, String password){
        this.email=email;
        this.nomeaz= nomeAzienda;

        }

    public Company(String email, int i){
        setCompanyEmail(email);} //super serve per accedere a metodi della superclasse sovrascritti nella sottoclasse

   public Company(String nomeaz){
        setCompanyNomeaz(nomeaz);
   }

    public void setCompanyNomeaz(String nomeaz){
        this.nomeaz= nomeaz;
    }
    public void setCompanyEmail(String email){
        this.email= email;
    }
    public String getCompanyNomeaz(){
        return nomeaz;
    }

    public String getCompanyEmail(){
        return email;
    }


    // E' UN MODEL? SE SI SCRIVERE MODEL NEL NOME!!!
}