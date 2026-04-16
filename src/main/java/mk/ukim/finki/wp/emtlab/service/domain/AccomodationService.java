package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccomodationService {
    Optional<Accomodation> findById(Long id);

    List<Accomodation> findAll();

    Page<Accomodation> findAll(Pageable pageable, Category category, Long hostId, Long hostCountryId, Integer numRooms, Boolean hasFreeRooms);

    List<Accomodation> findByRented(Boolean rented);

    Accomodation create(Accomodation accomodation);

    Optional<Accomodation> update(Long id, Accomodation accomodation);

    Optional<Accomodation> deleteById(Long id);

    Optional<Accomodation> toggleRented(Long id);
}
