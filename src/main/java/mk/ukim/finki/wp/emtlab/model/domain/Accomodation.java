package mk.ukim.finki.wp.emtlab.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.enums.Status;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "accomodations")
public class Accomodation extends BaseAuditableEntity {
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Integer numRooms;

    @Column(nullable = false)
    private Boolean rented;

    public Accomodation(String name, Category category, Host host, Status status, Integer numRooms, Boolean rented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.status = status;
        this.numRooms = numRooms;
        this.rented = rented;
    }
}
