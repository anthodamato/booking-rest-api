package booking.api.controller;

import booking.api.dto.VaccineBookingDto;
import booking.api.model.VaccineBooking;
import booking.api.service.VaccineBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class VaccineBookingController {
    private Logger log = LoggerFactory.getLogger(VaccineBookingController.class);
    @Autowired
    private VaccineBookingService vaccineBookingService;

    @PostMapping(path = "/book")
    public ResponseEntity<RestResponse> save(@Valid @RequestBody VaccineBookingDto vaccineBookingDto) {
        VaccineBooking vaccineBooking = convertToEntity(vaccineBookingDto);
        VaccineBooking vaccineBookingNew = vaccineBookingService.save(vaccineBooking);
        RestResponse restResponse = new RestResponse();
        restResponse.setVaccineBookingDto(convertToDto(vaccineBookingNew));
        log.info("Vaccine Booking Created id={}", vaccineBookingNew.getId());
        return new ResponseEntity<>(restResponse, HttpStatus.CREATED);
    }

    private VaccineBooking convertToEntity(VaccineBookingDto vaccineBookingDto) {
        VaccineBooking vaccineBooking = new VaccineBooking();
        vaccineBooking.setCreatedAt(LocalDateTime.now());
        vaccineBooking.setDateOf(vaccineBookingDto.getDateOf());
        vaccineBooking.setOrdinalNumber(vaccineBookingDto.getOrdinalNumber());
        vaccineBooking.setAddress(vaccineBookingDto.getAddress());
        return vaccineBooking;
    }

    private VaccineBookingDto convertToDto(VaccineBooking vaccineBooking) {
        VaccineBookingDto vaccineBookingDto = new VaccineBookingDto();
        vaccineBookingDto.setAddress(vaccineBooking.getAddress());
        vaccineBookingDto.setDateOf(vaccineBooking.getDateOf());
        vaccineBookingDto.setId(vaccineBooking.getId());
        vaccineBookingDto.setOrdinalNumber(vaccineBooking.getOrdinalNumber());
        return vaccineBookingDto;
    }
}
