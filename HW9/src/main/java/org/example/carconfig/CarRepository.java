package org.example.carconfig;

import org.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByPower(int power);
    List<Car> findAllByProducer(String producer);
}