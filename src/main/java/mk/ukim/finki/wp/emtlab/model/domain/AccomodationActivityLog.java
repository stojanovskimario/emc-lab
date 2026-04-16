package mk.ukim.finki.wp.emtlab.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accomodation_activity_log")
public class AccomodationActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accomodation_name", nullable = false)
    private String accomodationName;

    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    public AccomodationActivityLog(String accomodationName, LocalDateTime eventTime, String eventType) {
        this.accomodationName = accomodationName;
        this.eventTime = eventTime;
        this.eventType = eventType;
    }
}

