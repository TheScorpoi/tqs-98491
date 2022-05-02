package tqs.hw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tqs.hw1.model.ByCountry;

@Repository
public interface ByCountryRepository extends JpaRepository<ByCountry, Integer> {

    ByCountry findByCountry(String country);
    ByCountry findByCountryAndDaysearch(String country, String day);
}
