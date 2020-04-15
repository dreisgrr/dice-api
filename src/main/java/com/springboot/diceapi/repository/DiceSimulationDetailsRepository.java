package com.springboot.diceapi.repository;

import com.springboot.diceapi.model.DiceSimulationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceSimulationDetailsRepository extends JpaRepository<DiceSimulationDetails, Integer> {

}
