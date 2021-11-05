package au.edu.unsw.infs3634.unswgamifiedlearningapp.RecyclerAdapters;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.AppDatabase;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.LessonWelcomeActivity;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.R;

import static android.content.ContentValues.TAG;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {


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
        public ImageView planetKawaii;
        public TextView planetName;
        public View view;
        private RecyclerViewClickListener mListener;


        public PlanetViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
            Log.d(TAG, "On Click Working!");
            planetName = itemView.findViewById(R.id.planetName);
            planetKawaii = itemView.findViewById(R.id.planetKawaii);
            String sPlanetName = planetName.toString();
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
    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_recycler_view,parent,false);

        return new PlanetViewHolder(v,mListener);

    }


    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        final Planet planetAtPosition = mSetPlanet.get(position);


        holder.planetName.setText(String.valueOf(planetAtPosition.getPlanetName()));
        holder.planetKawaii.setImageResource(planetAtPosition.getPlanetPicture());
        String sPlanetName = String.valueOf(planetAtPosition.getPlanetName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent wikiIntent = new Intent(v.getContext(), LessonWelcomeActivity.class);
                wikiIntent.putExtra("planet_name_first_pass",sPlanetName);
                System.out.println(sPlanetName + "Hello");
                v.getContext().startActivity(wikiIntent);


            }
        });

    }



    public int getItemCount() {

        return mSetPlanet.size();
    }





}
