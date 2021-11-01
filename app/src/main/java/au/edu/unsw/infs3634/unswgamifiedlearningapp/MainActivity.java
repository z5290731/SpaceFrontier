package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters.PlanetAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity.class";

    public static AppDatabase db;

    private PlanetAdapter mPlanet;
    private androidx.fragment.app.FragmentManager FragmentManager;
    private androidx.fragment.app.FragmentTransaction FragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}