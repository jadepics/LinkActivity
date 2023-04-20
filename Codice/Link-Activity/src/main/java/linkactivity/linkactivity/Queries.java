package linkactivity.linkactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {
    public static ResultSet selectCompanybyName(Statement statement, String nomeAzienda) throws SQLException {
    String query =String.format("SELECT * FROM azienda_u where NomeAzienda = '%s' ", nomeAzienda);
    return statement.executeQuery(query);
    }

    //classe dove mettere tutte le queries
}
