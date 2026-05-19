package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.exception.ReservationValidationException;
import mk.ukim.finki.wp.emtlab.model.domain.Reservation;
import mk.ukim.finki.wp.emtlab.service.domain.ReservationService;
import mk.ukim.finki.wp.emtlab.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    @Transactional
    public Reservation reserve(Reservation reservation) {
        if (reservation.getUser() == null || reservation.getUser().getId() == null) {
            throw new ReservationValidationException("Reservation user is missing.");
        }

        if (reservation.getAccomodation() == null || reservation.getAccomodation().getId() == null) {
            throw new ReservationValidationException("Reservation accommodation is missing.");
        }

        if (Objects.equals(
                reservation.getUser().getId(),
                reservation.getAccomodation().getHost().getId()
        )) {
            throw new ReservationValidationException("Host cannot reserve its own accommodation!");
        }

        if (reservationRepository.existsByUserId(reservation.getUser().getId())) {
            throw new ReservationValidationException("User already has a reservation.");
        }

        if (reservationRepository.existsByAccomodationId(reservation.getAccomodation().getId())) {
            throw new ReservationValidationException("Accommodation is already reserved.");
        }

        return reservationRepository.save(reservation);
    }
}

