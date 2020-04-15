package com.springboot.diceapi.repository;

import com.springboot.diceapi.model.DiceSimulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiceSimulationRepository extends JpaRepository<DiceSimulation, Integer> {
    List<DiceSimulation> findBySidesOfDieAndNumberOfDice (int sidesOfDie, int numberOfDice);
}
