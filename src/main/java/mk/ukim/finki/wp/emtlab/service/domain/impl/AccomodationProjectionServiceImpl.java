package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.model.projection.AccomodationExtendedProjection;
import mk.ukim.finki.wp.emtlab.model.projection.AccomodationShortProjection;
import mk.ukim.finki.wp.emtlab.repository.AccomodationRepository;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationProjectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationProjectionServiceImpl implements AccomodationProjectionService {

    private final AccomodationRepository accomodationRepository;

    public AccomodationProjectionServiceImpl(AccomodationRepository accomodationRepository) {
        this.accomodationRepository = accomodationRepository;
    }

    @Override
    public List<AccomodationShortProjection> findAllShortProjected() {
        return accomodationRepository.findAllShortProjected();
    }

    @Override
    public List<AccomodationExtendedProjection> findAllExtendedProjected() {
        return accomodationRepository.findAllExtendedProjected();
    }
}

