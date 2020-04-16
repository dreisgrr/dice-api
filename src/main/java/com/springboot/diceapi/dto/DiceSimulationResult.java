package com.springboot.diceapi.dto;

public class DiceSimulationResult {

    private Long totalRolls;
    private Long simulations;
    private int sidesOfDie;
    private int numberOfDice;

    public DiceSimulationResult() {

    }

    public DiceSimulationResult(Long totalRolls, Long simulations) {
        this.totalRolls = totalRolls;
        this.simulations = simulations;
    }

    public DiceSimulationResult(Long totalRolls, Long simulations, int sidesOfDie, int numberOfDice) {
        this.totalRolls = totalRolls;
        this.simulations = simulations;
        this.numberOfDice = numberOfDice;
        this.sidesOfDie = sidesOfDie;
    }

    public Long getTotalRolls() {
        return totalRolls;
    }

    public Long getSimulations() {
        return simulations;
    }

    public int getSidesOfDie() {
        return sidesOfDie;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setTotalRolls(Long totalRolls) {
        this.totalRolls = totalRolls;
    }

    public void setSimulations(Long simulations) {
        this.simulations = simulations;
    }

    public void setSidesOfDie(int sidesOfDie) {
        this.sidesOfDie = sidesOfDie;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }
}
