package com.tqs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CarController {
    
    @Autowired
    private CarManagerService carManagerService;

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carManagerService.save(car));
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carManagerService.getAllCars());
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarDetails(@PathVariable Long id) {
        return ResponseEntity.ok(carManagerService.getCarDetails(id).get());
    }

}
