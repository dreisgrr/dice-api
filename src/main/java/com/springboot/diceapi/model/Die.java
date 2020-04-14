package com.springboot.diceapi.model;

import java.util.Random;

public class Die {
    private int id;
    private int sidesOfDie;
    private int diceValue;

    public Die(int id, int sidesOfDie) {
        this.id = id;
        this.sidesOfDie = sidesOfDie;
        this.diceValue = new Random().nextInt(sidesOfDie);
    }

    public int getId() {
        return id;
    }

    public int getSidesOfDie() {
        return sidesOfDie;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSidesOfDie(int sidesOfDie) {
        this.sidesOfDie = sidesOfDie;
    }

    public void setDiceValue(int rollValue) {
        this.diceValue = rollValue;
    }
}