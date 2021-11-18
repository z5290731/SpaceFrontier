package au.edu.unsw.infs3634.unswgamifiedlearningapp.uxui.spaceShip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

import au.edu.unsw.infs3634.unswgamifiedlearningapp.LessonWikiActivity;
import au.edu.unsw.infs3634.unswgamifiedlearningapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link spaceStationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class spaceStationFragment extends Fragment {

    private TextView APODDescription, textViewURL;
    private ImageView imageView3;
    public Context context;
    public String imageURL, UrlPhoto;
    public static final String TAG  = "TEST";
    public Bitmap bmp;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public spaceStationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment spaceShipFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static spaceStationFragment newInstance(String param1, String param2) {
        spaceStationFragment fragment = new spaceStationFragment();
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


    /**
     * Due to the nature of Asynch Tasks, a careful approach was required to call upon Variables that were set or initialised within the Asynch Task.
     * The difficulty was compounded with the usage of a Fragment which required certain tweaks to the usual references to Activity.
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_space_ship, container, false);

        /**
         * This code allowed the Threads and initialisation of variables to be passed
         */

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }

        /**
         * A method called upon to executed the API
         */

        new spaceStationFragment.ImportAPODContent(context).execute();







        // Inflate the layout for this fragment

        return rootView;



    }

    /**
     * AsyncTasks were chosen for API execution in this assessment, owing to its light footprint on resources
     * and ability to easily update when required. However, certain care was required in ensuring you could select
     * help.
     */



    private class ImportAPODContent extends AsyncTask<String, String, String> {

        private Context mContext;
        private View rootView;

        public ImportAPODContent(Context context) {
            this.mContext = context;

        }

        /**
         * Do In Background is an Async Method which allows for tasks to be completed in the background.
         */

        @Override
        protected String doInBackground(String... strings) {

            /**
             * NASA APOD API Key Declared
             */

            final String APODAPI = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

            Context applicationContext = getActivity().getApplicationContext();

            final RequestQueue queue = Volley.newRequestQueue(applicationContext);



            APODDescription = (TextView) getActivity().findViewById(R.id.textView6);

            textViewURL = (TextView) getActivity().findViewById(R.id.textView12);

            /**
             * On response to finalString queue.add, execute these actions below. Try Catch was used
             * to help in debugging. This was vitally important especially during the setting of ImageViews
             */

            Response.Listener<String> rListener = new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {



                    try {

                        /**
                         * In built JSONObject and Parser utilised to parse the details from the GET API Response
                         */

                        JSONObject obj = new JSONObject(response);
                        //JSONObject extract = obj.getJSONObject("explanation");;
                        String article = obj.getString("explanation");
                        String title =obj.getString("title");
                        System.out.println(article);
                        //System.out.println(extract + "TESTING");
                        APODDescription.setText(article);
                        textViewURL.setText(title);

                        imageURL = obj.getString("hdurl");

                        /**
                         * This Try Catch clause included the ability to set imageViews based on the website links
                         * undestanding whether links are passed through properly.
                         */


                        try {
                                InputStream in = new URL(imageURL).openStream();
                                bmp = BitmapFactory.decodeStream(in);
                                imageView3 = (ImageView) getActivity().findViewById(R.id.imageView3);
                                imageView3.setImageBitmap(bmp);


                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        System.out.println(imageURL + "INSIDE ASYNC");



                        queue.stop();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            };

            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG,"OH NOT ITS HAPPENING");

                }
            };

            StringRequest finalString = new StringRequest(Request.Method.GET,APODAPI,rListener,errorListener);
            queue.add(finalString);








            return null;
        }






    }


}