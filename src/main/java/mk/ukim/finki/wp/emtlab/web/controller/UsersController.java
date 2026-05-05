package mk.ukim.finki.wp.emtlab.web.controller;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayUserDto;
import mk.ukim.finki.wp.emtlab.service.application.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserApplicationService userApplicationService;

    public UsersController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayUserDto>> findAll() {
        return ResponseEntity.ok(userApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayUserDto> findById(@PathVariable Long id) {
        return userApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

