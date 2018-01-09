package kon.rafal.quiz.Result;

import java.util.Random;

public class Result {

    private int ID;
    private String userName;
    private int userPoint;

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", userPoint=" + userPoint +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public Result(int ID, String userName, int userPoint) {


        Random generator = new Random();
        this.ID = generator.nextInt();


        this.userName = userName;
        this.userPoint = userPoint;

    }
}
