package mk.ukim.finki.wp.emtlab.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.wp.emtlab.model.domain.User;
import mk.ukim.finki.wp.emtlab.model.dto.CreateReservationDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayReservationDto;
import mk.ukim.finki.wp.emtlab.service.application.ReservationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationApplicationService reservationApplicationService;

    public ReservationController(ReservationApplicationService reservationApplicationService) {
        this.reservationApplicationService = reservationApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayReservationDto>> findAll() {
        return ResponseEntity.ok(reservationApplicationService.findAll());
    }

    @PostMapping("/reserve")
    public ResponseEntity<DisplayReservationDto> reserve(
            @RequestBody @Valid CreateReservationDto createReservationDto,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(reservationApplicationService.reserve(createReservationDto, user));
    }
}

