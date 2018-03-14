package kon.rafal.quiz.User;

import kon.rafal.quiz.DataBase.DBConnection;
import kon.rafal.quiz.User.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    List<User> users = new LinkedList<>();

    public void addUsers(User user) {

        int points = 0;
        String sql = "Insert into user values('" + user.getName() + "','" + user.getSurname() + "','" + user.getEmail() + "','" + points + "')";

        DBConnection dbConnection = new DBConnection();

        try {
            dbConnection.dbExecuteUpdateQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    public User showUser() {


        return users.get(0);
    }

    public List<User> allUsers() {

        String sql = "Select * from user";

        DBConnection dbConnection = new DBConnection();
        ResultSet resultSet = null;

        try {
            resultSet = dbConnection.dbExecuteQuery(sql);
            while (resultSet.next()) {

                User user = new User();
                user.setName(resultSet.getString(1));
                user.setSurname(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPoints(resultSet.getInt(4));
                users.add(user);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;

    }

    public void updatePoints(int points, String email) {

        String sql = "Update user set points = '" + points + "' where email = '" + email + "'";

        DBConnection dbConnection = new DBConnection();
        try {
            dbConnection.dbExecuteUpdateQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
