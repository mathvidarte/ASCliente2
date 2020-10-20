package com.example.ascliente2.Model;

public class Elephant extends Character {
    public Elephant (int posx, int posy) {
        super(posx, posy);
        this.name = "elephant";
    }

    public Elephant () {

    }

    @Override
    public void agregarBalas() {
        balas.add(new Water(posx, posy, this.dir));
    }
}
