package linkactivity.linkactivity;

import javafx.scene.control.Alert;

import java.sql.*;

public class CompanyDAO {
    private static final String COMPANY_EMAIL="email";
    private static final String COMPANY_NOME ="nomeAzienda";

    public CompanyModel loadCompany(String nomeAzienda) throws IOExceptionSQL {
        Connection myConnection = DBConnection.getDBConnection();
    CompanyModel company= null;
        try {

            Statement statement = myConnection.createStatement();
            ResultSet resultSet = Queries.selectCompanybyName(statement, nomeAzienda);
            if(resultSet.next()){
                company = createCompany(resultSet);
            }
        } catch (SQLException sqlException) {
            throw new IOExceptionSQL("");
        }
    return company;}

    private CompanyModel createCompany(ResultSet resultSet) throws SQLException {
        String email =resultSet.getString(COMPANY_EMAIL);
        String nomeAzienda =resultSet.getString(COMPANY_NOME);

        return new CompanyModel(email, nomeAzienda);
    }
    public void newCompany(String userEmail, String username, String userPass) throws IOExceptionSQL {
        Connection myConnection = DBConnection.getDBConnection();
        try(PreparedStatement statement =myConnection.prepareStatement("INSERT INTO azienda_u(NomeAzienda, Email, Password) VALUES (?,?,?);")){
            statement.setString(1, username);
            statement.setString(2, userEmail);
            statement.setString(3, userPass);
            statement.execute();
        } catch (SQLException e) {
            throw new IOExceptionSQL("error");
        }
    }

    public int verifyCompany(String nomeAzienda, String password) throws NotExistentUserException {
        int i=15;
        Connection myConnection = DBConnection.getDBConnection();
        try (Statement statement = myConnection.createStatement();
             ResultSet resultSet = Queries.loadCompany(statement, nomeAzienda, password)) {
            if (resultSet.next()) {
                i = 1;
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Username or password are not correct");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            throw new NotExistentUserException("NOT EXISTENT USER");
        }
        return i;
    }
    }
