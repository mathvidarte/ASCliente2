package com.example.ascliente2.Model;

public class Chicken extends Character {

    public Chicken(int posx, int posy) {
        super(posx, posy);
        this.name = "chicken";
    }

    public Chicken () {

    }

    @Override
    public void agregarBalas() {
        // TODO Auto-generated method stub
        balas.add(new Eggs(posx, posy, this.dir));


    }
}
