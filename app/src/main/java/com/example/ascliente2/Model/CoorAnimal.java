package com.example.ascliente2.Model;

public class CoorAnimal {

    String type;
    int posx, posy;

    public CoorAnimal() {}

    public CoorAnimal(int posx, int posy, String type) {
        super();
        this.posx = posx;
        this.posy = posy;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
}
