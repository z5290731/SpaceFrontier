package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;

public class QuizJourneyEndActivity extends AppCompatActivity {

    public Button btn_share , btn_finish;
    public TextView tvJourneyPoints;
    public TextView tvOneLine;
    public TextView tvAttribute;
    public ImageView imageView2;
    public int quizScore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_journey_end);

        Button btn_finish = (findViewById(R.id.btn_finish));
        TextView tvJourneyPoints = findViewById(R.id.tvJourneyPoints);
        TextView tvOneLine = findViewById(R.id.tvOneLine);
        TextView tvAttribute = findViewById(R.id.tvAttribute);
        ImageView imageView2 = findViewById(R.id.imageView2);

        quizScore = Integer.valueOf(getIntent().getStringExtra("totalScore"));


        tvJourneyPoints.setText(String.format("%d points!", quizScore));

        imageView2.setImageResource(getIntent().getIntExtra("planet_picture",0));

        if(quizScore == 10) {
            tvOneLine.setText("Perfect!");
            tvAttribute.setText("Great Job on getting full marks! Try another quiz to test your exceptional learning skills :)");

        } else if(quizScore == 9) {
            tvOneLine.setText("So Close");
            tvAttribute.setText("Try watching the video lessons to learn more!");


        } else if (quizScore == 8) {
            tvOneLine.setText("So Close");
            tvAttribute.setText("Try watching the video lessons to learn more!");


        } else {
            tvOneLine.setText("Unlucky :(");
            tvAttribute.setText("Feel free to read through the lesson to increase your understanding!!");

        }

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                //planetInfoIntent.putExtra("planet", wPlanetName);
                //planetInfoIntent.putExtra("planet_picture",planetPicture);
                //planetInfoIntent.putExtra("planet_subtitle", planetSubtitle);
                c.startActivity(intent);

            }
        });






    }

}