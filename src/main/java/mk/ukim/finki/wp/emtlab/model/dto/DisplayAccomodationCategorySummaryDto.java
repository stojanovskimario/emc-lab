package mk.ukim.finki.wp.emtlab.model.dto;

import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.views.AccomodationCategorySummaryView;

import java.math.BigDecimal;
import java.util.List;

public record DisplayAccomodationCategorySummaryDto(
        Category category,
        Long totalAccommodations,
        Long totalRooms,
        BigDecimal averageRoomsPerAccommodation
) {
    public static DisplayAccomodationCategorySummaryDto from(AccomodationCategorySummaryView view) {
        return new DisplayAccomodationCategorySummaryDto(
                view.getCategory(),
                view.getTotalAccommodations(),
                view.getTotalRooms(),
                view.getAverageRoomsPerAccommodation()
        );
    }

    public static List<DisplayAccomodationCategorySummaryDto> from(List<AccomodationCategorySummaryView> views) {
        return views.stream().map(DisplayAccomodationCategorySummaryDto::from).toList();
    }
}

