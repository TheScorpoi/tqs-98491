package tqs.hw1.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

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
    



}
