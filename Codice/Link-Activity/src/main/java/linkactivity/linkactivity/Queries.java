package linkactivity.linkactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {
    public static ResultSet selectCompanybyName(Statement statement, String nomeAzienda) throws SQLException {
    String query =String.format("SELECT * FROM azienda_u where NomeAzienda = '%s' ", nomeAzienda);
    return statement.executeQuery(query);
    }

    public static ResultSet selectUserbyTag(Statement statement, String tag) throws SQLException{
        String query =String.format("SELECT Email FROM user where Preferiti = '%s' ", tag);
        return statement.executeQuery(query);
    }

    public static ResultSet loadUser(Statement statement, String username, String userPass) throws SQLException {
    String query= String.format("SELECT * FROM user WHERE Username= '%s' AND Password= '%s'", username, userPass);
    return  statement.executeQuery(query);
    }

    public static ResultSet loadCompany(Statement statement, String nomeAzienda, String password) throws SQLException {
        String query= String.format("SELECT * FROM azienda_u WHERE NomeAzienda ='%s' AND Password ='%s'", nomeAzienda, password);
        return statement.executeQuery(query);
    }

    //classe dove mettere tutte le queries
}
