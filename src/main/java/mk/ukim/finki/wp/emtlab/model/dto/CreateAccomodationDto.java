package mk.ukim.finki.wp.emtlab.model.dto;

import jakarta.validation.constraints.Positive;
import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.domain.Host;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.enums.Status;

import java.math.BigDecimal;

public record CreateAccomodationDto(
        String name,
        Category category,
        Status status,
        @Positive
        Integer numRooms,
        Long hostId,
        Boolean rented
) {
    public Accomodation toAccomodation(Host host) {
        return new Accomodation(name, category, host, status, numRooms,rented);
    }
}
