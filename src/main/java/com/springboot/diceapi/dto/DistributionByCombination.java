package com.springboot.diceapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistributionByCombination {
    private int totalOfDiceValue;
    private int frequency;

    public DistributionByCombination(int totalOfDiceValue, int frequency) {
        this.totalOfDiceValue = totalOfDiceValue;
        this.frequency = frequency;
    }

    public int getTotalOfDiceValue() {
        return totalOfDiceValue;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setTotalOfDiceValue(int totalOfDiceValue) {
        this.totalOfDiceValue = totalOfDiceValue;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
