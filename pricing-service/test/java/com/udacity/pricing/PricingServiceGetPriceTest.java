package com.udacity.pricing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class PricingServiceGetPriceTest {

    @LocalServerPort
    private int port=8762;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void getPrice() {
        ResponseEntity<String> price = this.testRestTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=1", String.class);
        assert price.getStatusCode() == HttpStatus.OK;
    }
}
