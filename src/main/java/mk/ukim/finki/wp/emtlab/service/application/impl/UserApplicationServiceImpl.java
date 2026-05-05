package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.domain.User;
import mk.ukim.finki.wp.emtlab.model.dto.LoginUserRequestDto;
import mk.ukim.finki.wp.emtlab.model.dto.LoginUserResponseDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayUserDto;
import mk.ukim.finki.wp.emtlab.model.dto.RegisterUserRequestDto;
import mk.ukim.finki.wp.emtlab.model.dto.RegisterUserResponseDto;
import mk.ukim.finki.wp.emtlab.config.JwtHelper;
import mk.ukim.finki.wp.emtlab.service.application.UserApplicationService;
import mk.ukim.finki.wp.emtlab.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public List<DisplayUserDto> findAll() {
        return DisplayUserDto.from(userService.findAll());
    }

    @Override
    public Optional<DisplayUserDto> findById(Long id) {
        return userService.findById(id).map(DisplayUserDto::from);
    }

    @Override
    public Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.register(registerUserRequestDto.toUser());
        return Optional.of(RegisterUserResponseDto.from(user));
    }

    @Override
    public Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto) {
        User user = userService.login(loginUserRequestDto.username(), loginUserRequestDto.password());
        String token = jwtHelper.generateToken(user);
        return Optional.of(new LoginUserResponseDto(token));
    }

    @Override
    public Optional<RegisterUserResponseDto> findByUsername(String username) {
        return userService.findByUsername(username).map(RegisterUserResponseDto::from);
    }
}


