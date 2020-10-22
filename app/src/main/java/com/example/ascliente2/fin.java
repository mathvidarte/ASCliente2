package com.example.ascliente2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class fin extends AppCompatActivity {

    ImageView elefanteLoser, elefanteWinner, pigLoser, pigWinner, chickenWinner, chickenLoser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        //referenciar
        elefanteLoser = findViewById(R.id.elefanteLoser);
        elefanteWinner = findViewById(R.id.elefanteWinner);
        chickenLoser = findViewById(R.id.chickenWinner);
        chickenWinner = findViewById(R.id.chickenWinner);
        pigLoser = findViewById(R.id.pigLoser);
        pigWinner = findViewById(R.id.pigWinner);
    }
}