package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;

public class LessonWelcomeActivity extends AppCompatActivity {

    public Button button2;
    public Button button5 , button4;
    public Planet aPlanet;
    public TextView textView4;
    private Planet wPlanet;
    public ImageView planetKawaiiNPC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_welcome);
        Intent intent = getIntent();
        Bundle values = intent.getExtras();
        String planetName = values.getString("planet_name_first_pass");
        String wPlanetName = getIntent().getStringExtra("planet_name_first_pass");
        int planetPicture = getIntent().getIntExtra("planet_picture",0);
        String videoID = getIntent().getStringExtra("planet_video");
        String planetDescription = getIntent().getStringExtra("planet_description");
        String planetSubtitle = getIntent().getStringExtra("planet_subtitle");
        //String planetVideoID = getIntent().getStringExtra("planet_video_id",wPlanet.getPlanetVideo());

        System.out.println(planetPicture);
        System.out.println("Hello THERE");

        //aPlanet = Planet.importPlanetData().get(planetName)
        int position = intent.getIntExtra(String.valueOf(journeyLogFragment.EXTRA_MESSAGE), 0);
        //wPlanet = Planet.importPlanetData().get(position);
        //String wPlanetName = wPlanet.getPlanetName();
        System.out.println(wPlanetName);

        ArrayList<Planet> sPlanet = Planet.importPlanetData();






        Button button2 = findViewById(R.id.button2);
        Button button5 = findViewById(R.id.button5);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        TextView textView4 = findViewById(R.id.textView4);
        ImageView planetKawaiiNPC = findViewById(R.id.planetKawaiiNPC);
        planetKawaiiNPC.setImageResource(planetPicture);
        textView4.setText(wPlanetName);








        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent planetInfoIntent = new Intent(getApplicationContext(),LessonWikiActivity.class);
                planetInfoIntent.putExtra("planet", wPlanetName);
                planetInfoIntent.putExtra("planet_picture",planetPicture);
                planetInfoIntent.putExtra("planet_subtitle", planetSubtitle);
                c.startActivity(planetInfoIntent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent planetInfoIntent = new Intent(getApplicationContext(),LessonPlanetDataActivity.class);
                planetInfoIntent.putExtra("planet", wPlanetName);
                c.startActivity(planetInfoIntent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent planetInfoIntent = new Intent(getApplicationContext(),QuizQuestionActivity.class);
                planetInfoIntent.putExtra("planet", wPlanetName);
                planetInfoIntent.putExtra("planet_picture",planetPicture);
                c.startActivity(planetInfoIntent);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent planetInfoIntent = new Intent(getApplicationContext(),LessonVideoActivity.class);
                planetInfoIntent.putExtra("planet", wPlanetName);
                planetInfoIntent.putExtra("planetVideo",videoID);
                c.startActivity(planetInfoIntent);

            }
        });




    }
}