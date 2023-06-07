package test;

import linkactivity.linkactivity.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginControllerTest {
     /*
        Responsabile testing: Giada Pica
        Matricola: 0280050
    */


    /* L'intento dei Test su questa classe è verificare la
    * correttezza del flusso di esecuzione e dei dati passati
    * ai metodi dato che sono presenti nell'applicazione due
    * utenti diversi */

    @Test
    public void testLoginUser_ValidCredentials_ReturnsSuccess() throws NotExistentUserException {
        /*Login dello user */
        UserBean userBean = new UserBean("","ale","ale");
        LoginController loginController = new LoginController() {
            @Override
            public int loginUser(UserBean userBean) throws NotExistentUserException {

                if (userBean.getUsername().equals("ale") && userBean.getUserPass().equals("ale")) {
                    return 1; // Success
                } else {
                    throw new NotExistentUserException("Invalid credentials");
                }
            }
        };


        int result = loginController.loginUser(userBean);

        assertEquals(1, result);
    }

    @Test
    public void testLoginCompany_ValidCredentials_ReturnsSuccess() throws NotExistentUserException {
        /*Login della company */
        CompanyBean companyBean = new CompanyBean();
        companyBean.setNomeAzienda("Apple");
        companyBean.setPassword("apple");

        LoginController loginController = new LoginController() {
            @Override
            public int loginCompany(CompanyBean companyBean) throws NotExistentUserException {
                if (companyBean.getNomeAzienda().equals("Apple") && companyBean.getPassword().equals("apple")) {
                    return 1; // Success
                } else {
                    throw new NotExistentUserException("Invalid credentials");
                }
            }
        };

        int result = loginController.loginCompany(companyBean);

        assertEquals(1, result);
    }

    @Test
    public void testAddLogoImage_ValidData_InvokesInsertLogo() throws IOExceptionHandler {
        /*Inserimento del logo di una company nel filesystem */
        String imagePath = "logo.png";
        CompanyBean companyName = new CompanyBean();
        companyName.setNomeAzienda("companyName");

        LoginController loginController = new LoginController() {
            @Override
            public void addLogoImage(String imagePath, CompanyBean companyName) {

                assertEquals("logo.png", imagePath);
                assertEquals("companyName", companyName.getNomeAzienda());
            }
        };


        loginController.addLogoImage(imagePath, companyName);
    }
}