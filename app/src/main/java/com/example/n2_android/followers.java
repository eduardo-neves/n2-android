package com.example.n2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.n2_android.R;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class followers extends AppCompatActivity {

    EditText txFollower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        txFollower = (EditText)findViewById(R.id.txFollower);

        String result = "";

        try {

            URL url = new URL("https://api.github.com/users/giselezrossi/followers");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                scanner.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void inicio(View v){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}