package mk.ukim.finki.wp.emtlab.model.dto;

import mk.ukim.finki.wp.emtlab.model.domain.AccomodationActivityLog;

import java.time.LocalDateTime;
import java.util.List;

public record DisplayAccomodationActivityLogDto(
        Long id,
        String accomodationName,
        LocalDateTime eventTime,
        String eventType
) {
    public static DisplayAccomodationActivityLogDto from(AccomodationActivityLog activityLog) {
        return new DisplayAccomodationActivityLogDto(
                activityLog.getId(),
                activityLog.getAccomodationName(),
                activityLog.getEventTime(),
                activityLog.getEventType()
        );
    }

    public static List<DisplayAccomodationActivityLogDto> from(List<AccomodationActivityLog> activityLogs) {
        return activityLogs.stream().map(DisplayAccomodationActivityLogDto::from).toList();
    }
}

