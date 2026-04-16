package mk.ukim.finki.wp.emtlab.service.domain;

import mk.ukim.finki.wp.emtlab.model.domain.AccomodationActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccomodationActivityLogService {
    Page<AccomodationActivityLog> findAll(Pageable pageable);

    AccomodationActivityLog create(AccomodationActivityLog activityLog);
}

