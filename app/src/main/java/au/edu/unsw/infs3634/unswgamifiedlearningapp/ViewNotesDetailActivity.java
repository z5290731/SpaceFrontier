package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewNotesDetailActivity extends AppCompatActivity {

    public TextView titleMissionNotes, bodyMissionNotes;
    public Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes_detail);



        TextView titleMissionNotes = findViewById(R.id.TitleMissionNotes);
        TextView bodyMissionNotes = findViewById(R.id.BodyMissionNotes);
        Button btnEdit = findViewById(R.id.btnEdit);

        Intent intent = getIntent();

        bodyMissionNotes.setText(intent.getStringExtra("bodyNotes"));
        titleMissionNotes.setText(intent.getStringExtra("titleNotes"));
        System.out.println(intent.getStringExtra("ID"));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),EditNotesDetailActivity.class);
                i.putExtra("titleNotes", intent.getStringExtra("titleNotes"));
                i.putExtra("bodyNotes", intent.getStringExtra("bodyNotes"));
                i.putExtra("ID",intent.getStringExtra("ID"));

                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ViewNotesDetailActivity.this, DetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finishAfterTransition();
    }
}