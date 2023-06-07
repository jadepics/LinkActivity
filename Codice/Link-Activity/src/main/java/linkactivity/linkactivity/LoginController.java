package linkactivity.linkactivity;

public class LoginController {

    public int loginUser(UserBean userBean) throws NotExistentUserException {
        UserDAO userDAO =new UserDAO();
        return userDAO.verifyUser(userBean.getUsername(),userBean.getUserPass());
    }

    public int loginCompany(CompanyBean companyBean) throws NotExistentUserException {
        CompanyDAO companyDAO= new CompanyDAO();
        return companyDAO.verifyCompany(companyBean.getNomeAzienda(),companyBean.getPassword());
    }

    public void addLogoImage(String imagePath, CompanyBean companyName) throws IOExceptionHandler {
        EventLogoDAO eventLogoDAO= new EventLogoDAO();
        eventLogoDAO.insertLogo(imagePath,companyName);
    }

    public void addInPoints(String nomeAzienda) throws  IOExceptionHandler {
        CouponPointsDAO couponPointsDAO =new CouponPointsDAO();
        couponPointsDAO.insertNewAzienda(nomeAzienda);
    }
    public void userRegistration(UserBean userBean) throws IOExceptionSQL {
                        UserDAO userDAO = new UserDAO();
                        userDAO.newUser(userBean.getUserEmail(),userBean.getUsername(),userBean.getUserPass());
        }

                public void companyRegister(CompanyBean companyBean) {
                        CompanyDAO companyDAO = new CompanyDAO();
                        companyDAO.newCompany(companyBean.getEmail(),companyBean.getNomeAzienda(),companyBean.getPassword());
        }
                public void userAddTag(UserBean userBean0, String tag) throws IOExceptionSQL {
                        UserDAO.addFavouriteTag(userBean0.getUsername(), tag);
                }
        }

