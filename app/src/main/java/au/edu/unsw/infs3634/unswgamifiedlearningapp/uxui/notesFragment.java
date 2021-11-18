package au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.CreateMissionNotesActivity;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.NotesFireBaseModel;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.R;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.ViewNotesDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link notesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class notesFragment extends Fragment {

    FloatingActionButton addMissionNotesButton;
    RecyclerView notesRecyclerView;
    StaggeredGridLayoutManager LayoutManager;
    FirestoreRecyclerAdapter<NotesFireBaseModel,MissionNotesViewHolder> MissionNotesAdapter;



    FirebaseUser currentUser;
    FirebaseFirestore fireBaseDB;

    private FirebaseAuth firebaseAuth;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public notesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment notesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static notesFragment newInstance(String param1, String param2) {
        notesFragment fragment = new notesFragment();
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

        View fragmentView = inflater.inflate(R.layout.fragment_notes, container, false);


        FloatingActionButton addMissionNotesButton = (FloatingActionButton) fragmentView.findViewById(R.id.addMissionNotes);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        fireBaseDB = FirebaseFirestore.getInstance();

        addMissionNotesButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateMissionNotesActivity.class);
                startActivity(intent);


            }
        });

        Query notesQuery = fireBaseDB.collection("journey").document(currentUser.getUid()).collection("userMissionNotes").orderBy("titleNotes", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<NotesFireBaseModel> currentMissionNotes = new FirestoreRecyclerOptions.Builder<NotesFireBaseModel>().setQuery(notesQuery,NotesFireBaseModel.class).build();

        MissionNotesAdapter = new FirestoreRecyclerAdapter<NotesFireBaseModel, MissionNotesViewHolder>(currentMissionNotes) {
            @Override
            protected void onBindViewHolder(@NonNull MissionNotesViewHolder missionNotesViewHolder, int i, @NonNull NotesFireBaseModel notesFireBaseModel) {



                missionNotesViewHolder.titleNote.setText(notesFireBaseModel.getTitleNotes());
                missionNotesViewHolder.bodyNote.setText(notesFireBaseModel.getBodyNotes());


                String noteID = MissionNotesAdapter.getSnapshots().getSnapshot(i).getId();

                missionNotesViewHolder.itemView.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), ViewNotesDetailActivity.class);
                        i.putExtra("titleNotes", notesFireBaseModel.getTitleNotes());
                        i.putExtra("bodyNotes", notesFireBaseModel.getBodyNotes());
                        i.putExtra("ID", noteID);

                        v.getContext().startActivity(i);

                    }
                });






            }

            @NonNull
            @Override
            public MissionNotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_recycler_view,parent,false);

                return new MissionNotesViewHolder(v);

            }
        };

        notesRecyclerView = fragmentView.findViewById(R.id.rvMissionNotes);
        notesRecyclerView.setHasFixedSize(true);
        LayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        notesRecyclerView.setLayoutManager(LayoutManager);
        System.out.println("Setting Adapters");
        notesRecyclerView.setAdapter(MissionNotesAdapter);




        // Inflate the layout for this fragment
        return fragmentView;




    }


    public class MissionNotesViewHolder extends RecyclerView.ViewHolder {

        private TextView titleNote;
        private TextView bodyNote;
        LinearLayout mNote;

        public MissionNotesViewHolder(@NonNull View itemView) {
            super(itemView);

            titleNote = itemView.findViewById(R.id.textView98);
            bodyNote = itemView.findViewById(R.id.textView99);
            //mNote = itemView.findViewById(R.id.ll_Note);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        MissionNotesAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(MissionNotesAdapter != null) {
            MissionNotesAdapter.stopListening();
        }
    }

}