package com.tqs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void whenFindByModel_thenReturnCar() {
        Car car = new Car("Audi", "A4");
        entityManager.persistAndFlush(car);

        Car foundCar = carRepository.findByModel(car.getModel());
        assertThat(foundCar.getModel()).isEqualTo(car.getModel());
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        Car carFromDB = carRepository.findByModel("wrong");
        assertThat(carFromDB).isNull();
    }
}