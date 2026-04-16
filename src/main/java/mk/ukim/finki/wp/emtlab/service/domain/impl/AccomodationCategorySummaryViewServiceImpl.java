package mk.ukim.finki.wp.emtlab.service.domain.impl;

import mk.ukim.finki.wp.emtlab.model.views.AccomodationCategorySummaryView;
import mk.ukim.finki.wp.emtlab.repository.AccomodationCategorySummaryViewRepository;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationCategorySummaryViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationCategorySummaryViewServiceImpl implements AccomodationCategorySummaryViewService {
    private final AccomodationCategorySummaryViewRepository repository;

    public AccomodationCategorySummaryViewServiceImpl(AccomodationCategorySummaryViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AccomodationCategorySummaryView> findAll() {
        return repository.findAll();
    }
}

