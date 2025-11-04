package booking.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import booking.api.model.VaccineBooking;
import booking.api.dto.VaccineBookingDto;
import booking.api.service.VaccineBookingService;

@RestController
public class VaccineBookingController {
	private Logger log = LoggerFactory.getLogger(VaccineBookingController.class);
	@Autowired
	private VaccineBookingService vaccineBookingService;

	@PostMapping(path = "/book")
	public ResponseEntity<RestResponse> save(@Valid @RequestBody VaccineBookingDto vaccineBookingDto) {
		VaccineBooking vaccineBooking = vaccineBookingService.save(vaccineBookingDto);
		RestResponse restResponse = new RestResponse();
		restResponse.setVaccineBookingDto(VaccineBookingDto.of(vaccineBooking));
		log.info("Vaccine Booking Created id={}", vaccineBooking.getId());
		return new ResponseEntity<RestResponse>(restResponse, HttpStatus.CREATED);
	}
}
