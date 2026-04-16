package mk.ukim.finki.wp.emtlab.service.application.listener;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.emtlab.model.domain.AccomodationActivityLog;
import mk.ukim.finki.wp.emtlab.service.application.event.AccomodationRentedEvent;
import mk.ukim.finki.wp.emtlab.service.domain.AccomodationActivityLogService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.LocalDateTime;

@Component
@Slf4j
public class AccomodationRentedEventListener {
    private final AccomodationActivityLogService activityLogService;

    public AccomodationRentedEventListener(AccomodationActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onAccomodationRented(AccomodationRentedEvent event) {
        log.info("Accommodation '{}' with id={} was successfully rented.", event.accomodationName(), event.accomodationId());
        activityLogService.create(new AccomodationActivityLog(event.accomodationName(), LocalDateTime.now(), "RENTED"));
    }
}


