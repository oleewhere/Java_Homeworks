package org.example.carconfig;

import lombok.AllArgsConstructor;
import org.example.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    private CarRepository carRepository;

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return carRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
    }

    @GetMapping("/power/{value}")
    public List<Car> getByPower(@PathVariable int value) {
        return carRepository.findAllByPower(value);
    }

    @GetMapping("/producer/{value}")
    public List<Car> getByProducer(@PathVariable String value) {
        return carRepository.findAllByProducer(value);
    }
}