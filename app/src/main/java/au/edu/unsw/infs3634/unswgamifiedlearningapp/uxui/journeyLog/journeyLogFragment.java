package au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.journeyLog;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.LessonWelcomeActivity;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.R;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters.PlanetAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link journeyLogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class journeyLogFragment extends Fragment {

    public static final Integer EXTRA_MESSAGE = 0;
    private RecyclerView RecyclerViewList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Planet> mEraArrayList;
    private List<Planet> mEraList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public journeyLogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment journeyLogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static journeyLogFragment newInstance() {
        journeyLogFragment fragment = new journeyLogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_journey_log, container, false);

        RecyclerViewList = view.findViewById(R.id.journeyRecycler);

        LinearLayoutManager planetLayoutManager = new LinearLayoutManager(view.getContext());

        RecyclerViewList.setLayoutManager(planetLayoutManager);

        PlanetAdapter.RecyclerViewClickListener jListener = new PlanetAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchLessonWelcomeActivity(position);
            }
        };

        PlanetAdapter jPlanetAdapter = new PlanetAdapter(Planet.importPlanetData(), jListener);
        jPlanetAdapter.setPlanetData(Planet.importPlanetData());
        RecyclerViewList.setAdapter(jPlanetAdapter);

        RecyclerViewList = view.findViewById(R.id.journeyRecycler);

        return view;



    }

    private void launchLessonWelcomeActivity(int position) {
        Intent intent = new Intent(getActivity(), LessonWelcomeActivity.class);
        String message = String.valueOf(EXTRA_MESSAGE);

        intent.putExtra(message, position);
        startActivity(intent);
    }
}