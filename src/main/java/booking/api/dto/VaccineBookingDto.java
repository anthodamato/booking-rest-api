package booking.api.dto;

import booking.api.model.VaccineBooking;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VaccineBookingDto {
	private Long id;
	@NotNull(message = "Vaccination date cannot be null")
	private LocalDateTime dateOf;
	@NotNull(message = "Dose order cannot be null")
	private Integer ordinalNumber;
	@NotEmpty(message = "Address cannot be empty")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateOf() {
		return dateOf;
	}

	public void setDateOf(LocalDateTime dateOf) {
		this.dateOf = dateOf;
	}

	public Integer getOrdinalNumber() {
		return ordinalNumber;
	}

	public void setOrdinalNumber(Integer ordinal_number) {
		this.ordinalNumber = ordinal_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static VaccineBookingDto of(VaccineBooking vaccineBooking) {
		VaccineBookingDto vaccineBookingDto = new VaccineBookingDto();
		vaccineBookingDto.setAddress(vaccineBooking.getAddress());
		vaccineBookingDto.setDateOf(vaccineBooking.getDateOf());
		vaccineBookingDto.setId(vaccineBooking.getId());
		vaccineBookingDto.setOrdinalNumber(vaccineBooking.getOrdinalNumber());
		return vaccineBookingDto;
	}
}
