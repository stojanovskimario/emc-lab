package mk.ukim.finki.wp.emtlab.service.domain.impl;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.emtlab.repository.AccomodationCategorySummaryViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class AccomodationCategorySummaryViewRefreshScheduler {
    private final AccomodationCategorySummaryViewRepository repository;

    public AccomodationCategorySummaryViewRefreshScheduler(AccomodationCategorySummaryViewRepository repository) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refresh() {
        log.info("Refreshing ACCOMODATION_CATEGORY_SUMMARY_VIEW...");
        repository.refresh();
        log.info("ACCOMODATION_CATEGORY_SUMMARY_VIEW successfully refreshed.");
    }
}

