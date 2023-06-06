package linkactivity.linkactivity;

public class LoginController {

    public int LoginUser(UserBean userBean) throws NotExistentUserException {
        UserDAO userDAO =new UserDAO();
        return userDAO.verifyUser(userBean.getUsername(),userBean.getUserPass());
    }

    public int LoginCompany(CompanyBean companyBean) throws NotExistentUserException, IOExceptionHandler {
        CompanyDAO companyDAO= new CompanyDAO();
        return companyDAO.verifyCompany(companyBean.getNomeAzienda(),companyBean.getPassword());
    }

    public void addLogoImage(String imagePath, CompanyBean companyName) throws IOExceptionHandler {
        EventLogoDAO eventLogoDAO= new EventLogoDAO();
        eventLogoDAO.insertLogo(imagePath,companyName);
    }

    public void AddInPoints(String nomeAzienda) throws IOExceptionHandler {
        CouponPointsDAO couponPointsDAO =new CouponPointsDAO();
        couponPointsDAO.insertNewAzienda(nomeAzienda);
    }

    public static class UserRegistration {
                public UserRegistration(UserBean userBean) {
                        UserDAO userDAO = new UserDAO();
                        userDAO.newUser(userBean.getUserEmail(),userBean.getUsername(),userBean.getUserPass());


                }
        }

        public static class CompanyRegister {
                public CompanyRegister(CompanyBean companyBean) {
                        CompanyDAO companyDAO = new CompanyDAO();
                        companyDAO.newCompany(companyBean.getEmail(),companyBean.getNomeAzienda(),companyBean.getPassword());
                }
        }

        public static class UserAddTag {
                public UserAddTag(UserBean userBean0, String tag) {
                        UserDAO userDAO= new UserDAO();
                        userDAO.addFavouriteTag(userBean0.getUsername(), tag);
                }
        }
}
