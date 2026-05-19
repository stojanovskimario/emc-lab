package mk.ukim.finki.wp.emtlab.model.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateReservationDto(
        @NotNull
        Long accommodationId,
        @NotNull
        LocalDateTime reservedAt,
        @NotNull
        LocalDateTime releaseAt
) {
}

