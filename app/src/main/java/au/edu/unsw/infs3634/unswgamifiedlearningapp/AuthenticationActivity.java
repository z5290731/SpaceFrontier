package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog.journeyLogFragment;


public class AuthenticationActivity extends AppCompatActivity {

    private static final int AUTHENTICATION = 1;
    private FirebaseAuth mAuth;
    private static final String TAG = "AuthenticationActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        List<AuthUI.IdpConfig> signIn = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setIsSmartLockEnabled(false)
                        .setTheme(R.style.AuthenticationTheme)
                        .setAvailableProviders(signIn)
                        .build(),
                AUTHENTICATION);
    }

    @Override
    protected void onActivityResult(int requestLoginCode, int resultLoginCode, @Nullable Intent data) {
        super.onActivityResult(requestLoginCode, resultLoginCode, data);

        if(requestLoginCode == AUTHENTICATION) {
            IdpResponse authenticationResponse = IdpResponse.fromResultIntent(data);

            if(resultLoginCode == RESULT_OK) {
                FirebaseUser appUser = FirebaseAuth.getInstance().getCurrentUser();
                loginSuccess();
            } else {

            }
        }
    }

    public void loginSuccess() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }





    }
