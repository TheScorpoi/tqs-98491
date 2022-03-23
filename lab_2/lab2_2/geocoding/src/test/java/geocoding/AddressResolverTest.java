package geocoding;

import connection.ISimpleHttpClient;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock
    ISimpleHttpClient simpleHttpClient;

    @InjectMocks
    AddressResolver addressResolver;

   final private String expected = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\\u00A9 2021 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\","
                + "\"imageAltText\":\"\\u00A9 2021 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},"
                + "\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.640661,\"lng\":-8.656688}},\"locations\":[{\"street\":\"Cais do Alboi\",\"adminArea6\":\"" 
                + "\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\""
                + ":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3800-246\",\""
                + "geocodeQualityCode\":\"B1AAA\",\"geocodeQuality\":\"STREET\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":"
                + "\"s\",\"latLng\":{\"lat\":40.640524,\"lng\":-8.656713},\"displayLatLng\":{\"lat\":40.640524,\"lng\":-8.656713},\"mapUrl\":\"http://open.mapquestapi.com/"
                + "staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.64052368145179,-8.656712986761146|marker-sm-50318A-1&scalebar=true"
                + "&zoom=15&rand=-1065678950\",\"roadMetadata\":null}]}]}";

    @Test
    void whenResolveAlboiGps_returnCaisAlboiAddress() throws ParseException, IOException, URISyntaxException {

        when(simpleHttpClient.doHttpGet(anyString())).thenReturn(expected);

        Optional<Address> result = addressResolver.findAddressForLocation(40.640661, -8.656688);

        assertEquals(result, Optional.of(new Address("Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null)));
    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddress() throws IOException, URISyntaxException, ParseException {

        Optional<Address> result = addressResolver.findAddressForLocation(-300, -810);
        Optional<Address> result2 = addressResolver.findAddressForLocation(1000, 1000);
        Optional<Address> result3 = addressResolver.findAddressForLocation(563, -4);

        assertFalse(result.isPresent());
        assertFalse(result2.isPresent());
        assertFalse(result3.isPresent());

    }
}