package kon.rafal.quiz.User;

import kon.rafal.quiz.Question.Question;
import kon.rafal.quiz.User.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface UserDAO {

    void addUsers(User user);

    User showUser();

    List<User> allUsers();

}
