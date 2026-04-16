package mk.ukim.finki.wp.emtlab.model.views;

import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.enums.Status;

import java.time.LocalDateTime;

public interface AccomodationView {
	Long getId();

	String getName();

	Category getCategory();

	Status getStatus();

	Integer getNumRooms();

	Boolean getRented();

	Long getHostId();

	String getHostName();

	String getHostSurname();

	Long getHostCountryId();

	String getHostCountryName();

	LocalDateTime getCreatedAt();
}
