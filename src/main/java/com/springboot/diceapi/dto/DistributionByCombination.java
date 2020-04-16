package com.springboot.diceapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DistributionByCombination {
    private int totalOfDiceValue;
    private long frequency;

    public  DistributionByCombination() {
        this.totalOfDiceValue = 0;
        this.frequency = 0;
    }

    public DistributionByCombination(int totalOfDiceValue, int frequency) {
        this();
        this.totalOfDiceValue = totalOfDiceValue;
        this.frequency = frequency;
    }

    public long getTotalOfDiceValue() {
        return totalOfDiceValue;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setTotalOfDiceValue(int totalOfDiceValue) {
        this.totalOfDiceValue = totalOfDiceValue;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
