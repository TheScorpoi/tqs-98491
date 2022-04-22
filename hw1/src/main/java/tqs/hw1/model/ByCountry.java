package tqs.hw1.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "by_country")
public class ByCountry implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @CreationTimestamp
    private Timestamp creationDate;

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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public Integer getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(Integer new_cases) {
        this.new_cases = new_cases;
    }

    public Integer getActive_cases() {
        return active_cases;
    }

    public void setActive_cases(Integer active_cases) {
        this.active_cases = active_cases;
    }

    public Integer getCritical_cases() {
        return critical_cases;
    }

    public void setCritical_cases(Integer critical_cases) {
        this.critical_cases = critical_cases;
    }

    public Integer getRecovered_cases() {
        return recovered_cases;
    }

    public void setRecovered_cases(Integer recovered_cases) {
        this.recovered_cases = recovered_cases;
    }

    public Integer getCases_per_million() {
        return cases_per_million;
    }

    public void setCases_per_million(Integer cases_per_million) {
        this.cases_per_million = cases_per_million;
    }

    public Integer getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(Integer total_cases) {
        this.total_cases = total_cases;
    }

    public Integer getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(Integer new_deaths) {
        this.new_deaths = new_deaths;
    }

    public Integer getDeaths_per_million() {
        return deaths_per_million;
    }

    public void setDeaths_per_million(Integer deaths_per_million) {
        this.deaths_per_million = deaths_per_million;
    }

    public Integer getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(Integer total_deaths) {
        this.total_deaths = total_deaths;
    }

    public Integer getTests_per_million() {
        return tests_per_million;
    }

    public void setTests_per_million(Integer tests_per_million) {
        this.tests_per_million = tests_per_million;
    }

    public Integer getTotal_tests() {
        return total_tests;
    }

    public void setTotal_tests(Integer total_tests) {
        this.total_tests = total_tests;
    }

    public String getDaysearch() {
        return daysearch;
    }

    public void setDaysearch(String daysearch) {
        this.daysearch = daysearch;
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
