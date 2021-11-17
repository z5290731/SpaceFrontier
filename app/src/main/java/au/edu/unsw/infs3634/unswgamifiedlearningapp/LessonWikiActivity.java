package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.Locale;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.DBEntities.Planet;

public class LessonWikiActivity extends AppCompatActivity {


    //public Planet planetName;
    private TextView wikiText, txPlanet, txSubtitle;
    private ImageView ivPlanet;
    private View view;
    public Planet wPlanet;
    public static final String TAG  = "TEST";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_wiki);

        String planetName = getIntent().getStringExtra("planet");
        String planetSubtitle = getIntent().getStringExtra("planet_subtitle");
        int planetPicture = getIntent().getIntExtra("planet_picture",0);

        System.out.println(planetName +"HELLO THERE");

        TextView txPlanet = findViewById(R.id.txPlanet);
        ImageView ivPlanet = findViewById(R.id.ivPlanet);
        TextView txSubtitle = findViewById(R.id.txSubtitle);


        txPlanet.setText(planetName);
        txSubtitle.setText(planetSubtitle);
        ivPlanet.setImageResource(planetPicture);



        //String stringPlanetName = String.valueOf(planetName);

        new ImportWikiContent().execute();



    }

    private class ImportWikiContent extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            String planetName = getIntent().getStringExtra("planet");

            String lowerCasePlanet = planetName.toLowerCase();




            System.out.println(planetName + "Acquiring From WikiPedia");

            //final String wikiAPI = "https://en.wikipedia.org/w/api.php?action=query&prop=extracts&ppprop=disambiguation&exsentences=10&exlimit=1&explaintext&titles=" + planetName + "&format=json";

            final String wikiAPI;

            System.out.println(lowerCasePlanet + "hello");

            if(lowerCasePlanet.equals("mercury")) {
                wikiAPI = "https://en.wikipedia.org/w/api.php?action=query&prop=extracts&exsentences=10&exlimit=1&explaintext&titles=" + planetName + " (planet)" + "&format=json";
                System.out.println(wikiAPI);
            } else {
                wikiAPI = "https://en.wikipedia.org/w/api.php?action=query&prop=extracts&exsentences=10&exlimit=1&explaintext&titles=" + planetName + "&format=json";
                System.out.println("Planet is not mercury");
            }

            Context applicationContext = getApplicationContext();
            final RequestQueue queue = Volley.newRequestQueue(applicationContext);
            Response.Listener<String> rListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    TextView wikiText = findViewById(R.id.wikiText);
                    wikiText.setMovementMethod(new ScrollingMovementMethod());
                    try {
                        JSONObject obj = new JSONObject(response);
                        JSONObject extract = obj.getJSONObject("query");
                        String article = extract.getString("pages");
                        String articleParse = article.replace("\"","");
                        String articleParse1 = articleParse.replace("\n","");
                        String articleParse2 = articleParse1.replace("}}","");
                        System.out.println(planetName + "This is the planet being viewed right now");
                        String articleClean = planetName + " " + articleParse2.substring(article.indexOf("ract"));
                        wikiText.setText(articleClean);

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
                    Log.d(TAG, "Volley Error");
                }
            };

            StringRequest finalString = new StringRequest(Request.Method.GET, wikiAPI,rListener,eListener);
            queue.add(finalString);
            //UpdateUi();
            return null;
        }
    }

    private void UpdateUi() {
        wikiText = findViewById(R.id.wikiText);
    }


}