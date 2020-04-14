package com.springboot.diceapi.model;

import com.springboot.diceapi.DiceAPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class DiceConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sidesOfDie;
    private int numberOfDice;

    public  DiceConfiguration(int sidesOfDie, int numberOfDice) {
        this.sidesOfDie = sidesOfDie;
        this.numberOfDice = numberOfDice;
    }

    public int getId() {
        return id;
    }

    public int getSidesOfDie() {
        return sidesOfDie;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSidesOfDie(int sidesOfDie) {
        this.sidesOfDie = sidesOfDie;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }
}
