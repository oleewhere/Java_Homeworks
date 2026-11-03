package org.example.service;

import org.example.dto.*;
import org.example.entity.Car;
import org.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarBasicDto> getAllCars() {
        return carRepository.findAll().stream().map(car -> {
            CarBasicDto dto = new CarBasicDto();
            dto.setModel(car.getModel());
            dto.setProducer(car.getProducer());
            return dto;
        }).collect(Collectors.toList());
    }

    public CarFullDto getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        CarFullDto dto = new CarFullDto();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setProducer(car.getProducer());
        dto.setPower(car.getPower());
        return dto;
    }

    public CarFullDto saveCar(CarRequestDto requestDto) {
        Car car = new Car();
        car.setModel(requestDto.getModel());
        car.setProducer(requestDto.getProducer());
        car.setPower(requestDto.getPower());

        Car savedCar = carRepository.save(car);

        CarFullDto dto = new CarFullDto();
        dto.setId(savedCar.getId());
        dto.setModel(savedCar.getModel());
        dto.setProducer(savedCar.getProducer());
        dto.setPower(savedCar.getPower());
        return dto;
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found with id: " + id);
        }
        carRepository.deleteById(id);
    }

    public List<CarPowerDto> getCarsByPower(Integer power) {
        return carRepository.findByPower(power).stream().map(car -> {
            CarPowerDto dto = new CarPowerDto();
            dto.setModel(car.getModel());
            dto.setProducer(car.getProducer());
            dto.setPower(car.getPower());
            return dto;
        }).collect(Collectors.toList());
    }

    public List<CarPowerDto> getCarsByProducer(String producer) {
        return carRepository.findByProducer(producer).stream().map(car -> {
            CarPowerDto dto = new CarPowerDto();
            dto.setModel(car.getModel());
            dto.setProducer(car.getProducer());
            dto.setPower(car.getPower());
            return dto;
        }).collect(Collectors.toList());
    }
}