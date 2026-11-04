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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MailService mailService;

    private final String uploadPath = System.getProperty("user.dir") + File.separator + "uploads";
    private final String targetEmail = "olegischenko06@gmail.com";

    public List<CarBasicDto> getAllCars() {
        return carRepository.findAll().stream().map(car -> {
            CarBasicDto dto = new CarBasicDto();
            dto.setModel(car.getModel());
            dto.setProducer(car.getProducer());
            return dto;
        }).collect(Collectors.toList());
    }

    public CarFullDto getCarById(String id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        CarFullDto dto = new CarFullDto();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setProducer(car.getProducer());
        dto.setPower(car.getPower());
        dto.setPhoto(car.getPhoto());
        return dto;
    }

    public CarFullDto saveCar(CarRequestDto requestDto, MultipartFile photo) {
        Car car = new Car();
        car.setModel(requestDto.getModel());
        car.setProducer(requestDto.getProducer());
        car.setPower(requestDto.getPower());

        if (photo != null && !photo.isEmpty()) {
            try {
                File dir = new File(uploadPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
                Path filePath = Paths.get(uploadPath, fileName);
                Files.write(filePath, photo.getBytes());
                car.setPhoto(fileName);
            } catch (IOException e) {
                throw new RuntimeException("Could not save photo");
            }
        }

        Car savedCar = carRepository.save(car);

        mailService.sendEmail(
                targetEmail,
                "Car Saved",
                "Saved car: " + savedCar.getProducer() + " " + savedCar.getModel() + ", power: " + savedCar.getPower()
        );



        CarFullDto dto = new CarFullDto();
        dto.setId(savedCar.getId());
        dto.setModel(savedCar.getModel());
        dto.setProducer(savedCar.getProducer());
        dto.setPower(savedCar.getPower());
        dto.setPhoto(savedCar.getPhoto());
        return dto;
    }

    public void deleteCar(String id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        carRepository.deleteById(id);

        mailService.sendEmail(
                targetEmail,
                "Car Deleted",
                "Deleted car: " + car.getProducer() + " " + car.getModel() + " (ID: " + car.getId() + ")"
        );
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

    @Scheduled(fixedRate = 60000)
    public void cleanWeakCars() {
        carRepository.deleteByPowerLessThan(100);
    }

}