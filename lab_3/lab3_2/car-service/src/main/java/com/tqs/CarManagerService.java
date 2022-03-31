package com.tqs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManagerService {
    
    @Autowired
    private CarRepository carRepository;

    public Car save(Car car) {
        //return carRepository.save(car);
        return null;
    }
    
    public List<Car> getAllCars() {
        //return carRepository.findAll();
        return null;

    }

    public Optional<Car> getCarDetails(Long id) {
        //return carRepository.findById(id);
        return null;
    }

}
