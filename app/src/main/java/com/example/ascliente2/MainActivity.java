package com.example.ascliente2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnMessageListener{

    private EditText codigo;
    private Button btnConectar;
    private String myCode;
    private TCPSingleton tcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConectar = findViewById(R.id.btnConectar);
        codigo = findViewById(R.id.codigo);

        tcp = TCPSingleton.getInstance();
        tcp.setObserver(this);

        btnConectar.setOnClickListener(
                (view) -> {

                    myCode = codigo.getText().toString().trim();
                    tcp.getIP(myCode);
                    tcp.start();


                }
        );
    }

    @Override
    public void cuandoLlegueElMensaje(String msg) {

        Log.d("<<<<<<<<<",""+msg);
        if(msg.equals("escoger")){
            Intent i = new Intent(this, Seleccion.class);
            startActivity(i);
        }
    }
}