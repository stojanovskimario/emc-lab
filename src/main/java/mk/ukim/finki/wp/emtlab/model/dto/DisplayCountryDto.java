package mk.ukim.finki.wp.emtlab.model.dto;

import mk.ukim.finki.wp.emtlab.model.domain.Country;

import java.util.List;

public record DisplayCountryDto(
        Long id,
        String name,
        String continent
) {
    public static DisplayCountryDto from(Country c) {
        return new DisplayCountryDto(
                c.getId(),
                c.getName(),
                c.getContinent()
        );
    }

    public static List<DisplayCountryDto> from(List<Country> c) {
        return c
                .stream()
                .map(DisplayCountryDto::from)
                .toList();
    }
}
