package linkactivity.linkactivity;

import java.io.Serializable;

public class CompanyModel implements Serializable {

    String nomeaz;
    String email;
    int j;

    public CompanyModel(String email, String nomeAzienda){
        this.email=email;
        this.nomeaz= nomeAzienda;
        }

    public CompanyModel(String email, int i){
        setCompanyEmail(email);
        setInt(i);
    } //super serve per accedere a metodi della superclasse sovrascritti nella sottoclasse

   public CompanyModel(String nomeaz){
        setCompanyNomeaz(nomeaz);
   }

    public CompanyModel() {

    }

    public void setInt(int i){
        this.j=i;
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


}