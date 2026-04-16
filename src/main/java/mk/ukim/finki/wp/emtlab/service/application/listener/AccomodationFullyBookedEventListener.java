package mk.ukim.finki.wp.emtlab.service.application.listener;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.wp.emtlab.service.application.event.AccomodationFullyBookedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class AccomodationFullyBookedEventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onAccomodationFullyBooked(AccomodationFullyBookedEvent event) {
        log.info("Accommodation '{}' with id={} is fully booked and has no free rooms left (numRooms={}).",
                event.accomodationName(), event.accomodationId(), event.numRooms());
    }
}

