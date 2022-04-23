package tqs.hw1.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import tqs.hw1.model.ByCountry;

@DataJpaTest
class ByCountryRepositoryTest {
    
    @Autowired
    private ByCountryRepository byCountryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testWhenFindCountryAndReturnByCountry() {

        ByCountry byCountry = new ByCountry();
        byCountry.setCountry("Portugal");
        byCountry.setContinente("Europe");
        byCountry.setPopulation(1000000);
        byCountry.setNew_cases(23);
        byCountry.setActive_cases(12);
        byCountry.setCritical_cases(3);
        byCountry.setRecovered_cases(5);
        byCountry.setCases_per_million(3);
        byCountry.setTotal_cases(100);
        byCountry.setNew_deaths(3);
        byCountry.setDeaths_per_million(1);
        byCountry.setTotal_deaths(5);
        byCountry.setTests_per_million(55);
        byCountry.setTotal_tests(8722);
        byCountry.setDaysearch("2022-04-22");
        byCountry.setCreationDate(new Timestamp(System.currentTimeMillis()));

        entityManager.persist(byCountry);

        ByCountry byCountryFound = byCountryRepository.findByCountry("Portugal");

        assertThat(byCountryFound).isNotNull();
        assertThat(byCountryFound.getCountry()).isEqualTo("Portugal");
        assertThat(byCountryFound.getContinente()).isEqualTo("Europe");

        assertThat(byCountryFound).isEqualTo(byCountry);
    }
    
    @Test
    void testWhenNotFindCountryAndReturnNull() {

        ByCountry byCountryFound = byCountryRepository.findByCountry("Portugalinho");
        assertThat(byCountryFound).isNull();
    }
    
    @Test
    void testIfAllTheDataAreStoredOnDB() {
        ByCountry byCountry1 = new ByCountry();
        byCountry1.setCountry("Portugal");
        byCountry1.setContinente("Europe");
        byCountry1.setPopulation(1000000);
        byCountry1.setNew_cases(23);
        byCountry1.setActive_cases(12);
        byCountry1.setCritical_cases(3);
        byCountry1.setRecovered_cases(5);
        byCountry1.setCases_per_million(3);
        byCountry1.setTotal_cases(100);
        byCountry1.setNew_deaths(3);
        byCountry1.setDeaths_per_million(1);
        byCountry1.setTotal_deaths(5);
        byCountry1.setTests_per_million(55);
        byCountry1.setTotal_tests(8722);
        byCountry1.setDaysearch("2022-04-22");
        byCountry1.setCreationDate(new Timestamp(System.currentTimeMillis()));

        entityManager.persist(byCountry1);

        ByCountry byCountry2 = new ByCountry();
        byCountry2.setCountry("Spain");
        byCountry2.setContinente("Europe");
        byCountry2.setPopulation(1234000);
        byCountry2.setNew_cases(323);
        byCountry2.setActive_cases(43);
        byCountry2.setCritical_cases(53);
        byCountry2.setRecovered_cases(2342);
        byCountry2.setCases_per_million(3);
        byCountry2.setTotal_cases(100);
        byCountry2.setNew_deaths(3);
        byCountry2.setDeaths_per_million(1);
        byCountry2.setTotal_deaths(5);
        byCountry2.setTests_per_million(55);
        byCountry2.setTotal_tests(8722);
        byCountry2.setDaysearch("2022-04-22");
        byCountry2.setCreationDate(new Timestamp(System.currentTimeMillis()));

        entityManager.persist(byCountry2);

        ByCountry byCountry3 = new ByCountry();
        byCountry3.setCountry("Portugal");
        byCountry3.setContinente("Europe");
        byCountry3.setPopulation(1000000);
        byCountry3.setNew_cases(23);
        byCountry3.setActive_cases(12);
        byCountry3.setCritical_cases(3);
        byCountry3.setRecovered_cases(5);
        byCountry3.setCases_per_million(3);
        byCountry3.setTotal_cases(100);
        byCountry3.setNew_deaths(3);
        byCountry3.setDeaths_per_million(1);
        byCountry3.setTotal_deaths(5);
        byCountry3.setTests_per_million(55);
        byCountry3.setTotal_tests(8722);
        byCountry3.setDaysearch("2022-04-22");
        byCountry3.setCreationDate(new Timestamp(System.currentTimeMillis()));

        entityManager.persist(byCountry3);

        assertThat(byCountryRepository.findAll()).isNotEmpty();
        List<ByCountry> allCovidDataOnDatabase = byCountryRepository.findAll();
        
        assertThat(allCovidDataOnDatabase).hasSize(3);

    }
}
