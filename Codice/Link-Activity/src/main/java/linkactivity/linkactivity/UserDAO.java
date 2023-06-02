package linkactivity.linkactivity;

import java.sql.*;
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
                System.out.println(resultSet);
                user.add(createUser(resultSet));

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return user;}

    private UserModel createUser(ResultSet resultSet) throws SQLException{
        String email =resultSet.getString(USER_EMAIL);
        System.out.println(email);
        return new UserModel(email);
    }

    public void newUser(String userEmail, String username, String userPass) {
        Connection myConnection = DBConnection.getDBConnection();
        try(PreparedStatement statement =myConnection.prepareStatement("INSERT INTO user(Email, Username, Password) VALUES (?,?,?);")){
            statement.setString(1, userEmail);
            statement.setString(2, username);
            statement.setString(3, userPass);
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
    public static void addFavouriteTag(String username, String tag) {
        Connection myConnection = DBConnection.getDBConnection();
        try(PreparedStatement statement =myConnection.prepareStatement("UPDATE user SET preferiti = ? WHERE username = ?;"))
        { statement.setString(1, tag);
            statement.setString(2, username);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int verifyUser(String username, String userPass) throws NotExistentUserException {
        int i = 15;
        Connection myConnection = DBConnection.getDBConnection();
        try (Statement statement = myConnection.createStatement();
             ResultSet resultSet = Queries.loadUser(statement, username, userPass)) {
            if (resultSet.next()) {
                i = 0;
            } else {
                throw new NotExistentUserException("NOT EXISTENT USER!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
