package tqs.hw1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "by_country")
public class ByCountry implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String country;    
    private String continente;
    private long population;
    private Integer new_cases;
    private Integer active_cases;
    private Integer critical_cases;
    private Integer recovered_cases;
    private Integer cases_per_million;
    private Integer total_cases;
    private Integer new_deaths;
    private Integer deaths_per_million;
    private Integer total_deaths;
    private Integer tests_per_million;
    private Integer total_tests;
    private String daysearch;

    public ByCountry() {
    }

    public ByCountry(String country, String continente, long population, int new_cases, int active_cases,
            int critical_cases, int recovered_cases, int cases_per_million, int total_cases, int new_deaths,
            int deaths_per_million, int total_deaths, int tests_per_million, int total_tests, String daysearch) {
        this.country = country;
        this.continente = continente;
        this.population = population;
        this.new_cases = new_cases;
        this.active_cases = active_cases;
        this.critical_cases = critical_cases;
        this.recovered_cases = recovered_cases;
        this.cases_per_million = cases_per_million;
        this.total_cases = total_cases;
        this.new_deaths = new_deaths;
        this.deaths_per_million = deaths_per_million;
        this.total_deaths = total_deaths;
        this.tests_per_million = tests_per_million;
        this.total_tests = total_tests;
        this.daysearch = daysearch;
    }

    public ByCountry(String country, String daysearch, int new_cases, int actieve_cases, int critical_cases,
            int recovered_cases, int cases_per_million, int total_cases, int new_deaths, int deaths_per_million,
            int total_deaths, int tests_per_million, int total_tests) {

        this.country = country;
        this.daysearch = daysearch;
        this.new_cases = new_cases;
        this.active_cases = actieve_cases;
        this.critical_cases = critical_cases;
        this.recovered_cases = recovered_cases;
        this.cases_per_million = cases_per_million;
        this.total_cases = total_cases;
        this.new_deaths = new_deaths;
        this.deaths_per_million = deaths_per_million;
        this.total_deaths = total_deaths;
        this.tests_per_million = tests_per_million;
        this.total_tests = total_tests;
    }

    @Override
    public String toString() {
        return "ByCountry [active_cases=" + active_cases + ", cases_per_million=" + cases_per_million + ", continente="
                + continente + ", country=" + country + ", critical_cases=" + critical_cases + ", daysearch="
                + daysearch + ", deaths_per_million=" + deaths_per_million + ", id=" + id + ", new_cases=" + new_cases
                + ", new_deaths=" + new_deaths + ", population=" + population + ", recovered_cases=" + recovered_cases
                + ", tests_per_million=" + tests_per_million + ", total_cases=" + total_cases + ", total_deaths="
                + total_deaths + ", total_tests=" + total_tests + "]";
    }
    
    
}
