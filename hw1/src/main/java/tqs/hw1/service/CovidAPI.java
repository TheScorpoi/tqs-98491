package tqs.hw1.service;

import java.net.URISyntaxException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tqs.hw1.connection.HTTPClient;
import tqs.hw1.model.ByCountry;

@Service
public class CovidAPI {

    // https://rapidapi.com/api-sports/api/covid-193/details
    
    private static final String URL_BASE = "https://covid-193.p.rapidapi.com";


    private static final Logger log = LoggerFactory.getLogger(CovidAPI.class);

    @Autowired
    private HTTPClient httpClient;

    public String getCovidDataByCountry(String country) throws URISyntaxException, ParseException {
        URIBuilder builder = new URIBuilder(URL_BASE + "/statistics");

        builder.setParameter("country", country);

        String apiResponse = httpClient.request(builder.build().toString());
        convertJsonToByCountryClass(apiResponse);

        //System.out.println(apiResponse);

        //JSONPObject json = new JSONPObject(apiResponse);

        //ir buscar cada argumento e criar uma classe de guarde estes arguemntos todos 

        return apiResponse;
    }

    /*
    public String getCovidDataByCountryAndDay(String country, String day) throws URISyntaxException {
        // https://covid-193.p.rapidapi.com/statistics?country=Portugal&day=2020-04-01 example of url
    
        URIBuilder builder = new URIBuilder(URL_BASE + "/history");
    
        builder.setParameter("country", country);
        builder.setParameter("day", day);
    
        log.info("Requesting data from {}", builder.toString());
    
        String apiResponse = httpClient.request(builder.build().toString());
    
        System.out.println(apiResponse);
    
        //JSONPObject json = new JSONPObject(apiResponse);
    
        //ir buscar cada argumento e criar uma classe de guarde estes arguemntos todos 
    
        return apiResponse;
    }*/
    

    /**
     *  private int new_cases;
    private int active_cases;
    private int critical_cases;
    private int recovered_cases;
    private int cases_per_million;
    private int total_cases;

    private int new_deaths;
    private int deaths_per_million;
    private int total_deaths;

    private int tests_per_million;
    private int total_tests;
     * @throws ParseException

     */


    
    public ByCountry convertJsonToByCountryClass(String apiResponse) throws ParseException {
        log.info("Converting info from json to ByCountry class");

        JSONObject obj = new JSONObject(apiResponse);
        String country = obj.getJSONObject("parameters").getString("country");

        String continent = obj.getJSONArray("response").getJSONObject(0).getString("continent");
        String countryInfo = obj.getJSONArray("response").getJSONObject(0).getString("country");
        // fazer uma verificação se o pais é igual ao do parameters 

        Long population = obj.getJSONArray("response").getJSONObject(0).getLong("population");

        Object obj_new_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("new");
        //int new_cases = obj_new_cases == null ? 0 : (Integer) obj_new_cases;
        Object obj_active_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("active");
        //int active_cases = obj_active_cases == null ? 0 : (Integer) obj_active_cases;
        Object obj_critical_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("critical");
        //int critical_cases = obj_critical_cases == null ? 0 : (Integer) obj_critical_cases;
        Object obj_recovered_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("recovered");
        //int recovered_cases = obj_recovered_cases == null ? 0 : (Integer) obj_recovered_cases;
        Object obj_cases_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("1M_pop");
        //int cases_per_million = obj_cases_per_million == null ? 0 : (Integer) obj_cases_per_million;
        Object obj_total_cases = obj.getJSONArray("response").getJSONObject(0).getJSONObject("cases").get("total");
        //int total_cases = obj_total_cases == null ? 0 : (Integer) obj_total_cases;
        
        Object obj_new_deaths = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("new");
        //int new_deaths = obj_new_deaths == null ? 0 : (Integer) obj_new_deaths;
        Object obj_deaths_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("1M_pop");
        //int deaths_per_million = obj_deaths_per_million == null ? 0 : (Integer) obj_deaths_per_million;
        Object obj_total_deaths = obj.getJSONArray("response").getJSONObject(0).getJSONObject("deaths").get("total");
        //int total_deaths = obj_total_deaths == null ? 0 : (Integer) obj_total_deaths;
        
        Object obj_tests_per_million = obj.getJSONArray("response").getJSONObject(0).getJSONObject("tests").get("1M_pop");
        //int tests_per_million = obj_tests_per_million == null ? 0 : (Integer) obj_tests_per_million;
        Object obj_total_tests = obj.getJSONArray("response").getJSONObject(0).getJSONObject("tests").get("total");
        //int otal_tests = obj_total_tests == null ? 0 : (Integer) obj_total_tests;   

        String date_string = obj.getJSONArray("response").getJSONObject(0).getString("day");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(date_string);

        ByCountry byCountry = new ByCountry(country, continent, population,
                (Integer) obj_new_cases, (Integer) obj_active_cases, (Integer) obj_critical_cases, (Integer) obj_recovered_cases, (Integer) obj_cases_per_million, (Integer) obj_total_cases,
                (Integer) obj_new_deaths, (Integer) obj_deaths_per_million, (Integer) obj_total_deaths, (Integer) obj_tests_per_million, (Integer) obj_total_tests, date);

                System.out.println(byCountry.toString());
        return null;
    }

    public boolean verifyIfObjectHaveNullValue(Object obj) {
        if (obj == null) {
            return true;
        } else {
            return false;
        }
    }
}