package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters.PlanetAdapter;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.profile.cantinaFragment;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.spaceShip.spaceStationFragment;

public class DetailActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;

    private PlanetAdapter mPlanet;


    //Navbar Setting of Fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navBar);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id){
                    case R.id.nav_journey_log:
                        journeyLogFragment journeyLog = new journeyLogFragment();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.fragment_container, journeyLog, "FragmentName");
                        fragmentTransaction1.commit();
                        return true;
                    case R.id.nav_space_station:
                        spaceStationFragment spaceStation = new spaceStationFragment();
                        FragmentTransaction fragmentTransactionS = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionS.replace(R.id.fragment_container, spaceStation, "FragmentName");
                        fragmentTransactionS.commit();
                        return true;
                    case R.id.nav_cantina:
                        cantinaFragment cantina = new cantinaFragment();
                        FragmentTransaction fragmentTransactionC = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionC.replace(R.id.fragment_container, cantina, "FragmentName");
                        fragmentTransactionC.commit();
                        return true;


                        //check id
                }
                return false;
            }
        });



        journeyLogFragment journeyLog = new journeyLogFragment();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.fragment_container, journeyLog, "FragmentName");
        fragmentTransaction1.commit();




        //CHANGE CODE ABOVE

        //Declaring Nav Bar and Fragment
        // Default Fragment is Spaceship Implementation
    }
}