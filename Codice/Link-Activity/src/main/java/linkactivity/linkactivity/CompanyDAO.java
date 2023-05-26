package linkactivity.linkactivity;

import java.sql.*;

public class CompanyDAO {
    private static final String COMPANY_EMAIL="email";
    private static final String COMPANY_NOME ="nomeAzienda";
    private static final String COMPANY_LOGO= ""; //vedi che ci devi mette

    public CompanyModel loadCompany(String nomeAzienda){
        Connection myConnection = DBConnection.getDBConnection();
    CompanyModel company= null;
        try {

            Statement statement = myConnection.createStatement();
            ResultSet resultSet = Queries.selectCompanybyName(statement, nomeAzienda);
            if(resultSet.next()){
                company = createCompany(resultSet);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    return company;}

    private CompanyModel createCompany(ResultSet resultSet) throws SQLException{
        String email =resultSet.getString(COMPANY_EMAIL);
        String nomeAzienda =resultSet.getString(COMPANY_NOME);
        //String logo =resultSet.getString(COMPANY_LOGO);

        return new CompanyModel(email, nomeAzienda, "");
    }
    public void newCompany(String userEmail, String username, String userPass) {
        Connection myConnection = DBConnection.getDBConnection();
        try(PreparedStatement statement =myConnection.prepareStatement("INSERT INTO azienda_u(NomeAzienda, Email, Password) VALUES (?,?,?);")){
            statement.setString(1, username);
            statement.setString(2, userEmail);
            statement.setString(3, userPass);
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int verifyCompany(String nomeAzienda, String password) throws NotExistentUserException{
        int i=15;
        Connection myConnection = DBConnection.getDBConnection();
        try (Statement statement = myConnection.createStatement();
             ResultSet resultSet = Queries.loadCompany(statement, nomeAzienda, password)) {
            if (resultSet.next()) {
                i = 1;
            } else {
                throw new NotExistentUserException("NOT EXISTENT COMPANY!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    }
