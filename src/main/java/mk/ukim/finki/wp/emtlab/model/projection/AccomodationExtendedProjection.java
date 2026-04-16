package mk.ukim.finki.wp.emtlab.model.projection;

import mk.ukim.finki.wp.emtlab.model.enums.Category;

public interface AccomodationExtendedProjection {
    Long getId();

    String getName();

    Category getCategory();

    Integer getNumRooms();

    String getHostName();

    String getHostSurname();

    String getHostCountryName();
}

