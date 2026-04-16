package mk.ukim.finki.wp.emtlab.model.dto;

import mk.ukim.finki.wp.emtlab.model.views.AccomodationView;
import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public record DisplayAccomodationViewDto(
		Long id,
		String name,
		Category category,
		Status status,
		Integer numRooms,
		Boolean rented,
		Long hostId,
		String hostName,
		String hostSurname,
		Long hostCountryId,
		String hostCountryName,
		LocalDateTime createdAt
) {
	public static DisplayAccomodationViewDto from(AccomodationView accomodationView) {
		return new DisplayAccomodationViewDto(
				accomodationView.getId(),
				accomodationView.getName(),
				accomodationView.getCategory(),
				accomodationView.getStatus(),
				accomodationView.getNumRooms(),
				accomodationView.getRented(),
				accomodationView.getHostId(),
				accomodationView.getHostName(),
				accomodationView.getHostSurname(),
				accomodationView.getHostCountryId(),
				accomodationView.getHostCountryName(),
				accomodationView.getCreatedAt()
		);
	}

	public static List<DisplayAccomodationViewDto> from(List<AccomodationView> accomodationViews) {
		return accomodationViews
				.stream()
				.map(DisplayAccomodationViewDto::from)
				.toList();
	}
}
