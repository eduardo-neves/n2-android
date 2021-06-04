package com.example.n2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView idAPI;
    TextView nameAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idAPI = (TextView)findViewById(R.id.idAPI);
        nameAPI = (TextView)findViewById(R.id.nameAPI);

        String url = "https://api.github.com/users/giselezrossi";

        UserGit usergit = new UserGit();

        RequestQueue queue = Volley.newRequestQueue(this);
        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        try {
                            usergit.setId(response.getString("id"));
                            usergit.setName(response.getString("name"));

                            //idAPI.setText(response.getString("id"));
                            //nameAPI.setText(response.getString("name"));

                            idAPI.setText(usergit.getId());
                            nameAPI.setText(usergit.getName());

                        } catch (JSONException e) {
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

    public void seguinte(View v){

        Intent i = new Intent(this, followers.class);
        startActivity(i);
    }
}