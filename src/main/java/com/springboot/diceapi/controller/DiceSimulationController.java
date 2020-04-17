package com.springboot.diceapi.controller;

import com.springboot.diceapi.dto.DiceSimulationResult;
import com.springboot.diceapi.dto.TotalCombinedDistributionResponse;
import com.springboot.diceapi.dto.TotalCombinedDistributionResult;
import com.springboot.diceapi.model.DiceSimulation;
import com.springboot.diceapi.model.Distribution;
import com.springboot.diceapi.repository.DiceSimulationRepository;
import com.springboot.diceapi.service.DiceSimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
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
        List<Distribution> result = diceSimulationService.runSimulation(diceSimulation);
        if(result.isEmpty()) throw new ValidationException("There was an error processing your request. Please try again.");
        return result;
    }

    @GetMapping("/total")
    public DiceSimulationResult totalRollsByCombination(@Valid @RequestBody DiceSimulation diceSimulation, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()) {
            throw new javax.validation.ValidationException("There are errors in the query parameters.");
        }
        DiceSimulationResult result = this.diceSimulationRepository.getSumNumberOfRolls(diceSimulation.getSidesOfDie(), diceSimulation.getNumberOfDice());
        if(result.getSimulations() == 0) throw new NotFoundException();
        return result;
    }

    @GetMapping("/distribution")
    public TotalCombinedDistributionResponse getDistribution(@Valid @RequestBody DiceSimulation diceSimulation, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()) {
            throw new javax.validation.ValidationException("Invalid query parameter/s.");
        }
        List<TotalCombinedDistributionResult> distributionResults;
        TotalCombinedDistributionResponse response = new TotalCombinedDistributionResponse();
        DiceSimulationResult diceSimulationResult = this.diceSimulationRepository.getSumNumberOfRolls(diceSimulation.getSidesOfDie(), diceSimulation.getNumberOfDice());;
        distributionResults = this.diceSimulationRepository.getTotalCombinedDistributionByCombination(diceSimulation.getSidesOfDie(), diceSimulation.getNumberOfDice());
        response.setNumberOfDice(diceSimulation.getNumberOfDice());
        response.setSidesOfDie(diceSimulation.getSidesOfDie());
        response.setSimulations(diceSimulationResult.getSimulations());
        response.setTotalRolls(diceSimulationResult.getTotalRolls());
        response.setNumberOfSumResult(diceSimulation.getNumberOfDice()*diceSimulation.getSidesOfDie());
        response.setDistribution(distributionResults);
        if(response.getSimulations() == 0) throw new NotFoundException();
        return response;
    }

    @GetMapping("/{id}")
    public DiceSimulation getDistributionBySimulation(@PathVariable int id) throws ValidationException {
        return this.diceSimulationRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NotFoundException extends RuntimeException {
    }
}
