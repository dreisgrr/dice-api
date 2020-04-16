package com.springboot.diceapi.controller;

import com.springboot.diceapi.repository.DistributionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diceapi/distribution")
public class DiceDistributionController {
    private DistributionRepository distributionRepository;

    DiceDistributionController(DistributionRepository distributionRepository) {
        this.distributionRepository = distributionRepository;
    }
}
