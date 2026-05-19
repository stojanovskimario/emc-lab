package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.domain.Reservation;
import mk.ukim.finki.wp.emtlab.model.domain.User;
import mk.ukim.finki.wp.emtlab.model.dto.CreateReservationDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayReservationDto;
import mk.ukim.finki.wp.emtlab.service.application.ReservationApplicationService;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationService;
import mk.ukim.finki.wp.emtlab.service.domain.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationApplicationServiceImpl implements ReservationApplicationService {

    private final ReservationService reservationService;
    private final AccomodationService accomodationService;

    public ReservationApplicationServiceImpl(ReservationService reservationService, AccomodationService accomodationService) {
        this.reservationService = reservationService;
        this.accomodationService = accomodationService;
    }

    @Override
    public List<DisplayReservationDto> findAll() {
        return DisplayReservationDto.from(reservationService.findAll());
    }

    @Override
    @Transactional
    public DisplayReservationDto reserve(CreateReservationDto createReservationDto, User user) {
        Accomodation accomodation = accomodationService
                .findById(createReservationDto.accommodationId())
                .orElseThrow(() -> new RuntimeException("Accommodation not found with id: " + createReservationDto.accommodationId()));

        Reservation reservation = new Reservation(
                user,
                accomodation,
                createReservationDto.reservedAt(),
                createReservationDto.releaseAt()
        );

        return DisplayReservationDto.from(reservationService.reserve(reservation));
    }
}

