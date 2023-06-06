package linkactivity.linkactivity;

public class UserModel {
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private String userEmail;
    public UserModel(String userEmail) {
        setUserEmail(userEmail);
    }
    public UserModel(){}
    public String getEmail(){
        return userEmail;
    }
}
