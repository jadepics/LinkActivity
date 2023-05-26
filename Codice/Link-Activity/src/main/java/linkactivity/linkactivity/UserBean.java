package linkactivity.linkactivity;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserBean {
    private String username;
    private String userEmail;
    private String userPass;

public UserBean(String email){}


    public UserBean(String userEmail, String username, String userPass){
    this.setUserEmail(userEmail);
    this.setUsername(username);
    this.setUserPass(userPass);
    }

    public UserBean(String emailUsernameLogin, String passLogin) {
        this.setUsername(emailUsernameLogin);
        this.setUserPass(passLogin);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
