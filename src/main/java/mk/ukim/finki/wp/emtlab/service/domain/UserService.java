package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    User register(User user);

    User login(String username, String password);
}


