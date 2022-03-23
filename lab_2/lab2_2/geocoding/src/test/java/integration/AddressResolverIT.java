package integration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;

public class AddressResolverIT {

    private AddressResolver addressResolver;

    @BeforeEach
    public void init() {
        addressResolver = new AddressResolver(new TqsBasicHttpClient());
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {

        Optional<Address> result = addressResolver.findAddressForLocation(40.640661, -8.656688);
        assertEquals(result, Optional.of(new Address("Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null)));
    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddrress() throws IOException, URISyntaxException, ParseException {

        Optional<Address> result = addressResolver.findAddressForLocation(-300, -810);

        assertFalse(result.isPresent());

        
    }

}
