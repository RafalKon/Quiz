package kon.rafal.quiz.Question;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionDAO {

    void addQuestion(Question question);

    List<Question> displayAllQuestion();

    void deleteQuestion(int ID);

    Question displayQuestionByID(int ID);
}
