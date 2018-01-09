package kon.rafal.quiz.Result;

import kon.rafal.quiz.Result.Result;

import java.util.List;

public interface ResultDAO {

    void addResult(Result result);

    List<Result> displayResult();


}
