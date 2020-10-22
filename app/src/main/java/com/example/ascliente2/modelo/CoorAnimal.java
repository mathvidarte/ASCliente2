package com.example.ascliente2.modelo;

public class CoorAnimal {
    String type;
    float posx, posy;

    public CoorAnimal() {}

    public CoorAnimal(float posx, float posy, String type) {
        super();
        this.posx = posx;
        this.posy = posy;
        this.type = type;
    }

    public float getPosx() {
        return posx;
    }

    public void setPosx(float posx) {
        this.posx = posx;
    }

    public float getPosy() {
        return posy;
    }

    public void setPosy(float posy) {
        this.posy = posy;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
