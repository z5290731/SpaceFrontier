package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

            final String solaireAPI = "https://api.le-systeme-solaire.net/rest/bodies/jupiter" + planetName;


            Context applicationContext = getApplicationContext();
            final RequestQueue queue = Volley.newRequestQueue(applicationContext);
            Response.Listener<String> rListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    TextView solaireText = findViewById(R.id.solaireText);
                    try {
                        JSONObject obj = new JSONObject(response);
                        JSONObject extract = obj.getJSONObject("query");
                        String article = extract.getString("pages");
                        String articleParse = article.replace("\"","");
                        String articleParse1 = articleParse.replace("\n","");
                        String articleParse2 = articleParse1.replace("}]","");
                        String articleClean = planetName + " " + articleParse2.substring(article.indexOf("ract"));
                        solaireText.setText(articleClean);
                        System.out.println(articleClean);
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
        solaireText = findViewById(R.id.solaireText);
        solaireText.setMovementMethod(new ScrollingMovementMethod());
    }
}