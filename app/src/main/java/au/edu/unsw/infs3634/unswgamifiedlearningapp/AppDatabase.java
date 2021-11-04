package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Explorer;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.JourneyQuiz;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;

@Database(entities = {Explorer.class, JourneyQuiz.class, Planet.class}, version = 4)

public abstract class AppDatabase extends RoomDatabase  {

    //Call DAOs


    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "SpaceFrontierDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }

        return instance;


    }
}
