package kon.rafal.quiz.User;

import kon.rafal.quiz.User.User;

import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl {

    List<User> users = new LinkedList<>();

    public void addUsers(User user) {

        users.add(user);


    }

    public User showUser() {


        return users.get(0);
    }

}
