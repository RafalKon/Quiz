package kon.rafal.quiz.Question;

import kon.rafal.quiz.DataBase.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class QuestionDAOImpl implements QuestionDAO {


    List<Question> allQuestions = new LinkedList<>();


    public void addQuestion(Question question) {

        String sql = "Insert into question values('" + question.getID() + "','" + question.getQuestion() + "','" + question.getAnserw1() +
                "','" + question.getAnserw2() + "','" + question.getAnserw3() + "','" + question.getCorrectAnserw() + "','"
                + question.getCorrectAnserw() + "')";

        DBConnection dbConnection = new DBConnection();

        try {
            dbConnection.dbExecuteUpdateQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Question> displayAllQuestion() {

        List<Question> allQuestions = new LinkedList<>();
        String sql = "Select * from question";

        DBConnection dbConnection = new DBConnection();
        ResultSet resultSet = null;

        try {
            resultSet = dbConnection.dbExecuteQuery(sql);
            while (resultSet.next()) {
                Question question = new Question();
                question.setID(resultSet.getInt(1));
                question.setQuestion(resultSet.getString(2));
                question.setAnserw1(resultSet.getString(3));
                question.setAnserw2(resultSet.getString(4));
                question.setAnserw3(resultSet.getString(5));
                question.setCorrectAnserw(resultSet.getInt(6));
                question.setUserChoice(resultSet.getInt(7));

                allQuestions.add(question);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allQuestions;
    }

    public Question displayQuestionByID(int ID){

        String sql = "Select * from question where ID=('" + ID + "')";
        Question question = new Question();

        DBConnection dbConnection = new DBConnection();
        ResultSet resultSet = null;

        try {
            resultSet = dbConnection.dbExecuteQuery(sql);
            while(resultSet.next()){
                question.setID(resultSet.getInt(1));
                question.setQuestion(resultSet.getString(2));
                question.setAnserw1(resultSet.getString(3));
                question.setAnserw2(resultSet.getString(4));
                question.setAnserw3(resultSet.getString(5));
                question.setCorrectAnserw(resultSet.getInt(6));
                question.setUserChoice(resultSet.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return question;
    }

    public void deleteQuestion(int ID) {

        String sql = "Delete from question where ID='" + ID + "'";

        DBConnection dbConnection = new DBConnection();
        try {
            dbConnection.dbExecuteUpdateQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
