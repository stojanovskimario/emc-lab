package mk.ukim.finki.wp.emtlab.service.application.listener;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.emtlab.service.application.event.AccomodationRentedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class AccomodationRentedEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onAccomodationRented(AccomodationRentedEvent event) {
        log.info("Accommodation '{}' with id={} was successfully rented.", event.accomodationName(), event.accomodationId());
    }
}


