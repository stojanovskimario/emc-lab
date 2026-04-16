package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.repository.AccomodationRepository;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccomodationServiceImpl implements AccomodationService {

    private final AccomodationRepository accomodationRepository;

    public AccomodationServiceImpl(AccomodationRepository accomodationRepository) {
        this.accomodationRepository = accomodationRepository;
    }

    @Override
    public Optional<Accomodation> findById(Long id) {
        return accomodationRepository.findById(id);
    }

    @Override
    public List<Accomodation> findAll() {
        return accomodationRepository.findAll();
    }

    @Override
    public Page<Accomodation> findAll(Pageable pageable, Category category, Long hostId, Long hostCountryId, Integer numRooms, Boolean hasFreeRooms) {
        return accomodationRepository.findAll(buildSpecification(category, hostId, hostCountryId, numRooms, hasFreeRooms), pageable);
    }

    @Override
    public List<Accomodation> findByRented(Boolean rented) {
        return accomodationRepository.findByRented(rented);
    }

    @Override
    public Accomodation create(Accomodation accomodation) {
        return accomodationRepository.save(accomodation);
    }

    @Override
    public Optional<Accomodation> update(Long id, Accomodation accomodation) {
        return accomodationRepository
            .findById(id)
            .map((existingAccomodation) -> {
                existingAccomodation.setName(accomodation.getName());
                existingAccomodation.setCategory(accomodation.getCategory());
                existingAccomodation.setHost(accomodation.getHost());
                existingAccomodation.setStatus(accomodation.getStatus());
                existingAccomodation.setNumRooms(accomodation.getNumRooms());
                existingAccomodation.setRented(accomodation.getRented());
                return accomodationRepository.save(existingAccomodation);
            });
    }

    @Override
    public Optional<Accomodation> deleteById(Long id) {
        Optional<Accomodation> accomodation = accomodationRepository.findById(id);
        accomodation.ifPresent(accomodationRepository::delete);
        return accomodation;
    }

    @Override
    public Optional<Accomodation> toggleRented(Long id) {
        return accomodationRepository
            .findById(id)
            .map((accomodation) -> {
                accomodation.setRented(!accomodation.getRented());
                return accomodationRepository.save(accomodation);
            });
    }

    private Specification<Accomodation> buildSpecification(Category category, Long hostId, Long hostCountryId, Integer numRooms, Boolean hasFreeRooms) {
        return (root, query, criteriaBuilder) -> {
            var predicates = criteriaBuilder.conjunction();
            var host = root.join("host");
            var country = host.join("country");

            if (category != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(root.get("category"), category));
            }

            if (hostId != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(host.get("id"), hostId));
            }

            if (hostCountryId != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(country.get("id"), hostCountryId));
            }

            if (numRooms != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(root.get("numRooms"), numRooms));
            }

            if (hasFreeRooms != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(root.get("rented"), !hasFreeRooms));
            }

            return predicates;
        };
    }
}
