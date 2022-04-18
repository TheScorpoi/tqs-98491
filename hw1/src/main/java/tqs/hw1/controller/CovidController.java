package tqs.hw1.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import tqs.hw1.service.CovidAPI;

@RestController
@RequestMapping("/covid")
public class CovidController {

    @Autowired
    private CovidAPI covidAPI;

    @GetMapping("/byCountry/{country}")
    public ResponseEntity<String> getCovidDataByCountry(@PathVariable String country) throws URISyntaxException {
        return new ResponseEntity<>(covidAPI.getCovidDataByCountry(country), HttpStatus.OK);
    }
    
    @GetMapping("/byCountryAndDay/{country}/{day}")
    public ResponseEntity<String> getCovidDataByCountryAndDay(@PathVariable String country, @PathVariable String day) throws URISyntaxException {
        return new ResponseEntity<>(covidAPI.getCovidDataByCountryAndDay(country, day), HttpStatus.OK);
    }

}