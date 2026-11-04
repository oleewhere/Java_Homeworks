package org.example.repository;

import org.example.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByPower(Integer power);
    List<Car> findByProducer(String producer);
    void deleteByPowerLessThan(Integer power);
}