package com.tqs;

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
