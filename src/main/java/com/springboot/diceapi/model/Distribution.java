package com.springboot.diceapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Distribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int diceSimulationId;
    private int totalOfDiceValues;
    private int frequency;

    public Distribution(int diceSimulationId, int totalOfDiceValues, int frequency) {
        this.diceSimulationId = diceSimulationId;
        this.totalOfDiceValues = totalOfDiceValues;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public int getDiceSimulationId() {
        return diceSimulationId;
    }

    public int getTotalOfDiceValues() {
        return totalOfDiceValues;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiceSimulationId(int diceSimulationId) {
        this.diceSimulationId = diceSimulationId;
    }

    public void setTotalOfDiceValues(int totalOfDiceValues) {
        this.totalOfDiceValues = totalOfDiceValues;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
