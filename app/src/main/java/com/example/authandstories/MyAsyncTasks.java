package com.example.authandstories;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MyAsyncTasks extends AsyncTask<String, String, String> {
    String myUrl = "https://api.nytimes.com/svc/topstories/v2/world.json?api-key=GW5a0tJfWOcfQ7k3dpQizIsrmpZ33Bmm";

    @Override
    protected String doInBackground (String... params) {
        // Fetch data from the API in the background.
        String result = "";
        try {
            URL url;
            HttpsURLConnection urlConnection = null;
            try {
                url = new URL(myUrl);
                //open a URL connection
                urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader isw = new InputStreamReader(in);
                int data = isw.read();
                while (data != -1) {
                    result += (char) data;
                    data = isw.read();
                }
                // return the data to onPostExecute method
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        }
        return result;
    }

        @Override
        protected void onPreExecute () {
            super.onPreExecute();
            // display a progress dialog to show the user what is happening
        }

        @Override
        protected void onPostExecute (String s){
            // show results
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray1 = jsonObject.getJSONArray("users");
                JSONObject jsonObject1 =jsonArray1.getJSONObject(0);
                String id = jsonObject1.getString("title");
                String name = jsonObject1.getString("abstract");
                String my_users = "User ID: " + id + "\n" + "Name: "+name;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
}
