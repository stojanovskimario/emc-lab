package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.domain.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAll();

    Reservation reserve(Reservation reservation);
}

