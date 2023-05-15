package linkactivity.linkactivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String USER_EMAIL="email";
    private static final String USER_USERNAME="username";
    private static final String USER_PREFERITI ="preferiti";

    public List<UserModel> loadUserFromFavoriteTag(String tag){
        Connection myConnection = DBConnection.getDBConnection();
        List<UserModel> user=new ArrayList<>();
        try (Statement statement = myConnection.createStatement();
            ResultSet resultSet = Queries.selectUserbyTag(statement, tag)){
            while(resultSet.next()){
                user.add(createUser(resultSet));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return user;}

    private UserModel createUser(ResultSet resultSet) throws SQLException{
        String email =resultSet.getString(USER_EMAIL);
        return new UserModel(email);
    }

}
