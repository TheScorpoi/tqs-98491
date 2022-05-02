package tqs.hw1.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tqs.hw1.repository.ByCountryRepository;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private ByCountryRepository byCountryRepository;

    @InjectMocks
    private CovidAPI covidAPI;

    
}
