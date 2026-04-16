package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.projection.AccomodationExtendedProjection;
import mk.ukim.finki.wp.emtlab.model.projection.AccomodationShortProjection;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationProjectionApplicationService;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationProjectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationProjectionApplicationServiceImpl implements AccomodationProjectionApplicationService {

    private final AccomodationProjectionService accomodationProjectionService;

    public AccomodationProjectionApplicationServiceImpl(AccomodationProjectionService accomodationProjectionService) {
        this.accomodationProjectionService = accomodationProjectionService;
    }

    @Override
    public List<AccomodationShortProjection> findAllShortProjected() {
        return accomodationProjectionService.findAllShortProjected();
    }

    @Override
    public List<AccomodationExtendedProjection> findAllExtendedProjected() {
        return accomodationProjectionService.findAllExtendedProjected();
    }
}

