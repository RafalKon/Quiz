package kon.rafal.quiz.Controler;

import kon.rafal.quiz.Question.Question;
import kon.rafal.quiz.Question.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionControler {

    @Autowired
    QuestionDAO questionDAO;

    @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
    public String Question(ModelMap modelMap) {

        modelMap.addAttribute("question", new Question());


        return "Question";
    }

    @PostMapping(value = "/test")
    public String Question(@ModelAttribute Question question, ModelMap modelMap) {

        modelMap.addAttribute("question", question);
        questionDAO.addQuestion(question);

        return "redirect:/addQuestion";
    }


}
