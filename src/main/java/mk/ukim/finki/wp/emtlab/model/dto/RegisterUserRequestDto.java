package mk.ukim.finki.wp.emtlab.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import mk.ukim.finki.wp.emtlab.model.domain.User;
import mk.ukim.finki.wp.emtlab.model.enums.Role;

public record RegisterUserRequestDto(
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String username,
        @NotBlank
        String password
) {
    public User toUser() {
        return new User(name, surname, email, username, password, Role.ROLE_USER);
    }
}

