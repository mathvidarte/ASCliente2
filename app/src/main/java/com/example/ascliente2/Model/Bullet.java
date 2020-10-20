package com.example.ascliente2.Model;

public class Bullet {

    //atributos
    protected int px, py, velo, dire;
    protected String tipo;

    //constructor
    public Bullet (int px, int py, int dire) {
        this.px = px;
        this.py = py;
        this.dire = dire;
        this.velo = 5;
    }

    public Bullet () {

    }

    //getters y setters
    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getVelo() {
        return velo;
    }

    public void setVelo(int velo) {
        this.velo = velo;
    }

    public int getDire() {
        return dire;
    }

    public void setDire(int dire) {
        this.dire = dire;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
