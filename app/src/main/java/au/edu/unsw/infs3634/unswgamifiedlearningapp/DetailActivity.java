package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters.PlanetAdapter;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.notesFragment;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.profile.cantinaFragment;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.spaceShip.spaceStationFragment;

public class DetailActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    private static final String TAG = "TEST";

    private PlanetAdapter mPlanet;


    //Navbar Setting of Fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navBar);

        FirebaseAuth authentication = FirebaseAuth.getInstance();
        FirebaseUser currentUser = authentication.getCurrentUser();


        FirebaseDatabase database = FirebaseDatabase.getInstance("https://spacefrontier-b2799-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference name = database.getReference(FirebaseAuth.getInstance().getUid()).child("Name");
        DatabaseReference XP = database.getReference(FirebaseAuth.getInstance().getUid()).child("XP");
        DatabaseReference quizScore = database.getReference(FirebaseAuth.getInstance().getUid()).child("Score");


        XP.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists() == false) {
                    XP.setValue(0);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "Error: Consult FireBase Documentation for DB Issues");

            }
        });

        quizScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists() == false) {
                    quizScore.setValue(0);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "Error: Consult FireBase Documentation for DB Issues");

            }
        });

        name.setValue(currentUser.getDisplayName());

        System.out.println(String.valueOf(currentUser.getDisplayName()));


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
                    case R.id.mission_notes:
                        notesFragment notes = new notesFragment();
                        FragmentTransaction fragmentTransactionN = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionN.replace(R.id.fragment_container, notes, "FragmentName");
                        fragmentTransactionN.commit();
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