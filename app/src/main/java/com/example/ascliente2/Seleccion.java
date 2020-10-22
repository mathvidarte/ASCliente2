package com.example.ascliente2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ascliente2.modelo.NameAnimal;
import com.google.gson.Gson;

public class Seleccion extends AppCompatActivity implements OnMessageListener, View.OnClickListener{

    Button btnChicken, btnElephant, btnPig;
    private TCPSingleton tcp;

    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion3);

        btnPig = findViewById(R.id.btnPig);
        btnElephant = findViewById(R.id.btnElephant);
        btnChicken = findViewById(R.id.btnChicken);

        btnPig.setOnClickListener(this);
        btnElephant.setOnClickListener(this);
        btnChicken.setOnClickListener(this);


        tcp = TCPSingleton.getInstance();
        tcp.setObserver(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnPig:
                tipo = "pig";
                break;
            case R.id.btnElephant:
                tipo = "elephant";
                break;
            case R.id.btnChicken:
                tipo = "chicken";
                break;
        }
        NameAnimal name = new NameAnimal(tipo);
        Gson gson = new Gson();
        String json = gson.toJson(name);
        tcp.sendMessage(json);
    }

    @Override
    public void cuandoLlegueElMensaje(String msg) {
        Log.d("llegaaaaa",""+msg);
        if(msg.contains("play")){
            Intent i = new Intent(this, Game.class);
            startActivity(i);
        }
    }
}