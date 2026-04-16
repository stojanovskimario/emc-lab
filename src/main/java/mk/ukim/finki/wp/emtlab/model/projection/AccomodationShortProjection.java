package mk.ukim.finki.wp.emtlab.model.projection;

import mk.ukim.finki.wp.emtlab.model.enums.Category;

public interface AccomodationShortProjection {
    Long getId();

    String getName();

    Category getCategory();

    Integer getNumRooms();
}

