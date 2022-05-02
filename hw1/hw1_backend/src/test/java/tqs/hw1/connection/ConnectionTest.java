package tqs.hw1.connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class ConnectionTest {

    private HTTPClient httpClient;

    @BeforeEach
    public void setUp() {
        httpClient = new HTTPClient();
    }

    @Test
    void testWhenRequestWithInvalidURL() {
        assertThrows(RuntimeException.class, () -> httpClient.request("thdfbgdcgsfx"));
    }

    @Test
    void testWhenRequestWithValidURL() {
        assertThat(httpClient.request("https://covid-193.p.rapidapi.com/history")).isNotNull();
    }

    
}
