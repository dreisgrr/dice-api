package com.springboot.diceapi.viewmodel;

public class DistributionViewModel {
    private int total;
    private int frequency;

    public int getTotal() {
        return total;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
