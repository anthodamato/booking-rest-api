package booking.api.service;

import booking.api.model.VaccineBooking;
import booking.api.repository.VaccineBookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccineBookingService {
    @Autowired
    private VaccineBookingRepository vaccineBookingRepository;

    @Transactional
    public VaccineBooking save(VaccineBooking vaccineBooking) {
        return vaccineBookingRepository.save(vaccineBooking);
    }

    public Optional<VaccineBooking> findById(Long id) {
        return vaccineBookingRepository.findById(id);
    }
}
