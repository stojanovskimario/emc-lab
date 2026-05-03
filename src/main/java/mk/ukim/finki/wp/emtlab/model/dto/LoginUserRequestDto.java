package mk.ukim.finki.wp.emtlab.model.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginUserRequestDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}

