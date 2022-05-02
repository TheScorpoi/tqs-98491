package tqs.hw1.service;

import java.net.URISyntaxException;
import java.text.ParseException;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tqs.hw1.cache.CovidCache;
import tqs.hw1.connection.HTTPClient;
import tqs.hw1.model.ByCountry;
import tqs.hw1.repository.ByCountryRepository;

@Service
public class CovidAPI {
    // https://rapidapi.com/api-sports/api/covid-193/details
    private static final String URL_BASE = "https://covid-193.p.rapidapi.com";
    private static final Logger log = LoggerFactory.getLogger(CovidAPI.class);

    @Autowired
    private HTTPClient httpClient;

    @Autowired
    private CovidCache covidCache;

    @Autowired
    private ByCountryRepository byCountryRepository;
    
    public ByCountry getCovidDataByCountry(String country) throws URISyntaxException, ParseException {
        URIBuilder builder = new URIBuilder(URL_BASE + "/statistics");

        builder.setParameter("country", country);

        if (covidCache.getTotalCovidDataByCountry(country) == null) {
            String apiResponse = httpClient.request(builder.build().toString());
            ByCountry result = convertJsonToByCountryClass(apiResponse);
            byCountryRepository.save(result);
            return result;
        } else {
            return covidCache.getTotalCovidDataByCountry(country);
        }
       
    }

    public ByCountry getCovidDataByCountryAndDay(String country, String day) throws URISyntaxException, ParseException {
        // https://covid-193.p.rapidapi.com/history?country=Portugal&day=2020-04-01 example of url    
        URIBuilder builder = new URIBuilder(URL_BASE + "/history");

        builder.setParameter("country", country);
        builder.setParameter("day", day);

        if (covidCache.getCovidDataByCountryAndDay(country, day) == null) {
            String apiResponse = httpClient.request(builder.build().toString());
            ByCountry result = convertJsonToByCountryClass(apiResponse);
            byCountryRepository.save(result);
            return result;
        } else {
            return covidCache.getCovidDataByCountryAndDay(country, day);
        }
    }
    
    public String getCacheStats() {
        return "{\"Cache_hits\":" + covidCache.getN_hits() + ", \"Cache_misses\":" + covidCache.getN_misses() + "}";
    }

    public ByCountry convertJsonToByCountryClass(String apiResponse) throws ParseException {
        log.info("Converting info from json to ByCountry class");

        JSONObject obj = new JSONObject(apiResponse);
        String country = obj.getJSONObject("parameters").getString("country");

        String continent = obj.getJSONArray("response").getJSONObject(0).getString("continent");
        //String countryInfo = obj.getJSONArray("response").getJSONObject(0).getString("country");

        Long population = obj.getJSONArray("response").getJSONObject(0).getLong("population");

        Object obj_new_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("new");
        int new_cases;
        if (obj_new_cases.equals(null)) {
            new_cases = 0;
        } else {
            String new_cases_string = obj_new_cases.toString();
            String splited = new_cases_string.replace("+", "");
            new_cases = Integer.parseInt(splited);
        }

        Object obj_active_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("active");
        int active_cases = verifyIfObjectHaveNullValue(obj_active_cases) ? 0 : (Integer) obj_active_cases;
        Object obj_critical_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases")
                .get("critical");
        int critical_cases = verifyIfObjectHaveNullValue(obj_critical_cases) ? 0 : (Integer) obj_critical_cases;
        Object obj_recovered_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases")
                .get("recovered");
        int recovered_cases = verifyIfObjectHaveNullValue(obj_recovered_cases) ? 0 : (Integer) obj_recovered_cases;
        String obj_cases_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases")
                .getString("1M_pop");
        int cases_per_million = Integer.parseInt(obj_cases_per_million);
        Object obj_total_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("total");
        int total_cases = verifyIfObjectHaveNullValue(obj_total_cases) ? 0 : (Integer) obj_total_cases;

        Object obj_new_deaths = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("new");
        int new_deaths;
        if (obj_new_deaths.equals(null)) {
            new_deaths = 0;
        } else {
            String new_deaths_string = obj_new_deaths.toString();
            String splited = new_deaths_string.replace("+", "");
            new_deaths = Integer.parseInt(splited);
        }

        String obj_deaths_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths")
                .getString("1M_pop");
        int deaths_per_million = Integer.parseInt(obj_deaths_per_million);
        Object obj_total_deaths = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("total");
        int total_deaths = verifyIfObjectHaveNullValue(obj_total_deaths) ? 0 : (Integer) obj_total_deaths;

        String obj_tests_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("tests")
                .getString("1M_pop");
        int tests_per_million = Integer.parseInt(obj_tests_per_million);
        Object obj_total_tests = obj.getJSONArray("response").getJSONObject(0).getJSONObject("tests").get("total");
        int total_tests = verifyIfObjectHaveNullValue(obj_total_tests) ? 0 : (Integer) obj_total_tests;

        String day = obj.getJSONArray("response").getJSONObject(0).getString("day");

        ByCountry byCountry = new ByCountry(country, continent, population,
                new_cases, active_cases, critical_cases, recovered_cases, cases_per_million, total_cases,
                new_deaths, deaths_per_million, total_deaths, tests_per_million, total_tests, day);

        return byCountry;
    }
    
    public ByCountry convertJsonToByCountryClassWithDates(String apiResponse) throws ParseException {
        log.info("Converting info from json to ByCountry class");

        JSONObject obj = new JSONObject(apiResponse);
        String country = obj.getJSONObject("parameters").getString("country");
        String day = obj.getJSONArray("response").getJSONObject(0).getString("day");


        Object obj_new_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("new");
        int new_cases;
        if (obj_new_cases.equals(null)) {
            new_cases = 0;
        } else {
            String new_cases_string = obj_new_cases.toString();
            String splited = new_cases_string.replace("+", "");
            new_cases = Integer.parseInt(splited);
        }
        Object obj_active_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("active");
        int active_cases = verifyIfObjectHaveNullValue(obj_active_cases) ? 0 : (Integer) obj_active_cases;
        Object obj_critical_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("critical");
        int critical_cases = verifyIfObjectHaveNullValue(obj_critical_cases) ? 0 : (Integer) obj_critical_cases;
        Object obj_recovered_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("recovered");
        int recovered_cases = verifyIfObjectHaveNullValue(obj_recovered_cases) ? 0 : (Integer) obj_recovered_cases;
        String obj_cases_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").getString("1M_pop");
        int cases_per_million = Integer.parseInt(obj_cases_per_million);
        Object obj_total_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("total");
        int total_cases = verifyIfObjectHaveNullValue(obj_total_cases) ? 0 : (Integer) obj_total_cases;

        Object obj_new_deaths = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("new");
        int new_deaths;
        if (obj_new_deaths.equals(null)) {
            new_deaths = 0;
        } else {
            String new_deaths_string = obj_new_deaths.toString();
            String splited = new_deaths_string.replace("+", "");
            new_deaths = Integer.parseInt(splited);
        }

        Object obj_deaths_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("1M_pop");
        int deaths_per_million;
        if (obj_deaths_per_million.equals(null)) {
            deaths_per_million = 0;
        } else {
            String deaths_per_million_string = obj_deaths_per_million.toString();
            String splited = deaths_per_million_string.replace("+", "");
            deaths_per_million = Integer.parseInt(splited);
        }
        
        Object obj_total_deaths = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("total");
        int total_deaths = verifyIfObjectHaveNullValue(obj_total_deaths) ? 0 : (Integer) obj_total_deaths;

        Object obj_tests_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("tests").get("1M_pop");
        int tests_per_million;
        if (obj_tests_per_million.equals(null)) {
            tests_per_million = 0;
        } else {
            String tests_per_million_string = obj_tests_per_million.toString();
            String splited = tests_per_million_string.replace("+", "");
            tests_per_million = Integer.parseInt(splited);
        }

        
        Object obj_total_tests = obj.getJSONArray("response").getJSONObject(0).getJSONObject("tests").get("total");
        int total_tests = verifyIfObjectHaveNullValue(obj_total_tests) ? 0 : (Integer) obj_total_tests;

        ByCountry byCountry = new ByCountry(country, day, new_cases, active_cases, critical_cases, recovered_cases, cases_per_million, total_cases,
                new_deaths, deaths_per_million, total_deaths, tests_per_million, total_tests);

        return byCountry;
    }

    public boolean verifyIfObjectHaveNullValue(Object obj) {
        if (obj.equals(null)) {
            return true;
        } else {
            return false;
        }

    }

}