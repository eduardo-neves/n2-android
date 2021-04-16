package com.example.n1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText campoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = (EditText)findViewById(R.id.campoNome);

    }

    public void seguinte(View v){

        String nome;
        nome = campoNome.getText().toString();
        Intent i = new Intent(this, nota.class);
        i.putExtra("nome", nome);
        startActivity(i);
    }
}