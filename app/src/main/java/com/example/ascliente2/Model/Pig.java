package com.example.ascliente2.Model;

public class Pig extends Character {

    public Pig(int posx, int posy) {
        super(posx, posy);
        this.name = "pig";
    }

    public Pig () {

    }

    @Override
    public void agregarBalas() {
        // TODO Auto-generated method stub
        balas.add(new Popo(posx, posy, this.dir));
    }
}
