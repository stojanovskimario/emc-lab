package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.domain.User;
import mk.ukim.finki.wp.emtlab.model.dto.CreateReservationDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayReservationDto;

import java.util.List;

public interface ReservationApplicationService {

    List<DisplayReservationDto> findAll();

    DisplayReservationDto reserve(CreateReservationDto createReservationDto, User user);
}

