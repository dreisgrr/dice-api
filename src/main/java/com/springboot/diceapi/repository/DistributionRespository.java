package com.springboot.diceapi.repository;

import com.springboot.diceapi.model.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRespository extends JpaRepository<Distribution, Integer> {
    
}
