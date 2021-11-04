package au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters;

import static android.content.ContentValues.TAG;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.AppDatabase;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.R;

public class PlanetAdapter extends RecyclerView.Adapter {


    private Planet mPlanet;
    private RecyclerViewClickListener mListener;
    private int[] planetImages;
    AppDatabase db;
    String planetName;


    private ArrayList<Planet> mSetPlanet;

    public PlanetAdapter(ArrayList<Planet> planets, RecyclerViewClickListener listener) {
        mSetPlanet = planets;
        mListener = listener;



    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //INSERT ADAPTER STUFF

        public View view;
        private RecyclerViewClickListener mListener;


        public PlanetViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            // TAG LOG
            // FINDVIEWBYID;
        }

        @Override
        public void onClick(View v) { mListener.onClick(v, getAdapterPosition()); }
    }

    public void setPlanetData(ArrayList<Planet> planetChosen) {
        this.mSetPlanet = planetChosen;
    }

    @NonNull
    //@Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_recycler_view,parent,false);

        return new PlanetViewHolder(v,mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet journeyPosition =mSetPlanet.get(position);
        //SET TEXT POSITION
        //SET IMAGE RESOURCE THROUGH ARRAY
    }


    public int getItemCount() {

        return mSetPlanet.size();
    }





}
