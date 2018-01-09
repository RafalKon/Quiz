package kon.rafal.quiz.Result;

import kon.rafal.quiz.DataBase.DBConnection;
import kon.rafal.quiz.Result.Result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ResultDAOImpl {

    List<Result> allResult = new LinkedList<>();

    public void addResult(Result result) {

        String sql = "Insert into result values('" + result.getID() + "','" + result.getUserName() + "','" + result.getUserPoint() + "')";

        DBConnection dbConnection = new DBConnection();
        try {
            dbConnection.dbExecuteUpdateQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Result> displayResult() {

        String sql = "Select * from result";

        DBConnection dbConnection = new DBConnection();
        ResultSet resultSet = null;


        try {
            dbConnection.dbExecuteQuery(sql);
            while (resultSet.next()) {
                Result result = new Result();
                result.setID(resultSet.getInt(1));
                result.setUserName(resultSet.getString(2));
                result.setUserPoint(resultSet.getInt(3));

                allResult.add(result);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allResult;

    }

}
