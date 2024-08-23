package com.reporter.WebEnergyReporter.services;

import com.reporter.WebEnergyReporter.models.Energy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.reporter.WebEnergyReporter.DTO.EnergyRequestDTO;
import com.reporter.WebEnergyReporter.repositories.EnergyRepository;

@Service
public class EnergyService {

    private static final String CORRECT_PASSWORD = "pass"; // Пароль

    @Autowired
    private EnergyRepository repository;

    public boolean addEnergy(EnergyRequestDTO requestDTO) {
        if (!CORRECT_PASSWORD.equals(requestDTO.getPassword())) {
            return false; // Пароль не совпадает, доделать
        }

        Energy energy = new Energy();
        energy.setEnergyType(Integer.parseInt(requestDTO.getType()));
        energy.setEnergyValue(Integer.parseInt(requestDTO.getValue()));

        repository.save(energy); // Сохранение в БД
        return true; // Успешное добавление
    }


    public Map<Integer, Integer> getEnergy() {
        List<Integer[]> results = repository.getEnergy();
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (Integer[] result : results) {
            counts.put(1, result[0]);
        }

        for (Integer[] result : results) {
            counts.put(2, result[1]);
            if (result[0]>result[1]){
                counts.put(3, result[0]-result[1]);
                counts.put(4, 0);
            }else {
                counts.put(3, 0);
                counts.put(4, result[1]-result[0]);
            }
        }
        return counts;
    }
}

//public void saveEnergy(int energyType, int energyValue) {
//    if (energyType < 1 || energyType > 2) {
//        throw new IllegalArgumentException("Type must be between 1 and 2");
//    }
//    Energy energy = new Energy(energyType, energyValue);
//    repository.save(energy);
//}