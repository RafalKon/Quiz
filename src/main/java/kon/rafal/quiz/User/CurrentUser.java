package kon.rafal.quiz.User;

import kon.rafal.quiz.Controler.UserControler;
import kon.rafal.quiz.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CurrentUser {

    LinkedList<User> users = new LinkedList<>();


 /*   public List<User> getCurrentUser(User user) {

        users.add(user);

        return users;
    } */

    public void addCurrentUser(User user) {

        users.add(user);

    }

    public List<User> getCurrentUser() {

        return users;
    }

}
