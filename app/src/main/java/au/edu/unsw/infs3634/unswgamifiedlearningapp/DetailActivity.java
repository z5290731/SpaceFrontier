package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters.PlanetAdapter;

public class DetailActivity extends AppCompatActivity {

    private PlanetAdapter mPlanet;

    //Navbar Setting of Fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Declaring Nav Bar and Fragment
        // Default Fragment is Spaceship Implementation
    }
}