package tqs.hw1.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tqs.hw1.repository.ByCountryRepository;
import tqs.hw1.cache.CovidCache;
import tqs.hw1.service.CovidAPI;
import tqs.hw1.model.ByCountry;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.anyString;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import javax.xml.crypto.URIReferenceException;
import java.text.ParseException;


@ExtendWith(MockitoExtension.class)
class ServiceTest {

    private ByCountry byCountry;

    @Mock
    private CovidCache covidCache;

    @Mock
    private ByCountryRepository byCountryRepository;

    @InjectMocks
    private CovidAPI covidAPI;

    @BeforeEach
    public void setUp() {
        byCountry = new ByCountry();
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
    }

    @Test
    public void testWhenFindCountryAndReturnByCountry() throws URISyntaxException, ParseException {

        when(covidCache.getTotalCovidDataByCountry("Portugal")).thenReturn(this.byCountry);

        ByCountry byCountryFound = covidAPI.getCovidDataByCountry("Portugal");

        verify(covidCache, times(2)).getTotalCovidDataByCountry(anyString());
        assertThat(byCountryFound).isNotNull();
        assertThat(byCountryFound).isEqualTo(byCountry);
    }

    






    
}
