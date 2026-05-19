package mk.ukim.finki.wp.emtlab.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NamedEntityGraph(
        name = "reservation.user-and-accomodation",
        attributeNodes = {
                @NamedAttributeNode("user"),
                @NamedAttributeNode("accomodation")
        }
)
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "reservations",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_reservations_user_id", columnNames = "user_id"),
                @UniqueConstraint(name = "uq_reservations_accomodation_id", columnNames = "accomodation_id")
        }
)
public class Reservation extends BaseAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accomodation_id", nullable = false)
    private Accomodation accomodation;

    @Column(nullable = false)
    private LocalDateTime reservedAt;

    @Column(nullable = false)
    private LocalDateTime releaseAt;

    public Reservation(User user, Accomodation accomodation, LocalDateTime reservedAt, LocalDateTime releaseAt) {
        this.user = user;
        this.accomodation = accomodation;
        this.reservedAt = reservedAt;
        this.releaseAt = releaseAt;
    }
}



