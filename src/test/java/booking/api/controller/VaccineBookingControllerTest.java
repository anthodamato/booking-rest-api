package booking.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestClientException;

import booking.api.Application;
import booking.api.dto.VaccineBookingDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class VaccineBookingControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void givenVB_WhenPost_ThenCreated() throws MalformedURLException, RestClientException, URISyntaxException {
		URL url = new URL("http://localhost:" + port + "/book");
		VaccineBookingDto vaccineBookingDto = new VaccineBookingDto();
		vaccineBookingDto.setDateOf(LocalDateTime.now());
		vaccineBookingDto.setOrdinalNumber(1);
		vaccineBookingDto.setAddress("London Excel");

		ResponseEntity<RestResponse> response = testRestTemplate.postForEntity(url.toURI(), vaccineBookingDto,
				RestResponse.class);
		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
		RestResponse restResponse = response.getBody();
		assertNotNull(restResponse);
		VaccineBookingDto vbDto = restResponse.getVaccineBookingDto();
		assertEquals(1, vbDto.getOrdinalNumber());
		assertEquals("London Excel", vbDto.getAddress());
	}
}
