package au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

import java.util.ArrayList;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.R;

@Entity
public class Planet {

    @PrimaryKey
    @NonNull
    private String planetID;

    @ColumnInfo(name = "planet_name")
    private String planetName;

    @ColumnInfo(name = "planet_background")
    private String planetBackground;

    @ColumnInfo(name = "planet_completion")
    private String planetCompletion;

    @ColumnInfo(name = "planet_sun_orbit")
    private String planetSunOrbit;

    @ColumnInfo(name = "planet_description")
    private String planetDescriptionLong;

    @ColumnInfo(name = "planet_subtitle")
    private String planetSubtitle;

    @ColumnInfo(name = "planet_video")
    private String planetVideo;


    private String planetNotes;
    private String planetDiscoveryYear;

    private Integer planetPicture;

    public Planet(@NonNull String planetID, String planetName, String planetBackground, String planetCompletion, String planetSunOrbit, String planetNotes, String planetDiscoveryYear, Integer planetPicture, String planetDescriptionLong, String planetSubtitle, String planetVideo) {
        this.planetID = planetID;
        this.planetName = planetName;
        this.planetBackground = planetBackground;
        this.planetCompletion = planetCompletion;
        this.planetSunOrbit = planetSunOrbit;
        this.planetDescriptionLong = planetDescriptionLong;
        this.planetSubtitle = planetSubtitle;
        this.planetVideo = planetVideo;
        this.planetNotes = planetNotes;
        this.planetDiscoveryYear = planetDiscoveryYear;
        this.planetPicture = planetPicture;
    }

    public String getPlanetDescriptionLong() {
        return planetDescriptionLong;
    }

    public void setPlanetDescriptionLong(String planetDescriptionLong) {
        this.planetDescriptionLong = planetDescriptionLong;
    }

    public String getPlanetSubtitle() {
        return planetSubtitle;
    }

    public void setPlanetSubtitle(String planetSubtitle) {
        this.planetSubtitle = planetSubtitle;
    }

    public String getPlanetVideo() {
        return planetVideo;
    }

    public void setPlanetVideo(String planetVideo) {
        this.planetVideo = planetVideo;
    }

    @NonNull
    public String getPlanetID() {
        return planetID;
    }

    public void setPlanetID(@NonNull String planetID) {
        this.planetID = planetID;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetBackground() {
        return planetBackground;
    }

    public void setPlanetBackground(String planetBackground) {
        this.planetBackground = planetBackground;
    }

    public String getPlanetCompletion() {
        return planetCompletion;
    }

    public void setPlanetCompletion(String planetCompletion) {
        this.planetCompletion = planetCompletion;
    }

    public String getPlanetNotes() {
        return planetNotes;
    }

    public void setPlanetNotes(String planetNotes) {
        this.planetNotes = planetNotes;
    }

    public String getPlanetDiscoveryYear() {
        return planetDiscoveryYear;
    }

    public void setPlanetDiscoveryYear(String planetDiscoveryYear) {
        this.planetDiscoveryYear = planetDiscoveryYear;
    }

    public String getPlanetSunOrbit() {
        return planetSunOrbit;
    }

    public void setPlanetSunOrbit(String planetSunOrbit) {
        this.planetSunOrbit = planetSunOrbit;
    }

    public Integer getPlanetPicture() {
        return planetPicture;
    }

    public void setPlanetPicture(Integer planetPicture) {
        this.planetPicture = planetPicture;
    }

    public static ArrayList<Planet> importPlanetData() {
        ArrayList<Planet> planets = new ArrayList<>();
        planets.add(new Planet("1","Mercury", "mercury_background", "Incomplete", "JourneyQuiz log for the trip to Mercury", "265 BCE","88 days", R.drawable.mercury,"HI THERE","The Jumping Planet", "0KBjnNuhRHs"));
        planets.add(new Planet("2","Venus", "venus_background", "Incomplete", "JourneyQuiz log for the trip to Venus", "265 BCE","88 days", R.drawable.venus,"HI THERE","Earth's Sister Planet", "BvXa1n9fjow"));
        planets.add(new Planet("3","Earth", "earth_background", "Incomplete", "JourneyQuiz log for the trip to Earth", "265 BCE","88 days", R.drawable.earth,"HI THERE","THe Pale Blue Dot", "HCDVN7DCzYE"));
        planets.add(new Planet("4","Mars", "mars_background", "Incomplete", "JourneyQuiz log for the trip to Mars", "265 BCE","88 days", R.drawable.mars,"HI THERE","The Red Planet", "D8pnmwOXhoY"));
        planets.add(new Planet("5","Jupiter", "jupiter_background", "Incomplete", "JourneyQuiz log for the trip to Jupiter", "265 BCE","88 days", R.drawable.jupiter,"HI THERE","The God Planet", "PtkqwslbLY8"));
        planets.add(new Planet("6","Saturn", "saturn_background", "Incomplete", "JourneyQuiz log for the trip to Saturn", "265 BCE","88 days", R.drawable.saturn,"HI THERE","The Ringed Planet", "epZdZaEQhS0"));
        planets.add(new Planet("7","Uranus", "uranus_background", "Incomplete", "JourneyQuiz log for the trip to Uranus", "265 BCE","88 days", R.drawable.uranus,"HI THERE","The Sky King Star", "m4NXbFOiOGk"));
        planets.add(new Planet("8","Neptune", "neptune_background", "Incomplete", "JourneyQuiz log for the trip to Neptune", "265 BCE","88 days", R.drawable.neptune,"HI THERE","The Sea King Star", "0KBjnNuhRHs"));

        return planets;

    }

}
