package bryan_caleb.weatherapp;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by csuser on 3/13/2018.
 */

public class Utility {
    private final static String WEATHER_URL = "https://courses.cs.westga.edu/mod/url/view.php?id=70084";

    private final static String KEY = "";

    private static final String TAG = "Utility";

    private final static String PARAM_KEY = "api_key";

    private static URL buildURLWeather() {
        Uri built = Uri.parse(WEATHER_URL).buildUpon().appendQueryParameter(PARAM_KEY, KEY).build();
        URL url = null;
        try{
            url = new URL(built.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.i(TAG,"buildURLWeather: url: " + url );
        return  url;
    }
}
