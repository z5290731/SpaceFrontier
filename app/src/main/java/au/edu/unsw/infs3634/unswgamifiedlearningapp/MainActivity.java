package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters.PlanetAdapter;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler delayHandler = new Handler();
        delayHandler.postDelayed(loginScreen, 200);

    }

    private Runnable loginScreen = new Runnable () {
        @Override
        public void run() {
            Intent intent = new Intent(MainActivity.this, AuthenticationActivity.class);
            startActivity(intent);

        }


    };

}