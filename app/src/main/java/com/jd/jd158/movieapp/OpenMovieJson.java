package com.jd.jd158.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * Created by jd158 on 29/03/2017.
 */
public class OpenMovieJson {
    private static final String URL_IMAGE = "http://image.tmdb.org/t/p/";

    private static final String IMAGE_SIZE = "w780";

    /**
     * This method parses JSON from a web response and returns an array of Strings
     * describing the movie .
     */

    public static String[] getMovieStringsFromJson(Context context, String movieJsonStr)
            throws JSONException {

         
         /* Weather information. Each day's forecast info is an element of the "list" array */
        final String OWM_PAGE = "results";
        final String ORIGINAL_TITLE = "original_title";

        // Poster Image of the movie
        final String POSTER_IMAGE = "poster_path";

        final String OVERVIEW = "overview";

        final String VOTE_AVG = "vote_average";

        final String RELEASE_DATE = "release_date";

        final String IMAGE_PATH = "poster_path";

        final String OWM_MESSAGE_CODE = "cod";

        final String MOVIE_ID = "id";



    /* String array to hold each day's weather String */
        String[] parsedMovieData = null;

        JSONObject movieJson = new JSONObject(movieJsonStr);

        /* Is there an error? */
        if (movieJson.has(OWM_MESSAGE_CODE)) {
            int errorCode = movieJson.getInt(OWM_MESSAGE_CODE);

            switch (errorCode) {
                case HttpURLConnection.HTTP_OK:
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    /* Location invalid */
                    return null;
                default:
                    /* Server probably down */
                    return null;
            }
        }

        JSONArray movieArray = movieJson.getJSONArray(OWM_PAGE);

        parsedMovieData = new String[movieArray.length()];

        // long localDate = System.currentTimeMillis();
        // long utcDate = SunshineDateUtils.getUTCDateFromLocal(localDate);
        // long startDay = SunshineDateUtils.normalizeDate(utcDate);

        for (int i = 0; i < movieArray.length(); i++) {
            String date;
            String highAndLow;

            /* These are the values that will be collected */
            String originalTitle;
            String synopsis;
            String voteAvg;
            String releaseDate;
            String imagePath;
            String movieId;

            /* Get the JSON object representing the day */
            JSONObject movieDetails = movieArray.getJSONObject(i);
            StringBuilder jsonResultString = new StringBuilder();


            originalTitle = movieDetails.getString(ORIGINAL_TITLE) + ",";
            synopsis = movieDetails.getString(OVERVIEW);
            voteAvg = movieDetails.getString(VOTE_AVG);
            releaseDate = movieDetails.getString(RELEASE_DATE);
            imagePath = movieDetails.getString(IMAGE_PATH);
            Uri urlImage = buildImageUrl(imagePath);
            movieId = movieDetails.getString(MOVIE_ID);

            //Movie movie = new Movie();

            jsonResultString.append(originalTitle);
            jsonResultString.append("\\n");
            jsonResultString.append(synopsis);
            jsonResultString.append("\\n");
            jsonResultString.append(voteAvg);
            jsonResultString.append("\\n");
            jsonResultString.append(releaseDate);
            jsonResultString.append("\\n");
            jsonResultString.append(imagePath);
            jsonResultString.append("\\n");
            jsonResultString.append(movieId);
            jsonResultString.append("\\n");
            jsonResultString.append(urlImage);
            jsonResultString.append("\\n");
            jsonResultString.append(urlImage);


            //parsedMovieData[i] = urlImage.toString();
            parsedMovieData[i] = urlImage.toString();

        }

        return parsedMovieData;
    }


    /**
     * Parse the JSON and convert it into ContentValues that can be inserted into our database.
     *
     * @param context      An application context, such as a service or activity context.
     * @param movieJsonStr The JSON to parse into ContentValues.
     * @return An array of ContentValues parsed from the JSON.
     */
    public static ContentValues[] getFullWeatherDataFromJson(Context context, String movieJsonStr) {
        /** This will be implemented in a future lesson **/
        return null;
    }

    private static Uri buildImageUrl(String imagePath) {
        imagePath = imagePath.replace("/", "");
        Uri builtUri = Uri.parse(URL_IMAGE).buildUpon()
                .appendPath(IMAGE_SIZE)
                .appendPath(imagePath)
                .build();
        return builtUri;

    }
}
