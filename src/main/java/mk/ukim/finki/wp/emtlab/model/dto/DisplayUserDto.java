package mk.ukim.finki.wp.emtlab.model.dto;

import mk.ukim.finki.wp.emtlab.model.domain.User;

import java.util.List;

public record DisplayUserDto(
        Long id,
        String name,
        String surname,
        String email,
        String username,
        String role
) {
    public static DisplayUserDto from(User user) {
        return new DisplayUserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getUsername(),
                user.getRole().name()
        );
    }

    public static List<DisplayUserDto> from(List<User> users) {
        return users
                .stream()
                .map(DisplayUserDto::from)
                .toList();
    }
}

