package mk.ukim.finki.wp.emtlab.model.dto;

import jakarta.validation.constraints.NotBlank;
import mk.ukim.finki.wp.emtlab.model.domain.Country;

public record CreateCountryDto(
        @NotBlank
        String name,
        @NotBlank
        String continent
) {
    public Country toCountry() {
        return new Country(name, continent);
    }
}
