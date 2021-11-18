package au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.profile;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.MainActivity;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cantinaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cantinaFragment extends Fragment {

    private TextView tvUser, tvLevel, tvScore;
    private Button btnSignOut, btnTutorial;
    private ProgressBar progressBar2;
    private SeekBar seekBar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cantinaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cantinaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static cantinaFragment newInstance(String param1, String param2) {
        cantinaFragment fragment = new cantinaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_cantina, container, false);

        tvUser = (TextView) fragmentView.findViewById(R.id.tvUser);

        tvLevel = (TextView) fragmentView.findViewById(R.id.tvLevel);

        tvScore = (TextView) fragmentView.findViewById(R.id.tvScore);

        btnSignOut = (Button) fragmentView.findViewById(R.id.btnSignOut);

        btnTutorial = (Button) fragmentView.findViewById(R.id.btnTutorial);

        seekBar = (SeekBar) fragmentView.findViewById(R.id.seekBar);

        /**
         * For the Cantina, utilisation of the Firebase Realtime Database was utilise
         * as a simple and efficient way to query the limited data by each user
         */



        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        tvUser.setText(user.getDisplayName().toString());

        /**
         * The getInstance() method called included a specific link to the Database backend
         * due to the Firebase default location being in the U.S. The Sydney Servers were chosen
         * for data integrity and low latency reasons.
         */

        FirebaseDatabase RealtimeDB = FirebaseDatabase.getInstance("https://spacefrontier-b2799-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference scoreValue = RealtimeDB.getReference(FirebaseAuth.getInstance().getUid()).child("Score");
        DatabaseReference levelValue = RealtimeDB.getReference(FirebaseAuth.getInstance().getUid()).child("XP");
        //
        // DatabaseReference myLeadRef = database.getReference();

        /**
         * These ValueEventListeners help in setting and understanding when and how data hase changed. Indeed
         * the onDataChange and checking of snapshots of the Realtime Database allow decisions to be made which impact
         * upon the users score.
         */

        scoreValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    tvScore.setText(snapshot.getValue().toString());
                    seekBar.setProgress(Integer.parseInt(snapshot.getValue().toString()));
                    seekBar.setMax(100);

                } else {
                    tvScore.setText(String.valueOf(0));

                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                /**
                 *This allowed a return string to be utilised if an error occurred.
                 */

                System.out.println("Oh No, Its happening");

            }
        });

        levelValue.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    tvLevel.setText(snapshot.getValue().toString());
                } else {
                    tvLevel.setText(String.valueOf(1));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);


            }
        });






        return fragmentView;
    }
}