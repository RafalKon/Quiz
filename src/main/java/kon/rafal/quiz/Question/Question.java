package kon.rafal.quiz.Question;

public class Question {

    private int ID;
    private String question;
    private String anserw1;
    private String anserw2;
    private String anserw3;
    private int correctAnserw;
    private int userChoice;



    @Override
    public String toString() {
        return "QuestionControler{" +
                "ID=" + ID +
                ", question='" + question + '\'' +
                ", anserw1='" + anserw1 + '\'' +
                ", anserw2='" + anserw2 + '\'' +
                ", anserw3='" + anserw3 + '\'' +
                ", correctAnserw=" + correctAnserw +
                ", userChoice=" + userChoice +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnserw1() {
        return anserw1;
    }

    public void setAnserw1(String anserw1) {
        this.anserw1 = anserw1;
    }

    public String getAnserw2() {
        return anserw2;
    }

    public void setAnserw2(String anserw2) {
        this.anserw2 = anserw2;
    }

    public String getAnserw3() {
        return anserw3;
    }

    public void setAnserw3(String anserw3) {
        this.anserw3 = anserw3;
    }

    public int getCorrectAnserw() {
        return correctAnserw;
    }

    public void setCorrectAnserw(int correctAnserw) {
        this.correctAnserw = correctAnserw;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public Question() {

    }

    public Question(int ID, String question, String anserw1, String anserw2, String anserw3, int correctAnserw, int userChoice) {

        this.ID = ID;
        this.question = question;
        this.anserw1 = anserw1;
        this.anserw2 = anserw2;
        this.anserw3 = anserw3;
        this.correctAnserw = correctAnserw;
        this.userChoice = userChoice;
    }
}
