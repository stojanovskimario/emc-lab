package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AccomodationService {
    Optional<Accomodation> findById(Long id);

    List<Accomodation> findAll();

    List<Accomodation> findByRented(Boolean rented);

    Accomodation create(Accomodation accomodation);

    Optional<Accomodation> update(Long id, Accomodation accomodation);

    Optional<Accomodation> deleteById(Long id);

    Optional<Accomodation> toggleRented(Long id);
}
