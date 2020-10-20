package com.example.ascliente2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPSingleton extends Thread{

    //unica instancia de TcpSingleton
    private static TCPSingleton unicaInstancia;

    //constructor privado
    private TCPSingleton(){}


    //metodo estático que devuelve la unica instancia
    public static TCPSingleton getInstance(){
        if(unicaInstancia == null){
            unicaInstancia = new TCPSingleton();
            //unicaInstancia.start();
        }
        return unicaInstancia;
    }

    private String codigo;
    private OnMessageListener observer;


    //variables globales tcp
    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;

    //Suscripcion
    public void setObserver (OnMessageListener observer) {
        this.observer = observer;
    }


    public void run() {
        try {
            //conexion
            socket = new Socket (codigo, 6000);
            Log.d("cliente conectado", "yei");

            //emisor
            OutputStream os = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os));

            //receptor
            InputStream is = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));

            while(true){
                //recibe constantemente
                String line = reader.readLine();
                observer.cuandoLlegueElMensaje(line);
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void sendMessage (String msg) {
        new Thread (
                ()-> {
                    try {
                        writer.write(msg+"\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    public void getIP (String myIp) {
        codigo = myIp;
        Log.d(">>>>>>>>>", ""+codigo);
    }
}
