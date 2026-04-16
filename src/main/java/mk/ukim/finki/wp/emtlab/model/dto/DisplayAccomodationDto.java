package mk.ukim.finki.wp.emtlab.model.dto;

import jakarta.validation.constraints.Positive;
import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.domain.Host;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.enums.Status;

import java.util.List;

public record DisplayAccomodationDto(
        Long id,
        String name,
        Category category,
        Status status,
        Integer numRooms,
        Long hostId,
        Boolean rented
) {
    public static DisplayAccomodationDto from(Accomodation a) {
        return new DisplayAccomodationDto(
                a.getId(),
                a.getName(),
                a.getCategory(),
                a.getStatus(),
                a.getNumRooms(),
                a.getHost().getId(),
                a.getRented()
        );
    }

    public static List<DisplayAccomodationDto> from(List<Accomodation> a) {
        return a
                .stream()
                .map(DisplayAccomodationDto::from)
                .toList();
    }
}
