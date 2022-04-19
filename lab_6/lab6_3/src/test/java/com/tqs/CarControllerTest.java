package com.tqs;

import java.io.IOException;
import java.util.List;

import net.minidev.json.JSONUtil;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest()
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CarControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
    void whenValidInput_thenCreateCar() throws IOException, Exception {
        Car car = new Car("Ford", "Fiesta");
        //mvc.perform(post("/api/car").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(car)));

        List<Car> found = repository.findAll();
        assertThat(found).extracting(Car::getBrand).containsOnly("Ford");
    }




}
