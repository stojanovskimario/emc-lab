package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.dto.CreateCountryDto;
import mk.ukim.finki.wp.emtlab.model.dto.DisplayCountryDto;
import mk.ukim.finki.wp.emtlab.model.projection.CountryHostStatisticsProjection;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    Optional<DisplayCountryDto> findById(Long id);

    List<DisplayCountryDto> findAll();

    List<CountryHostStatisticsProjection> findHostStatistics();

    DisplayCountryDto create(CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> deleteById(Long id);
}
