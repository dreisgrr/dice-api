package com.springboot.diceapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class DiceSimulationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int diceSimulationId;
    private int rollNumber;
    private int diceNumber;
    private int diceValue;

    public DiceSimulationDetails() {

    }

    public DiceSimulationDetails(int diceSimulationId, int rollNumber, int diceNumber, int diceValue) {
        this.diceSimulationId = diceSimulationId;
        this.rollNumber = rollNumber;
        this.diceNumber = diceNumber;
        this.diceValue = diceValue;
    }

    public int getId() {
        return id;
    }

    public int getDiceSimulationId() {
        return diceSimulationId;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiceSimulationId(int diceSimulationId) {
        this.diceSimulationId = diceSimulationId;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }
}
