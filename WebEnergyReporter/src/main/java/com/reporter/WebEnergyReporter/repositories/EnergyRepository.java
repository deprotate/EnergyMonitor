package com.reporter.WebEnergyReporter.repositories;

import com.reporter.WebEnergyReporter.models.Energy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnergyRepository extends JpaRepository<Energy, Long> {
    @Query("SELECT " +
            "SUM(CASE WHEN e.energyType = 1 THEN e.energyValue ELSE 0 END), " +
            "SUM(CASE WHEN e.energyType = 2 THEN e.energyValue ELSE 0 END) " +
            "FROM Energy e")
    List<Integer[]> getEnergy();
}