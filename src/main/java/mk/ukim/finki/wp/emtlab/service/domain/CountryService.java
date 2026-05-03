package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.domain.Country;
import mk.ukim.finki.wp.emtlab.model.projection.CountryHostStatisticsProjection;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);

    List<Country> findAll();

    List<CountryHostStatisticsProjection> findHostStatistics();

    Country create(Country country);

    Optional<Country> update(Long id, Country country);

    Optional<Country> deleteById(Long id);
}
