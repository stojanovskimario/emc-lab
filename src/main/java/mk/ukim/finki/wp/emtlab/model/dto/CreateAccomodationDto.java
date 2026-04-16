package mk.ukim.finki.wp.emtlab.model.dto;

import jakarta.validation.constraints.PositiveOrZero;
import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.domain.Host;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.enums.Status;

public record CreateAccomodationDto(
        String name,
        Category category,
        Status status,
        @PositiveOrZero
        Integer numRooms,
        Long hostId,
        Boolean rented
) {
    public Accomodation toAccomodation(Host host) {
        return new Accomodation(name, category, host, status, numRooms,rented);
    }
}
