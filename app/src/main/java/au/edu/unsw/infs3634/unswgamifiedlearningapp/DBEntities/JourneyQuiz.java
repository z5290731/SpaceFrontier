package au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities;

import java.util.ArrayList;

public class JourneyQuiz {

    private Integer quizNumber;

    private String quizQuestion;

    private String quizOption1;

    private String quizOption2;

    private String quizOption3;

    private String quizOption4;

    private Integer quizAnswerNumber;

    private String quizBackgroundImage;

    public JourneyQuiz(Integer quizNumber, String quizQuestion, String quizOption1, String quizOption2, String quizOption3, String quizOption4, Integer quizAnswerNumber, String quizBackgroundImage) {
        this.quizNumber = quizNumber;
        this.quizQuestion = quizQuestion;
        this.quizOption1 = quizOption1;
        this.quizOption2 = quizOption2;
        this.quizOption3 = quizOption3;
        this.quizOption4 = quizOption4;
        this.quizAnswerNumber = quizAnswerNumber;
        this.quizBackgroundImage = quizBackgroundImage;
    }

    public Integer getQuizNumber() {
        return quizNumber;
    }

    public void setQuizNumber(Integer quizNumber) {
        this.quizNumber = quizNumber;
    }

    public String getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(String quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    public String getQuizOption1() {
        return quizOption1;
    }

    public void setQuizOption1(String quizOption1) {
        this.quizOption1 = quizOption1;
    }

    public String getQuizOption2() {
        return quizOption2;
    }

    public void setQuizOption2(String quizOption2) {
        this.quizOption2 = quizOption2;
    }

    public String getQuizOption3() {
        return quizOption3;
    }

    public void setQuizOption3(String quizOption3) {
        this.quizOption3 = quizOption3;
    }

    public String getQuizOption4() {
        return quizOption4;
    }

    public void setQuizOption4(String quizOption4) {
        this.quizOption4 = quizOption4;
    }

    public Integer getQuizAnswerNumber() {
        return quizAnswerNumber;
    }

    public void setQuizAnswerNumber(Integer quizAnswerNumber) {
        this.quizAnswerNumber = quizAnswerNumber;
    }

    public String getQuizBackgroundImage() {
        return quizBackgroundImage;
    }

    public void setQuizBackgroundImage(String quizBackgroundImage) {
        this.quizBackgroundImage = quizBackgroundImage;
    }

    public static ArrayList<JourneyQuiz> getJourneyQuiz(String planetName) {
        ArrayList<JourneyQuiz> quizArray = new ArrayList<>();
        switch(planetName) {
            case "Mercury":

                break;

            case "Venus":

                break;

            case "Earth":
                break;

            case "Mars":
                break;

            case "Jupiter":
                break;

            case "Saturn":
                break;

            case "Uranus":
                break;

            case "Neptune":

                break;

        }
        return quizArray;
    }
}
