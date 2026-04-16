package mk.ukim.finki.wp.emtlab.service.application.event;

public record AccomodationFullyBookedEvent(
        Long accomodationId,
        String accomodationName,
        Integer numRooms
) {
}

