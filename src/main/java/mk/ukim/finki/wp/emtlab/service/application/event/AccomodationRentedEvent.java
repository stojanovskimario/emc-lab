package mk.ukim.finki.wp.emtlab.service.application.event;

public record AccomodationRentedEvent(
        Long accomodationId,
        String accomodationName
) {
}

