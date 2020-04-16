package com.springboot.diceapi.service;

import com.springboot.diceapi.model.DiceSimulation;
import com.springboot.diceapi.model.DiceSimulationDetails;
import com.springboot.diceapi.model.Die;
import com.springboot.diceapi.model.Distribution;
import com.springboot.diceapi.repository.DiceSimulationDetailsRepository;
import com.springboot.diceapi.repository.DistributionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiceSimulationService {
    private DiceSimulation diceSimulation;
    private DiceSimulationDetails diceSimulationDetails;
    private Die die;
    private DiceSimulationDetailsRepository diceSimulationDetailsRepository;
    private DistributionRepository distributionRespository;
    private int[] distributionCount;

    DiceSimulationService(DiceSimulationDetailsRepository diceSimulationDetailsRepository, DistributionRepository distributionRespository) {
       this.diceSimulationDetailsRepository = diceSimulationDetailsRepository;
       this.distributionRespository = distributionRespository;
    }

    public List<Distribution> runSimulation(DiceSimulation diceSimulation) {
        this.diceSimulation = diceSimulation;
        distributionCount = new int[diceSimulation.getNumberOfDice() * diceSimulation.getSidesOfDie() + 1];

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
            distributionCount[sumOfSet] += 1;
            System.out.println("Sum of set: "+sumOfSet);
        }
        return saveDistribution(diceSimulation.getId());
    }

    public List<Distribution> saveDistribution(int diceSimulationId) {
        List<Distribution> distributionList = new ArrayList<>();
        for (int i = 1; i < distributionCount.length; i++) {
            Distribution distribution = new Distribution();
            distribution.setTotalOfDiceValues(i);
            distribution.setFrequency(distributionCount[i]);
            distributionList.add(distribution);
            distribution.setDiceSimulationId(diceSimulationId);
            this.distributionRespository.save(distribution);
        }
        return distributionList;
    }

}
