package com.springboot.diceapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class DiceSimulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int diceConfigId;
    private int numberOfRolls;

    public DiceSimulation(int diceConfigId, int numberOfRolls) {
        this.diceConfigId = diceConfigId;
        this.numberOfRolls = numberOfRolls;
    }

    public int getId() {
        return id;
    }

    public int getDiceConfigId() {
        return diceConfigId;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiceConfigId(int diceConfigId) {
        this.diceConfigId = diceConfigId;
    }

    public void setNumberOfRolls(int numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
    }
}
