package com.tqs;



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
        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(car)));

        List<Car> found = repository.findAll();
        assertThat(found).extracting(Car::getBrand).containsOnly("Ford");
    }




}
