package com.example.ascliente2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ascliente2.modelo.CoorAnimal;
import com.google.gson.Gson;

public class Game extends AppCompatActivity implements View.OnTouchListener, OnMessageListener, View.OnClickListener {

    private Button jump, left, right, shot;
    private TCPSingleton tcp;
    private ImageView soyGallo, soyElefante, soyPig;

    //variables del salto
    private float posX = 960;
    private float posY = 0;
    private int niveles = 0;
    private float salto = 0, bajo = 0;
    private Boolean tope = false, pigsito = false;

    private Boolean elJump = false, elRight = false, elLeft = false, elShot = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        jump = findViewById(R.id.jump);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        shot = findViewById(R.id.shot);
        soyGallo = findViewById(R.id.soyGallo);
        soyElefante = findViewById(R.id.soyElefante);
        soyPig = findViewById(R.id.soyPig);

        tcp = TCPSingleton.getInstance();
        tcp.setObserver(this);

        left.setOnTouchListener(this);
        right.setOnTouchListener(this);

        shot.setOnClickListener(this);
        jump.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.jump:
                Log.e("UPPPP", "PRESIONADO");
                elJump = true;
                Gson gsonU = new Gson();
                Gson gsonD = new Gson();
                new Thread(
                        ()->{
                            while(elJump == true){
                                if(salto >= 0 && tope == false){
                                    salto += 0.5;
                                    bajo = 0;
                                    if(salto == 11){
                                        tope = true;
                                    }
                                    CoorAnimal jumps = new CoorAnimal(posX, salto, "ap");
                                    String jsonU = gsonU.toJson(jumps);
                                    tcp.sendMessage(jsonU);
                                }
                                if(tope == true){
                                    bajo += 0.5;
                                    salto -= 0.5;

                                    if(salto == 0){
                                        tope = false;
                                        elJump = false;
                                    }
                                    CoorAnimal jumps = new CoorAnimal(posX, bajo, "dawn");
                                    String jsonD = gsonD.toJson(jumps);
                                    tcp.sendMessage(jsonD);
                                }
                                try {
                                    Thread.sleep(30);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();
                break;


            case R.id.shot:
                Gson gsonS = new Gson();
                CoorAnimal shootss = new CoorAnimal(posX,posY,"paw");
                String jsonS = gsonS.toJson(shootss);
                tcp.sendMessage(jsonS);
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                switch (view.getId()) {

                    ///////////SI UNDE IZQUIERDA//////////////
                    case R.id.left:
                        Log.e("LEFT", "PRESIONADO");
                        elLeft = true;
                        Gson gsonL = new Gson();
                        new Thread(
                                () -> {
                                    while (elLeft==true) {
                                        if (posX >= 0) {
                                            posX -= 3;

                                            CoorAnimal jumps = new CoorAnimal(posX, posY, "left");
                                            String jsonL = gsonL.toJson(jumps);
                                            tcp.sendMessage(jsonL);

                                        }
                                        try {
                                            Thread.sleep(20);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }
                        ).start();
                        break;

                    //////////SI UNDE DERECHA///////////
                    case R.id.right:
                        Log.e("RIGHT", "PRESIONADO");
                        elRight = true;
                        Gson gsonR = new Gson();

                        new Thread(
                                () -> {

                                    while (elRight == true) {
                                        if (posX <= 1030) {
                                            posX += 3;

                                            CoorAnimal jumps = new CoorAnimal(posX, posY, "right");
                                            String jsonR = gsonR.toJson(jumps);
                                            tcp.sendMessage(jsonR);
                                        }
                                        try {
                                            Thread.sleep(20);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                }
                        ).start();
                        break;

                }
                break;

            case MotionEvent.ACTION_UP:
                switch (view.getId()){

                    ////////si el boton soltado es el boton de izquierda////////
                    case R.id.left:
                        elLeft = false;
                        Log.e("UP", "SOLTADO");
                        break;

                    ////////si el boton soltado es el boton de la derecha////////
                    case R.id.right:
                        elRight = false;
                        Log.e("UP", "SOLTADO");
                        break;
                }
                break;
        }
        return true;
    }



    @Override
    public void cuandoLlegueElMensaje(String msg) {
        Log.d("mensajeeee",""+msg);
        if(msg.contains("end")){
            Intent i = new Intent(this, fin.class);
            startActivity(i);
        }
        if(msg.contains("chosenPig")){
            soyPig.setVisibility(View.VISIBLE);
        }
        if(msg.contains("chosenChic")){
            soyGallo.setVisibility(View.VISIBLE);
        }
        if(msg.contains("chosenElef")){
            soyElefante.setVisibility(View.VISIBLE);
        }

    }
}