package com.koreanair.samplemobilequiz;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Quiz5ApiCallActivity extends AppCompatActivity {

    TextView _location;
    TextView _condition;
    TextView _temperature;

    String _locationValue;
    String _conditionValue;
    String _temparatureValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5_api_call);

        _location = (TextView) findViewById(R.id.location_textview);
        _condition = (TextView) findViewById(R.id.condition_textview);
        _temperature = (TextView) findViewById(R.id.temperature_textview);

        new AsyncTaskImpl().execute();
    }

    private class AsyncTaskImpl extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
            String query = "select * from weather.forecast where woeid=1132599 and u='c'";


            try {
                String endpoint = baseUrl + URLEncoder.encode(query, "UTF-8") + "&format=json";
                Log.d("baseURl", endpoint);
                JSONObject json_data = getJSONfromURL(endpoint);
                Log.d("json_object", json_data+"");

                parseJson(json_data);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        private void parseJson(JSONObject jObject) {

            if (jObject == null)
                return;

            try {
                JSONObject query = jObject.getJSONObject("query");
                JSONObject results = query.getJSONObject("results");
                JSONObject channel = results.getJSONObject("channel");
                JSONObject location = channel.getJSONObject("location");

                _locationValue = location.getString("city") + ", " + location.getString("country");

                JSONObject item = channel.getJSONObject("item");
                JSONObject condition = item.getJSONObject("condition");

                _conditionValue = condition.getString("text");
                _temparatureValue = condition.getString("temp");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void onPostExecute(Void args) {
            _location.setText(_locationValue);
            _condition.setText(_conditionValue);
            _temperature.setText(_temparatureValue);
        }

        private JSONObject getJSONfromURL(String endpoint){

            try{
                URL url = new URL(endpoint);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                if(conn.getResponseCode()==conn.HTTP_OK){
                    InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream(),"UTF-8");
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    StringBuffer buffer = new StringBuffer();
                    String line;
                    while ((line=reader.readLine())!=null){
                        buffer.append(line);
                    }
                    reader.close();
                    JSONObject jsonObject = new JSONObject(buffer.toString());
                    return jsonObject;
                }
            }catch (Exception e){

            }

            return null;
        }
    }
}
