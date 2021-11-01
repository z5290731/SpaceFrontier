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


}
