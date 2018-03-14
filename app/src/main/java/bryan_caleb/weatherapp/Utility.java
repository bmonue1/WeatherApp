package bryan_caleb.weatherapp;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

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

    public static String getResponse(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            InputStream input = connection.getInputStream();
            Scanner scanner = new Scanner(input);
            scanner.useDelimiter("\\A");

            boolean validInput = scanner.hasNext();
            if(validInput) {
                return  scanner.next();
            } else {
                return null;
            }
        }finally {
            connection.disconnect();
        }
    }
}
