package com.springboot.diceapi.repository;

import com.springboot.diceapi.dto.DistributionByCombination;
import com.springboot.diceapi.model.DiceSimulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiceSimulationRepository extends JpaRepository<DiceSimulation, Integer> {

    @Query("SELECT SUM(u.numberOfRolls) from DiceSimulation u WHERE sidesOfDie = ?1 AND numberOfDice = ?2")
    int getSumNumberOfRolls(int sidesOfDie, int numberOfDice);

    //Returns Frequency for each Number Total given Dice Side and Dice Quantity as parameters
    //Not yet grouped -- Frequency is yet to be implemented using SUM
    @Query("SELECT new com.springboot.diceapi.dto.DistributionByCombination(d.totalOfDiceValues, d.frequency) FROM DiceSimulation ds JOIN ds.distribution d")
    public List<DistributionByCombination> getJoin();
}
