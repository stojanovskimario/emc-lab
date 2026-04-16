package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.dto.CreateAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.dto.CreateHostDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    Optional<DisplayHostDto> findById(Long id);

    List<DisplayHostDto> findAll();

    DisplayHostDto create(CreateHostDto createHostDto);

    Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto);

    Optional<DisplayHostDto> deleteById(Long id);
}
