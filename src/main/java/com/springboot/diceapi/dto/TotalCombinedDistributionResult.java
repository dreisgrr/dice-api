package com.springboot.diceapi.dto;

import java.text.DecimalFormat;

public class TotalCombinedDistributionResult {

    private int totalOfDiceValues;
    private Long frequency;
    private String percentage;

    public TotalCombinedDistributionResult(int totalOfDiceValues, Long frequency, Long percentage) {
        this.totalOfDiceValues = totalOfDiceValues;
        this.frequency = frequency;
        this.percentage = computePercentage(frequency, percentage);
    }

    public TotalCombinedDistributionResult(int totalOfDiceValues, Long frequency) {
        this.totalOfDiceValues = totalOfDiceValues;
        this.frequency = frequency;
    }

    private String computePercentage(Long frequency, Long percentage) {
        double dFrequency = (double) frequency;
        double dTotalRolls = (double) percentage;
        double converted = (dFrequency/dTotalRolls)*100;
        DecimalFormat df = new DecimalFormat("#.##");
        return String.valueOf(df.format(converted));
    }

    public int getTotalOfDiceValues() {
        return totalOfDiceValues;
    }

    public Long getFrequency() {
        return frequency;
    }

    public String getPercentage() { return percentage; }

    public void setTotalOfDiceValues(int totalOfDiceValues) {
        this.totalOfDiceValues = totalOfDiceValues;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
