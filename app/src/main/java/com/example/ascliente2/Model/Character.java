package com.example.ascliente2.Model;

import java.util.ArrayList;

public abstract class Character {

    //atributos
    protected int posx, posy, vel, dir, vida;
    protected String name;
    protected ArrayList<Bullet> balas;

    //constructor
    public Character(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        this.vel = 2;
        this.dir = 1;
        this.vida = 100;

        balas = new ArrayList <Bullet>();
    }

    public Character () {

    }

    public abstract void agregarBalas();

    //getters y setters
    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
