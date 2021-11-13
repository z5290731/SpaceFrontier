package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuizJourneyEndActivity extends AppCompatActivity {

    public Button btn_share;
    public TextView tvJourneyPoints;
    public TextView tvOneLine;
    public TextView tvAttribute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_journey_end);
    }
}