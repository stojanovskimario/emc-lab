package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.dto.CreateAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AccomodationApplicationService {
    Optional<DisplayAccomodationDto> findById(Long id);

    List<DisplayAccomodationDto> findAll();

    Page<DisplayAccomodationDto> findAll(int page, int size, String sortBy, String sortDirection, Category category, Long hostId, Long hostCountryId, Integer numRooms, Boolean hasFreeRooms);

    List<DisplayAccomodationDto> findByRented(Boolean rented);

    DisplayAccomodationDto create(CreateAccomodationDto createAccomodationDto);

    Optional<DisplayAccomodationDto> update(Long id, CreateAccomodationDto createAccomodationDto);

    Optional<DisplayAccomodationDto> deleteById(Long id);

    Optional<DisplayAccomodationDto> toggleRented(Long id);
}
