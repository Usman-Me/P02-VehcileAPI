package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.ws.rs.core.MediaType;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters


public class PricingServiceApplicationTests {
	@Autowired
	private MockMvc MockMvc;






	@MockBean
	PricingService pricingService;

	@Test
	public void contextLoads() {
	}
	/*
	 * Fahrzeug mit Validen Preisangaben Testen
	 * */
	@Test
	public void PriceWithVehicleID_Valid() throws Exception{
		 MockMvc.perform(get("/services/price").param("vehicleId", "1"))
				.andExpect(status().isOk());
	}
	/*
	 * Fahrzeug mit Invaliden Preisangaben Testen
	 * */
	@Test
	public void PriceWithVehicleID_Invalid() throws Exception{
		MockMvc.perform(get("/services/price").param("vehicleId","100"))
				.andExpect(status().isNotFound());

	}

}
