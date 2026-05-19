package mk.ukim.finki.wp.emtlab.model.dto;

import mk.ukim.finki.wp.emtlab.model.domain.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public record DisplayReservationDto(
        Long id,
        Long userId,
        String userName,
        Long accommodationId,
        String accommodationName,
        LocalDateTime reservedAt,
        LocalDateTime releaseAt
) {
    public static DisplayReservationDto from(Reservation reservation) {
        return new DisplayReservationDto(
                reservation.getId(),
                reservation.getUser().getId(),
                reservation.getUser().getName() + " " + reservation.getUser().getSurname(),
                reservation.getAccomodation().getId(),
                reservation.getAccomodation().getName(),
                reservation.getReservedAt(),
                reservation.getReleaseAt()
        );
    }

    public static List<DisplayReservationDto> from(List<Reservation> reservations) {
        return reservations
                .stream()
                .map(DisplayReservationDto::from)
                .toList();
    }
}

