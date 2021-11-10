package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

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
    public boolean questionAnswered;
    public int quizPoints;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        planetName = getIntent().getStringExtra("planet");
        System.out.println(planetName +"HELLO THERE");

        TextView questionNumber = findViewById(R.id.questionNumber);
        TextView questionText = findViewById(R.id.questionText);
        Button buttonChoiceA = findViewById(R.id.buttonChoiceA);
        Button buttonChoiceB = findViewById(R.id.buttonChoiceB);
        Button buttonChoiceC = findViewById(R.id.buttonChoiceC);
        Button buttonChoiceD = findViewById(R.id.buttonChoiceD);
        ImageButton exitButton = findViewById(R.id.exitButton);
        Button buttonNext = findViewById(R.id.buttonNext);
        Button buttonConfirm = findViewById(R.id.buttonConfirm);


        questionArray = JourneyQuiz.getJourneyQuiz(planetName);
        System.out.println(questionArray.toString());

        totalNumberQuestions = questionArray.size();
        System.out.println(totalNumberQuestions);

        setQuestion();

        checkAnswer();

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionAnswered == false) {

                    checkAnswer();
                } else {
                    System.out.println("NOTHING WAS SELECTED");
                }


            }
        });


    }

    private void checkAnswer() {
        View.OnClickListener buttonChoiceOnClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

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
                String incorrect = "Incorrect Answer";

                if(selectedAnswerString.equals(quizDetails.getQuizAnswer())) {
                    quizPoints++;
                    System.out.println("ANSWER WAS CORRECT");
                    Toast.makeText(getApplicationContext(),correct,Toast.LENGTH_SHORT).show();

                    setQuestion();

                    if(currentQuestionNumber <= 10) {
                        quizCompletion();
                    } else {

                        Toast.makeText(getApplicationContext(),incorrect,Toast.LENGTH_SHORT).show();
                        System.out.println("QUESTION WAS NOT CHECKED");
                        setQuestion();
                    }



                } else {
                    System.out.println("ISSUE WITH CHECKING LOGIC");
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
            Button buttonNext = findViewById(R.id.buttonNext);
            Button buttonConfirm = findViewById(R.id.buttonConfirm);


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
            System.out.println("HELLO WORLD");
        }

    }
}