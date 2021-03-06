package kon.rafal.quiz.Controler;

import kon.rafal.quiz.EmailService.EmailServices;
import kon.rafal.quiz.User.CurrentUser;
import kon.rafal.quiz.Question.Question;
import kon.rafal.quiz.Question.QuestionDAO;
import kon.rafal.quiz.User.User;
import kon.rafal.quiz.User.UserDAO;
import kon.rafal.quiz.User.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionControler {

    @Autowired
    QuestionDAO questionDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    CurrentUser currentUser;

    @Autowired
    EmailServices emailServices;

    @Autowired
    UserDAOImpl userDAOimpl;

    int ID = 0;
    int userCorrectAnserw = 0;
    int countQuestion = 1;

    @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
    public String Question(ModelMap modelMap) {

        modelMap.addAttribute("question", new Question());


        return "Question";
    }

    @PostMapping(value = "/test")
    public String question(@ModelAttribute Question question, ModelMap modelMap) {

        modelMap.addAttribute("question", question);
        questionDAO.addQuestion(question);

        return "redirect:/addQuestion";
    }

    @RequestMapping(value = "/displayQuestion", method = RequestMethod.GET)
    public String displayQuestion(ModelMap modelMap) {


        modelMap.addAttribute("questions", questionDAO.displayAllQuestion());


        return "displayQuestion";
    }

    @RequestMapping(value = "/removeQuestion", method = RequestMethod.GET)
    public String removeQuestionByID(@RequestParam("id") int id, ModelMap modelMap) {

        questionDAO.deleteQuestion(id);
        System.out.println("dziala");
        return "redirect:/displayQuestion";
    }

    @RequestMapping(value = "/showQuestion", method = RequestMethod.GET)
    public String showQuestion(ModelMap modelMap) {

        ID++;

        modelMap.addAttribute("question", questionDAO.displayQuestionByID(ID));

        return "showQuestion";
    }

    @PostMapping(value = "/showQuestionPost")
    public String showQuestionPost(@RequestParam("anserw") int userchoice, ModelMap modelMap) {

        String uri;
        Question question = new Question();
        if (userchoice == questionDAO.displayQuestionByID(ID).getCorrectAnserw()) {
            userCorrectAnserw++;
        }

        if (questionDAO.displayAllQuestion().size() > countQuestion) {

            uri = "/showQuestion";
            countQuestion++;
        } else {

            uri = "/summary";
        }
        return "redirect:" + uri;
    }

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String summary(ModelMap modelMap, User user) {


        String amountOfPoints = "Uzyskałeś " + userCorrectAnserw + " punktów na " + countQuestion + " Możliwych";


        String person = "czesc " + currentUser.getCurrentUser().get(0).getName();

        modelMap.addAttribute("amountOfPoints", amountOfPoints);

        modelMap.addAttribute("Currentuser", person);

        String to = currentUser.getCurrentUser().get(0).getEmail();
        String subject = "Rozwiązanie Quizu";
        String text = "Uzyskałeś " + userCorrectAnserw + " punktów na " + countQuestion + " Możliwych";
        emailServices.sendSimpleMessage(to, subject, text);

        userDAOimpl.updatePoints(userCorrectAnserw, currentUser.getCurrentUser().get(0).getEmail());

        return "summary";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(ModelMap modelMap) {


        modelMap.addAttribute("lista", userDAO.allUsers());

        return "result";
    }


}
