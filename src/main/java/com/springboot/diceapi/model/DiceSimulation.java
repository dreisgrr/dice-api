package com.springboot.diceapi.model;

import com.springboot.diceapi.controller.ConfigurationValidation;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table (name = "diceSimulation")
public class DiceSimulation {
    @Id
    @GeneratedValue(generator = "simulation_generator")
    @SequenceGenerator(
            name = "simulation_generator",
            sequenceName = "simulation_sequence",
            initialValue = 1000
    )
    private int id;

    @Min(value = 4L)
    private int sidesOfDie;

    @Min(value = 1L)
    private int numberOfDice;

    @Min(value = 1L, groups = ConfigurationValidation.class)
    private int numberOfRolls;

    @OneToMany(targetEntity = Distribution.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "diceSimulationId", referencedColumnName = "id")
    private List<Distribution> distribution;
    @OneToMany(targetEntity = DiceSimulationDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "diceSimulationId", referencedColumnName = "id")
    private List<DiceSimulationDetails> details;

    public DiceSimulation() {

    }

    public DiceSimulation(int sidesOfDie, int numberOfDice, int numberOfRolls) {
        this.sidesOfDie = sidesOfDie;
        this.numberOfDice = numberOfDice;
        this.numberOfRolls = numberOfRolls;
    }

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

    public List<Distribution> getDistribution() {
        return distribution;
    }

    public void setDistribution(List<Distribution> distribution) {
        this.distribution = distribution;
    }

    public List<DiceSimulationDetails> getDetails() {
        return details;
    }

    public void setDetails(List<DiceSimulationDetails> details) {
        this.details = details;
    }
}
