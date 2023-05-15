package linkactivity.linkactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {
    public static ResultSet selectCompanybyName(Statement statement, String nomeAzienda) throws SQLException {
    String query =String.format("SELECT Email FROM azienda_u where NomeAzienda = '%s' ", nomeAzienda);
    return statement.executeQuery(query);
    }

    public static ResultSet selectUserbyTag(Statement statement, String tag) throws SQLException{
        String query =String.format("SELECT Email FROM user where Preferiti = '%s' ", tag);
        return statement.executeQuery(query);
    }

    //classe dove mettere tutte le queries
}
