package com.springboot.diceapi.controller;

import com.springboot.diceapi.dto.DistributionByCombination;
import com.springboot.diceapi.dto.TotalCombinedDistributionResult;
import com.springboot.diceapi.model.DiceSimulation;
import com.springboot.diceapi.model.Distribution;
import com.springboot.diceapi.repository.DiceSimulationRepository;
import com.springboot.diceapi.service.DiceSimulationService;
import com.springboot.diceapi.viewmodel.DiceSimulationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/diceapi/simulation")
public class DiceSimulationController {
    @Autowired
    private DiceSimulationRepository diceSimulationRepository;
    @Autowired
    private DiceSimulationService diceSimulationService;

    @PostMapping
    public List<Distribution> rollDice(@Validated({ConfigurationValidation.class})  @RequestBody DiceSimulation diceSimulation, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()) {
            throw new ValidationException("Dice configuration has errors. Unable run simulation.");
        }
        this.diceSimulationRepository.save(diceSimulation);
        //execute Service
        return diceSimulationService.runSimulation(diceSimulation);
    }

    @GetMapping("/total")
    public int totalRollsByCombination(@Valid @RequestBody DiceSimulation diceSimulation, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new javax.validation.ValidationException("There are errors in the query parameters.");
        }
        return  this.diceSimulationRepository.getSumNumberOfRolls(diceSimulation.getSidesOfDie(), diceSimulation.getNumberOfDice());
    }

    @GetMapping("/distributions")
    public List<DistributionByCombination> getDistribution() {
        return this.diceSimulationRepository.getJoin();
    }
    @GetMapping("/distribution")
    public List<TotalCombinedDistributionResult> test() {
        return this.diceSimulationRepository.getTest();
    }

}
