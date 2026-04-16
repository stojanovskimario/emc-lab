package mk.ukim.finki.wp.emtlab.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Entity
@Getter
@Immutable
@NoArgsConstructor
@Table(name = "accomodation_category_summary_view")
public class AccomodationCategorySummaryView {
    @Id
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "total_accommodations")
    private Long totalAccommodations;

    @Column(name = "total_rooms")
    private Long totalRooms;

    @Column(name = "average_rooms_per_accommodation")
    private BigDecimal averageRoomsPerAccommodation;
}

