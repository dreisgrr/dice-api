package com.springboot.diceapi.service;

import com.springboot.diceapi.model.DiceSimulation;
import com.springboot.diceapi.model.DiceSimulationDetails;
import com.springboot.diceapi.model.Die;
import com.springboot.diceapi.repository.DiceSimulationDetailsRepository;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTextAreaUI;

@Service
public class DiceSimulationService {
    private DiceSimulation diceSimulation;
    private DiceSimulationDetails diceSimulationDetails;
    private Die die;
    private DiceSimulationDetailsRepository diceSimulationDetailsRepository;

    DiceSimulationService(DiceSimulationDetailsRepository diceSimulationDetailsRepository) {
       this.diceSimulationDetailsRepository = diceSimulationDetailsRepository;
    }

    public void runSimulation(DiceSimulation diceSimulation) {
        this.diceSimulation = diceSimulation;

        System.out.println("Rolling "+ diceSimulation.getNumberOfDice() + " " + diceSimulation.getSidesOfDie() + " sided dice " + diceSimulation.getNumberOfRolls() + " times");
        for (int i = 1; i <= diceSimulation.getNumberOfRolls(); i++) {
            int sumOfSet = 0;
            System.out.println("Roll "+ i);
            for (int j = 1; j <= diceSimulation.getNumberOfDice(); j++) {
                die = new Die(diceSimulation.getSidesOfDie());
                diceSimulationDetails = new DiceSimulationDetails();
                diceSimulationDetails.setDiceSimulationId(diceSimulation.getId());
                diceSimulationDetails.setRollNumber(i);
                diceSimulationDetails.setDiceNumber(j);
                diceSimulationDetails.setDiceValue(die.getDiceValue());
                sumOfSet += die.getDiceValue();
                System.out.println("Dice "+ j +": "+die.getDiceValue());
                this.diceSimulationDetailsRepository.save(diceSimulationDetails);
            }
            System.out.println("Sum of set: "+sumOfSet);
        }
    }

}
