package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters.PlanetAdapter;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;

public class DetailActivity extends AppCompatActivity {

    private PlanetAdapter mPlanet;

    //Navbar Setting of Fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        journeyLogFragment journeyLog = new journeyLogFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fragment_container, journeyLog, "FragmentName");
        fragmentTransaction1.commit();

        //CHANGE CODE ABOVE

        //Declaring Nav Bar and Fragment
        // Default Fragment is Spaceship Implementation
    }
}