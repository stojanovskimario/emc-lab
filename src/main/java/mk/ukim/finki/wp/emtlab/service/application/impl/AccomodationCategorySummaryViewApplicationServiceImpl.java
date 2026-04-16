package mk.ukim.finki.wp.emtlab.service.application.impl;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationCategorySummaryDto;
import mk.ukim.finki.wp.emtlab.service.application.AccomodationCategorySummaryViewApplicationService;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationCategorySummaryViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationCategorySummaryViewApplicationServiceImpl implements AccomodationCategorySummaryViewApplicationService {
    private final AccomodationCategorySummaryViewService service;

    public AccomodationCategorySummaryViewApplicationServiceImpl(AccomodationCategorySummaryViewService service) {
        this.service = service;
    }

    @Override
    public List<DisplayAccomodationCategorySummaryDto> findAll() {
        return DisplayAccomodationCategorySummaryDto.from(service.findAll());
    }
}

