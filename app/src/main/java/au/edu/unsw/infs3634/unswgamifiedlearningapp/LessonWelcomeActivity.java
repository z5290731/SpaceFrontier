package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;

public class LessonWelcomeActivity extends AppCompatActivity {

    public Button button2;
    private Planet aPlanet;
    public TextView textView4;
    private Planet wPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_welcome);
        Intent intent = getIntent();
        Bundle values = intent.getExtras();
        String planetName = values.getString("planet_name_first_pass");
        String wPlanetName = getIntent().getStringExtra("planet_name_first_pass");
        //aPlanet = Planet.importPlanetData().get(planetName)
        int position = intent.getIntExtra(String.valueOf(journeyLogFragment.EXTRA_MESSAGE), 0);
        //wPlanet = Planet.importPlanetData().get(position);
        //String wPlanetName = wPlanet.getPlanetName();
        System.out.println(wPlanetName);



        Button button2 = findViewById(R.id.button2);
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText(wPlanetName);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Intent planetInfoIntent = new Intent(getApplicationContext(),LessonWikiActivity.class);
                planetInfoIntent.putExtra("planet", wPlanetName);
                c.startActivity(planetInfoIntent);

            }
        });

    }
}