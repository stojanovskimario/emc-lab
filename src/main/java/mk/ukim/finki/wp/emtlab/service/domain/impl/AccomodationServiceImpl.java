package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.repository.AccomodationRepository;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationService;
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
}
