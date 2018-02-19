package kon.rafal.quiz.Controler;

import kon.rafal.quiz.CurrentUser;
import kon.rafal.quiz.User.User;
import kon.rafal.quiz.User.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserControler {

    @Autowired
    UserDAO userDAO;

    @Autowired
    CurrentUser currentUser;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String addUser(ModelMap modelMap) {

        modelMap.addAttribute("User", new User());

        return "user";
    }

    @PostMapping(value = "/cos")
    public String user(@ModelAttribute User user, ModelMap modelMap){

        modelMap.addAttribute("User", new User());
        userDAO.addUsers(user);
        currentUser.addCurrentUser(user);

        return "redirect:/showQuestion";
    }




}
