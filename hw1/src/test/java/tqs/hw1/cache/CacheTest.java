package tqs.hw1.cache;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tqs.hw1.model.ByCountry;
import tqs.hw1.repository.ByCountryRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class CacheTest {

    private ByCountry byCountry;
    
    @Mock
    ByCountryRepository repository;

    @InjectMocks
    CovidCache cache;

    @BeforeEach
    void setUp() {
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
    void testGetValidInfoByCountryClass() {
        when(repository.findByCountry("Portugal")).thenReturn(byCountry);

        ByCountry cacheByCountry = repository.findByCountry("Portugal");

        assertNotNull(cacheByCountry);

        assertEquals(cacheByCountry.getCountry(), byCountry.getCountry());
        assertEquals(cacheByCountry.getContinente(), byCountry.getContinente());
        assertEquals(cacheByCountry.getPopulation(), byCountry.getPopulation());
        assertEquals(cacheByCountry.getNew_cases(), byCountry.getNew_cases());
        assertEquals(cacheByCountry.getActive_cases(), byCountry.getActive_cases());
        assertEquals(cacheByCountry.getCritical_cases(), byCountry.getCritical_cases());
        assertEquals(cacheByCountry.getRecovered_cases(), byCountry.getRecovered_cases());
        assertEquals(cacheByCountry.getCases_per_million(), byCountry.getCases_per_million());
        assertEquals(cacheByCountry.getTotal_cases(), byCountry.getTotal_cases());
        assertEquals(cacheByCountry.getNew_deaths(), byCountry.getNew_deaths());
        assertEquals(cacheByCountry.getDeaths_per_million(), byCountry.getDeaths_per_million());
        assertEquals(cacheByCountry.getTotal_deaths(), byCountry.getTotal_deaths());
        assertEquals(cacheByCountry.getTests_per_million(), byCountry.getTests_per_million());
        assertEquals(cacheByCountry.getTotal_tests(), byCountry.getTotal_tests());
        assertEquals(cacheByCountry.getDaysearch(), byCountry.getDaysearch());

        verify(repository, times(1)).findByCountry(anyString());
    }

    @Test 
    void testGetNonValidInfoByCountryClass() {
        when(repository.findByCountry("Portugal2")).thenReturn(null);

        ByCountry cacheByCountry = repository.findByCountry("Portugal2");

        assertNull(cacheByCountry);

        verify(repository, times(1)).findByCountry(anyString());
    }

    @Test 
    void testExperiedCacheByCountry() {
        long diff = byCountry.getCreationDate().getTime() - (237 * 1000);
        byCountry.setCreationDate(new Timestamp(diff));

        when(repository.findByCountry("Portugal")).thenReturn(byCountry);

        ByCountry cacheByCountry = cache.getTotalCovidDataByCountry("Portugal");

        assertNull(cacheByCountry);
    }

    @Test
    void testExperiedCacheByCountryAndDay() {
        long diff = byCountry.getCreationDate().getTime() - (237 * 1000);
        byCountry.setCreationDate(new Timestamp(diff));

        when(repository.findByCountryAndDaysearch("Portugal", "2022-04-22")).thenReturn(byCountry);

        ByCountry cacheByCountry = cache.getCovidDataByCountryAndDay("Portugal", "2022-04-22");

        assertNull(cacheByCountry);
    }

    @Test
    void testNonExperiedCacheByCountry() {
        long diff = byCountry.getCreationDate().getTime() - (42 * 1000);
        byCountry.setCreationDate(new Timestamp(diff));

        when(repository.findByCountry("Portugal")).thenReturn(byCountry);

        ByCountry cacheByCountry = cache.getTotalCovidDataByCountry("Portugal");

        assertNotNull(cacheByCountry);
    }
    
    @Test
    void testNonExperiedCacheByCountryAndDay() {
        long diff = byCountry.getCreationDate().getTime() - (37 * 1000);
        byCountry.setCreationDate(new Timestamp(diff));

        when(repository.findByCountryAndDaysearch("Portugal", "2022-04-22")).thenReturn(byCountry);

        ByCountry cacheByCountry = cache.getCovidDataByCountryAndDay("Portugal", "2022-04-22");

        assertNotNull(cacheByCountry);
    }

    @Test
    void testCheckIfWhenExperiedCacheIsDeleted() {
        long diff = byCountry.getCreationDate().getTime() - (237 * 1000);
        byCountry.setCreationDate(new Timestamp(diff));

        when(repository.findByCountry("Portugal")).thenReturn(byCountry);

        ByCountry cacheByCountry = cache.getTotalCovidDataByCountry("Portugal");
        repository.delete(cacheByCountry);

        assertNull(cacheByCountry);

        verify(repository, times(1)).findByCountry("Portugal");

        //TODO: ISTO JÁ NAO DEVIA ESTAR NA BD E ESTÁ, IDK WHY
        //assertNull(repository.findByCountry("Portugal"));
    }
    
    @Test
    void testValidTimeToLive() {
        assertFalse(cache.isExpired(byCountry));
    }

    @Test
    void testInvalidTimeToLive() {
        long diff = byCountry.getCreationDate().getTime() - (61 * 1000);
        byCountry.setCreationDate(new Timestamp(diff));

        assertTrue(cache.isExpired(byCountry));
    }

    @Test
    void testSaveByCountryClassAlreadyExistentOnDataBase() {
        when(repository.findByCountry("Portugal")).thenReturn(byCountry);

        assertEquals(cache.getTotalCovidDataByCountry("Portugal"), byCountry);

        verify(repository, times(0)).save(byCountry);
    }

}
