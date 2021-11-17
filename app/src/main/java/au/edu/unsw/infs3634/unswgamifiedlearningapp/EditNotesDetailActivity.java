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

public class EditNotesDetailActivity extends AppCompatActivity {

    public EditText editTitleMissionNotes, editBodyMissionNotes;
    public Button btnSaveFromEdit;

    public FirebaseAuth firebaseAuth;
    public FirebaseUser currentUser;
    public FirebaseFirestore firebaseDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes_detail);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDB = FirebaseFirestore.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        editTitleMissionNotes = findViewById(R.id.eTitleMissionNotes);
        editBodyMissionNotes = findViewById(R.id.eBodyMissionNotes);
        btnSaveFromEdit = findViewById(R.id.btnSaveFromEdit);

        Intent dataIntent = getIntent();

        btnSaveFromEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editedTitle = editTitleMissionNotes.getText().toString();
                String editedBody = editBodyMissionNotes.getText().toString();

                if(editedTitle.isEmpty() || editedBody.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please fill in both the Title and Body of the Mission Note :)", Toast.LENGTH_LONG).show();

                } else {
                    try{
                        DocumentReference missionDB = firebaseDB.collection("journey").document(currentUser.getUid()).collection("userMissionNotes").document(dataIntent.getStringExtra("ID"));
                        Map<String,Object> missionNoteHash = new HashMap<>();
                        missionNoteHash.put("titleNotes",editedTitle);
                        missionNoteHash.put("bodyNotes", editedBody);

                        missionDB.set(missionNoteHash).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                //Insert Log.e

                                Toast.makeText(getApplicationContext(), "Saved Changes!", Toast.LENGTH_LONG).show();
                                Intent mainNotes = new Intent(EditNotesDetailActivity.this, DetailActivity.class);
                                startActivity(mainNotes);



                            }
                        }).addOnCanceledListener(new OnCanceledListener() {
                            @Override
                            public void onCanceled() {

                                Toast.makeText(getApplicationContext(), "Cancelled Changes!", Toast.LENGTH_LONG).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(getApplicationContext(), "Changes Unsuccessful", Toast.LENGTH_LONG).show();

                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        String titleNotes = dataIntent.getStringExtra("titleNotes");
        String bodyNotes = dataIntent.getStringExtra("bodyNotes");
        editTitleMissionNotes.setText(titleNotes);
        editBodyMissionNotes.setText(bodyNotes);




    }
}