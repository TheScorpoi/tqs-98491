package com.tqs;

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
