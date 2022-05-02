package tqs.hw1.connection;

import org.springframework.stereotype.Component;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class HTTPClient {

    private static final Logger log = LoggerFactory.getLogger(HTTPClient.class);

    public String request(String url) {
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;

        try {
            log.info("Requesting data from {}", url);

            HttpGet request = new HttpGet(url);
            request.setHeader("x-rapidapi-host", "covid-193.p.rapidapi.com");
            request.setHeader("x-rapidapi-key", "b17dd8ee0emsh978d6befbd7713ep1ef035jsnf0474879bd38");

            client = org.apache.http.impl.client.HttpClients.createDefault();
            response = client.execute(request);

            HttpEntity entity = response.getEntity();


            return EntityUtils.toString(entity);


        } catch (Exception e) {
            log.error("Error while requesting data from {}", url, e);
            throw new RuntimeException(e);

        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    log.error("Error while closing response", e);
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (Exception e) {
                    log.error("Error while closing client", e);
                }
            }

        }
    }

}
