package com.example.n1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    TextView txResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txResultado = (TextView)findViewById(R.id.txResultado);

        Intent i = getIntent();
        float media = i.getFloatExtra("media", 0f);

        String situacao = null;
        if (media >= 6)
            situacao = "Aprovado";
        else
            situacao = "Reprovado";
        String resultado = "Situação: " + situacao +". Média: " + media;

        txResultado.setText(resultado);
    }

    public void inicio(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}