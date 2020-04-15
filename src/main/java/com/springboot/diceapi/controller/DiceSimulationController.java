package com.springboot.diceapi.controller;

import com.springboot.diceapi.model.DiceSimulation;
import com.springboot.diceapi.model.Distribution;
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
import java.util.List;

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
    public List<Distribution> rollDice(@Valid @RequestBody DiceSimulation diceSimulation, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()) {
            throw new ValidationException("Dice configuration has errors. Unable run simulation.");
        }
        this.diceSimulationRepository.save(diceSimulation);
        //execute Service
        return diceSimulationService.runSimulation(diceSimulation);
    }

}
