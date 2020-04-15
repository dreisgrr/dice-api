package com.springboot.diceapi.viewmodel;

import javax.validation.constraints.Min;

public class DiceSimulationViewModel {
    private int id;
    @Min(value = 4L)
    private int sidesOfDie;
    @Min(value = 4L)
    private int numberOfDice;
    private int numberOfRolls;

    public int getId() {
        return id;
    }

    public int getSidesOfDie() {
        return sidesOfDie;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
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

    public void setNumberOfRolls(int numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
    }
}
