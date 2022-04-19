package tqs.hw1.model;

import java.util.Date;

public class ByCountry {

    private String country;
    private String continente;
    private Long population;

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

    private Date day;

    public ByCountry(String country, String continente, long population, int new_cases, int active_cases,
            int critical_cases, int recovered_cases, int cases_per_million, int total_cases, int new_deaths,
            int deaths_per_million, int total_deaths, int tests_per_million, int total_tests, Date day) {
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
        this.day = day;
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

    public int getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(int new_cases) {
        this.new_cases = new_cases;
    }

    public int getActive_cases() {
        return active_cases;
    }

    public void setActive_cases(int active_cases) {
        this.active_cases = active_cases;
    }

    public int getCritical_cases() {
        return critical_cases;
    }

    public void setCritical_cases(int critical_cases) {
        this.critical_cases = critical_cases;
    }

    public int getRecovered_cases() {
        return recovered_cases;
    }

    public void setRecovered_cases(int recovered_cases) {
        this.recovered_cases = recovered_cases;
    }

    public int getCases_per_million() {
        return cases_per_million;
    }

    public void setCases_per_million(int cases_per_million) {
        this.cases_per_million = cases_per_million;
    }

    public int getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(int total_cases) {
        this.total_cases = total_cases;
    }

    public int getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(int new_deaths) {
        this.new_deaths = new_deaths;
    }

    public int getDeaths_per_million() {
        return deaths_per_million;
    }

    public void setDeaths_per_million(int deaths_per_million) {
        this.deaths_per_million = deaths_per_million;
    }

    public int getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(int total_deaths) {
        this.total_deaths = total_deaths;
    }

    public int getTests_per_million() {
        return tests_per_million;
    }

    public void setTests_per_million(int tests_per_million) {
        this.tests_per_million = tests_per_million;
    }

    public int getTotal_tests() {
        return total_tests;
    }

    public void setTotal_tests(int total_tests) {
        this.total_tests = total_tests;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + active_cases;
        result = prime * result + cases_per_million;
        result = prime * result + ((continente == null) ? 0 : continente.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + critical_cases;
        result = prime * result + ((day == null) ? 0 : day.hashCode());
        result = prime * result + deaths_per_million;
        result = prime * result + new_cases;
        result = prime * result + new_deaths;
        result = prime * result + (int) (population ^ (population >>> 32));
        result = prime * result + recovered_cases;
        result = prime * result + tests_per_million;
        result = prime * result + total_cases;
        result = prime * result + total_deaths;
        result = prime * result + total_tests;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ByCountry other = (ByCountry) obj;
        if (active_cases != other.active_cases)
            return false;
        if (cases_per_million != other.cases_per_million)
            return false;
        if (continente == null) {
            if (other.continente != null)
                return false;
        } else if (!continente.equals(other.continente))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (critical_cases != other.critical_cases)
            return false;
        if (day == null) {
            if (other.day != null)
                return false;
        } else if (!day.equals(other.day))
            return false;
        if (deaths_per_million != other.deaths_per_million)
            return false;
        if (new_cases != other.new_cases)
            return false;
        if (new_deaths != other.new_deaths)
            return false;
        if (population != other.population)
            return false;
        if (recovered_cases != other.recovered_cases)
            return false;
        if (tests_per_million != other.tests_per_million)
            return false;
        if (total_cases != other.total_cases)
            return false;
        if (total_deaths != other.total_deaths)
            return false;
        if (total_tests != other.total_tests)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ByCountry [active_cases=" + active_cases + ", cases_per_million=" + cases_per_million + ", continente="
                + continente + ", country=" + country + ", critical_cases=" + critical_cases + ", day=" + day
                + ", deaths_per_million=" + deaths_per_million + ", new_cases=" + new_cases + ", new_deaths="
                + new_deaths + ", population=" + population + ", recovered_cases=" + recovered_cases
                + ", tests_per_million=" + tests_per_million + ", total_cases=" + total_cases + ", total_deaths="
                + total_deaths + ", total_tests=" + total_tests + "]";
    }

}
