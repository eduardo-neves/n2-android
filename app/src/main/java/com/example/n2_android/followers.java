package com.example.n2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.n2_android.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class followers extends AppCompatActivity {

    TextView idFollower;
    TextView loginFollower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        idFollower = (TextView)findViewById(R.id.idFollower);
        loginFollower = (TextView)findViewById(R.id.loginFollower);

        String url = "https://api.github.com/users/giselezrossi/followers";

        FollowerGit followergit = new FollowerGit();

        RequestQueue queue = Volley.newRequestQueue(this);
        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response

                            //String test = response.toString();

                            try {
                                JSONArray jsonArray = response.getJSONArray("");

                                for (int i = 0; i < jsonArray.length(); i++){
                                    JSONObject parseData = jsonArray.getJSONObject(i);

                                    followergit.setId(parseData.get("id"));
                                    followergit.setLogin(parseData.get("login"));
                                }


                                idFollower.setText(followergit.getId());
                                loginFollower.setText(followergit.getLogin());


                                //idAPI.setText(response.getString("id"));
                                //nameAPI.setText(response.getString("name"));

                            } catch (JSONException e){
                                e.printStackTrace();
                            }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );

        // add it to the RequestQueue
        queue.add(getRequest);

    }

    public void inicio(View v){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}