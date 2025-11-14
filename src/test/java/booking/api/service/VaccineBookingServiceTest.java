package booking.api.service;

import booking.api.model.VaccineBooking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VaccineBookingServiceTest {
    @Autowired
    private VaccineBookingService vaccineBookingService;

    @Test
    public void saveVaccineBooking() {
        VaccineBooking vaccineBooking = new VaccineBooking();
        vaccineBooking.setCreatedAt(LocalDateTime.now());
        vaccineBooking.setDateOf(LocalDateTime.now());
        vaccineBooking.setOrdinalNumber(2);
        vaccineBooking.setAddress("Maryland");
        VaccineBooking vaccineBookingSaved = vaccineBookingService.save(vaccineBooking);
        assertNotNull(vaccineBookingSaved);
        assertNotNull(vaccineBookingSaved.getId());
        assertEquals("Maryland", vaccineBookingSaved.getAddress());

        Optional<VaccineBooking> optionalVaccineBookingById = vaccineBookingService.findById(vaccineBookingSaved.getId());
        assertTrue(optionalVaccineBookingById.isPresent());
        VaccineBooking vaccineBookingById = optionalVaccineBookingById.get();
        assertEquals(vaccineBookingSaved.getId(), vaccineBookingById.getId());
        assertEquals(vaccineBookingSaved.getAddress(), vaccineBookingById.getAddress());
    }
}
