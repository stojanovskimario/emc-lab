package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.model.domain.AccomodationActivityLog;
import mk.ukim.finki.wp.emtlab.repository.AccomodationActivityLogRepository;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
public class AccomodationActivityLogServiceImpl implements AccomodationActivityLogService {
    private final AccomodationActivityLogRepository repository;

    public AccomodationActivityLogServiceImpl(AccomodationActivityLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<AccomodationActivityLog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AccomodationActivityLog create(AccomodationActivityLog activityLog) {
        return repository.save(activityLog);
    }
}

