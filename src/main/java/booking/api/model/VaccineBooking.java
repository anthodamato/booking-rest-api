package booking.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class VaccineBooking extends BasicEntity {

	private LocalDateTime dateOf;
	private Integer ordinalNumber;
	private String address;

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

}
