package tqs.hw1.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;

import tqs.hw1.connection.HTTPClient;

@Component
public class CovidAPI {

    // https://rapidapi.com/api-sports/api/covid-193/details
    
    private static final String URL_BASE = "https://covid-193.p.rapidapi.com";


    private static final Logger log = LoggerFactory.getLogger(CovidAPI.class);

    @Autowired
    private HTTPClient httpClient;

    public String getCovidDataByCountry(String country) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(URL_BASE + "/statistics");

        builder.setParameter("country", country);

        log.info("Requesting data from {}", builder.toString());

        String apiResponse = httpClient.request(builder.build().toString());

        System.out.println(apiResponse);

        //JSONPObject json = new JSONPObject(apiResponse);

        //ir buscar cada argumento e criar uma classe de guarde estes arguemntos todos 

        return apiResponse;
    }

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
    }
    
}