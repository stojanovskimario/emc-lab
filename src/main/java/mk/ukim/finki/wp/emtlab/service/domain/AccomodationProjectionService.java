package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.projection.AccomodationExtendedProjection;
import mk.ukim.finki.wp.emtlab.model.projection.AccomodationShortProjection;

import java.util.List;

public interface AccomodationProjectionService {
    List<AccomodationShortProjection> findAllShortProjected();

    List<AccomodationExtendedProjection> findAllExtendedProjected();
}

