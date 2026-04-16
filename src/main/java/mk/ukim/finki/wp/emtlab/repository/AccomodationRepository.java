package mk.ukim.finki.wp.emtlab.repository;

import mk.ukim.finki.wp.emtlab.model.domain.Accomodation;
import mk.ukim.finki.wp.emtlab.model.projection.AccomodationExtendedProjection;
import mk.ukim.finki.wp.emtlab.model.projection.AccomodationShortProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation, Long> {
    @Override
    @EntityGraph(value = "accomodation.host-and-country", type = EntityGraph.EntityGraphType.FETCH)
    @NonNull Optional<Accomodation> findById(@NonNull Long id);

    List<Accomodation> findByRented(Boolean rented);

    @Query("select a.id as id, a.name as name, a.category as category, a.numRooms as numRooms from Accomodation a")
    List<AccomodationShortProjection> findAllShortProjected();

    @Query("""
            select
                a.id as id,
                a.name as name,
                a.category as category,
                a.numRooms as numRooms,
                h.name as hostName,
                h.surname as hostSurname,
                c.name as hostCountryName
            from Accomodation a
                join a.host h
                join h.country c
            """)
    List<AccomodationExtendedProjection> findAllExtendedProjected();
}
