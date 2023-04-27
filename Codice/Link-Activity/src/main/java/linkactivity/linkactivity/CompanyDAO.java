package linkactivity.linkactivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyDAO {
    //private static final String COMPANY_EMAIL="email";
    private static final String COMPANY_NOME ="nomeAzienda";
    private static final String COMPANY_LOGO= ""; //vedi che ci devi mette

    public Company loadCompany(String nomeAzienda){
        Connection myConnection = DBConnection.getDBConnection();
    Company company=null;
        try {

            Statement statement = myConnection.createStatement();
            ResultSet resultSet = Queries.selectCompanybyName(statement, nomeAzienda);
            if(resultSet.next()){
                company =createCompany(resultSet);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    return company;}

    private Company createCompany(ResultSet resultSet) throws SQLException{
      //  String email =resultSet.getString(COMPANY_EMAIL);
        String nomeAzienda =resultSet.getString(COMPANY_NOME);
        //String logo =resultSet.getString(COMPANY_LOGO);

        return new Company(nomeAzienda, "");
    }
}
