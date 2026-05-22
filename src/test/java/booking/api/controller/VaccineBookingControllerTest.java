package booking.api.controller;

import booking.api.dto.VaccineBookingDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestClientException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class VaccineBookingControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void createBookingVaccine() throws MalformedURLException, RestClientException, URISyntaxException {
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
