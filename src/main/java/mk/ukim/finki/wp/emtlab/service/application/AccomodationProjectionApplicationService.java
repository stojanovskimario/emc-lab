package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.projection.AccomodationExtendedProjection;
import mk.ukim.finki.wp.emtlab.model.projection.AccomodationShortProjection;

import java.util.List;

public interface AccomodationProjectionApplicationService {
    List<AccomodationShortProjection> findAllShortProjected();

    List<AccomodationExtendedProjection> findAllExtendedProjected();
}

