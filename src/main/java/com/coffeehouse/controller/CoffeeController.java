package com.coffeehouse.controller;

import com.coffeehouse.model.Coffee;
import com.coffeehouse.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {
    @Autowired
    private CoffeeService coffeeService;

    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return coffeeService.createCoffee(coffee);
    }

    @GetMapping
    public List<Coffee> getAllCoffees() {
        return coffeeService.getAllCoffees();
    }

    @GetMapping("/{id}")
    public Coffee getCoffeeById(@PathVariable Long id) {
        return coffeeService.getCoffeeById(id);
    }

    @PutMapping("/{id}")
    public Coffee updateCoffee(@PathVariable Long id, @RequestBody Coffee coffeeDetails) {
        return coffeeService.updateCoffee(id, coffeeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Long id) {
        coffeeService.deleteCoffee(id);
    }
}
