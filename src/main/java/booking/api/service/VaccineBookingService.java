package booking.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booking.api.model.VaccineBooking;
import booking.api.dto.VaccineBookingDto;
import booking.api.repository.VaccineBookingRepository;

import jakarta.transaction.Transactional;

@Service
public class VaccineBookingService {
	@Autowired
	private VaccineBookingRepository vaccineBookingRepository;

	@Transactional
	public VaccineBooking save(VaccineBookingDto vaccineBookingDto) {
		VaccineBooking vaccineBooking = new VaccineBooking();
		vaccineBooking.setCreatedAt(LocalDateTime.now());
		vaccineBooking.setDateOf(vaccineBookingDto.getDateOf());
		vaccineBooking.setOrdinalNumber(vaccineBookingDto.getOrdinalNumber());
		vaccineBooking.setAddress(vaccineBookingDto.getAddress());
		return vaccineBookingRepository.save(vaccineBooking);
	}
}
