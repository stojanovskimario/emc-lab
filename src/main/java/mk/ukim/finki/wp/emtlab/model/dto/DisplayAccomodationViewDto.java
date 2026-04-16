package mk.ukim.finki.wp.emtlab.model.dto;

import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.views.AccomodationView;

import java.util.List;

public record DisplayAccomodationViewDto(
		Long id,
		String name,
		Category category,
		Integer numRooms,
		String hostFullName,
		String countryName
) {
	public static DisplayAccomodationViewDto from(AccomodationView accomodationView) {
		return new DisplayAccomodationViewDto(
				accomodationView.getId(),
				accomodationView.getName(),
				accomodationView.getCategory(),
				accomodationView.getNumRooms(),
				accomodationView.getHostFullName(),
				accomodationView.getCountryName()
		);
	}

	public static List<DisplayAccomodationViewDto> from(List<AccomodationView> accomodationViews) {
		return accomodationViews
				.stream()
				.map(DisplayAccomodationViewDto::from)
				.toList();
	}
}
