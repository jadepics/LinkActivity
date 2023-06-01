package linkactivity.linkactivity;

public class LoginController {

        public int LoginUser(UserBean userBean) throws NotExistentUserException {
                UserDAO userDAO =new UserDAO();
                int i=userDAO.verifyUser(userBean.getUsername(),userBean.getUserPass());
                return i;
        }

        public int LoginCompany(CompanyBean companyBean) throws NotExistentUserException {
                CompanyDAO companyDAO= new CompanyDAO();
                int i=companyDAO.verifyCompany(companyBean.getNomeAzienda(),companyBean.getPassword());
                return i;
        }

    public void addLogoImage(String imagePath, CompanyBean companyName) {
            EventLogoDAO eventLogoDAO= new EventLogoDAO();
            eventLogoDAO.insertLogo(imagePath,companyName);

    }

    public void AddInPoints(String nomeAzienda) {
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
