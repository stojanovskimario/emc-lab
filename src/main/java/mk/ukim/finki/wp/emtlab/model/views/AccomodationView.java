package mk.ukim.finki.wp.emtlab.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@NoArgsConstructor
@Table(name = "accomodation_view")
public class AccomodationView {
	@Id
	private Long id;

	private String name;

	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(name = "num_rooms")
	private Integer numRooms;

	@Column(name = "host_full_name")
	private String hostFullName;

	@Column(name = "country_name")
	private String countryName;
}
