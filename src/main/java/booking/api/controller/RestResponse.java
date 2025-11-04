package booking.api.controller;

import booking.api.dto.VaccineBookingDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RestResponse {
	private String status;
	private String message;
	private VaccineBookingDto vaccineBookingDto;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public VaccineBookingDto getVaccineBookingDto() {
		return vaccineBookingDto;
	}

	public void setVaccineBookingDto(VaccineBookingDto vaccineBookingDto) {
		this.vaccineBookingDto = vaccineBookingDto;
	}

}
