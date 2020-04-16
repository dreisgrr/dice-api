package com.springboot.diceapi.dto;

import java.util.List;

public class TotalCombinedDistributionResponse {
    private int sidesOfDie;
    private int numberOfDice;
    private Long simulations;
    private Long totalRolls;
    private int numberOfSumResult;
    private List<TotalCombinedDistributionResult> distribution;

    public TotalCombinedDistributionResponse() {

    }

    public TotalCombinedDistributionResponse(
            int sidesOfDie,
            int numberOfDice,
            Long simulations,
            Long totalRolls,
            int numberOfSumResult,
            List<TotalCombinedDistributionResult> distribution) {
        this.sidesOfDie = sidesOfDie;
        this.numberOfDice = numberOfDice;
        this.simulations = simulations;
        this.totalRolls = totalRolls;
        this.numberOfSumResult = numberOfSumResult;
        this.distribution = distribution;
    }

    public int getSidesOfDie() {
        return sidesOfDie;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public Long getSimulations() {
        return simulations;
    }

    public Long getTotalRolls() {
        return totalRolls;
    }

    public int getNumberOfSumResult() {
        return numberOfSumResult;
    }

    public List<TotalCombinedDistributionResult> getDistribution() {
        return distribution;
    }

    public void setSidesOfDie(int sidesOfDie) {
        this.sidesOfDie = sidesOfDie;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public void setSimulations(Long simulations) {
        this.simulations = simulations;
    }

    public void setTotalRolls(Long totalRolls) {
        this.totalRolls = totalRolls;
    }

    public void setNumberOfSumResult(int numberOfSumResult) {
        this.numberOfSumResult = numberOfSumResult;
    }

    public void setDistribution(List<TotalCombinedDistributionResult> distribution) {
        this.distribution = distribution;
    }
}
