package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.notesFragment;

public class CreateMissionNotesActivity extends AppCompatActivity {

    public EditText titleMissionNotes, bodyMissionNotes;
    public Button btnSave;
    public FirebaseAuth firebaseAuth;
    public FirebaseUser currentUser;
    public FirebaseFirestore firebaseDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mission_notes);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDB = FirebaseFirestore.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        EditText titleMissionNotes = findViewById(R.id.titleMissionNotes);
        EditText bodyMissionNotes = findViewById(R.id.bodyMissionNotes);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleNotes = titleMissionNotes.getText().toString();
                String bodyNotes = bodyMissionNotes.getText().toString();

                if(bodyNotes.isEmpty() || titleNotes.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please fill in both the Title and Body of the Mission Note :)", Toast.LENGTH_LONG).show();

                } else {
                    try{
                        DocumentReference missionDB = firebaseDB.collection("journey").document(currentUser.getUid()).collection("userMissionNotes").document();
                        Map<String,Object> missionNoteHash = new HashMap<>();
                        missionNoteHash.put("titleNotes",titleNotes);
                        missionNoteHash.put("bodyNotes", bodyNotes);

                        missionDB.set(missionNoteHash).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                //Insert Log.e

                                Toast.makeText(getApplicationContext(), "Mission Note Created!", Toast.LENGTH_LONG).show();
                                Intent mainNotes = new Intent(CreateMissionNotesActivity.this, DetailActivity.class);
                                startActivity(mainNotes);



                            }
                        }).addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {

                                Toast.makeText(getApplicationContext(), "Mission Note Creation Cancelled!", Toast.LENGTH_LONG).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(getApplicationContext(), "Mission Note Creation Unsuccessful!", Toast.LENGTH_LONG).show();

                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });





    }
}