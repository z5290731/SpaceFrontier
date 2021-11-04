package au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Explorer {

    @PrimaryKey
    @NonNull
    private int explorerID;

    @ColumnInfo(name = "explorer_name")
    private String explorerName;

    @ColumnInfo(name = "progress_rate")
    private double progressRate;

    private double quizQuestionsCorrect;

    private double quizQuestionsAttempted;

    public Explorer(int explorerID, String explorerName, double progressRate, double quizQuestionsCorrect, double quizQuestionsAttempted) {

        this.explorerID = explorerID;
        this.explorerName = explorerName;
        this.progressRate = progressRate;
        this.quizQuestionsCorrect = quizQuestionsCorrect;
        this.quizQuestionsAttempted = quizQuestionsAttempted;
    }

    public int getExplorerID() {
        return explorerID;
    }

    public void setExplorerID(int explorerID) {
        this.explorerID = explorerID;
    }

    public String getExplorerName() {
        return explorerName;
    }

    public void setExplorerName(String explorerName) {
        this.explorerName = explorerName;
    }

    public double getProgressRate() {
        return progressRate;
    }

    public void setProgressRate(double progressRate) {
        this.progressRate = progressRate;
    }

    public double getQuizQuestionsCorrect() {
        return quizQuestionsCorrect;
    }

    public void setQuizQuestionsCorrect(double quizQuestionsCorrect) {
        this.quizQuestionsCorrect = quizQuestionsCorrect;
    }

    public double getQuizQuestionsAttempted() {
        return quizQuestionsAttempted;
    }

    public void setQuizQuestionsAttempted(double quizQuestionsAttempted) {
        this.quizQuestionsAttempted = quizQuestionsAttempted;
    }
}
