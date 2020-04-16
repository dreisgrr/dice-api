package com.springboot.diceapi.repository;

import com.springboot.diceapi.dto.DiceSimulationResult;
import com.springboot.diceapi.dto.TotalCombinedDistributionResult;
import com.springboot.diceapi.model.DiceSimulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiceSimulationRepository extends JpaRepository<DiceSimulation, Integer> {

    @Query("SELECT new com.springboot.diceapi.dto.DiceSimulationResult(SUM(ds.numberOfRolls), COUNT(ds.id) as simulations) FROM DiceSimulation ds WHERE ds.sidesOfDie = ?1 AND ds.numberOfDice = ?2")
    public DiceSimulationResult getSumNumberOfRolls(int sidesOfDie, int numberOfDice);

    @Query("SELECT new com.springboot.diceapi.dto.TotalCombinedDistributionResult(d.totalOfDiceValues, SUM(d.frequency), SUM(ds.numberOfRolls)) FROM DiceSimulation ds JOIN ds.distribution d WHERE ds.sidesOfDie = ?1 AND ds.numberOfDice = ?2 GROUP BY d.totalOfDiceValues ORDER BY d.totalOfDiceValues ASC")
    public List<TotalCombinedDistributionResult> getTotalCombinedDistributionByCombination(int sidesOfDie, int numberOfDice);
}
