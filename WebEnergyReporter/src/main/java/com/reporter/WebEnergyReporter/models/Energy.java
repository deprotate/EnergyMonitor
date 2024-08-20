package com.reporter.WebEnergyReporter.models;

import jakarta.persistence.*;

@Entity
@Table(name = "energy")
public class Energy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "energy_type")
    private int energyType;

    @Column(name = "energy_value")
    private int energyValue;

    public Energy(int energyType, int energyValue) {
        this.energyType = energyType;
        this.energyValue = energyValue;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(int numberValue) {
        this.energyValue = numberValue;
    }

    public int getEnergyType() {
        return energyType;
    }

    public void setEnergyType(int energyType) {
        this.energyType = energyType;
    }
}
