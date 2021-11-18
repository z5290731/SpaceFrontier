package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.Executors;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.JourneyQuiz;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;

public class QuizQuestionActivity extends AppCompatActivity {

    public TextView questionNumber, questionText;
    public ImageButton exitButton;
    public Button buttonChoiceA, buttonChoiceB, buttonChoiceC, buttonChoiceD, buttonNext, buttonConfirm;
    public ArrayList<JourneyQuiz> questionArray;
    public JourneyQuiz quizDetails;
    public Integer currentQuestionNumber = 0;
    public Integer totalNumberQuestions = 0;
    public String planetName;
    public int planetPic;
    public boolean questionAnswered;
    public int quizPoints;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        planetName = getIntent().getStringExtra("planet");
        planetPic = getIntent().getIntExtra("planet_picture",0);
        System.out.println(planetName +"HELLO THERE");

        TextView questionNumber = findViewById(R.id.questionNumber);
        TextView questionText = findViewById(R.id.questionText);
        Button buttonChoiceA = findViewById(R.id.buttonChoiceA);
        Button buttonChoiceB = findViewById(R.id.buttonChoiceB);
        Button buttonChoiceC = findViewById(R.id.buttonChoiceC);
        Button buttonChoiceD = findViewById(R.id.buttonChoiceD);
        ImageButton exitButton = findViewById(R.id.exitButton);


        questionArray = JourneyQuiz.getJourneyQuiz(planetName);
        System.out.println(questionArray.toString());

        totalNumberQuestions = questionArray.size();
        System.out.println(totalNumberQuestions);

        setQuestion();

        checkAnswer();


    }

    private void checkAnswer() {
        View.OnClickListener buttonChoiceOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Button buttonChoiceA = findViewById(R.id.buttonChoiceA);
                Button buttonChoiceB = findViewById(R.id.buttonChoiceB);
                Button buttonChoiceC = findViewById(R.id.buttonChoiceC);
                Button buttonChoiceD = findViewById(R.id.buttonChoiceD);


                buttonChoiceA.setClickable(false);
                buttonChoiceB.setClickable(false);
                buttonChoiceC.setClickable(false);
                buttonChoiceD.setClickable(false);

                int currentArrayNumber = currentQuestionNumber -1;

                quizDetails = questionArray.get(currentArrayNumber);

                System.out.println(currentQuestionNumber);

                Button selectedAnswer = (Button) v;

                String selectedAnswerString = selectedAnswer.getText().toString();

                System.out.println(selectedAnswerString + "THIS IS WHAT WAS SELECTED");

                System.out.println(quizDetails.getQuizQuestion());
                System.out.println(quizDetails.getQuizNumber());
                System.out.println(quizDetails.getQuizAnswer() + "THIS IS THE QUIZZES ANSWER");

                String correct = "Correct Answer";
                String incorrect = "Incorrect Answer procceding to neext quesiton";
                String total = quizPoints + "Total Points";


                if(selectedAnswerString.equals(quizDetails.getQuizAnswer())) {

                    if(currentQuestionNumber < 10) {

                        quizPoints++;
                        System.out.println("ANSWER WAS CORRECT");
                        Toast.makeText(getApplicationContext(),correct,Toast.LENGTH_SHORT).show();
                        System.out.println("This is the current question being marked" + currentQuestionNumber);
                        setQuestion();
                        System.out.println(currentQuestionNumber + "QUESTION NOW");

                    } else {

                        Toast.makeText(getApplicationContext(),"Quiz Completed!",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),total,Toast.LENGTH_SHORT).show();
                        quizCompletion();

                    }


                } else {

                    if(currentQuestionNumber < 10) {

                        Toast.makeText(getApplicationContext(),incorrect,Toast.LENGTH_SHORT).show();
                        System.out.println("NEXT Q INCORRECT");
                        setQuestion();



                    } else {

                        Toast.makeText(getApplicationContext(),"Quiz Completed!",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),total,Toast.LENGTH_SHORT).show();
                        quizCompletion();


                    }


                }

            }
        };

        questionAnswered = true;

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {

                Button buttonChoiceA = findViewById(R.id.buttonChoiceA);
                Button buttonChoiceB = findViewById(R.id.buttonChoiceB);
                Button buttonChoiceC = findViewById(R.id.buttonChoiceC);
                Button buttonChoiceD = findViewById(R.id.buttonChoiceD);


                buttonChoiceA.setOnClickListener(buttonChoiceOnClickListener);
                buttonChoiceB.setOnClickListener(buttonChoiceOnClickListener);
                buttonChoiceC.setOnClickListener(buttonChoiceOnClickListener);
                buttonChoiceD.setOnClickListener(buttonChoiceOnClickListener);
            }
        });




    }

    private void quizCompletion() {
        Intent intent = new Intent(this,QuizJourneyEndActivity.class);
        intent.putExtra("totalScore",String.valueOf(quizPoints));
        intent.putExtra("planetName", planetName);
        intent.putExtra("planet_picture", planetPic);
        startActivity(intent);

    }

    private void setQuestion() {

        if(currentQuestionNumber < totalNumberQuestions) {

            quizDetails = questionArray.get(currentQuestionNumber);

            TextView questionNumber = findViewById(R.id.questionNumber);
            TextView questionText = findViewById(R.id.questionText);
            Button buttonChoiceA = findViewById(R.id.buttonChoiceA);
            Button buttonChoiceB = findViewById(R.id.buttonChoiceB);
            Button buttonChoiceC = findViewById(R.id.buttonChoiceC);
            Button buttonChoiceD = findViewById(R.id.buttonChoiceD);
            ImageButton exitButton = findViewById(R.id.exitButton);


            buttonChoiceA.setClickable(true);
            buttonChoiceB.setClickable(true);
            buttonChoiceC.setClickable(true);
            buttonChoiceD.setClickable(true);


            System.out.println(currentQuestionNumber + "THIS IS THE CURRENT QUESTION NUMBER");
            System.out.println(quizDetails.toString() + "TESTING" );
            System.out.println(quizDetails.getQuizQuestion() + "AYY LMAO");

            questionText.setText(quizDetails.getQuizQuestion());



            buttonChoiceA.setText(quizDetails.getQuizOption1());
            System.out.println(buttonChoiceA.toString());
            buttonChoiceB.setText(quizDetails.getQuizOption2());
            System.out.println(buttonChoiceB.toString());
            buttonChoiceC.setText(quizDetails.getQuizOption3());
            System.out.println(buttonChoiceC.toString());
            buttonChoiceD.setText(quizDetails.getQuizOption4());

            currentQuestionNumber++;

            questionNumber.setText(String.valueOf(currentQuestionNumber));

        } else {
            //INSERT RESULT TING;
            System.out.println("ISSUE WITH SETTING QUESTION HERE");
        }

    }
}