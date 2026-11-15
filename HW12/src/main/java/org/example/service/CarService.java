package org.example.service;

import org.example.dto.*;
import org.example.entity.Car;
import org.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MailService mailService;

    private final String uploadDir = "uploads";
    private final String targetEmail = "olegischenko06@gmail.com";

    public List<CarBasicDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        List<CarBasicDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(toBasicDto(car));
        }
        return result;
    }

    public CarFullDto getCarById(String id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return toFullDto(car);
    }

    public List<CarPowerDto> getCarsByPower(int power) {
        List<Car> cars = carRepository.findByPower(power);
        List<CarPowerDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(toPowerDto(car));
        }
        return result;
    }

    public List<CarPowerDto> getCarsByProducer(String producer) {
        List<Car> cars = carRepository.findByProducer(producer);
        List<CarPowerDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(toPowerDto(car));
        }
        return result;
    }

    public CarFullDto saveCar(CarRequestDto requestDto, MultipartFile photo) {
        Car car = new Car();
        car.setModel(requestDto.getModel());
        car.setProducer(requestDto.getProducer());
        car.setPower(requestDto.getPower());

        if (photo != null && !photo.isEmpty()) {
            try {
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
                Path filePath = Paths.get(uploadDir, fileName);
                Files.write(filePath, photo.getBytes());
                car.setPhoto("/uploads/" + fileName);
            } catch (IOException e) {
                throw new RuntimeException("Could not save photo", e);
            }
        }

        Car savedCar = carRepository.save(car);

        mailService.sendEmail(
                targetEmail,
                "Car Saved",
                "Saved car: " + savedCar.getProducer() + " " + savedCar.getModel() + ", power: " + savedCar.getPower()
        );

        return toFullDto(savedCar);
    }

    public void deleteCar(String id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));

        carRepository.deleteById(id);

        mailService.sendEmail(
                targetEmail,
                "Car Deleted",
                "Deleted car: " + car.getProducer() + " " + car.getModel() + " (ID: " + car.getId() + ")"
        );
    }

    @Scheduled(fixedRate = 60000)
    public void cleanWeakCars() {
        carRepository.deleteByPowerLessThan(100);
    }

    private CarFullDto toFullDto(Car car) {
        CarFullDto dto = new CarFullDto();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setProducer(car.getProducer());
        dto.setPower(car.getPower());
        dto.setPhoto(car.getPhoto());
        return dto;
    }

    private CarBasicDto toBasicDto(Car car) {
        CarBasicDto dto = new CarBasicDto();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setProducer(car.getProducer());
        return dto;
    }

    private CarPowerDto toPowerDto(Car car) {
        CarPowerDto dto = new CarPowerDto();
        dto.setModel(car.getModel());
        dto.setProducer(car.getProducer());
        dto.setPower(car.getPower());
        return dto;
    }
}