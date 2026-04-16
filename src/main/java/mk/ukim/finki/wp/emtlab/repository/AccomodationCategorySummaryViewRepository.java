package mk.ukim.finki.wp.emtlab.repository;

import mk.ukim.finki.wp.emtlab.model.enums.Category;
import mk.ukim.finki.wp.emtlab.model.views.AccomodationCategorySummaryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationCategorySummaryViewRepository extends JpaRepository<AccomodationCategorySummaryView, Category> {
    @Modifying
    @Query(value = "refresh materialized view accomodation_category_summary_view", nativeQuery = true)
    void refresh();
}


