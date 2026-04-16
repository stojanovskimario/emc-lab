package mk.ukim.finki.wp.emtlab.service.application;

import mk.ukim.finki.wp.emtlab.model.dto.DisplayAccomodationCategorySummaryDto;

import java.util.List;

public interface AccomodationCategorySummaryViewApplicationService {
    List<DisplayAccomodationCategorySummaryDto> findAll();
}

