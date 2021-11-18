package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;

public class QuizJourneyEndActivity extends AppCompatActivity {

    public Button btn_share , btn_finish;
    public TextView tvJourneyPoints;
    public TextView tvOneLine;
    public TextView tvAttribute;
    public ImageView imageView2;
    public int quizScore;
    public long currentScore;
    public long currentLevel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_journey_end);

        btn_finish = findViewById(R.id.btn_finish);
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
                Toast.makeText(getApplication(), "Clicked to Finish!", Toast.LENGTH_SHORT).show();
                scoreUpload();
            }
        });
    }

    @Override
    public void onBackPressed() {
        scoreUpload();
    }


    public void scoreUpload() {

        System.out.println("Entering Score Upload Method Now!");

        FirebaseAuth authentication = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://spacefrontier-b2799-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference finalScore = database.getReference(authentication.getUid()).child("Score");
        DatabaseReference finalLevel = database.getReference(authentication.getUid()).child("XP");

        System.out.println("Database Initialised");

        finalScore.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("Entering onDataChange now!");
                if(snapshot.exists()) {
                    System.out.println("SnapShot Exists");
                    currentScore = (long) snapshot.getValue();
                    currentScore = currentScore + quizScore;
                    if(currentScore >= 100) {
                        currentScore = currentScore - 100;
                        snapshot.getRef().setValue(currentScore);
                        finalLevel.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()) {
                                    currentLevel = (long) snapshot.getValue();
                                    currentLevel = currentLevel + 1;
                                    snapshot.getRef().setValue(currentLevel);

                                } else {
                                    finalScore.setValue(1);

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                                Toast.makeText(getApplication(), "Score Upload Failed :(", Toast.LENGTH_SHORT).show();


                            }
                        });
                    } else {
                        snapshot.getRef().setValue(currentScore);
                    }

                } else {
                    System.out.println("Snapshot Does Not Exist");
                    finalScore.setValue(quizScore);
                }
                Toast.makeText(getApplication(), "Returning to Journey Log!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuizJourneyEndActivity.this, DetailActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getApplication(), "Score Upload Failed :(", Toast.LENGTH_SHORT).show();

            }
        });

    }

}