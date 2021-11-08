package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;

public class LessonPlanetDataActivity extends AppCompatActivity {


    //public Planet planetName;
    private TextView solaireText;
    private View view;
    public Planet wPlanet;
    public static final String TAG  = "TEST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_planet_data);

        String planetName = getIntent().getStringExtra("planet");
        System.out.println(planetName +"HELLO THERE");

        //String stringPlanetName = String.valueOf(planetName);

        new ImportSolarSystemAPI().execute();

    }

    private class ImportSolarSystemAPI extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            String planetName = getIntent().getStringExtra("planet");



            System.out.println(planetName + "Acquiring From WikiPedia");

            final String solaireAPI = "https://api.le-systeme-solaire.net/rest/bodies/" + planetName;


            Context applicationContext = getApplicationContext();
            final RequestQueue queue = Volley.newRequestQueue(applicationContext);
            Response.Listener<String> rListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    TextView solaireText = findViewById(R.id.solaireText);
                    try {
                        //ArrayList<HashMap<String,String>> planetData = new ArrayList<>();

                        ArrayList<JSONObject> dataArray = new ArrayList<JSONObject>();

                        JSONObject obj = new JSONObject(response);
                        //List<String> 1 = new ArrayList<String>(obj.keySet());
                        String englishName = obj.getString("englishName");
                        String moon = obj.getString("moon");
                        //JSONArray array = obj.getJSONArray()
                        //JSONObject extract = obj.getJSONObject(" ");
                        //JSONObject extract1 = obj.getString("isPlanet");
                        //String article = extract.getString("englishName");
                        //String articleParse = article.replace("\"","");
                        //String articleParse1 = articleParse.replace("\n","");
                        //String articleParse2 = articleParse1.replace("}]","");
                        //String articleClean = planetName + " " + articleParse2.substring(article.indexOf("ract"));
                        solaireText.setText(moon);
                        System.out.println(englishName);
                        queue.stop();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }



                }
            };

            Response.ErrorListener eListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Log.d(TAG, "onErrorResponse Volley Error:");
                    System.out.println("Shit");
                }
            };

            StringRequest finalString = new StringRequest(Request.Method.GET, solaireAPI,rListener,eListener);
            queue.add(finalString);
            setSolaireText();
            return null;
        }
    }



    private void setSolaireText() {

        new Handler(Looper.getMainLooper()).post(new Runnable(){
            @Override
            public void run() {
                solaireText = findViewById(R.id.solaireText);
                solaireText.setMovementMethod(new ScrollingMovementMethod());
            }
        });



    }
}