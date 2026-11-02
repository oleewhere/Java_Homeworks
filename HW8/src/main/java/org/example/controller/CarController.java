package org.example.controller;

import org.example.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private List<Car> cars = new ArrayList<>();

    public CarController() {
        cars.add(new Car(1, "Camry", "Toyota", 200));
        cars.add(new Car(2, "Corolla", "Toyota", 140));
        cars.add(new Car(3, "M5", "BMW", 600));
        cars.add(new Car(4, "A6", "Audi", 200));
    }

    @GetMapping
    public List<Car> getAllCars() {
        return cars;
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        cars.add(car);
        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        Car carToRemove = null;
        for (Car car : cars) {
            if (car.getId() == id) {
                carToRemove = car;
                break;
            }
        }
        if (carToRemove != null) {
            cars.remove(carToRemove);
        }
    }

    @GetMapping("/power/{value}")
    public List<Car> getCarsByPower(@PathVariable int value) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPower() == value) {
                result.add(car);
            }
        }
        return result;
    }

    @GetMapping("/producer/{value}")
    public List<Car> getCarsByProducer(@PathVariable String value) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (value.equalsIgnoreCase(car.getProducer())) {
                result.add(car);
            }
        }
        return result;
    }
}