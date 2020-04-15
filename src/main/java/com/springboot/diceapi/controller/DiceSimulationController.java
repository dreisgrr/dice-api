package com.springboot.diceapi.controller;

import com.springboot.diceapi.model.DiceSimulation;
import com.springboot.diceapi.repository.DiceSimulationRepository;
import com.springboot.diceapi.service.DiceSimulationService;
import com.springboot.diceapi.viewmodel.DiceSimulationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/diceapi/diceSimulation")
public class DiceSimulationController {
    private DiceSimulationRepository diceSimulationRepository;
    @Autowired
    private DiceSimulationService diceSimulationService;

    DiceSimulationController(DiceSimulationRepository diceSimulationRepository) {
        this.diceSimulationRepository = diceSimulationRepository;
    }

    @PostMapping
    public String rollDice(@Valid @RequestBody DiceSimulation diceSimulation, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()) {
            throw new ValidationException("Dice configuration has errors. Unable run simulation.");
        }
        this.diceSimulationRepository.save(diceSimulation);
        //execute Service
        diceSimulationService.runSimulation(diceSimulation);
        return "Received";
    }

}
