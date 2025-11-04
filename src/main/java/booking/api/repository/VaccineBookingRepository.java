package booking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import booking.api.model.VaccineBooking;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineBookingRepository extends JpaRepository<VaccineBooking, Long> {

}
