package tqs.hw1.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tqs.hw1.model.ByCountry;
import tqs.hw1.repository.ByCountryRepository;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CovidCache {

    @Autowired
    private ByCountryRepository byCountryRepository;

    private static final Logger log = LoggerFactory.getLogger(CovidCache.class);
    private int timeToLive = 60; // seconds

    private int n_misses = 0;
    private int n_hits = 0;

    public ByCountry getTotalCovidDataByCountry(String country) {
        ByCountry byCountry = byCountryRepository.findByCountry(country);

        if (byCountry == null) {
            log.info("Cache miss for country: " + country);
            n_misses++;
            return null;
        } else {
            if (isExpired(byCountry)) {
                log.info("Information is expired on cache");
                log.info("Deleting information from cache");
                byCountryRepository.delete(byCountry);
                n_misses++;
                return null;
            } else {
                log.info("Cache hit for country: " + country);
                n_hits++;    
                return byCountry;
            }
        }
    }

    public ByCountry getCovidDataByCountryAndDay(String country, String day) {
        ByCountry byCountry = byCountryRepository.findByCountryAndDaysearch(country, day);
        if (byCountry == null) {
            log.info("Cache miss for country: " + country);
            n_misses++;
            return null;
        } else {

            if (isExpired(byCountry)) {
                log.info("Information is expired on cache");
                log.info("Deleting information from cache");
                byCountryRepository.delete(byCountry);
                n_misses++;
                return null;
            } else {
                log.info("Cache hit for country: " + country);
                n_hits++;
                return byCountry;
            }
        }
    }

    public boolean isExpired(ByCountry byCountry) {
        long now = System.currentTimeMillis();
        Timestamp lastUpdate = byCountry.getCreationDate();
        long diff = now - lastUpdate.getTime();
        return diff > timeToLive * 1000;
    }

    public int getN_misses() {
        return n_misses;
    }

    public int getN_hits() {
        return n_hits;
    }
}
