package com.coffeehouse.service;

import com.coffeehouse.model.Coffee;
import com.coffeehouse.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public Coffee createCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeById(Long id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coffee not found"));
    }

    public Coffee updateCoffee(Long id, Coffee coffeeDetails) {
        Coffee coffee = coffeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coffee not found"));
        coffee.setName(coffeeDetails.getName());
        coffee.setPrice(coffeeDetails.getPrice());
        return coffeeRepository.save(coffee);
    }

    public void deleteCoffee(Long id) {
        coffeeRepository.deleteById(id);
    }
}
