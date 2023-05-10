package linkactivity.linkactivity;

public class CompanyBean {


    private String nomeAzienda;
    private String email;
    private String logo;        //cg prende la path dal file

    public CompanyBean(){}
    public CompanyBean(String nomeAzienda){
        this.setNomeAzienda(nomeAzienda);
    }
    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public CompanyBean setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
