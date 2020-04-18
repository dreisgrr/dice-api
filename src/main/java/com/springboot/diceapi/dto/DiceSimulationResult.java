package com.springboot.diceapi.dto;

public class DiceSimulationResult {

    private Long totalRolls;
    private Long simulations;

    public DiceSimulationResult() {

    }

    public DiceSimulationResult(Long totalRolls, Long simulations) {
        this.totalRolls = totalRolls;
        this.simulations = simulations;
    }

    public Long getTotalRolls() {
        return totalRolls;
    }

    public Long getSimulations() {
        return simulations;
    }

    public void setTotalRolls(Long totalRolls) {
        this.totalRolls = totalRolls;
    }

    public void setSimulations(Long simulations) {
        this.simulations = simulations;
    }
}
