package com.springboot.diceapi.dto;

public class TotalCombinedDistributionResult {
    private Long simulations;
    private int totalOfDiceValues;
    private Long frequency;
    private Long totalNumberOfRolls;

    public TotalCombinedDistributionResult(Long simulations, int totalOfDiceValues, Long frequency, Long totalNumberOfRolls) {
        this.simulations = simulations;
        this.totalOfDiceValues = totalOfDiceValues;
        this.frequency = frequency;
        this.totalNumberOfRolls = totalNumberOfRolls;
    }

    public Long getSimulations() {
        return simulations;
    }

    public int getTotalOfDiceValues() {
        return totalOfDiceValues;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setSimulations(Long simulations) {
        this.simulations = simulations;
    }

    public void setTotalOfDiceValues(int totalOfDiceValues) {
        this.totalOfDiceValues = totalOfDiceValues;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Long getTotalNumberOfRolls() {
        return totalNumberOfRolls;
    }

    public void setTotalNumberOfRolls(Long totalNumberOfRolls) {
        this.totalNumberOfRolls = totalNumberOfRolls;
    }
}
