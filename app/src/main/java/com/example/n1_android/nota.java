package com.example.n1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class nota extends AppCompatActivity {

    EditText nota1;
    EditText nota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        nota1 = (EditText)findViewById(R.id.nota1);
        nota2 = (EditText)findViewById(R.id.nota2);
    }

    public void calcular(View v){

        float nota_1 = Float.parseFloat(nota1.getText().toString());
        float nota_2 = Float.parseFloat(nota2.getText().toString());

        float media = (nota_1 + nota_2) / 2;

        Intent i = new Intent(this, resultado.class);
        i.putExtra("media", media);
        startActivity(i);
    }
}