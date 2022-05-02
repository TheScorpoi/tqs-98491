package tqs.hw1.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import tqs.hw1.model.ByCountry;
import tqs.hw1.service.CovidAPI;

@WebMvcTest(CovidController.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CovidAPI covidAPI;

    @Test
    void getCountryByName() throws Exception {

        ByCountry byCountry = new ByCountry();
        byCountry.setCountry("Portugal");

        when(covidAPI.getCovidDataByCountry("Portugal")).thenReturn(byCountry);

        mockMvc.perform(get("/covid/byCountry/Portugal"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("Portugal"));
    
    
        verify(covidAPI, times(1)).getCovidDataByCountry("Portugal");
    }

    @Test
    void getCountryByNameAndDay() throws Exception {

        ByCountry byCountry = new ByCountry();
        byCountry.setCountry("Portugal");
        byCountry.setDaysearch("2022-04-01");

        when(covidAPI.getCovidDataByCountryAndDay("Portugal", "2022-04-01")).thenReturn(byCountry);

        mockMvc.perform(get("/covid/byCountryAndDay/Portugal/2022-04-01"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("Portugal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.daysearch").value("2022-04-01"));
        
        verify(covidAPI, times(1)).getCovidDataByCountryAndDay("Portugal", "2022-04-01");
    }

    // TODO: Fazer teste para o endpoint da cache

    @Test
    void getCountryByNameWithInvalidName() throws Exception {
        ByCountry byCountry = new ByCountry();
        // byCountry.setCountry("Portugallo");

        when(covidAPI.getCovidDataByCountry("Portugallo")).thenReturn(byCountry);

        mockMvc.perform(get("/covid/byCountry/Portug/allo")).andExpect(status().isNotFound());

        verify(covidAPI, times(0)).getCovidDataByCountry("Portugallo");
    }

    @Test
    void getCountryByNameAndDayInvalidDay() throws Exception {

        ByCountry byCountry = new ByCountry();
        byCountry.setCountry("Portugal");
        byCountry.setDaysearch("2022-04-44");

        mockMvc.perform(get("/covid/byCountryAndDay/Portugal/2022/04/44")).andExpect(status().isNotFound());

        verify(covidAPI, times(0)).getCovidDataByCountry("Portugal");
    }

    @Test
    void testAllAtributesOfByCountryClass() throws Exception {

        ByCountry byCountry = new ByCountry();
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

        when(covidAPI.getCovidDataByCountry("Portugal")).thenReturn(byCountry);

        mockMvc.perform(get("/covid/byCountry/Portugal"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("Portugal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.continente").value("Europe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.population").value(1000000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.new_cases").value(23))
                .andExpect(MockMvcResultMatchers.jsonPath("$.active_cases").value(12))
                .andExpect(MockMvcResultMatchers.jsonPath("$.critical_cases").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.recovered_cases").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cases_per_million").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_cases").value(100))
                .andExpect(MockMvcResultMatchers.jsonPath("$.new_deaths").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.deaths_per_million").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_deaths").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tests_per_million").value(55))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total_tests").value(8722))
                .andExpect(MockMvcResultMatchers.jsonPath("$.daysearch").value("2022-04-22"));

        verify(covidAPI, times(1)).getCovidDataByCountry("Portugal");
    }

}
