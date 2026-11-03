package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.*;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarBasicDto>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarFullDto> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarFullDto> createCar(@Valid @RequestBody CarRequestDto requestDto) {
        return new ResponseEntity<>(carService.saveCar(requestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/power/{value}")
    public ResponseEntity<List<CarPowerDto>> getCarsByPower(@PathVariable Integer value) {
        return new ResponseEntity<>(carService.getCarsByPower(value), HttpStatus.OK);
    }

    @GetMapping("/producer/{value}")
    public ResponseEntity<List<CarPowerDto>> getCarsByProducer(@PathVariable String value) {
        return new ResponseEntity<>(carService.getCarsByProducer(value), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}