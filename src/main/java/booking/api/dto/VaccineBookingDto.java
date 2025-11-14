package booking.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

}
